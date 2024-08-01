package io.github.berkayelken.couchbase.spring.demo.configuration;

import io.github.berkayelken.couchbase.spring.demo.properties.CouchbaseConnectionPropertiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CacheManagerTest {

	private CacheManager createInstance() {
		return new CacheManager(CouchbaseConnectionPropertiesTest.createTestInstance());
	}

	@Test
	public void testCacheManager() {
		CacheManager cacheManager = createInstance();
		Assertions.assertNotNull(cacheManager);
		Assertions.assertDoesNotThrow(cacheManager::cacheManager);
	}
}
