package com.wook.top.member.command.adapter.in.web;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.member.command.application.port.in.JoinMemberInfo;
import com.wook.top.member.command.application.port.in.MemberAuthUseCase;
import com.wook.top.member.command.application.port.in.JoinMemberCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequestMapping("/member/v1")
@RequiredArgsConstructor
public class MemberAuthController {
	private final MemberAuthUseCase memberAuthUseCase;

	@PostMapping("/member")
	public ResponseEntity<JoinMemberInfo> joinMember(
			@RequestBody JoinMemberRequest request
	) {
		JoinMemberCommand command = new JoinMemberCommand(
				request.email(),
				request.password(),
				request.nickname()
		);
		return new ResponseEntity<>(memberAuthUseCase.joinMember(command), HttpStatus.OK);
	}
}
