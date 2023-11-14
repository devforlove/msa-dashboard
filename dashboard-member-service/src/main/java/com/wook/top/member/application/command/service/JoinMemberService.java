package com.wook.top.member.application.command.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.member.application.command.port.in.JoinMemberUseCase;
import com.wook.top.member.application.command.port.in.command.JoinMemberCommand;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class JoinMemberService implements JoinMemberUseCase {

	@Override
	public boolean joinMember(JoinMemberCommand command) {
		return false;
	}
}
