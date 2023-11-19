package com.wook.top.member.adapter.in;

import static org.junit.jupiter.api.Assertions.*;

import com.wook.top.member.command.application.port.in.MemberAuthUseCase;
import com.wook.top.member.support.presentation.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

class MemberAuthControllerTest extends BaseControllerTest {
	@Autowired
	MemberAuthUseCase memberAuthUseCase;

	@Test
	void joinMember() {

	}
}