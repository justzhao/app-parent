package com.consumer.client.schema;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.api.service.UserService;

public class Invoker {
	 public static void main(String[] args) throws Exception {
         ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/schema/consumer.xml"});
     context.start();
         UserService echoService = (UserService)context.getBean("userService"); // 获取远程服务代理
         String hello = echoService.sayHello("world");
         System.out.println(hello);
     }

}
