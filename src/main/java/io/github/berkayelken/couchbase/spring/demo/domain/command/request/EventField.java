package io.github.berkayelken.couchbase.spring.demo.domain.command.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EventField {
	CITIZEN_NUMBER("citizenNumber", Long.class),
	NAME("name", String.class),
	SURNAME("surname", String.class),
	AGE("age", Integer.class),
	CITY("city", String.class),
	EMAIL("email", String.class),
	PHONE("phone", String.class),
	PREMIUM("premium", Boolean.class);

	private final String fieldName;
	private final Class<?> type;

	public boolean checkValueTypeFeasible(Object value) {
		if (value == null) {
			return false;
		}

		return type.isInstance(value);
	}
}
