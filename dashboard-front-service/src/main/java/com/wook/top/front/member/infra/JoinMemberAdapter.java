package com.wook.top.front.member.infra;

import com.wook.top.front.common.http.ApiResponse;
import com.wook.top.front.member.common.dto.JoinDto;
import com.wook.top.front.member.common.feign.MemberFeignClient;
import com.wook.top.front.member.common.feign.request.JoinFeignRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JoinMemberAdapter {
	private final MemberFeignClient memberFeignClient;

	public boolean joinMember(JoinDto request) {
		JoinFeignRequest feignRequest = new JoinFeignRequest(request.email(), request.password(), request.nickname());
		ApiResponse<Boolean> response = memberFeignClient.joinMember(feignRequest);
		return response.getResult();
	}
}
