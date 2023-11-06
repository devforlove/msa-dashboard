package com.wook.top.member.domain.model;

import com.wook.top.member.domain.model.converter.MoneyConverter;
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

@Entity
@Table(name = "member")
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long memberId;

	@Embedded
	private MemberInfo memberInfo;

	@Embedded
	private Password password;

	@Column(name = "member_like_count")
	private Integer likeCount;

	@Column(name = "member_score")
	@Convert(converter = MoneyConverter.class)
	private Score score;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "member_grade", length =30)
	private Grade grade;

	private enum Grade {
		JUNIOR, SENIOR, SOPHOMORE
	}
}
