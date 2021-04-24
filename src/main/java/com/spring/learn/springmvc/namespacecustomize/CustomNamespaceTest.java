package com.spring.learn.springmvc.namespacecustomize;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

import java.util.Arrays;

/**
 * @author liangchen
 * @date 2021/4/23
 */
public class CustomNamespaceTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext appcontext = new ClassPathXmlApplicationContext("beans.xml");
        MyService service = appcontext.getBean("myservice-123", MyService.class);
        MyDao dao = appcontext.getBean("mydao-123", MyDao.class);

        Assert.isTrue(dao == service.getDefaultDao());
        Assert.isTrue(dao == service.getDaoRegistry().get("dao1"));
        System.out.println(Arrays.toString(dao.getFields().toArray()));
        MyDao dao11 = appcontext.getBean("com.spring.learn.springmvc.namespacecustomize.Hello", MyDao.class);
        Assert.isTrue(dao11 != null);
        appcontext.close();
    }
}