package com.wook.top.front.member.common.request;

public record JoinRequest(
		String email,
		String password,
		String nickname
) {
}
