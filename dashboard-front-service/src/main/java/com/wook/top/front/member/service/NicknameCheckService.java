package com.wook.top.front.member.service;

import com.wook.top.front.member.infra.NicknameCheckAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NicknameCheckService {
	private final NicknameCheckAdapter nicknameCheckAdapter;

	public boolean checkNicknameDuplication(String nickname) {
		return nicknameCheckAdapter.checkNicknameDuplication(nickname);
	}
}
