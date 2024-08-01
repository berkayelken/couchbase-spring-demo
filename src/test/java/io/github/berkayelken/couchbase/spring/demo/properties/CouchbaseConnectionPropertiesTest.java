package io.github.berkayelken.couchbase.spring.demo.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CouchbaseConnectionPropertiesTest {
	@Test
	public void testNoArgsConstructor() {
		Assertions.assertDoesNotThrow(CouchbaseConnectionProperties::new);
	}

	@Test
	public void testAccessors() {
		CouchbaseConnectionProperties properties = new CouchbaseConnectionProperties();

		Assertions.assertNull(properties.getCommandSource());
		Assertions.assertNull(properties.getQuerySource());
		Assertions.assertNull(properties.getCachingSource());
	}

	@Test
	public void testMutators() {
		CouchbaseConnectionProperties properties = createTestInstance();

		Assertions.assertNotNull(properties.getCommandSource());
		Assertions.assertNotNull(properties.getQuerySource());
		Assertions.assertNotNull(properties.getCachingSource());
	}

	@Test
	public void testCreateCommandConnection() {
		CouchbaseConnectionProperties properties = createTestInstance();

		Assertions.assertDoesNotThrow(properties::createCommandConnection);
	}

	@Test
	public void testCreateQueryConnection() {
		CouchbaseConnectionProperties properties = createTestInstance();

		Assertions.assertDoesNotThrow(properties::createQueryConnection);
	}

	@Test
	public void testCreateCachingConnection() {
		CouchbaseConnectionProperties properties = createTestInstance();

		Assertions.assertDoesNotThrow(properties::createCachingConnection);
	}

	public static CouchbaseConnectionProperties createTestInstance() {
		CouchbaseConnectionProperties properties = new CouchbaseConnectionProperties();

		properties.setCommandSource(CouchbaseConnectionPropertyTest.createTestInstance());
		properties.setQuerySource(CouchbaseConnectionPropertyTest.createTestInstance());
		properties.setCachingSource(CouchbaseConnectionPropertyTest.createTestInstance());

		return properties;
	}
}
