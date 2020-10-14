package com.demo.h2db.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String exceptionDetail;
	private Object fieldValue;
	
	public ProductNotFoundException(String exceptionDetail, Long fieldValue) {
		super(exceptionDetail + " - " + fieldValue);
		this.exceptionDetail = exceptionDetail;
		this.fieldValue = fieldValue;
	}

	public ProductNotFoundException(String message) {
		super(message);
	}

	public ProductNotFoundException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public String getExceptionDetail() {
		return exceptionDetail;
	}

	public Object getFieldValue() {
		return fieldValue;
	}
	
}
