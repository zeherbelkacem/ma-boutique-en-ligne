package com.fms.springEx1.Exceptions;

public class EntityNotFound extends ClassNotFoundException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String message;

	public EntityNotFound(String message) {
		super();
		this.message = message;
	}
	
}
