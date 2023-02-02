package com.andyron.springframework.beans.factory;

import com.andyron.springframework.beans.BeansException;

/**
 * @author andyron
 */
public interface BeanFactory {

    Object getBean(String name) throws BeansException;
}
