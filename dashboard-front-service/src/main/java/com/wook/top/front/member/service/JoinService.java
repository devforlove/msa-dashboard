package com.wook.top.front.member.service;

import com.wook.top.front.member.common.dto.JoinCommand;
import com.wook.top.front.member.infra.JoinMemberAdapter;
import com.wook.top.front.member.infra.JoinRemoteResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
	private final JoinMemberAdapter joinMemberAdapter;

	public JoinMemberInfo joinMember(JoinCommand command) {
		JoinRemoteResponse response = joinMemberAdapter.joinMember(command);
		return new JoinMemberInfo(response.email(), response.nickname());
	}
}
