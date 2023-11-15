package com.wook.top.member.application.command.port.in;

public record JoinMemberCommand(
		String email,
		String password,
		String nickname) {
}
