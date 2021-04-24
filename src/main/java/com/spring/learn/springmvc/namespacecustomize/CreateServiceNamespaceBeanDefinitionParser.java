package com.spring.learn.springmvc.namespacecustomize;

/**
 * @author liangchen
 * @date 2021/4/23
 */
import java.util.Arrays;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;



public class CreateServiceNamespaceBeanDefinitionParser implements BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        //parsing <custns:abcd service="myservice" dao="MyDao" fields="field1,field2,field3"/>
        //<custns:createservice serviceId="myservice-123" daoId="mydao-123" fields="field1,field2,field3"/>
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(MyDao.class);
        builder.addPropertyValue("fields", Arrays.asList(element.getAttribute("fields").split(",")));

        String daoId = element.getAttribute("daoId");
        parserContext.getRegistry().registerBeanDefinition(daoId, builder.getBeanDefinition());

        ManagedMap<Object, Object> map = new ManagedMap<Object, Object>();
        map.put("dao1", new RuntimeBeanReference(daoId));

        builder = BeanDefinitionBuilder.genericBeanDefinition(MyService.class);
        builder.addPropertyValue("serviceName", "myservice");
        builder.addPropertyReference("defaultDao", daoId);
        builder.addPropertyValue("daoRegistry", map);

        parserContext.getRegistry().registerBeanDefinition(element.getAttribute("serviceId"), builder.getBeanDefinition());

        return null;
    }

}
