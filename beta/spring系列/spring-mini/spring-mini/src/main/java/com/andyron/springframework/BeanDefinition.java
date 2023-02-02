package com.andyron.springframework;

/**
 * Bean定义信息
 * @author andyron
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
