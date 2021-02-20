package com.example.dao;

import com.example.entity.Goods;
import com.example.entity.GoodsOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.dao
 * @ClassName: GoodsMapper
 * @Author:lin
 * @Description: ${description}
 * @Date: 2021/2/19 10:16
 * @Version: 1.0
 */
@Mapper
public interface GoodsMapper {

    List<Goods> queryAllGoods();


    void updateGoodsNum(GoodsOrder order);
}
