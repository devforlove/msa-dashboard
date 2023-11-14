package com.wook.top.member.application.command.port.in;

import com.wook.top.member.application.command.port.in.command.JoinMemberCommand;

public interface JoinMemberUseCase {
	boolean joinMember(JoinMemberCommand command);
}
