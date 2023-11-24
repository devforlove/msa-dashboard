package com.wook.top.member.adapter.in;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wook.top.member.command.adapter.in.web.JoinMemberRequest;
import com.wook.top.member.support.presentation.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

class MemberAuthControllerTest extends BaseControllerTest {
	@Autowired
	ObjectMapper objectMapper;

	@Test
	void joinMember() throws Exception {
		//given
		String email = "inwook94@naver.com";
		String password = "password123!";
		String nickname = "inwook";
		JoinMemberRequest request = new JoinMemberRequest(email, password, nickname);

		//when
		ResultActions result = mockMvc.perform(post("/member/v1/member")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)));

		//then
		result.andExpect(status().isOk())
				.andExpect(jsonPath("email").value(request.email()))
				.andExpect(jsonPath("nickname").value(request.nickname()));
	}
}