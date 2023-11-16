package com.wook.top.member.query.adapter;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.member.query.application.port.out.NicknameCheckPort;
import com.wook.top.member.query.dao.MemberQueryDao;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class NicknameCheckAdapter implements NicknameCheckPort {
	private final MemberQueryDao memberQuerydslRepository;

	@Override
	public boolean checkNicknameDuplication(String nickname) {
		return !memberQuerydslRepository.existNickname(nickname);
	}
}
