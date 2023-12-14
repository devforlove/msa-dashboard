package com.wook.top.postquery.query.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("postDetails")
public class PostDetail {

	@Id
	private String id;
	private String name;
	private int age;
}
