package com.example.service;

import com.example.entity.Goods;

import java.util.List;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.service
 * @ClassName: GoodsService
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 10:26
 * @Version: 1.0
 */
public interface GoodsService {

    List<Goods> queryAllGoods();

}
