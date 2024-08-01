package io.github.berkayelken.couchbase.spring.demo.domain.command.request;

import io.github.berkayelken.couchbase.spring.demo.domain.command.CustomerEvent;
import io.github.berkayelken.couchbase.spring.demo.domain.command.EventOperation;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
public class EventRequest {
	private String relatedCustomer;
	private EventOperation operation;
	private List<EventFieldRequest> fields;

	public List<CustomerEvent> convertCustomerEvents() {
		if (!StringUtils.hasText(relatedCustomer) || operation == null) {
			return null;
		}

		if (operation == EventOperation.DELETE) {
			return Collections.singletonList(new CustomerEvent(relatedCustomer, operation));
		}

		return fields.stream().filter(Objects::nonNull).map(field -> field.convertCustomerEvent(relatedCustomer, operation))
				.toList();
	}

}