package io.github.berkayelken.couchbase.spring.demo.repository;

import io.github.berkayelken.couchbase.spring.demo.domain.command.CustomerEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Scope("CustomerEventCommand")
@Collection("CustomerEvent")
@Repository
public interface CommandRepository extends CouchbaseRepository<CustomerEvent, String> {
}
