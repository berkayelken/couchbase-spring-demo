package io.github.berkayelken.couchbase.spring.demo.rest;

import io.github.berkayelken.couchbase.spring.demo.domain.command.request.EventRequestTest;
import io.github.berkayelken.couchbase.spring.demo.service.command.CustomerEventService;
import io.github.berkayelken.couchbase.spring.demo.service.query.CustomerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith (MockitoExtension.class)
public class CustomerControllerTest {
	private static final String ID = "id";
	@Mock
	private CustomerService queryService;
	@Mock
	private CustomerEventService commandService;

	private CustomerController getController() {
		MockitoAnnotations.openMocks(this);
		return new CustomerController(queryService, commandService);
	}

	@Test
	public void testGetCustomer() {
		CustomerController controller = getController();
		Assertions.assertDoesNotThrow(() -> controller.getCustomer(ID));
	}

	@Test
	public void testCreateCustomer() {
		CustomerController controller = getController();
		Assertions.assertDoesNotThrow(() -> controller.createCustomer(EventRequestTest.createFilledRequest()));
	}

	@Test
	public void testUpdateCustomer() {
		CustomerController controller = getController();
		Assertions.assertDoesNotThrow(() -> controller.updateCustomer(ID, EventRequestTest.createFilledRequest()));
	}

	@Test
	public void testDeleteCustomer() {
		CustomerController controller = getController();
		Assertions.assertDoesNotThrow(() -> controller.deleteCustomer(ID));
	}

}
