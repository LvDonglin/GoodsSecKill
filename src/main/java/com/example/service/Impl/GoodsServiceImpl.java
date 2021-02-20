package com.example.service.Impl;

import com.example.dao.GoodsMapper;
import com.example.entity.Goods;
import com.example.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.service.Impl
 * @ClassName: GoodsServiceImpl
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 10:31
 * @Version: 1.0
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public List<Goods> queryAllGoods() {
        return goodsMapper.queryAllGoods();
    }
}
