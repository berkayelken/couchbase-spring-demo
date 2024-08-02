package io.github.berkayelken.couchbase.spring.demo.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;

@Getter
@Setter
@Configuration
@ConfigurationProperties("couchbase-connection")
public class CouchbaseConnectionProperties {
	private CouchbaseConnectionProperty commandSource;
	private CouchbaseConnectionProperty querySource;
	private CouchbaseConnectionProperty cachingSource;
	private CouchbaseConnectionProperty levelSource;

	public CouchbaseTemplate createCommandConnection() {
		return commandSource.createTemplate();
	}

	public CouchbaseTemplate createQueryConnection() {
		return querySource.createTemplate();
	}

	public CouchbaseTemplate createCachingConnection() {
		return cachingSource.createTemplate();
	}

	public CouchbaseTemplate createLevelConnection() {
		return levelSource.createTemplate();
	}
}
