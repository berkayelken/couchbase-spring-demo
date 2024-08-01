package io.github.berkayelken.couchbase.spring.demo.domain.command.request;

import io.github.berkayelken.couchbase.spring.demo.domain.command.EventOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

public class EventRequestTest {
	private static final String TEST_STR = "TEST_STR";

	@Test
	public void testNoArgsConstructor() {
		Assertions.assertDoesNotThrow(EventRequest::new);
	}

	@Test
	public void testAccessors() {
		EventRequest request = new EventRequest();

		Assertions.assertNull(request.getFields());
		Assertions.assertNull(request.getOperation());
		Assertions.assertNull(request.getRelatedCustomer());
	}

	@Test
	public void testMutators() {
		EventRequest request = new EventRequest();

		request.setFields(Collections.emptyList());
		request.setOperation(EventOperation.DELETE);
		request.setRelatedCustomer(TEST_STR);

		Assertions.assertNotNull(request.getFields());
		Assertions.assertEquals(EventOperation.DELETE, request.getOperation());
		Assertions.assertEquals(TEST_STR, request.getRelatedCustomer());
	}

	@Test
	public void testConvertCustomerEvents() {
		EventRequest request = new EventRequest();

		Assertions.assertNull(request.convertCustomerEvents());

		request.setRelatedCustomer(TEST_STR);
		Assertions.assertNull(request.convertCustomerEvents());

		request.setOperation(EventOperation.DELETE);
		Assertions.assertEquals(1, request.convertCustomerEvents().size());

		request.setOperation(EventOperation.UPDATE);

		EventFieldRequest fieldRequest = new EventFieldRequest();

		fieldRequest.setField(EventField.NAME);
		fieldRequest.setValue(TEST_STR);

		request.setFields(List.of(fieldRequest, fieldRequest));
		Assertions.assertEquals(2, request.convertCustomerEvents().size());
	}
}
