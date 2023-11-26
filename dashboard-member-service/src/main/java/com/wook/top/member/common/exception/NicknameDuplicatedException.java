package com.wook.top.member.common.exception;

import com.wook.top.webcore.error.ErrorCode;
import com.wook.top.webcore.error.exception.BusinessException;

public class NicknameDuplicatedException extends BusinessException {

	public NicknameDuplicatedException(String nickname) {
		super(ErrorCode.NICKNAME_DUPLICATED, String.format("nickname (%s) is duplicated.", nickname));
	}
}
