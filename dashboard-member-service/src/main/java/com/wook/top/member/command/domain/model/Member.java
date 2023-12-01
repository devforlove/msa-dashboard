package com.wook.top.member.command.domain.model;

import com.wook.top.member.command.domain.model.converter.MemberLikeCountConverter;
import com.wook.top.member.command.domain.model.converter.ScoreConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Set;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class Member implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long memberId;

	@Embedded
	private MemberInfo memberInfo;

	@Embedded
	private PasswordInfo passwordInfo;

	@Column(name = "member_like_count")
	@Convert(converter = MemberLikeCountConverter.class)
	private LikeCount likeCount;

	@Column(name = "member_score")
	@Convert(converter = ScoreConverter.class)
	private Score score;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "member_grade")
	private Grade grade;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
			joinColumns = { @JoinColumn(name = "memberId", referencedColumnName = "member_id")},
			inverseJoinColumns = { @JoinColumn(name = "roleId", referencedColumnName = "role_id")}
	)
	private Set<UserRole> roles;

	public Member(MemberInfo memberInfo, PasswordInfo passwordInfo, LikeCount likeCount, Score score, Grade grade, Set<UserRole> roles) {
		this.memberInfo = memberInfo;
		this.passwordInfo = passwordInfo;
		this.likeCount = likeCount;
		this.score = score;
		this.grade = grade;
		this.roles = roles;
	}

	public static Member createMember(String email, String password, String nickname, String profileImage, Set<UserRole> roles) {
		MemberInfo memberInfo = new MemberInfo(email, nickname, profileImage);
		PasswordInfo passwordInfo = new PasswordInfo(password);
		LikeCount likeCount = new LikeCount(0);
		Score score = new Score(0);
		return new Member(memberInfo, passwordInfo, likeCount, score, Grade.COMMON, roles);
	}
}
