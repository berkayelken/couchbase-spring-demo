package io.github.berkayelken.couchbase.spring.demo.service.command;

import io.github.berkayelken.couchbase.spring.demo.domain.command.CustomerEvent;
import io.github.berkayelken.couchbase.spring.demo.domain.command.EventOperation;
import io.github.berkayelken.couchbase.spring.demo.domain.command.request.EventRequest;
import io.github.berkayelken.couchbase.spring.demo.domain.query.Customer;
import io.github.berkayelken.couchbase.spring.demo.repository.CommandRepository;
import io.github.berkayelken.couchbase.spring.demo.service.query.CustomerService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerEventService {
	private final CommandRepository repository;
	private final CustomerService customerService;

	@Autowired
	public CustomerEventService(CommandRepository repository, CustomerService customerService) {
		this.repository = repository;
		this.customerService = customerService;
	}

	public Customer createCustomer(EventRequest request) {
		request.setOperation(EventOperation.CREATE);
		request.setNewId();
		saveEvents(request);
		return customerService.getCustomer(request.getRelatedCustomer());
	}

	@CacheEvict (value = "customerCache", key = "#request.relatedCustomer")
	public void updateCustomer(EventRequest request) {
		request.setOperation(EventOperation.UPDATE);
		saveEvents(request);
	}

	@CacheEvict (value = "customerCache", key = "#request.relatedCustomer")
	public void deleteCustomer(EventRequest request) {
		request.setOperation(EventOperation.DELETE);
		saveEvents(request);
	}

	@SneakyThrows
	private void saveEvents(EventRequest request) {
		List<CustomerEvent> events = request.convertCustomerEvents();
		Objects.requireNonNull(events);
		events.forEach(this::saveEvent);
		Thread.sleep(2000);
	}

	@SneakyThrows
	private void saveEvent(CustomerEvent event) {
		Thread.sleep(200);
		repository.withScope("CustomerEventCommand").withCollection("CustomerEvent").getOperations().insertById(CustomerEvent.class)
				.one(event);
	}

}
