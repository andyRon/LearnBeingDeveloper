package com.andyron.springframework.beans.factory.support;

import com.andyron.springframework.beans.BeansException;
import com.andyron.springframework.beans.factory.BeanFactory;
import com.andyron.springframework.beans.factory.config.BeanDefinition;
import com.andyron.springframework.beans.factory.config.DefaultSingletonBeanRegistry;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
