package com.wook.top.member.adapter.in;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.member.application.command.port.in.JoinMemberInfo;
import com.wook.top.member.application.command.port.in.JoinMemberUseCase;
import com.wook.top.member.application.command.port.in.JoinMemberCommand;
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
public class JoinMemberController {
	private final JoinMemberUseCase joinMemberUseCase;

	@PostMapping("/member")
	public ResponseEntity<JoinMemberInfo> joinMember(
			@RequestBody JoinMemberRequest request
	) {
		JoinMemberCommand command = new JoinMemberCommand(request.email(), request.password(), request.nickname());
		return new ResponseEntity<>(joinMemberUseCase.joinMember(command), HttpStatus.OK);
	}
}
