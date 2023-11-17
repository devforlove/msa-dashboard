package com.wook.top.member.common.error.exception;

import com.wook.top.member.common.error.ErrorCode;

public class NicknameDuplicatedException extends BusinessException {

	public NicknameDuplicatedException(String nickname) {
		super(ErrorCode.NICKNAME_DUPLICATED, String.format("nickname (%s) is duplicated.", nickname));
	}
}
