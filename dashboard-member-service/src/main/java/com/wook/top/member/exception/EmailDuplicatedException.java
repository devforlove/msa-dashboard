package com.wook.top.member.exception;

import com.wook.top.webcore.error.ErrorCode;
import com.wook.top.webcore.error.exception.BusinessException;

public class EmailDuplicatedException extends BusinessException {

	public EmailDuplicatedException(String email) {
		super(ErrorCode.EMAIL_DUPLICATED, String.format("email (%s) is duplicated.", email));
	}
}
