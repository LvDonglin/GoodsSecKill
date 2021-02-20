package com.example.controller;

import com.example.dao.GoodsOrderMapper;
import com.example.entity.Goods;
import com.example.entity.GoodsOrder;
import com.example.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.controller
 * @ClassName: GoodsController
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 12:50
 * @Version: 1.0
 */
@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @GetMapping("/queryAll")
    public List<Goods> queryAllGoods(){
        return goodsService.queryAllGoods();
    }


}
