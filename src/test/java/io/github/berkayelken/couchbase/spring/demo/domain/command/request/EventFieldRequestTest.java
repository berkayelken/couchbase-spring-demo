package io.github.berkayelken.couchbase.spring.demo.domain.command.request;

import io.github.berkayelken.couchbase.spring.demo.domain.command.EventOperation;
import io.github.berkayelken.couchbase.spring.demo.exception.EventException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class EventFieldRequestTest {
	private static final String TEST_STR = "TEST_STR";

	@Test
	public void testNoArgsConstructor() {
		Assertions.assertDoesNotThrow(EventFieldRequest::new);
	}

	@Test
	public void testAccessors() {
		EventFieldRequest request = new EventFieldRequest();

		Assertions.assertNull(request.getField());
		Assertions.assertNull(request.getValue());
	}

	@Test
	public void testMutators() {
		EventFieldRequest request = new EventFieldRequest();

		request.setField(EventField.NAME);
		request.setValue(TEST_STR);

		Assertions.assertEquals(EventField.NAME, request.getField());
		Assertions.assertEquals(TEST_STR, request.getValue());
	}

	@Test
	public void testCheckValueTypeFeasible() {
		EventFieldRequest request = new EventFieldRequest();

		Assertions.assertFalse(request.checkValueTypeFeasible());

		request.setField(EventField.NAME);
		Assertions.assertFalse(request.checkValueTypeFeasible());

		request.setValue(Integer.MAX_VALUE);
		Assertions.assertFalse(request.checkValueTypeFeasible());

		request.setValue(TEST_STR);
		Assertions.assertTrue(request.checkValueTypeFeasible());
	}

	@Test
	public void testConvertCustomerEvent() {
		EventFieldRequest request = new EventFieldRequest();

		Assertions.assertThrows(EventException.class, () -> request.convertCustomerEvent(TEST_STR, EventOperation.UPDATE, new AtomicBoolean()));

		request.setField(EventField.NAME);
		request.setValue(TEST_STR);
		Assertions.assertDoesNotThrow(() -> request.convertCustomerEvent(TEST_STR, EventOperation.UPDATE, new AtomicBoolean()));
	}
}
