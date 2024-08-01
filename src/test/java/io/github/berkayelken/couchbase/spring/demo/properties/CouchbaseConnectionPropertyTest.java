package io.github.berkayelken.couchbase.spring.demo.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CouchbaseConnectionPropertyTest {
	private static final String TEST_STR = "TEST_STR";

	@Test
	public void testNoArgsConstructor() {
		Assertions.assertDoesNotThrow(CouchbaseConnectionProperty::new);
	}

	@Test
	public void testAccessors() {
		CouchbaseConnectionProperty property = new CouchbaseConnectionProperty();

		Assertions.assertNull(property.getHost());
		Assertions.assertNull(property.getUsername());
		Assertions.assertNull(property.getPassword());
		Assertions.assertNull(property.getBucket());
	}

	@Test
	public void testMutators() {
		CouchbaseConnectionProperty property = createTestInstance();

		Assertions.assertEquals(TEST_STR, property.getHost());
		Assertions.assertEquals(TEST_STR, property.getUsername());
		Assertions.assertEquals(TEST_STR, property.getPassword());
		Assertions.assertEquals(TEST_STR, property.getBucket());
	}

	@Test
	public void testCreateCouchbaseTemplate() {
		CouchbaseConnectionProperty property = createTestInstance();
		Assertions.assertDoesNotThrow(property::createTemplate);
	}

	static CouchbaseConnectionProperty createTestInstance() {
		CouchbaseConnectionProperty property = new CouchbaseConnectionProperty();

		property.setHost(TEST_STR);
		property.setUsername(TEST_STR);
		property.setPassword(TEST_STR);
		property.setBucket(TEST_STR);

		return property;
	}
}
