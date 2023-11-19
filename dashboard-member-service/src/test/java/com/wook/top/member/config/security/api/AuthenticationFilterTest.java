package com.wook.top.member.config.security.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wook.top.member.command.domain.model.Member;
import com.wook.top.member.command.domain.model.Role;
import com.wook.top.member.command.domain.model.UserRole;
import com.wook.top.member.command.domain.repository.MemberRepository;
import com.wook.top.member.command.domain.repository.UserRoleRepository;
import com.wook.top.member.config.security.AuthenticationRequest;
import com.wook.top.member.config.security.SecurityUser;
import com.wook.top.member.support.presentation.BaseControllerTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.ResultActions;

class AuthenticationFilterTest extends BaseControllerTest {
	@Autowired
	UserRoleRepository roleRepository;

	@Autowired
	MemberRepository memberRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Test
	@DisplayName("유저 정보를 이용해 jwt 토큰을 생성한다.")
	void attemptAuthentication() throws Exception {
		//given
		String email = "inwook94@naver.com";
		String password = "123456";
		String nickname = "inwook";
		generateMember(email, password, nickname);
		AuthenticationRequest request = new AuthenticationRequest(email, password);

		//when
		ResultActions result = mockMvc.perform(post("/member/login")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request))
		);

		//then
		result.andExpect(status().isOk());
	}

	void generateMember(String email, String password, String nickname) {
		UserRole role = roleRepository.findByName(Role.MEMBER);
		Member member = Member.createMember(
				email,
				passwordEncoder.encode(password),
				nickname,
				Set.of(role));
		memberRepository.save(member);
	}
}