package io.github.berkayelken.couchbase.spring.demo.domain.command;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.time.Instant;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document
public class CustomerEvent {
	@Id
	@GeneratedValue (strategy = GenerationStrategy.UNIQUE)
	private String id;
	private String relatedCustomer;
	private EventOperation operation;
	private long operationTime;
	private String field;
	private Object value;

	public CustomerEvent(String relatedCustomer, EventOperation operation) {
		this.relatedCustomer = relatedCustomer;
		this.operation = operation;
		operationTime = Instant.now().toEpochMilli();
	}

	public CustomerEvent(String relatedCustomer, EventOperation operation, String field, Object value) {
		this(relatedCustomer, operation);
		this.field = field;
		this.value = value;
	}
}
