package com.wook.top.testFixture;

import com.wook.top.member.command.domain.model.Member;
import com.wook.top.member.command.domain.model.UserRole;
import java.util.Set;

public enum MemberFixture {

	NORMAL_MEMBER("member@company.com", "password1234!", "홍길동");

	private final String email;
	private final String password;
	private final String nickname;

	MemberFixture(String email, String password, String nickname) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}

	public Member getMember(String email, String password, String nickname, Set<UserRole> roles) {
		return Member.createMember(email, password, nickname, null, roles);
	}
}
