package com.wook.top.member.application.command.port.out;

import com.wook.top.member.domain.model.Member;

public interface JoinMemberPort {
	Member joinMember(Member member);
}
