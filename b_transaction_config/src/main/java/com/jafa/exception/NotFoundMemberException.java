package com.jafa.exception;

public class NotFoundMemberException extends RuntimeException{

	public NotFoundMemberException() {
		super("계좌정보를 찾을 수 없습니다.");
	}
}
