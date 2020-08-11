package com.encore.exception;
// 그런 레코드 없다. 그런 데이터 없다.
public class RecordNotFoundException extends Exception {
	public RecordNotFoundException() {
		this("This is RecordNotFoundException...");
	}
	public RecordNotFoundException(String message) {
		super(message);
	}
}
