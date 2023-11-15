package com.wook.top.front.member.common.feign;

import com.wook.top.common.exception.ErrorCode;
import com.wook.top.front.common.error.CustomException;
import feign.Response;
import feign.codec.ErrorDecoder;
import org.springframework.http.HttpStatus;

public class MemberFeignErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder errorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		return errorDecoder.decode(methodKey, response);
	}
}
