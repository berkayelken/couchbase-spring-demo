package io.github.berkayelken.couchbase.spring.demo.properties;

import com.couchbase.client.core.env.Authenticator;
import com.couchbase.client.core.env.PasswordAuthenticator;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;

@Getter
@Setter
public class CouchbaseConnectionProperty {
	private String host;
	private String username;
	private String password;
	private String bucket;

	CouchbaseTemplate createTemplate() {
		CouchbaseClientFactory clientFactory = createClientFactory();
		return new CouchbaseTemplate(clientFactory, new MappingCouchbaseConverter());
	}

	private CouchbaseClientFactory createClientFactory() {
		Authenticator authenticator = createAuthenticator();
		return new SimpleCouchbaseClientFactory(host, authenticator, bucket);
	}

	private Authenticator createAuthenticator() {
		return PasswordAuthenticator.builder().username(username).password(password).onlyEnablePlainSaslMechanism().build();
	}
}
