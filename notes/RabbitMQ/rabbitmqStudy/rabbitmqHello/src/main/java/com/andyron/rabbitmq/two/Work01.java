package com.andyron.rabbitmq.two;

import com.andyron.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;

/**
 * 工作线程（消费者）
 * @author andyron
 **/
public class Work01 {
    public static final String QUEUE_NAME  = "hello";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMqUtils.getChannel();

        // 声明 接受消息
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接收到的消息" + new String(message.getBody()));
        };
        // 取消消息时的回调
        CancelCallback cancelCallback = (consumerTag) -> {
            System.out.println(consumerTag + "消息消费被中断");
        };

        /*
            消费者消费信息
            1. 消费哪个队列
            2. 消费成功后是否自动应答
            3. 消费者未成功消费的回调
            4. 消费者取消消费的回调
         */
        System.out.println("C2等待消息....");
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);

    }
}
