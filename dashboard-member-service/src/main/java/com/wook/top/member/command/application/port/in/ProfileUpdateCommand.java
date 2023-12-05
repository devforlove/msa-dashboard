package com.wook.top.member.command.application.port.in;

public record ProfileUpdateCommand(
		String nickname,
		String profileImage,
		Long memberId) {

}
