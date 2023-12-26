package com.wook.top.member.config.query.adapter;

import com.wook.top.common.annotation.PersistenceAdapter;
import com.wook.top.member.config.query.application.port.out.NicknameCheckPort;
import com.wook.top.member.config.query.dao.MemberQueryDao;
import lombok.RequiredArgsConstructor;

@PersistenceAdapter
@RequiredArgsConstructor
public class NicknameCheckAdapter implements NicknameCheckPort {
	private final MemberQueryDao memberQueryDao;

	@Override
	public boolean checkNicknameDuplication(String nickname) {
		return !memberQueryDao.existNickname(nickname);
	}
}
