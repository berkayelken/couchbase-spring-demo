package io.github.berkayelken.couchbase.spring.demo.service.command;

import io.github.berkayelken.couchbase.spring.demo.domain.command.EventOperation;
import io.github.berkayelken.couchbase.spring.demo.domain.command.request.EventRequest;
import io.github.berkayelken.couchbase.spring.demo.domain.query.Customer;
import io.github.berkayelken.couchbase.spring.demo.repository.CommandRepository;
import io.github.berkayelken.couchbase.spring.demo.service.query.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

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
		repository.saveAll(request.convertCustomerEvents());
		return customerService.getCustomer(request.getRelatedCustomer());
	}

	@CacheEvict(value = "customerCache", key = "#request.relatedCustomer")
	public Customer updateCustomer(EventRequest request) {
		request.setOperation(EventOperation.UPDATE);
		repository.saveAll(request.convertCustomerEvents());
		return customerService.getCustomer(request.getRelatedCustomer());
	}

	@CacheEvict(value = "customerCache", key = "#request.relatedCustomer")
	public void deleteCustomer(EventRequest request) {
		request.setOperation(EventOperation.DELETE);
		repository.saveAll(request.convertCustomerEvents());
	}


}
