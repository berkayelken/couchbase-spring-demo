package io.github.berkayelken.couchbase.spring.demo.domain.level;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Getter
@Setter
@ToString
@Document
public class CustomerLevel {
	@Id
	@GeneratedValue (strategy = GenerationStrategy.UNIQUE)
	private String id;
	@Version
	@Field
	private long version;
	@Field
	private long value;
}
