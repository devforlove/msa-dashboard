package com.wook.top.member.query.repository;

import static com.wook.top.member.domain.model.QMember.*;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberQuerydslRepository {
	private final JPAQueryFactory queryFactory;

	public Boolean existNickname(String nickname) {
		Integer fetchOne = queryFactory
				.selectOne()
				.from(member)
				.where(member.memberInfo.name.eq(nickname))
				.fetchFirst();

		return fetchOne != null;
	}
}
