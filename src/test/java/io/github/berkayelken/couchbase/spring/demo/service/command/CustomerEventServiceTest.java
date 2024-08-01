package io.github.berkayelken.couchbase.spring.demo.service.command;

import io.github.berkayelken.couchbase.spring.demo.domain.command.request.EventRequestTest;
import io.github.berkayelken.couchbase.spring.demo.repository.CommandRepository;
import io.github.berkayelken.couchbase.spring.demo.service.query.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith (MockitoExtension.class)
public class CustomerEventServiceTest {
	@Mock
	private CommandRepository repository;
	@Mock
	private CustomerService customerService;

	private CustomerEventService getService() {
		MockitoAnnotations.openMocks(this);
		return new CustomerEventService(repository, customerService);
	}

	@Test
	public void testCreateCustomer() {
		CustomerEventService service = getService();
		Assertions.assertDoesNotThrow(() -> service.createCustomer(EventRequestTest.createFilledRequest()));
	}

	@Test
	public void testUpdateCustomer() {
		CustomerEventService service = getService();
		Assertions.assertDoesNotThrow(() -> service.updateCustomer(EventRequestTest.createFilledRequest()));
	}

	@Test
	public void testDeleteCustomer() {
		CustomerEventService service = getService();
		Assertions.assertDoesNotThrow(() -> service.deleteCustomer(EventRequestTest.createFilledRequest()));
	}
}
