package com.wook.top.member.command.application.port.in;

public record JoinMemberCommand(
		String email,
		String password,
		String nickname) {
}
