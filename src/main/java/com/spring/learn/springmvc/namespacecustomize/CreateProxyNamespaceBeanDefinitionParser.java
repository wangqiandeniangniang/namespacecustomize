package com.spring.learn.springmvc.namespacecustomize;

/**
 * @author liangchen
 * @date 2021/4/23
 */

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import java.util.Arrays;


public class CreateProxyNamespaceBeanDefinitionParser implements BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyDao.class);

        String daoId = element.getAttribute("classPath");
        parserContext.getRegistry().registerBeanDefinition(daoId, builder.getBeanDefinition());
        System.out.println(element.getAttribute("classPath"));
        return null;
    }

}
