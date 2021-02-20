package com.example.controller;

import com.example.entity.GoodsOrder;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName: springboot-redis-rabbitmq-seckill
 * @Package: com.example.controller
 * @ClassName: SecKillController
 * @Author: lin
 * @Description: ${description}
 * @Date: 2021/2/19 15:35
 * @Version: 1.0
 */
@RestController
public class SecKillController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/secKill")
    public String secKillGoods(HttpServletRequest request){
        GoodsOrder order = new GoodsOrder();
        order.setGoodsName( request.getParameter("goodsName"));
        order.setUserId(Integer.parseInt(request.getParameter("userId")) );
        order.setGoodsNum(Integer.parseInt(request.getParameter("num")));
        return orderService.secKillGoods(order);
    }

}
