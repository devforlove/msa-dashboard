package com.wook.top.webcore.error.exception;

import com.wook.top.webcore.error.ErrorCode;

public class BusinessException extends RuntimeException {
	private final ErrorCode errorCode;

	public BusinessException(ErrorCode errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
