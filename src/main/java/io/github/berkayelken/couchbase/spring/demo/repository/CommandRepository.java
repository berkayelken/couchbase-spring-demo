package io.github.berkayelken.couchbase.spring.demo.repository;

import io.github.berkayelken.couchbase.spring.demo.domain.command.CustomerEvent;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends CouchbaseRepository<CustomerEvent, String>, DynamicProxyable<CommandRepository> {
}
