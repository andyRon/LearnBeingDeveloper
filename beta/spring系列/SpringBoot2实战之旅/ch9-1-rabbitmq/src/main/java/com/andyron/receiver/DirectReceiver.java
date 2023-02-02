package com.andyron.receiver;

import com.andyron.config.DirectConfig;
import com.andyron.entity.Goods;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 简单消息发送  消费者
 * @author Andy Ron
 */
@Component
public class DirectReceiver {

    private static final Logger log = LoggerFactory.getLogger(DirectReceiver.class);


    @RabbitListener(queues = DirectConfig.DIRECT_QUEUE)
    public void receiverDirectQueue(Goods goods) {
        log.info("简单消息接受成功，参数是：" + goods.toString());
    }
}
