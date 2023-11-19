package com.wook.top.member.command.application.service;

import com.wook.top.common.annotation.UseCase;
import com.wook.top.member.command.application.port.in.JoinMemberInfo;
import com.wook.top.member.command.application.port.in.MemberAuthUseCase;
import com.wook.top.member.command.application.port.in.JoinMemberCommand;
import com.wook.top.member.command.application.port.out.MemberAuthPort;
import com.wook.top.member.command.application.port.out.UserRolePort;
import com.wook.top.member.command.domain.model.Member;
import com.wook.top.member.command.domain.model.Role;
import com.wook.top.member.command.domain.model.UserRole;
import com.wook.top.member.common.error.exception.EmailDuplicatedException;
import com.wook.top.member.common.error.exception.NicknameDuplicatedException;
import java.util.HashSet;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class MemberAuthService implements MemberAuthUseCase {
	private final MemberAuthPort memberAuthPort;
	private final UserRolePort userRolePort;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	@Override
	public JoinMemberInfo joinMember(JoinMemberCommand command) {
		verifyUniqueNickname(command.nickname());
		verifyAvailableEmail(command.email());

		UserRole role = userRolePort.findByName(Role.MEMBER);
		Member member = Member.createMember(
				command.email(),
				passwordEncoder.encode(command.password()),
				command.nickname(),
				new HashSet<>(List.of(role))
		);

		memberAuthPort.joinMember(member);

		return new JoinMemberInfo(member.getMemberInfo().getEmail(), member.getMemberInfo().getName());
	}

	private void verifyUniqueNickname(String nickname) {
		if (memberAuthPort.existByNickname(nickname)) {
			throw new NicknameDuplicatedException(nickname);
		}
	}

	private void verifyAvailableEmail(String email) {
		if (memberAuthPort.existByEmail(email)) {
			throw new EmailDuplicatedException(email);
		}
	}
}
