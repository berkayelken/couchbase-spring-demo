package io.github.berkayelken.couchbase.spring.demo.repository;

import io.github.berkayelken.couchbase.spring.demo.domain.query.Customer;
import org.springframework.context.annotation.Scope;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Scope("CustomerQuery")
@Collection("Customer")
@Repository
public interface QueryRepository extends CouchbaseRepository<Customer, String> {
}
