package com.wook.top.member.command.application.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

import com.wook.top.member.command.application.port.in.JoinMemberCommand;
import com.wook.top.member.command.application.port.in.JoinMemberInfo;
import com.wook.top.member.command.application.port.out.MemberAuthPort;
import com.wook.top.member.command.application.port.out.UserRolePort;
import com.wook.top.member.command.domain.model.Role;
import com.wook.top.member.command.domain.model.UserRole;
import com.wook.top.member.common.error.exception.EmailDuplicatedException;
import com.wook.top.member.common.error.exception.NicknameDuplicatedException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
@DisplayName("MemberAuthService의")
class MemberAuthServiceTest {
	@InjectMocks
	private MemberAuthService sut;

	@Mock
	MemberAuthPort joinMemberPort;

	@Mock
	UserRolePort userRolePort;

	@Mock
	PasswordEncoder passwordEncoder;

	@Nested
	@DisplayName("joinMember 메서드는")
	class joinMember {
		JoinMemberCommand command;

		@BeforeEach
		void setup() {
			command = new JoinMemberCommand("inwook@company.com", "password1234", "inwook");
		}

		@Test
		@DisplayName("생성할 회원 데이터를 가지고 회원을 생성하고, 생성한 회원을 반환한다.")
		void ItCreateMemberAndReturnMemberInfo() {
			//given
			given(userRolePort.findByName(Role.MEMBER)).willReturn(new UserRole(Role.MEMBER));

			//when
			JoinMemberInfo memberInfo = sut.joinMember(command);

			//then
			assertThat(memberInfo.email()).isEqualTo(command.email());
			assertThat(memberInfo.nickname()).isEqualTo(command.nickname());
		}

		@Test
		@DisplayName("중복된 닉네임이 있다면 NicknameDuplicatedException을 발생시킨다.")
		void withExistNickname_ItThrowEmailDuplicatedException() {
			//given
			given(joinMemberPort.existByNickname(command.nickname())).willReturn(true);

			//when & then
			assertThatThrownBy(() -> sut.joinMember(command))
					.isInstanceOf(NicknameDuplicatedException.class);
		}

		@Test
		@DisplayName("중복된 이메일이 있다면 EmailDuplicatedException을 발생시킨다.")
		void withExistEmail_ItThrowEmailDuplicatedException() {
			//given
			given(joinMemberPort.existByEmail(command.email())).willReturn(true);

			//when & then
			assertThatThrownBy(() -> sut.joinMember(command))
					.isInstanceOf(EmailDuplicatedException.class);
		}
	}
}