package com.andyron.springframework.beans.factory.support;

import com.andyron.springframework.beans.BeansException;
import com.andyron.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        // todo
        return null;
    }
}
