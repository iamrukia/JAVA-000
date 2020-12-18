学习笔记


#### （必做）按自己设计的表结构，插入100万订单模拟数据，测试不同方式的插入效率

01-simple-insert 内的项目：
 - SimpleJdbcDemo
    傻愣愣的插入1百万条，这个我没等跑完。反正过了2个小时才有30多万条吧
 - SimpleJdbcBatchDemo
    这个直接用preparedStatement.addBatch，结果和方法1没啥性能差别
 - SimpleJdbcBatchOptionDemo
    后来发现是自己完全不熟MySQL，连接数据库时需要rewriteBatchedStatements=true。然后性能才起飞。2分钟不到1百万条数据插入完毕

#### （必做）读写分离-动态切换数据源版本1.0

02-multi-source的项目实现
 - 实现了一个SimpleReadAnnotation注解
 - 1主2从MySQL本地配置 （见MySQL8主从配置.md）
 - 利用spring的Aspect, jointPoint和@Around实现了AOP，在遇到@SimpleReadAnnotation时指定切换到从库
 - 2个从库，用当前时间milliseconds >500 （0-1000范围）来判断用哪个从库

#### （必做）读写分离-数据库框架版本2.0

03-sharding-sphere-jdbc-springboot
 - 这个把我搞到爆炸
 - sharding-sphere的配置文件各种报错。参考了好几个issue的解决方案也没搞定。后来只好参考同学的作业。
 - sharding-sphere还是挺复杂的。
 - 最终是简单的：


```
select 语句 2次，分别走了从 1 和从2 数据库
insert 语句1次， 走了主库
立刻select 语句，仍走主库 （这是避免了主从延迟导致查询结果不一致）
```



总体来说，这章作业对我来说学了不少新东西。
本身Spring AOP就只是概念少了解一点，现在掌握了Aspect的具体实现。
ShardingSphere我觉得还是要多用才有意义；文档感觉有点更新不过来，希望越来越好。