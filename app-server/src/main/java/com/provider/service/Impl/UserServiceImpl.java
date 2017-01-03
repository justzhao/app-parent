package com.provider.service.Impl;

import com.api.service.UserService;
import com.dianping.pigeon.remoting.provider.config.annotation.Service;
@Service
public class UserServiceImpl implements UserService {

	public String sayHello(String content) throws InterruptedException {
		// TODO Auto-generated method stub

		// 测试future调用
		//Thread.sleep(1000);
		System.out.println("this is provider");
		return "from provider say"+content;
	}

	public void init() throws Exception {
		System.out.println("this is init ");
	}

}
