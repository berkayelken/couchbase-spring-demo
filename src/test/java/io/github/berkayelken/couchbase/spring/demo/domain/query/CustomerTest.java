package io.github.berkayelken.couchbase.spring.demo.domain.query;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CustomerTest {
	private static final String TEST_STR = "TEST_STR";

	@Test
	public void testNoArgsConstructor() {
		Assertions.assertDoesNotThrow(Customer::new);
	}

	@Test
	public void testAccessors() {
		Customer customer = new Customer();

		Assertions.assertNull(customer.getId());
		Assertions.assertEquals(0L, customer.getCitizenNumber());
		Assertions.assertNull(customer.getName());
		Assertions.assertNull(customer.getSurname());
		Assertions.assertEquals(0, customer.getAge());
		Assertions.assertNull(customer.getCity());
		Assertions.assertNull(customer.getEmail());
		Assertions.assertNull(customer.getPhone());
		Assertions.assertFalse(customer.isPremium());
	}

	@Test
	public void testMutators() {
		Customer customer = new Customer();

		customer.setId(TEST_STR);
		customer.setCitizenNumber(Long.MAX_VALUE);
		customer.setName(TEST_STR);
		customer.setSurname(TEST_STR);
		customer.setAge(Integer.MAX_VALUE);
		customer.setCity(TEST_STR);
		customer.setEmail(TEST_STR);
		customer.setPhone(TEST_STR);
		customer.setPremium(true);

		Assertions.assertEquals(TEST_STR, customer.getId());
		Assertions.assertEquals(Long.MAX_VALUE, customer.getCitizenNumber());
		Assertions.assertEquals(TEST_STR, customer.getName());
		Assertions.assertEquals(TEST_STR, customer.getSurname());
		Assertions.assertEquals(Integer.MAX_VALUE, customer.getAge());
		Assertions.assertEquals(TEST_STR, customer.getCity());
		Assertions.assertEquals(TEST_STR, customer.getEmail());
		Assertions.assertEquals(TEST_STR, customer.getPhone());
	}
}
