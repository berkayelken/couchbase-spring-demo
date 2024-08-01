package io.github.berkayelken.couchbase.spring.demo.service.query;

import io.github.berkayelken.couchbase.spring.demo.domain.query.Customer;
import io.github.berkayelken.couchbase.spring.demo.exception.RecordNotFoundException;
import io.github.berkayelken.couchbase.spring.demo.repository.QueryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith (MockitoExtension.class)
public class CustomerServiceTest {
	private static final String ID = "id";

	@Mock
	private QueryRepository repository;

	private CustomerService getService() {
		MockitoAnnotations.openMocks(this);
		return new CustomerService(repository);
	}

	@Test
	public void testGetCustomerWithNotFound() {
		CustomerService service = getService();
		Assertions.assertThrows(RecordNotFoundException.class, () -> service.getCustomer(ID));
	}

	@Test
	public void testGetCustomer() {
		CustomerService service = getService();
		Mockito.when(repository.findById(ArgumentMatchers.anyString())).thenReturn(Optional.of(new Customer()));
		Assertions.assertDoesNotThrow(() -> service.getCustomer(ID));
	}

	@Test
	public void testGetAllCustomers() {
		CustomerService service = getService();

		Assertions.assertDoesNotThrow(service::getAllCustomers);
	}
}
