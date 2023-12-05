package com.wook.top.member.command.domain.model;

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
	private String nickname;

	@Column(name = "member_email", length = 200)
	private String email;

	@Column(name = "member_profile_image", length = 200)
	private String profileImage;

	public MemberInfo(String email, String nickname, String profileImage) {
		this.email = email;
		this.nickname = nickname;
		this.profileImage = profileImage;
	}

	public void changeMemberInfo(String nickname, String profileImage) {
		this.nickname = nickname;
		this.profileImage = profileImage;
	}
}
