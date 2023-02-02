package com.andyron.rabbitmq.one;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.TimeoutException;

/**
 * 消费者：接受信息
 * @author Andy Ron
 */
public class Consumer {
    public static final String QUEUE_NAME  = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();

        factory.setHost("");
        factory.setUsername("admin");
        factory.setPassword("123");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();


        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println(message);
            System.out.println(message.getBody().toString());
        };
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println("消息消费被中断");
        };

        /*
            消费者消费信息
            1. 消费哪个队列
            2. 消费成功后是否自动应答
            3. 消费者未成功消费的回调
            4. 消费者取消消费的回调
         */
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

    }
}
