package com.example.service;

import com.example.entity.GoodsOrder;

import java.util.List;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.service
 * @ClassName: OrderService
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 10:26
 * @Version: 1.0
 */
public interface OrderService {

    String secKillGoods(GoodsOrder order);

    List<GoodsOrder> queryUserOrders(Integer userId);

    void addOrder(GoodsOrder order);
}
