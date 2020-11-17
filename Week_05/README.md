###学习笔记


####作业1

实现简单的基于Java的AOP

 - 在文件夹01-simple-aop中
 - TimingDynamicInvocationHandler 实现了InvocationHandler
 - 具体的增强是在调用任意基于接口实现的对象中的 重载方法时，记录执行前后的系统时间并计算方法执行耗时

控制台输出的结果如下
`C:\Program Files\Java\jdk1.8.0_201\bin\java.exe demo.Demo
===system time before invoke method run
180665053215100
car is running
===system time before invoke method run
180665053382700
Executing run finished in 167600 nano seconds.

Process finished with exit code 0`
















use below for instrument sample
D:\IDEAproject\geektime_java_camp\JAVA-000\Week_01\assignment\20201017\out\production\gc_demo\demo


https://www.baeldung.com/spring-boot-custom-starter