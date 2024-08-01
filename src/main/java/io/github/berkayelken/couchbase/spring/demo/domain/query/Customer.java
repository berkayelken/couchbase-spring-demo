package io.github.berkayelken.couchbase.spring.demo.domain.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

@Getter
@Setter
@ToString
@Document
public class Customer {
	@Id
	@GeneratedValue (strategy = GenerationStrategy.UNIQUE)
	private String id;
	@Field
	private long citizenNumber;
	@Field
	private String name;
	@Field
	private String surname;
	@Field
	private int age;
	@Field
	private String city;
	@Field
	private String email;
	@Field
	private String phone;
	@Field
	private boolean premium;
}
