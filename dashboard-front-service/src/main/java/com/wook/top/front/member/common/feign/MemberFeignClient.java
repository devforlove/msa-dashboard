package com.wook.top.front.member.common.feign;

import com.wook.top.front.common.http.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(
		name = "member-client",
		url = "${feign.url.member}",
		configuration = MemberFeignConfig.class
)
public interface MemberFeignClient {

	@PostMapping("/v1/member")
	ApiResponse<String> joinMember(

	);

	@GetMapping("/v1/nickname/{nickname}")
	ApiResponse<Boolean> checkNicknameDuplication(
			@PathVariable String nickname
	);
}
