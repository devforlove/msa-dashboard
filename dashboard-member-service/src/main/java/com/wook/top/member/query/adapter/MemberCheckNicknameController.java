package com.wook.top.member.query.adapter;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.member.query.application.port.in.NicknameCheckUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<MemberCheckNicknameResponse> checkNicknameDuplication(
			@PathVariable("nickname") String nickname
	) {
		checkNicknameUseCase.checkNicknameDuplication(nickname);
		return new ResponseEntity<>(new MemberCheckNicknameResponse(nickname), HttpStatus.OK);
	}
}
