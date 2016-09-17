package com.consumer.client.annotation;

import com.api.service.UserService;
import com.dianping.pigeon.remoting.invoker.callback.ServiceFutureFactory;
import com.dianping.pigeon.remoting.invoker.config.annotation.Reference;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Created by zhaopeng on 2016/9/17.
 */

/**
 *
 *
 *  //调用ServiceA的method1 serviceA.method1("aaa");
 *  //获取ServiceA的method1调用future状态
 *  Future future1OfServiceA = ServiceFutureFactory.getFuture();
 *  //调用ServiceA的method2 serviceA.method2("bbb");
 *  //获取ServiceA的method2调用future状态
 *  Future future2OfServiceA = ServiceFutureFactory.getFuture();
 *  //调用ServiceB的method1 serviceB.method1("ccc");
 *  //获取ServiceB的method1调用future状态
 *  Future future1OfServiceB = ServiceFutureFactory.getFuture();
 *  //获取ServiceA的method2调用结果
 *  Object result2OfServiceA = future2OfServiceA.get();
 *  //获取ServiceA的method1调用结果
 *  Object result1OfServiceA = future1OfServiceA.get();
 *  //获取ServiceB的method1调用结果
 *  Object result1OfServiceB = future1OfServiceB.get();
 *  最后的get()调用顺序由业务自行决定，操作总共花费的时间，大致等于耗时最长的服务方法执行时间。 除了get();接口也可以使用get(timeout);指定超时时间
 */


public class FutureInvoker {




    public static void  main(String args[]){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"spring/annotation/consumer.xml"});
        context.start();
        AnnotationService annotationService = (AnnotationService)context.getBean("annotationService");
        UserService userService=annotationService.getUserService();
       userService.sayHello("123123");
        Future futureResult = ServiceFutureFactory.getFuture();

        try {
            String str=futureResult.get().toString();
            System.out.println(str);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
