package com.wook.top.member.common.error.exception;


import com.wook.top.member.common.error.ErrorCode;

public class EntityNotFoundException extends BusinessException {

	public EntityNotFoundException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}
}
