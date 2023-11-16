package com.wook.top.member.command.application.port.out;

import com.wook.top.member.command.domain.model.Member;

public interface JoinMemberPort {
	Member joinMember(Member member);
}
