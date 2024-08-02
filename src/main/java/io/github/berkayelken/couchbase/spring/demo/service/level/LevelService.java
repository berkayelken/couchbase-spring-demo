package io.github.berkayelken.couchbase.spring.demo.service.level;

import io.github.berkayelken.couchbase.spring.demo.domain.level.CustomerLevel;
import io.github.berkayelken.couchbase.spring.demo.exception.RecordNotFoundException;
import io.github.berkayelken.couchbase.spring.demo.repository.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LevelService {
	private final LevelRepository repository;

	@Autowired
	public LevelService(LevelRepository repository) {
		this.repository = repository;
	}

	public CustomerLevel createLevel(long level) {
		CustomerLevel customerLevel = new CustomerLevel();
		customerLevel.setValue(level);
		return repository.save(customerLevel);
	}

	public CustomerLevel updateLevel(String id, long level) {
		CustomerLevel customerLevel = repository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
		customerLevel.setValue(level);
		return repository.save(customerLevel);
	}
}
