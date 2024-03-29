package com.wook.top.member.command.domain.repository;

import com.wook.top.member.command.domain.model.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

public interface MemberRepository extends Repository<Member, Long> {
	Optional<Member> findByMemberId(Long memberId);
	Optional<Member> findByMemberInfoEmail(String email);
	boolean existsByMemberInfoEmail(String email);
	boolean existsByMemberInfoNickname(String nickname);
	void save(Member member);
}
