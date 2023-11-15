package com.wook.top.front.member.common.dto;

public record JoinCommand(
		String email,
		String password,
		String nickname
) {

}
