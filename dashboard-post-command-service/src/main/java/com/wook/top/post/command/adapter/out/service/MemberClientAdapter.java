package com.wook.top.post.command.adapter.out.service;

import com.wook.top.common.annotation.ExternalSystemAdapter;
import com.wook.top.memberclient.client.MemberClient;
import com.wook.top.memberclient.client.response.MemberCheckResponse;
import com.wook.top.post.command.application.port.out.MemberClientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

@Slf4j
@ExternalSystemAdapter
@RequiredArgsConstructor
public class MemberClientAdapter implements MemberClientPort {

	private final MemberClient memberClient;

	@Override
	public boolean checkMemberValid(Long memberId) {
		ResponseEntity<MemberCheckResponse> response = memberClient.checkMember(memberId);

		return response.getBody().isValid();
	}
}
