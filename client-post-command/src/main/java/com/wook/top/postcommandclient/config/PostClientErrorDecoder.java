package com.wook.top.postcommandclient.config;

import feign.Response;
import feign.codec.ErrorDecoder;

public class PostClientErrorDecoder implements ErrorDecoder {

	private final ErrorDecoder errorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		return errorDecoder.decode(methodKey, response);
	}
}
