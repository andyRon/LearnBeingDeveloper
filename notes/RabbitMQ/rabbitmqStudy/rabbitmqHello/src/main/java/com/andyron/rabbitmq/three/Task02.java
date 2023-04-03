package com.andyron.rabbitmq.three;

import com.andyron.rabbitmq.utils.RabbitMqUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;

import java.util.Scanner;

/**
 * 测试 消息在手动应答时是不丢失、放回队列中重新消费
 * @author andyron
 **/
public class Task02 {
    public static final String TASK_QUEUE_NAME= "ack_queue";

    public static void main(String[] args)  throws Exception  {
        Channel channel = RabbitMqUtils.getChannel();

        // 让消息队列持久化
        boolean durable = true;
        channel.queueDeclare(TASK_QUEUE_NAME, durable, false, false, null);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String message = scanner.next();

            // 设置生产者发送消息为持久化消息
            channel.basicPublish("", TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
            System.out.println("生产者发送消息：" + message);
        }
    }
}
