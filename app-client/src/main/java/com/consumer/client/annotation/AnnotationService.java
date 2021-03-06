package com.consumer.client.annotation;

import com.api.service.UserService;

import com.dianping.pigeon.remoting.invoker.config.annotation.Reference;

public class AnnotationService {

	@Reference(timeout = 1000)
	private UserService userService;

	public String testService(String input) {
		return userService.sayHello(input);
	}

}
