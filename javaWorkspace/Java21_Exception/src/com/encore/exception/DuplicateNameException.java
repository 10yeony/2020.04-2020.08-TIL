package com.encore.exception;
//이름이 중복되면 터짐.
public class DuplicateNameException extends Exception {
	public DuplicateNameException() {
		this("This is DuplicateNameException...");
	}
	public DuplicateNameException(String message) {
		super(message);
	}
}
