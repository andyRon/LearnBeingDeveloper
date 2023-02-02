package com.andyron.rabbitmq.one;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 生成者：发消息
 * @author Andy Ron
 */
public class Producer {
    // 队列名称
    public static final String QUEUE_NAME  = "hello";

    // 发消息
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建一个连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 工厂IP
        factory.setHost("");
        // 用户名
        factory.setUsername("admin");
        factory.setPassword("123");
        // 创建连接
        Connection connection = factory.newConnection();
        // 获取信道
        Channel channel = connection.createChannel();

        /*
           生成一个队列
           1. 队列名称
           2. 队列里消息是否持久化，默认消息存储在内存中
           3. 该队列是否是否只供一个消费者进行消费（是否共享消息），true共享，false不共享
           4. 是否自动删除，最后一个消费者断开连接以后，该队列是否自动删除，true删除，false不删除
           5. 其它参数
         */
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 发消息
        String message = "hello, rabbitmq!";
        /*
            1. 发送到哪个交换机
            2. 路由的Key值
            3. 其它参数信息
            4. 发送消息的消息体
         */
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("消息发送完毕");
    }
}
