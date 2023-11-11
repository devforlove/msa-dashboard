package com.wook.top.front.member.feign;

import feign.Request.HttpMethod;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class MemberFeignInterceptor implements RequestInterceptor {

	@Override
	public void apply(RequestTemplate template) {

		if (Objects.equals(template.method(), HttpMethod.GET.name())) {
			return;
		}

		String encodedString = StringUtils.toEncodedString(template.body(), StandardCharsets.UTF_8);

		//추가적으로 필요한 로직 추가
		template.body(encodedString);
	}
}
