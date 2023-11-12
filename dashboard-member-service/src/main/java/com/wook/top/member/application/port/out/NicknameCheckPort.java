package com.wook.top.member.application.port.out;

public interface NicknameCheckPort {
	boolean checkNicknameDuplication(String nickname);
}
