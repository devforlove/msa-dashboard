package com.wook.top.front.member.controller;

import com.wook.top.front.member.common.dto.JoinCommand;
import com.wook.top.front.member.common.request.JoinRequest;
import com.wook.top.front.member.service.JoinMemberInfo;
import com.wook.top.front.member.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class JoinMemberController {
	private final JoinService joinService;

	@PostMapping("/member")
	public ResponseEntity<JoinMemberInfo> checkNicknameDuplication(
			@RequestBody JoinRequest joinRequest
	) {
		JoinCommand command = new JoinCommand(joinRequest.email(), joinRequest.password(), joinRequest.nickname());
		JoinMemberInfo memberInfo = joinService.joinMember(command);
		return new ResponseEntity<>(memberInfo, HttpStatus.OK);
	}
}
