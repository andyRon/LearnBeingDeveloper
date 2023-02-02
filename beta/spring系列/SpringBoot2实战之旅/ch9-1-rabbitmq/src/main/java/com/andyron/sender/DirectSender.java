package com.andyron.sender;

import com.andyron.config.DirectConfig;
import com.andyron.entity.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 简单消息发送 生产者
 * @author Andy Ron
 */
@Component
public class DirectSender {
    private static final Logger log = LoggerFactory.getLogger(DirectSender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirectQueue() {
        Goods goods = new Goods(System.currentTimeMillis(), "测试商品", "这是一个测试商品", 98.6);
        log.info("简单消息已经发送");

        this.amqpTemplate.convertAndSend(DirectConfig.DIRECT_QUEUE, goods);
    }

}
