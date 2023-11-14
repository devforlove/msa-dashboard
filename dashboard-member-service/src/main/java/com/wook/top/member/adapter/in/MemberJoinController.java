package com.wook.top.member.adapter.in;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.member.adapter.in.request.JoinRequest;
import com.wook.top.member.application.command.port.in.JoinMemberUseCase;
import com.wook.top.member.application.command.port.in.command.JoinMemberCommand;
import com.wook.top.member.common.http.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/member/v1")
@WebAdapter
@RequiredArgsConstructor
public class MemberJoinController {
	private final JoinMemberUseCase joinMemberUseCase;

	@PostMapping("/member")
	public ApiResponse<Boolean> joinMember(
			@RequestBody JoinRequest request
	) {
		JoinMemberCommand command = new JoinMemberCommand(request.email(), request.password(), request.nickname());
		return new ApiResponse<>(HttpStatus.OK, joinMemberUseCase.joinMember(command));
	}
}
