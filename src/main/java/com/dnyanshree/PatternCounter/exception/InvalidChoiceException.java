package com.dnyanshree.PatternCounter.exception;


public class InvalidChoiceException extends RuntimeException {
	private static final long serialVersionUID = -8577427513124689088L;

	public InvalidChoiceException(String message){
		super(message);
	}
}
