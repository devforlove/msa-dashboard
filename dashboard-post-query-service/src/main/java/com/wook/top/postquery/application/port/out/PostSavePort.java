package com.wook.top.postquery.application.port.out;

public interface PostSavePort {
	void savePostData(Long writerId, String title, String content);
}
