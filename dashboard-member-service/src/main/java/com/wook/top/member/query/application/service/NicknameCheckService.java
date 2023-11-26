package com.wook.top.member.query.application.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.member.common.exception.NicknameDuplicatedException;
import com.wook.top.member.query.application.port.in.NicknameCheckUseCase;
import com.wook.top.member.query.application.port.out.NicknameCheckPort;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class NicknameCheckService implements NicknameCheckUseCase {
	private final NicknameCheckPort nicknameCheckPort;

	@Override
	public void checkNicknameDuplication(String nickname) {
		if (!nicknameCheckPort.checkNicknameDuplication(nickname)) {
			throw new NicknameDuplicatedException(nickname);
		}
	}
}
