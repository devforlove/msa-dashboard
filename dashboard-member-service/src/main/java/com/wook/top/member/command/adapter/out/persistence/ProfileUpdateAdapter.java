package com.wook.top.member.command.adapter.out.persistence;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.member.command.application.port.out.ProfileUpdatePort;
import com.wook.top.member.command.domain.model.Member;
import com.wook.top.member.command.domain.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class ProfileUpdateAdapter implements ProfileUpdatePort {

	private final MemberRepository memberRepository;

	@Override
	public Optional<Member> findMemberById(Long memberId) {
		return memberRepository.findByMemberId(memberId);
	}
}
