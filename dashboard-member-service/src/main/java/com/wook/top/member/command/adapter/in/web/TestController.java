package com.wook.top.member.command.adapter.in.web;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.member.command.domain.model.Member;
import com.wook.top.member.command.domain.repository.MemberRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequestMapping("/member/v1")
@RequiredArgsConstructor
public class TestController {

	private final MemberRepository memberRepository;

	@PostMapping("/test")
	public void joinMember() {

		ArrayList<Long> list = new ArrayList<>();
		long num = 0;
		while (true) {
			list.add(++num);
			memberRepository.findByMemberIdIn(list);
		}
	}
}
