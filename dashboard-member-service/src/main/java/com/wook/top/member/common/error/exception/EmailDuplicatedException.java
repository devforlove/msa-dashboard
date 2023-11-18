package com.wook.top.member.common.error.exception;

import com.wook.top.member.common.error.ErrorCode;

public class EmailDuplicatedException extends BusinessException {

	public EmailDuplicatedException(String email) {
		super(ErrorCode.EMAIL_DUPLICATED, String.format("email (%s) is duplicated.", email));
	}
}
