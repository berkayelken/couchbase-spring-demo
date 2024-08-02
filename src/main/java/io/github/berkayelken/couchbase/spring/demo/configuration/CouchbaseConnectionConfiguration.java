package io.github.berkayelken.couchbase.spring.demo.configuration;

import io.github.berkayelken.couchbase.spring.demo.domain.command.CustomerEvent;
import io.github.berkayelken.couchbase.spring.demo.domain.query.Customer;
import io.github.berkayelken.couchbase.spring.demo.properties.CouchbaseConnectionProperties;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

@Getter
@Setter
@Configuration
@ConfigurationProperties ("couchbase-default-connection")
@EnableCouchbaseRepositories (basePackages = { "io.github.berkayelken.couchbase.spring.demo" })
public class CouchbaseConnectionConfiguration extends AbstractCouchbaseConfiguration {
	private String connectionString;
	private String userName;
	private String password;
	private String bucketName;

	@Getter (AccessLevel.NONE)
	private final CouchbaseConnectionProperties properties;

	@Autowired
	public CouchbaseConnectionConfiguration(CouchbaseConnectionProperties properties) {
		this.properties = properties;
	}

	@SneakyThrows
	@Override
	public void configureRepositoryOperationsMapping(RepositoryOperationsMapping baseMapping) {
		baseMapping.mapEntity(Customer.class, properties.createQueryConnection());
		baseMapping.mapEntity(CustomerEvent.class, properties.createCommandConnection());
	}

}
