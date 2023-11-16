package com.wook.top.member.query.application.port.in;

public interface NicknameCheckUseCase {

	boolean checkNicknameDuplication(String nickname);
}
