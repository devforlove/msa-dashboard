package com.wook.top.member.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class MemberInfo {
	@Column(name = "member_name", length = 100)
	private String name;

	@Column(name = "member_email", length = 200)
	private String email;

	public MemberInfo(String name, String email) {
		this.name = name;
		this.email = email;
	}
}
