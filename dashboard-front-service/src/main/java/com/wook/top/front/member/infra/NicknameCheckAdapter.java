package com.wook.top.front.member.infra;

import com.wook.top.front.member.common.feign.MemberFeignClient;
import com.wook.top.front.member.common.feign.request.CheckNicknameResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NicknameCheckAdapter {
	public final MemberFeignClient memberFeignClient;

	public boolean checkNicknameDuplication(String nickname) {
		ResponseEntity<CheckNicknameResponse> response = memberFeignClient.checkNicknameDuplication(nickname);
		return response.getStatusCode().equals(HttpStatus.OK);
	}
}
