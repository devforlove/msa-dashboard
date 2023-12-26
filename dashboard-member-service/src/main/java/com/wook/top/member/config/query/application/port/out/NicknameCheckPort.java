package com.wook.top.member.config.query.application.port.out;

public interface NicknameCheckPort {
	boolean checkNicknameDuplication(String nickname);
}
