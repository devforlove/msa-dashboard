package com.wook.top.member.command.domain.model;

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
	private PasswordInfo password;

	@Column(name = "member_like_count")
	private Integer likeCount;

	@Column(name = "member_score")
	@Convert(converter = ScoreConverter.class)
	private Score score;

	@Enumerated(value = EnumType.STRING)
	@Column(name = "member_grade")
	private Grade grade;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
			joinColumns = { @JoinColumn(name = "member_id", referencedColumnName = "memberId")},
			inverseJoinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "roleId")}
	)
	private Set<UserRole> roles;

	public Member(MemberInfo memberInfo, PasswordInfo password, Set<UserRole> roles) {
		this.memberInfo = memberInfo;
		this.password = password;
		this.roles = roles;
	}

	public static Member createMember(String email, String password, String nickname, Set<UserRole> roles) {
		MemberInfo memberInfo = new MemberInfo(email, nickname);
		PasswordInfo passwordInfo = new PasswordInfo(password);
		return new Member(memberInfo, passwordInfo, roles);
	}
}
