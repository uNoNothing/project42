package com.yeti.exception;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BaseException(String message) {
		super(message);
	}
}