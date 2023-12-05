package com.wook.top.member.command.application.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.member.command.application.port.in.ProfileUpdateCommand;
import com.wook.top.member.command.application.port.in.ProfileUpdateInfo;
import com.wook.top.member.command.application.port.in.ProfileUpdateUseCase;
import com.wook.top.member.command.application.port.out.ProfileUpdatePort;
import com.wook.top.member.command.domain.model.Member;
import com.wook.top.member.command.domain.repository.MemberRepository;
import com.wook.top.member.common.exception.EntityNotFoundException;
import com.wook.top.webcore.error.ErrorCode;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class ProfileUpdateService implements ProfileUpdateUseCase {

	private final ProfileUpdatePort profileUpdatePort;

	@Transactional
	@Override
	public ProfileUpdateInfo updateProfile(ProfileUpdateCommand command) {
		Member member = profileUpdatePort.findMemberById(command.memberId())
				.orElseThrow(() -> new EntityNotFoundException(ErrorCode.MEMBER_NOT_FOUND, String.format("member not found memberId=%s", command.memberId())));
		member.changeProfile(command.nickname(), command.profileImage());

		return ProfileUpdateInfo.builder()
				.nickname(member.getMemberInfo().getNickname())
				.profileImageUrl(member.getMemberInfo().getProfileImage())
				.build();
	}
}
