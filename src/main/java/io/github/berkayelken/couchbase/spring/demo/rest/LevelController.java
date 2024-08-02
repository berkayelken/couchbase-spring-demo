package io.github.berkayelken.couchbase.spring.demo.rest;

import io.github.berkayelken.couchbase.spring.demo.domain.level.CustomerLevel;
import io.github.berkayelken.couchbase.spring.demo.service.level.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/level")
public class LevelController {
	private final LevelService service;

	@Autowired
	public LevelController(LevelService service) {
		this.service = service;
	}

	@PostMapping ("/{level}")
	public CustomerLevel create(@PathVariable ("level") long level) {
		return service.createLevel(level);
	}

	@PutMapping ("/{id}/{level}")
	public CustomerLevel update(@PathVariable ("id") String id, @PathVariable ("level") long level) {
		return service.updateLevel(id, level);
	}
}
