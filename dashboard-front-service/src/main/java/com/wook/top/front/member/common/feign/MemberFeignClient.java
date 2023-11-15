package com.wook.top.front.member.common.feign;

import com.wook.top.front.member.common.feign.request.CheckNicknameResponse;
import com.wook.top.front.member.common.feign.request.JoinFeignRequest;
import com.wook.top.front.member.infra.JoinRemoteResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
		name = "member-client",
		url = "${feign.url.member}",
		configuration = MemberFeignConfig.class
)
public interface MemberFeignClient {

	@PostMapping("/v1/member")
	ResponseEntity<JoinRemoteResponse> joinMember(
		@RequestBody JoinFeignRequest joinFeignRequest
	);

	@GetMapping("/v1/nickname/{nickname}")
	ResponseEntity<CheckNicknameResponse> checkNicknameDuplication(
			@PathVariable String nickname
	);
}
