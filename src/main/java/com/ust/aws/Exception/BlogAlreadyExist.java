package com.ust.aws.Exception;

public class BlogAlreadyExist extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BlogAlreadyExist(String msg) {
		super(msg);
	}

}
