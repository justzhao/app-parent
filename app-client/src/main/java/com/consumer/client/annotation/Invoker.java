package com.consumer.client.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.api.service.UserService;

public class Invoker {
	 public static void main(String[] args) throws Exception {
     ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/annotation/consumer.xml"});
     context.start();
     AnnotationService annotationService = (AnnotationService)context.getBean("annotationService"); // 获取远程服务代理
         String hello = annotationService.testService("hello World");
         System.out.println(hello);
     }

}
