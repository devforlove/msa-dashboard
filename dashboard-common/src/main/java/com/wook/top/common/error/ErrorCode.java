package com.wook.top.common.error;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
	INVALID_INPUT_VALUE(BAD_REQUEST, 400000, "invalid input value"),
	BAD_ARGUMENT(BAD_REQUEST, 400001, "bad argument"),
	INVALID_PARAMETER(BAD_REQUEST, 400002, "invalid parameter"),
	USER_NOT_VALID(BAD_REQUEST, 400003, "user not valid"),
	RESOURCE_NOT_VALID(BAD_REQUEST, 400004, "resource not valid"),
	DUPLICATE_RESOURCE(BAD_REQUEST, 400004, "duplicate resource"),

	/** 401 */
	MEMBER_UNAUTHORIZED(UNAUTHORIZED, 401001, "unauthorized member"),
	CLIENT_USER_NOT_AUTHORIZED(UNAUTHORIZED, 401002, "client user not authorized"),

	/** 403 */
	FORBIDDEN_RESOURCE(FORBIDDEN, 403001, "forbidden resource"),
	INVALID_ACCOUNT(FORBIDDEN, 403002, "invalid account"),

	/** 404 */
	NOT_FOUND_FROM_REMOTE(NOT_FOUND, 404000, "resource not found in remote"),
	USER_NOT_FOUND(NOT_FOUND, 404001, "user not found"),
	RESOURCE_NOT_FOUND(NOT_FOUND, 404002, "resource not found"),
	CLIENT_USER_NOT_FOUND(NOT_FOUND, 404003, "client user not found"),

	/** 409 */
	USER_ALREADY_EXIST(CONFLICT, 409001, "user already exist"),
	RESOURCE_ALREADY_EXIST(CONFLICT, 409002, "resource already exist"),
	RESOURCE_NAME_ALREADY_EXIST(CONFLICT, 409003, "resource name already exist"),

	/** 500 */
	INTERNAL_SERVER_ERR(INTERNAL_SERVER_ERROR, 500001, "internal server error");

	private final HttpStatus httpStatus;
	private final int  code;
	private final String message;

	ErrorCode(HttpStatus httpStatus, int code, String message) {
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
	}
}
