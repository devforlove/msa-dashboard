package com.wook.top.member.exception;


import com.wook.top.webcore.error.ErrorCode;
import com.wook.top.webcore.error.exception.BusinessException;

public class EntityNotFoundException extends BusinessException {

	public EntityNotFoundException(ErrorCode errorCode, String message) {
		super(errorCode, message);
	}
}
