package com.wook.top.member.adapter.out.persistence;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.member.application.port.out.NicknameCheckPort;
import com.wook.top.member.query.repository.MemberQuerydslRepository;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class NicknameCheckAdapter implements NicknameCheckPort {
	private final MemberQuerydslRepository memberQuerydslRepository;

	@Override
	public boolean checkNicknameDuplication(String nickname) {
		return !memberQuerydslRepository.existNickname(nickname);
	}
}
