package com.consumer.client.annotation;

import com.api.service.UserService;

import com.dianping.pigeon.remoting.invoker.config.annotation.Reference;

public class AnnotationService {

	@Reference(timeout = 2000,callType = "future")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String testService(String input) {
		try {
			return userService.sayHello(input);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return  "error";
	}

}
