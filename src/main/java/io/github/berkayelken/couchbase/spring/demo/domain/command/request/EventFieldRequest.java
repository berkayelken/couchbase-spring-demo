package io.github.berkayelken.couchbase.spring.demo.domain.command.request;

import io.github.berkayelken.couchbase.spring.demo.domain.command.CustomerEvent;
import io.github.berkayelken.couchbase.spring.demo.domain.command.EventOperation;

import io.github.berkayelken.couchbase.spring.demo.exception.EventException;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.concurrent.atomic.AtomicBoolean;

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

	CustomerEvent convertCustomerEvent(String relatedCustomer, EventOperation operation, AtomicBoolean firstOperationOfCreation) {
		if(!checkValueTypeFeasible()) {
			throw new EventException(EVENT_FAILURE);
		}

		EventOperation exactOperation = getExactOperation(operation, firstOperationOfCreation);

		return new CustomerEvent(relatedCustomer, exactOperation, field.getFieldName(), value);
	}

	private EventOperation getExactOperation(EventOperation operation, AtomicBoolean firstOperationOfCreation) {
		if (operation != EventOperation.CREATE) {
			return operation;
		}

		if(firstOperationOfCreation.get()) {
			firstOperationOfCreation.set(false);
			return operation;
		}

		operation = EventOperation.UPDATE;
		return operation;
	}
}
