package com.provider.service.Impl;

import com.api.service.UserService;
import com.dianping.pigeon.remoting.provider.config.annotation.Service;
@Service
public class UserServiceImpl implements UserService {

	public String sayHello(String content) {
		// TODO Auto-generated method stub
		
		System.out.println("this is provider");
		return "from provider say"+content;
	}

	public void init() throws Exception {
		System.out.println("this is init ");
	}

}
