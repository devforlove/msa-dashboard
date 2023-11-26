package com.wook.top.webcore.error;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
	INVALID_INPUT_VALUE(BAD_REQUEST, 400000, "invalid input value"),
	NICKNAME_DUPLICATED(BAD_REQUEST, 400001, "nickname duplicated"),
	EMAIL_DUPLICATED(BAD_REQUEST, 400002, "email duplicated"),
	USER_UNAUTHORIZED(UNAUTHORIZED, 401000, "user not authorized");

	private final HttpStatus status;
	private final int  code;
	private final String message;

	ErrorCode(HttpStatus status, int code, String message) {
		this.status = status;
		this.code = code;
		this.message = message;
	}
}
