package io.github.berkayelken.couchbase.spring.demo.configuration;

import io.github.berkayelken.couchbase.spring.demo.properties.CouchbaseConnectionPropertiesTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CacheManagerConfigurationTest {

	private CacheManagerConfiguration createInstance() {
		return new CacheManagerConfiguration(CouchbaseConnectionPropertiesTest.createTestInstance());
	}

	@Test
	public void testCacheManager() {
		CacheManagerConfiguration cacheManager = createInstance();
		Assertions.assertNotNull(cacheManager);
		Assertions.assertDoesNotThrow(cacheManager::cacheManager);
	}
}
