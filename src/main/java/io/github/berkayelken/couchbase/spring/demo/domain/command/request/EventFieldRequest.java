package io.github.berkayelken.couchbase.spring.demo.domain.command.request;

import io.github.berkayelken.couchbase.spring.demo.domain.command.CustomerEvent;
import io.github.berkayelken.couchbase.spring.demo.domain.command.EventOperation;

import io.github.berkayelken.couchbase.spring.demo.exception.EventException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EventFieldRequest {
	private static final String EVENT_FAILURE = "User did not give proper events.";
	private EventField field;
	private Object value;

	public boolean checkValueTypeFeasible() {
		if (field == null) {
			return false;
		}

		return field.checkValueTypeFeasible(value);
	}

	CustomerEvent convertCustomerEvent(String relatedCustomer, EventOperation operation) {
		if(!checkValueTypeFeasible()) {
			throw new EventException(EVENT_FAILURE);
		}

		return new CustomerEvent(relatedCustomer, operation, field.getFieldName(), value);
	}
}
