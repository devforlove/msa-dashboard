package com.wook.top.postquery.adapter.out.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("postDetails")
public class PostDetail {

	@Id
	private String id;
	private Long writerId;
	private String content;
	private String title;

	private PostDetail(Long writerId, String content, String title) {
		this.writerId = writerId;
		this.content = content;
		this.title = title;
	}

	public static PostDetail of(Long writerId, String content, String title) {
		return new PostDetail(writerId, content, title);
	}
}
