package com.wook.top.postcommandclient.config;

import feign.Request.HttpMethod;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.util.Objects;

public class PostClientInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {

		if (Objects.equals(template.method(), HttpMethod.GET.name())) {
			return;
		}
	}
}
