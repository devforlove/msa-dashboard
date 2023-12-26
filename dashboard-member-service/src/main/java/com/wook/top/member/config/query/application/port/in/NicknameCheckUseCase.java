package com.wook.top.member.config.query.application.port.in;

public interface NicknameCheckUseCase {

	void checkNicknameDuplication(String nickname);
}
