package com.spring.learn.springmvc.namespacecustomize;

/**
 * @author liangchen
 * @date 2021/4/23
 */
import java.util.Map;

public class MyService {

    private String serviceName;
    private MyDao defaultDao;
    private Map<String, MyDao> daoRegistry;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public MyDao getDefaultDao() {
        return defaultDao;
    }

    public void setDefaultDao(MyDao defaultDao) {
        this.defaultDao = defaultDao;
    }

    public Map<String, MyDao> getDaoRegistry() {
        return daoRegistry;
    }

    public void setDaoRegistry(Map<String, MyDao> daoRegistry) {
        this.daoRegistry = daoRegistry;
    }

}