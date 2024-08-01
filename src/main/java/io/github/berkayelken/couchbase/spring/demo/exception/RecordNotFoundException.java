package io.github.berkayelken.couchbase.spring.demo.exception;

import lombok.ToString;

@ToString
public class RecordNotFoundException extends RuntimeException{
	private static final String NOT_FOUND = "Record not found with id %s";

	private final String message;

	public RecordNotFoundException(String id) {
		message = String.format(NOT_FOUND, id);
	}
}
