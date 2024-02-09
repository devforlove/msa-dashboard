package com.wook.top.memberclient.client;

import com.wook.top.memberclient.config.FeignConfig;
import com.wook.top.memberclient.response.MemberCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
		name = "demo-client",
		url = "${feign.url.member-service}",
		configuration = FeignConfig.class
)
public interface MemberClient {

	@GetMapping("/v1/{memberId}/check")
	ResponseEntity<MemberCheckResponse> checkMember(
			@PathVariable Long memberId
	);
}
