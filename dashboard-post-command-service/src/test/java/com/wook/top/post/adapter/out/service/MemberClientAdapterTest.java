package com.wook.top.post.adapter.out.service;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.wook.top.memberclient.client.MemberClient;
import com.wook.top.memberclient.client.response.MemberCheckResponse;
import com.wook.top.post.command.adapter.out.service.MemberClientAdapter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class MemberClientAdapterTest {

	@InjectMocks
	private MemberClientAdapter memberClientAdapter;

	@Mock
	private MemberClient memberClient;

	@Test
	void test() {
		when(memberClient.checkMember(anyLong())).thenReturn(ResponseEntity.ok(new MemberCheckResponse(true)));

		boolean result = memberClientAdapter.checkMemberValid(1L);

		assertThat(result).isTrue();
	}
}