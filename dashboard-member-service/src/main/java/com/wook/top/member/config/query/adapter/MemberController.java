package com.wook.top.member.config.query.adapter;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.member.config.query.dao.MemberQueryDao;
import com.wook.top.member.config.query.dto.MemberSummary;
import com.wook.top.webcore.security.SecurityUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/member/v1")
@RequiredArgsConstructor
public class MemberController {
	private final MemberQueryDao memberQueryDao;

	@GetMapping("/me")
	private ResponseEntity<MemberSummary> me(@AuthenticationPrincipal SecurityUser user) {
		return new ResponseEntity<>(memberQueryDao.findMemberSummaryById(user.getMemberId()), HttpStatus.OK);
	}
}
