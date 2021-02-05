###学习笔记


#### （必做）改造自定义RPC的程序，提交到github：
1）尝试将服务端写死查找接口实现类变成泛型和反射
2）尝试将客户端动态代理改成AOP，添加异常处理
3）尝试使用Netty+HTTP作为client端传输方式

老师的代码迭代了很多次。同学的作业也看了看，感触很深，写的很好。
我自己对这里都不是很熟悉，所以打算手撸轮子，从小推车开始。

##### version 0.1 

@RequestBody @RequestHeader 这种最好加 @RequestHeader(required=false) 避免空
