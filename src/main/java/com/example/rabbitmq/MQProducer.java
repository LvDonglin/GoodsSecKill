package com.example.rabbitmq;

import com.example.entity.GoodsOrder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.rabbitmq
 * @ClassName: MQProducer
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 14:46
 * @Version: 1.0
 */
@Service
public class MQProducer {
    @Autowired
    private AmqpTemplate amqpTemplate;
    //Direct模式
    public void send(GoodsOrder order) {

        //第一个参数队列的名字，第二个参数发出的信息
        amqpTemplate.convertAndSend("GOODS_QUEUE", order);

        System.out.println("RabbitMQ: 消息发送成功！");
    }

}
