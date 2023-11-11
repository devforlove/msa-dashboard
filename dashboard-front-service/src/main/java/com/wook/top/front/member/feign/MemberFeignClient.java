package com.wook.top.front.member.feign;

import com.wook.top.front.common.http.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		name = "member-client",
		url = "${feign.url.member}",
		configuration = MemberFeignConfig.class
)
public interface MemberFeignClient {

	@GetMapping("/member/v1/email/{email}")
	ApiResponse<String> checkDuplicatedEmail(
			@PathVariable String email
	);
}
