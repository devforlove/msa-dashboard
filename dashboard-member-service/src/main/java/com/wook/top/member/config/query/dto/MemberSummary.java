package com.wook.top.member.config.query.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MemberSummary{
	Long memberId;
	String nickname;
	String profileImage;

	public MemberSummary(Long memberId, String nickname, String profileImage) {
		this.memberId = memberId;
		this.nickname = nickname;
		this.profileImage = profileImage;
	}
}
