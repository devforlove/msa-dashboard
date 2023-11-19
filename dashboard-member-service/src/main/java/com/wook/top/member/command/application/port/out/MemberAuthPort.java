package com.wook.top.member.command.application.port.out;

import com.wook.top.member.command.domain.model.Member;

public interface MemberAuthPort {
	void joinMember(Member member);
	boolean existByEmail(String email);
	boolean existByNickname(String nickname);
}
