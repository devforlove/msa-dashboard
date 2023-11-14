package com.wook.top.member.adapter.query.in;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.member.application.query.port.in.NicknameCheckUseCase;
import com.wook.top.member.common.http.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/member/v1")
@RequiredArgsConstructor
public class MemberCheckNicknameController {
	private final NicknameCheckUseCase checkNicknameUseCase;

	@GetMapping("/nickname/{nickname}")
	public ApiResponse<Boolean> checkNicknameDuplication(
			@PathVariable("nickname") String nickname
	) {
		return new ApiResponse<>(HttpStatus.OK, checkNicknameUseCase.checkNicknameDuplication(nickname));
	}
}
