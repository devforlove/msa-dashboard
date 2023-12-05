package com.wook.top.member.command.adapter.in.web;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.member.command.application.port.in.ProfileUpdateCommand;
import com.wook.top.member.command.application.port.in.ProfileUpdateInfo;
import com.wook.top.member.command.application.port.in.ProfileUpdateUseCase;
import com.wook.top.webcore.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequestMapping("/member/v1")
@RequiredArgsConstructor
public class ProfileUpdateController {

	private final ProfileUpdateUseCase profileUpdateUseCase;

	@PostMapping("/profile/me")
	public ResponseEntity<ProfileUpdateInfo> updateProfile(
			@RequestParam String nickname,
			@RequestParam String profileImage,
			@AuthenticationPrincipal SecurityUser securityUser
	) {
		ProfileUpdateCommand command = new ProfileUpdateCommand(
				nickname,
				profileImage,
				securityUser.getMemberId()
		);

		return new ResponseEntity<>(profileUpdateUseCase.updateProfile(command), HttpStatus.OK);
	}
}
