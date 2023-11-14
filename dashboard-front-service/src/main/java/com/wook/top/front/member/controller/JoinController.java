package com.wook.top.front.member.controller;

import com.wook.top.front.common.http.ApiResponse;
import com.wook.top.front.member.common.dto.JoinDto;
import com.wook.top.front.member.common.request.JoinRequest;
import com.wook.top.front.member.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class JoinController {
	private final JoinService joinService;

	@PostMapping("/member/nickname/{nickname}")
	public ApiResponse<Boolean> checkNicknameDuplication(
			@RequestBody JoinRequest joinRequest
	) {
		JoinDto joinDto = new JoinDto(joinRequest.email(), joinRequest.password(), joinRequest.nickname());
		return new ApiResponse<>(joinService.joinMember(joinDto), HttpStatus.OK.value());
	}
}
