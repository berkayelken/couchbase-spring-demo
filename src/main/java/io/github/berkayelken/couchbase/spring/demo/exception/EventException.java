package io.github.berkayelken.couchbase.spring.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class EventException extends RuntimeException{
	private final String message;
}
