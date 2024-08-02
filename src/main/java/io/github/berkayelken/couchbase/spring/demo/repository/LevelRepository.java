package io.github.berkayelken.couchbase.spring.demo.repository;

import io.github.berkayelken.couchbase.spring.demo.domain.level.CustomerLevel;
import org.springframework.data.couchbase.repository.Collection;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.couchbase.repository.DynamicProxyable;
import org.springframework.data.couchbase.repository.Scope;
import org.springframework.stereotype.Repository;

@Scope ("LevelScope")
@Collection("LevelCollection")
@Repository
public interface LevelRepository extends CouchbaseRepository<CustomerLevel, String>, DynamicProxyable<LevelRepository> {
}
