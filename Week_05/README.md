### 学习笔记

##### 第9课

#### 作业1

实现简单的基于Java的AOP

 - 在文件夹01-simple-aop中
 - TimingDynamicInvocationHandler 实现了InvocationHandler
 - 具体的增强是在调用任意基于接口实现的对象中的 重载方法时，记录执行前后的系统时间并计算方法执行耗时

控制台输出的结果如下
    `C:\Program Files\Java\jdk1.8.0_201\bin\java.exe demo.Demo`
    `===system time before invoke method run`
    `180665053215100`
    `car is running`
    `===system time before invoke method run`
    `180665053382700`
    `Executing run finished in 167600 nano seconds.`
    `Process finished with exit code 0`



#### 作业2
实现Spring Bean的装配，越多越好 

在02-bean-load-demo里
 - Annotation: 基于 `@Component` 的实现：
    - package: annotation.demo1
    - Bean Class: Dog
    - Main Class: AnnotationDemo1
    - 运行显示无论是用Dog.class还是BeanName（"gou")，获取的都是同一个对象，是单例（默认）
 - Annotation: 基于 `@Configuration` 的实现
    - package: annotation.demo2
    - Bean Class: Cat
    - Config Class: AnimalConfig
    - Main Class: AnnotationDemo2
    - Property File： application.properties
    - 其中还用了springboot中的 `@ConditionalOnProperty` 当在属性文件中注释掉cat行时，无法获取到cat实例
 - Xml: 基于XML的实现
    - package: xml
    - Bean Class: Duck
    - Main Class: XmlDemo
    - xml file: duckBean.xml
    - xml文件这里非常简单，只有`<bean id="duck" class="xml.Duck"></bean>`



##### 第10课

#### 作业3 基于Student/Klass/School实现自动配置和Starter 
 - 在03-auto-config-and-start里
    - customized.start项目实现了auto config starter
    - demo里是测试，需要提前install 上一步打包好的jar包
    -     <dependency>
            <groupId>com.iamrukia</groupId>
            <artifactId>starter</artifactId>
            <version>0.0.1-SNAPSHOT</version>
          </dependency>
 - 核心是需要
    - 自动配置类
    - 属性类
    - src/main/resources/META-INF 下的 spring.factories 包含
    org.springframework.boot.autoconfigure.EnableAutoConfiguration=自动配置类全包路径
 - 本例子半天没有完成，各种空指针。后来发现是需要在调用starter的环境里的application.properties写入之前预设属性。

#### 作业6 研究一下JDBC接口和数据库连接池，掌握他们的设计和用法：
 - 使用jdbc原生接口实现数据库增删改查
 - 使用事务，PrepareStatement方式，批处理方式，改进上述操作
 - 配置Hikari连接池，改进上述操作。 

06-jdbc-demos里两个项目:
 - h2demo 启动了一个h2 database用来测试连接用
      `spring.datasource.url=jdbc:h2:mem:testdb`
      `spring.datasource.driverClassName=org.h2.Driver`
      `spring.datasource.username=sa`
      `spring.datasource.password=password`
      - 刚开始发现不开server模式暴露tcp是连接不上的，因为这个数据库在内存里, 跨jvm应该不好直接访问。
      - 实际链接url用jdbc:h2:tcp://localhost:9090/mem:testdb
      - 里面就一张表
      ID, FIRST_NAME, LAST_NAME, CAREER
      1,Aliko,Dangote,Billionaire Industrialist
      2,Bill,Gates,Billionaire Tech Entrepreneur
      3,Folrunsho,Alakija,Billionaire Oil Magnate
 - jdbc_demo里是具体作业的实现
      - simple_jdbc 就是裸jdbc直接操作
      - multi_source_jdbc里可以简易的保留多个链接源的连接，并只保留一份（用url+username做key）
      - connection_pool_jdbc 实现简单连接池
      - hikari_pool 用hikariCP连接池
      - 好像只写了查询:) 也没有用事务和批处理batch-后面加....










参考
https://www.baeldung.com/spring-boot-custom-starter

instrument sample for calculating 2d array size 
D:\IDEAproject\geektime_java_camp\JAVA-000\Week_01\assignment\20201017\out\production\gc_demo\demo