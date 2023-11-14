package com.wook.top.member.application.query.port.in;

public interface NicknameCheckUseCase {

	boolean checkNicknameDuplication(String nickname);
}
