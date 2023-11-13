package com.wook.top.front.member.controller;

import com.wook.top.front.common.http.ApiResponse;
import com.wook.top.front.member.service.NicknameCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class NicknameCheckController {
	private final NicknameCheckService nicknameCheckService;

	@GetMapping("/member/nickname/{nickname}")
	public ApiResponse<Boolean> checkNicknameDuplication(
			@PathVariable String nickname
	) {
		return new ApiResponse<>(nicknameCheckService.checkNicknameDuplication(nickname), HttpStatus.OK.value());
	}
}
