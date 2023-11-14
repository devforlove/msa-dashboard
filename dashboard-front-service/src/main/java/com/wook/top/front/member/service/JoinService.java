package com.wook.top.front.member.service;

import com.wook.top.front.member.common.dto.JoinDto;
import com.wook.top.front.member.common.feign.request.JoinFeignRequest;
import com.wook.top.front.member.infra.JoinMemberAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
	private final JoinMemberAdapter joinMemberAdapter;
	public boolean joinMember(JoinDto dto) {
		return joinMemberAdapter.joinMember(dto);
	}
}
