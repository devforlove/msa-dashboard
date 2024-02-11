package com.wook.top.member.query.dao;


import static com.wook.top.member.command.domain.model.QMember.member;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.wook.top.member.query.dto.MemberSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberQueryDao {
	private final JPAQueryFactory queryFactory;

	public Boolean existNickname(String nickname) {
		Integer fetchOne = queryFactory
				.selectOne()
				.from(member)
				.where(member.memberInfo.nickname.eq(nickname))
				.fetchFirst();

		return fetchOne != null;
	}

	public MemberSummary findMemberSummaryById(Long id) {
		return queryFactory
				.select(Projections.fields(MemberSummary.class,
						member.memberId,
						member.memberInfo.nickname,
						member.memberInfo.profileImage
				))
				.from(member)
				.where(member.memberId.eq(id))
				.fetchOne();
	}
}
