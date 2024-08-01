package io.github.berkayelken.couchbase.spring.demo.domain.command;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerEventTest {
	private static final String TEST_STR = "TEST_STR";

	@Test
	public void testArgsConstructorForDeletion() {
		Assertions.assertDoesNotThrow(() -> new CustomerEvent(TEST_STR, EventOperation.DELETE));
	}

	@Test
	public void testArgsConstructorForOtherOperations() {
		Assertions.assertDoesNotThrow(() -> new CustomerEvent(TEST_STR, EventOperation.CREATE, TEST_STR, TEST_STR));
		Assertions.assertDoesNotThrow(() -> new CustomerEvent(TEST_STR, EventOperation.UPDATE, TEST_STR, TEST_STR));
	}

	@Test
	public void testGetOperationTime() {
		CustomerEvent event = new CustomerEvent(TEST_STR, EventOperation.DELETE);
		Assertions.assertNotEquals(0L, event.getOperationTime());
	}

}
