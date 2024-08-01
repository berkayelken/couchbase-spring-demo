package io.github.berkayelken.couchbase.spring.demo.configuration;

import io.github.berkayelken.couchbase.spring.demo.properties.CouchbaseConnectionPropertiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

@ExtendWith(MockitoExtension.class)
public class CouchbaseConnectionConfigurationTest {
	@Mock
	private RepositoryOperationsMapping baseMapping;

	private CouchbaseConnectionConfiguration createInstance() {
		return new CouchbaseConnectionConfiguration(CouchbaseConnectionPropertiesTest.createTestInstance());
	}

	@Test
	public void testAccessors() {
		CouchbaseConnectionConfiguration configuration = createInstance();

		Assertions.assertNull(configuration.getConnectionString());
		Assertions.assertNull(configuration.getUserName());
		Assertions.assertNull(configuration.getPassword());
		Assertions.assertNull(configuration.getBucketName());
	}

	@Test
	public void testConfigureRepositoryOperationsMapping() {
		CouchbaseConnectionConfiguration configuration = createInstance();
		Assertions.assertDoesNotThrow(() -> configuration.configureRepositoryOperationsMapping(baseMapping));
	}
}
