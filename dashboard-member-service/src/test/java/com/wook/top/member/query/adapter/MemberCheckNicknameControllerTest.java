package com.wook.top.member.query.adapter;

import com.wook.top.member.support.presentation.BaseControllerTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberCheckNicknameControllerTest extends BaseControllerTest {

	@Test
	@DisplayName("유저 닉네임 중복 체크를 할 수 있다.")
	void findAll() {

	}

	@Test
	void strTest() {
		String str = new String("ssdf");
		System.out.println(System.identityHashCode(str));
		sss(str);
	}

	private void sss(String str) {
		System.out.println(System.identityHashCode(str));
		str = str + "ss";
		System.out.println(System.identityHashCode(str));
	}
}