package com.example.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.entity
 * @ClassName: Goods
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 9:56
 * @Version: 1.0
 */
@Data
public class Goods implements Serializable {

    private  Integer goodsId;

    private String goodsName;

    private Integer goodsNum;
}
