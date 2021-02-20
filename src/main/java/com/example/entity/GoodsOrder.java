package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.entity
 * @ClassName: GoodsOrder
 * @Author: 吕东霖
 * @Description: ${description}
 * @Date: 2021/2/19 16:54
 * @Version: 1.0
 */
@Data
public class GoodsOrder implements Serializable {

    private Integer userId;

    private String goodsName;

    private Integer goodsNum;
}
