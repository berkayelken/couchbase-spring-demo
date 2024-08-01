package io.github.berkayelken.couchbase.spring.demo.service.query;

import io.github.berkayelken.couchbase.spring.demo.domain.query.Customer;
import io.github.berkayelken.couchbase.spring.demo.exception.RecordNotFoundException;
import io.github.berkayelken.couchbase.spring.demo.repository.QueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
	private final QueryRepository repository;

	@Autowired
	public CustomerService(QueryRepository repository) {
		this.repository = repository;
	}

	@Cacheable(value = "customerCache", key = "#id")
	public Customer getCustomer(String id) {
		return repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
	}

	public List<Customer> getAllCustomers() {
		return repository.findAll();
	}
}
