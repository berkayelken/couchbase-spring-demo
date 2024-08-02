package io.github.berkayelken.couchbase.spring.demo.repository;

import io.github.berkayelken.couchbase.spring.demo.domain.query.Customer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends CouchbaseRepository<Customer, String> , DynamicProxyable<QueryRepository> {
}
