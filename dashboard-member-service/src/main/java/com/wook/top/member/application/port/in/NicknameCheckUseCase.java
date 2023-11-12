package com.wook.top.member.application.port.in;

public interface NicknameCheckUseCase {

	boolean checkNicknameDuplication(String nickname);
}
