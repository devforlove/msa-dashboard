package com.wook.top.member.query.application.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.member.query.application.port.in.NicknameCheckUseCase;
import com.wook.top.member.query.application.port.out.NicknameCheckPort;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class NicknameCheckService implements NicknameCheckUseCase {
	private final NicknameCheckPort nicknameCheckPort;

	@Override
	public boolean checkNicknameDuplication(String nickname) {
		return nicknameCheckPort.checkNicknameDuplication(nickname);
	}
}
