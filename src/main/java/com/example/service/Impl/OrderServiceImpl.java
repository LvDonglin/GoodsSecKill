package com.example.service.Impl;

import com.example.dao.GoodsMapper;
import com.example.entity.GoodsOrder;
import com.example.rabbitmq.MQProducer;
import com.example.service.OrderService;
import com.example.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.service.Impl
 * @ClassName: OrderServiceImpl
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 10:31
 * @Version: 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private GoodsMapper goodsMapper;

    /*@Autowired
    private OrderMapper orderMapper;*/

    @Autowired
    private MQProducer mqProducer;

    @Override
    public String secKillGoods(GoodsOrder order) {
        String goodsName = order.getGoodsName();
        Integer num = order.getGoodsNum();

        // 查询redis， 判断库存是否充足
        long surplusNumber = redisUtil.decr(goodsName,num);
        System.out.println("Redis: 修改成功！！修改后库容："+surplusNumber);
        if(surplusNumber < 0){
            // 如果不够了，重新加回
            if((surplusNumber + num) > 0){
                redisUtil.incr(goodsName,num);
            }
            return "商品数量不足，秒杀失败！！！";
        }
        // 信息入消息队列
        mqProducer.send(order);
        return "正在抢购，请稍后……";
    }

    @Override
    public List<GoodsOrder> queryUserOrders(Integer userId) {
        //return orderMapper.queryOrderList(userId);
        return null;
    }

    @Override
    public void addOrder(GoodsOrder order) {
      // orderMapper.addOrder(order);
    }
}
