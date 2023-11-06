package com.wook.top.member.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class MemberInfo {

	@Column(name = "member_name", length = 100)
	private String name;

	@Column(name = "member_email", length = 200)
	private String email;
}
