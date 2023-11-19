package com.wook.top.member.command.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class PasswordInfo {
	@Column(name = "member_password", length = 100)
	String password;

	public PasswordInfo(String password) {
		this.password = password;
	}
}
