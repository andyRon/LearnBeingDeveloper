package com.andyron.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Andy Ron
 */
@ConfigurationProperties(prefix = "book")
public class BookConfigBean {
    private String name;
    private String reader;
    private String value;
    private int intValue;
    private String uuid;
    private int randomNumber;
    private String title;
}
