package com.user.exception;

public class UserAlreadExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadExistsException(String msg) {
		super(msg);
	}

}
