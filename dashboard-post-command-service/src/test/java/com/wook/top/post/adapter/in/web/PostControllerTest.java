package com.wook.top.post.adapter.in.web;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.wook.top.memberclient.client.MemberClient;
import com.wook.top.memberclient.response.MemberCheckResponse;
import com.wook.top.post.adapter.in.web.request.PostCreateRequest;
import com.wook.top.post.domain.model.Post;
import com.wook.top.post.domain.repository.PostRepository;
import com.wook.top.post.presentation.BaseControllerTest;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.TestExecutionEvent;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.ResultActions;
import org.webjars.NotFoundException;

class PostControllerTest extends BaseControllerTest {

	@Autowired
	@Qualifier("memberClient")
	private MemberClient memberClient;

	@Autowired
	private PostRepository postRepository;

	@WithUserDetails(value = "test@example.com", setupBefore = TestExecutionEvent.TEST_EXECUTION)
	@Test
	void makePost() throws Exception {

		// given
		PostCreateRequest request = new PostCreateRequest("title", "content");

		when(memberClient.checkMember(anyLong())).thenReturn(ResponseEntity.ok(new MemberCheckResponse(true)));

		// when
		ResultActions result = mockMvc.perform(post("/post/v1/post/me")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(request)));

		// then
		result.andExpect(status().is2xxSuccessful());
		Optional<Post> postOptional = postRepository.findById(1L);
		Post post = postOptional.orElseThrow(() -> new NotFoundException("post not found"));
		assertThat(post.getTitle()).isEqualTo("title");
		assertThat(post.getContent()).isEqualTo("content");
	}
}