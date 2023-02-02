package com.andyron.springframework.beans.factory.config;

/**
 * @author andyron
 */
public interface SingletonBeanRegistry {

    Object getSingleton(String beanName);
}
