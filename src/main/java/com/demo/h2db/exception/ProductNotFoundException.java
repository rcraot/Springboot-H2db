package com.demo.h2db.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ProductNotFoundException(String exceptionDetail, Long fieldValue) {
		super(exceptionDetail + " - " + fieldValue);
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
}
