package com.example.firstInit;

import com.example.entity.Goods;
import com.example.service.GoodsService;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.firstInit
 * @ClassName: AddGoodsToRedis
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 13:15
 * @Version: 1.0
 */
@Component
@Order(1)
public class AddGoodsToRedis implements CommandLineRunner {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public void run(String... args) throws Exception {

        List<Goods> goodsList = goodsService.queryAllGoods();

        // 将商品以<name，num> 的形式存入redis
        goodsList.forEach(x -> {
            redisUtil.set(x.getGoodsName(), x.getGoodsNum());
        } );
        System.out.println("=============>>> Redis 初始化完成……");
    }
}
