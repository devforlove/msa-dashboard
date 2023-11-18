package com.wook.top.member.command.domain.repository;

import com.wook.top.member.command.domain.model.Member;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long> {
	boolean existsByMemberInfoEmail(String email);
	void save(Member member);
}
