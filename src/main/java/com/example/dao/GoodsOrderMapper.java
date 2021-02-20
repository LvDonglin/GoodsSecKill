package com.example.dao;

import com.example.entity.GoodsOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.dao
 * @ClassName: GoodsOrderMapper
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 19:48
 * @Version: 1.0
 */
@Mapper
public interface GoodsOrderMapper {

    // 秒杀时订单入库
    void addOrder(GoodsOrder order);


    List<GoodsOrder> queryOrderList(@Param("userId") Integer userId);

    List<GoodsOrder> queryOrders();
}
