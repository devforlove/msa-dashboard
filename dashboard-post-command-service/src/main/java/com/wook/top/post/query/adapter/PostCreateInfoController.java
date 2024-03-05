package com.wook.top.post.query.adapter;

import com.wook.top.common.annotation.WebAdapter;
import com.wook.top.post.query.dao.PostDataDao;
import com.wook.top.post.query.dto.PostData;
import com.wook.top.postcommandclient.client.response.PostCreateInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@WebAdapter
@RequestMapping("/post/v1")
@RequiredArgsConstructor
public class PostCreateInfoController {

	private final PostDataDao postDataDao;

	@GetMapping("post/{postId}/info/create")
	public ResponseEntity<PostCreateInfo> getPostCreateInfo(@PathVariable long postId) {
		final PostData postData = postDataDao.findByPostId(postId);
		final PostCreateInfo postCreateInfo = new PostCreateInfo(postData.getWriterId(), postData.getTitle(), postData.getContent());
		return new ResponseEntity<>(postCreateInfo, HttpStatus.OK);
	}
}
