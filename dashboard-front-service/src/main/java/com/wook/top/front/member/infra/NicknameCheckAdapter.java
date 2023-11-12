package com.wook.top.front.member.infra;

import com.wook.top.front.common.http.ApiResponse;
import com.wook.top.front.member.common.feign.MemberFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NicknameCheckAdapter {
	public final MemberFeignClient memberFeignClient;

	public boolean checkNicknameDuplication(String nickname) {
		ApiResponse<Boolean> response = memberFeignClient.checkNicknameDuplication(nickname);
		return response.getResult();
	}
}
