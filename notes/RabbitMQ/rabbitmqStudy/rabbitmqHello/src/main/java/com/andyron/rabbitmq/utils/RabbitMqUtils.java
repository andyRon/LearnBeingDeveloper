package com.andyron.rabbitmq.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 连接工作创建信道的工具类
 * @author andyron
 **/
public class RabbitMqUtils {

    public static Channel getChannel() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setUsername("admin");
        factory.setPassword("123");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }
}
