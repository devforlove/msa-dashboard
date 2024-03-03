package com.wook.top.member.query.adapter;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.memberclient.response.MemberCheckResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequestMapping("/member/v1")
@RequiredArgsConstructor
public class CheckValidController {

	@GetMapping("/{memberId}/check")
	public ResponseEntity<MemberCheckResponse> checkMemberValidation(
			@PathVariable("memberId") Long memberId
	) {
		return new ResponseEntity<>(new MemberCheckResponse(true), HttpStatus.OK);
	}
}
