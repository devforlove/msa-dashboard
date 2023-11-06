package com.wook.top.member.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Password {

	@Column(name = "member_password", length = 100)
	String password;
}
