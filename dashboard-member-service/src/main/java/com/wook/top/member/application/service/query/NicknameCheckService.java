package com.wook.top.member.application.service.query;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.member.application.port.in.NicknameCheckUseCase;
import com.wook.top.member.application.port.out.NicknameCheckPort;
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
