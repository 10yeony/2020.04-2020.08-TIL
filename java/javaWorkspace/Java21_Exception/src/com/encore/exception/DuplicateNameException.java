package com.encore.exception;
//�̸��� �ߺ��Ǹ� ����.
public class DuplicateNameException extends Exception {
	public DuplicateNameException() {
		this("This is DuplicateNameException...");
	}
	public DuplicateNameException(String message) {
		super(message);
	}
}
