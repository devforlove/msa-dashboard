package com.wook.top.member.command.application.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.member.command.application.port.in.JoinMemberInfo;
import com.wook.top.member.command.application.port.in.JoinMemberUseCase;
import com.wook.top.member.command.application.port.in.JoinMemberCommand;
import com.wook.top.member.command.application.port.out.JoinMemberPort;
import com.wook.top.member.command.domain.model.Member;
import lombok.RequiredArgsConstructor;

@UseCase
@RequiredArgsConstructor
public class JoinMemberService implements JoinMemberUseCase {
	private final JoinMemberPort joinMemberPort;

	@Override
	public JoinMemberInfo joinMember(JoinMemberCommand command) {
		Member member = joinMemberPort.joinMember(Member.createMember(command.email(), command.password(), command.nickname()));
		return new JoinMemberInfo(member.getMemberInfo().getEmail(), member.getMemberInfo().getName());
	}
}
