package com.wook.top.member.command.domain.model;

import com.wook.top.member.command.domain.model.converter.ScoreConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long memberId;

	@Embedded
	private MemberInfo memberInfo;

	@Embedded
	private PasswordInfo password;

	@Column(name = "member_like_count")
	private Integer likeCount;

	@Column(name = "member_score")
	@Convert(converter = ScoreConverter.class)
	private Score score;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "member_grade")
	private Grade grade;

	public enum Grade {
		JUNIOR, SENIOR, SOPHOMORE
	}

	public Member(MemberInfo memberInfo, PasswordInfo password) {
		this.memberInfo = memberInfo;
		this.password = password;
	}

	public static Member createMember(String email, String password, String nickname) {
		MemberInfo memberInfo = new MemberInfo(email, nickname);
		PasswordInfo passwordInfo = new PasswordInfo(password);
		return new Member(memberInfo, passwordInfo);
	}
}
