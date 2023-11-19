package com.wook.top.front.member.common.feign;

import feign.Response;
import feign.codec.ErrorDecoder;

public class MemberFeignErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder errorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		return errorDecoder.decode(methodKey, response);
	}
}
