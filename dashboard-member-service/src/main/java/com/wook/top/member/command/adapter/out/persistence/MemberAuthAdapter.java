package com.wook.top.member.command.adapter.out.persistence;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.member.command.application.port.out.MemberAuthPort;
import com.wook.top.member.command.domain.model.Member;
import com.wook.top.member.command.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class MemberAuthAdapter implements MemberAuthPort {
	private final MemberRepository memberRepository;

	@Override
	public void joinMember(Member member) {
		memberRepository.save(member);
	}

	@Override
	public boolean existByEmail(String email) {
		return memberRepository.existsByMemberInfoEmail(email);
	}

	@Override
	public boolean existByNickname(String nickname) {
		return memberRepository.existsByMemberInfoName(nickname);
	}
}
