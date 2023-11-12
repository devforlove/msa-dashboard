package com.wook.top.front.member.controller;

import com.wook.top.front.common.http.ApiResponse;
import com.wook.top.front.member.common.request.CheckNicknameRequest;
import com.wook.top.front.member.service.NicknameCheckService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class NicknameCheckController {
	private final NicknameCheckService nicknameCheckService;

	@PostMapping("/member/nickname")
	public ApiResponse<Boolean> checkNicknameDuplication(
			@RequestBody CheckNicknameRequest request
	) {
		return new ApiResponse<>(nicknameCheckService.checkNicknameDuplication(request.nickname()), HttpStatus.OK.value());
	}
}
