package com.wook.top.member.application.query.port.out;

public interface NicknameCheckPort {
	boolean checkNicknameDuplication(String nickname);
}
