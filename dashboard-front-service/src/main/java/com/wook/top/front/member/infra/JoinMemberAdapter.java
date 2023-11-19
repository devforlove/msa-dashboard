package com.wook.top.front.member.infra;

import com.wook.top.front.member.common.dto.JoinCommand;
import com.wook.top.front.member.common.feign.MemberFeignClient;
import com.wook.top.front.member.common.feign.request.JoinFeignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JoinMemberAdapter {
	private final MemberFeignClient memberFeignClient;

	public JoinRemoteResponse joinMember(JoinCommand request) {
		JoinFeignRequest feignRequest = new JoinFeignRequest(request.email(), request.password(), request.nickname());
		ResponseEntity<JoinRemoteResponse> response = memberFeignClient.joinMember(feignRequest);
		return response.getBody();
	}
}
