package io.github.berkayelken.couchbase.spring.demo.rest;

import io.github.berkayelken.couchbase.spring.demo.domain.command.request.EventRequest;
import io.github.berkayelken.couchbase.spring.demo.domain.query.Customer;
import io.github.berkayelken.couchbase.spring.demo.service.command.CustomerEventService;
import io.github.berkayelken.couchbase.spring.demo.service.query.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping ("/customer")
public class CustomerController {
	private final CustomerService queryService;
	private final CustomerEventService commandService;

	@Autowired
	public CustomerController(CustomerService queryService, CustomerEventService commandService) {
		this.queryService = queryService;
		this.commandService = commandService;
	}

	@GetMapping ("/{id}")
	public Customer getCustomer(@PathVariable ("id") String id) {
		return queryService.getCustomer(id);
	}

	@GetMapping
	public List<Customer> getAllCustomer() {
		return queryService.getAllCustomers();
	}

	@PostMapping
	public Customer createCustomer(@RequestBody EventRequest request) {
		return commandService.createCustomer(request);
	}

	@PutMapping ("/{id}")
	public Customer updateCustomer(@PathVariable ("id") String id, @RequestBody EventRequest request) {
		request.setRelatedCustomer(id);
		return commandService.updateCustomer(request);
	}

	@DeleteMapping ("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable ("id") String id) {
		EventRequest request = new EventRequest();
		request.setRelatedCustomer(id);
		commandService.deleteCustomer(request);
	}

}
