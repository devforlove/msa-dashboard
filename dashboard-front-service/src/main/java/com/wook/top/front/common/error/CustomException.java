package com.wook.top.front.common.error;

import com.wook.top.common.exception.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	public CustomException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	private final ErrorCode errorCode;
}
