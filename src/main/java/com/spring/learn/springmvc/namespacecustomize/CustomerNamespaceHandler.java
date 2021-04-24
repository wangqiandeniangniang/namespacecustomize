package com.spring.learn.springmvc.namespacecustomize;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author liangchen
 * @date 2021/4/23
 */
public class CustomerNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("createservice", new CreateServiceNamespaceBeanDefinitionParser());
        registerBeanDefinitionParser("createProxy", new CreateProxyNamespaceBeanDefinitionParser());

    }
}
