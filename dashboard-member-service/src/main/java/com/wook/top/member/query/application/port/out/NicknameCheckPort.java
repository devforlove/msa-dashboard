package com.wook.top.member.query.application.port.out;

public interface NicknameCheckPort {
	boolean checkNicknameDuplication(String nickname);
}
