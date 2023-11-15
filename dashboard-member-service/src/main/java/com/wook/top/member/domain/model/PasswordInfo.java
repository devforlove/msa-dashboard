package com.wook.top.member.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
public class PasswordInfo {
	@Column(name = "member_password", length = 100)
	String password;

	public PasswordInfo(String password) {
		this.password = password;
	}
}
