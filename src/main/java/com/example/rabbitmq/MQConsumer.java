package com.example.rabbitmq;

import com.example.dao.GoodsMapper;
import com.example.dao.GoodsOrderMapper;
import com.example.entity.GoodsOrder;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.rabbitmq
 * @ClassName: MQConsumer
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 14:48
 * @Version: 1.0
 */
@Service
public class MQConsumer {

    @Autowired
    //private OrderMapper orderMapper;
    private GoodsOrderMapper goodsOrderMapper;

    @Autowired
    private GoodsMapper goodsMapper;


    @RabbitListener(queues= "GOODS_QUEUE")//指明监听的是哪一个queue
    public void receive(GoodsOrder order ){
        long now = System.currentTimeMillis();
        System.out.println("RabbitMQ: 正在接收消息。。。。");
        goodsOrderMapper.addOrder(order);
        // 更新库存
        goodsMapper.updateGoodsNum(order);
        System.out.println("RabbitMQ: 消息已消费，商品库存和订单数据库修改成功！！！共耗时："+(System.currentTimeMillis()-now)+"ms");
    }

}
