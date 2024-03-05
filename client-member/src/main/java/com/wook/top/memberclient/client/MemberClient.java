package com.wook.top.memberclient.client;

import com.wook.top.memberclient.config.MemberFeignConfig;
import com.wook.top.memberclient.client.response.MemberCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		name = "memberClient",
		url = "${feign.url.member-service:default}",
		configuration = MemberFeignConfig.class
)
public interface MemberClient {

	@GetMapping("/v1/{memberId}/check")
	ResponseEntity<MemberCheckResponse> checkMember(
			@PathVariable Long memberId
	);
}
