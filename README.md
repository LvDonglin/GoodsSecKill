# GoodsSecKill
这是一个简单的商品秒杀项目，技术栈： SpringBoot+Redis+RabbitMQ+MyBatis+MySql

# SpringBoot+Redis+RabbitMQ实现简单的商品秒杀



### 秒杀存在的问题：

1、短时间内大量请求发送到服务器，很可能会造成服务器崩溃；

2、商品超卖；

3、服务器响应时间过久（频繁读写数据库，耗时长），用户体验性差。



#### 解决思路：

![image-20210220101945952](https://gitee.com/dongldl/my-cdn/raw/master/image/image-20210220101945952.png)



1、为解决频繁读数据库问题以及减轻数据库压力，使用 Redis ，项目初始化时先将商品信息缓存起来，请求过来时先查Redis，根据商品库存做进一步处理。

2、使用 Redis 解决超卖问题；

3、使用RabbitMQ 实现 流量削峰 和 异步调用，即当我们从 Redis 中知道库存充足时即可给用户返回success，然后将请求以消息的形式存入队列，之后由消费者端进行 修改商品库存和生成订单操作；



### 具体的实现我就不在这里赘述了！！



### 项目的测试结果：

1秒发100次请求：

![image-20210220131322997](https://gitee.com/dongldl/my-cdn/raw/master/image/image-20210220131322997.png)



![image-20210220133253748](https://gitee.com/dongldl/my-cdn/raw/master/image/image-20210220133253748.png)

分析：

平均响应时间：42ms

QPS：91.1/sec  平均每秒可处理91次请求



疑问之处： 当1m 请求140次或200次时，QPS 就变得很低。

![image-20210220133912829](https://gitee.com/dongldl/my-cdn/raw/master/image/image-20210220133912829.png)



### 思考：

1、这样的架构能很大程度提升系统处理高并发请求的能力，与此同时系统架构也会更复杂。

2、虽然 RabbitMQ 能很好的解决系统高耦合问题，但如果 RabbitMQ 挂掉也会让系统崩掉。这时可以考虑一下 RabbitMQ 集群。

3、对 Redis 的数据频繁写会影响Redis的查询性能。





参考文章：[基于SpringBoot、Redis和RabbitMq的商品秒杀处理 - 码在江湖 - 博客园 (cnblogs.com)](https://www.cnblogs.com/mcjhcnblogs/p/14109506.html)

参考项目：https://gitee.com/gitee__wsq/seckill





