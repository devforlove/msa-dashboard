package com.wook.top.member.query.application.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.member.exception.NicknameDuplicatedException;
import com.wook.top.member.query.application.port.in.CheckNicknameQuery;
import com.wook.top.member.query.application.port.out.NicknameCheckPort;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class CheckNicknameService implements CheckNicknameQuery {
	private final NicknameCheckPort nicknameCheckPort;

	@Override
	public void checkNicknameDuplication(String nickname) {
		if (!nicknameCheckPort.checkNicknameDuplication(nickname)) {
			throw new NicknameDuplicatedException(nickname);
		}
	}
}
