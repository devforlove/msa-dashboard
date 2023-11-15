package com.wook.top.member.adapter.out.persistence;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.member.application.command.port.out.JoinMemberPort;
import com.wook.top.member.domain.model.Member;
import com.wook.top.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class JoinMemberAdapter implements JoinMemberPort {
	private final MemberRepository memberRepository;

	@Override
	public Member joinMember(Member member) {
		return memberRepository.save(member);
	}
}
