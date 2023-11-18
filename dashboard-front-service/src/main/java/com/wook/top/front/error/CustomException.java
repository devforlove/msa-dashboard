package com.wook.top.front.error;

import com.wook.top.common.error.ErrorCode;
import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

	public CustomException(ErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	private final ErrorCode errorCode;
}
