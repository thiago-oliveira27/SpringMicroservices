package com.spring.ms.hrworker.exceptions;

public class WorkerNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public WorkerNotFoundException(String msg) {
		super(msg);
	}
}