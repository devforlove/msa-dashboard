package com.wook.top.testFixture;

import com.wook.top.member.config.security.SecurityUser;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

public enum SecurityUserFixture {
	MEMBER(1L, "inwook94@naver.com", "wjddlsdnr12!", "inwook", AuthorityUtils.createAuthorityList(List.of("ROLE_MEMBER"))),
	ADMIN(2L, "admin@naver.com", "admin12!", "admin", AuthorityUtils.createAuthorityList(List.of("ROLE_MEMBER", "ROLE_ADMIN")));

	Long memberId;
	String email;
	String password;
	String nickname;
	List<GrantedAuthority> authorities;

	SecurityUserFixture(Long memberId, String email, String password, String nickname, List<GrantedAuthority> authorities) {
		this.memberId = memberId;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.authorities = authorities;
	}

	public SecurityUser getSecurityUser() {
		return new SecurityUser(memberId, email, password, nickname, authorities);
	}
}
