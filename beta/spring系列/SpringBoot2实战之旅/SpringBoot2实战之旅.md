## 《SpringBoot2实战之旅》笔记

微信读书

代码  https://gitee.com/dalaoyang/springboot_book



微服务 https://martinfowler.com/articles/microservices.html



### 3 Web



?? 3.4 新增ConfigBean出问题





#### 3.5 使用页面模板

##### Thymeleaf

nekohtml

Thymeleaf的常用语法：　

th:text　设置当前元素的文本内容。

th:value　设置当前元素的值。

th:each　循环遍历元素，一般配合上面两者使用。　

th:attr　设置当前元素的属性。

th:if th:switch th:case th:unless　用作条件判断。

th:insert th:replace th:incloud　代码块引入，一般用作提取公共文件，或者引用公共静态文件等。



步骤：在pom文件中添加依赖；在application.properties中添加配置内容；新建Controller；新建模板文件。



##### FreeMarker



#### 3.6 WebJars

**WebJars是将web前端资源（js，css等）打成jar包文件**，然后借助Maven工具，以jar包形式对web前端资源进行统一依赖管理，保证这些Web资源版本唯一性。WebJars的jar包部署在Maven中央仓库上。



#### 3.7 国际化

??报错

```
2020-03-02 16:55:14.084 ERROR 54988 --- [nio-8080-exec-2] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed; nested exception is org.thymeleaf.exceptions.TemplateInputException: Error resolving template [index], template might not exist or might not be accessible by any of the configured Template Resolvers] with root cause

org.thymeleaf.exceptions.TemplateInputException: Error resolving template [index], template might not exist or might not be accessible by any of the configured Template Resolvers
```



### 4 数据库



#### 4.2 使用JDBC操作数据库



#### 4.3 使用JPA操作数据库

**JPA**是Java Persistence API的简称，是JCP组织发布的Java EE标准之一。JPA是一种面向对象的查询语言，定义了独特的JPQL（Java Persistence Query Language），是一种针对实体的查询语言，无论是查询还是修改，全部操作的都是对象实体，而非数据库的表。

??  略过不写了，涉及hibernate，国内使用的越来越少。



#### 4.4 MyBatis

MyBatis避免了几乎所有的JDBC代码和手动设置参数以及获取结果集。

MyBatis可以使用简单的XML或注解来配置和映射原生信息，将接口和Java的POJOs（Plain Old Java Objects，普通的Java对象）映射成数据库中的记录。



?? 跳过了插件

Mybatis-Generator插件

PageHelper插件

Mybatis-Plus插件



#### 4.5 配置多数据源

??



#### 4.6 使用Druid数据库连接池

Druid是Java语言中最好的数据库连接池，

稳定性

实时监控功能，如数据源监控、SQL监控、SQL防火墙、Web应用监控、URI监控、Session监控、Spring监控等。

**Druid主要用于存储、查询和分析大型事件流。**

??



### 5 缓存

#### 5.1 使用Spring Cache

`@CachePut`

`@Cacheable`

`@CacheEvict`



#### 5.2 Redis

jpa依赖

?? 链接失败

```
Description:

Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.

Reason: Failed to determine a suitable driver class
```



#### 5.3 Memcached



?? 



### 6 日志

Spring Boot使用Commons Logging进行所有内部日志记录，但保留底层日志实现。为JavaUtil Logging、Log4j2和Logback提供了默认配置。每种情况下，记录器都预先配置为使用控制台输出，并且提供可选的文件输出。

#### 6.1 Logback日志

Spring Boot中，默认就是Logback日志。

Logback日志框架（官网地址：https://logback.qos.ch/）是由Log4j创始人开发的另一套开源日志组件。3个模块：

- logback-core：属于Logback的基础模块，是其他两个模块的基础。
- logback-classic：可以看作Log4j的改进版本，同时logback-classic自身实现了SLF4J API，使开发者可以在Logback框架与其他日志框架（如Log4j或java.util.logging）之间自由切换。
- logback-access：与Servlet容器（如Tomcat和Jetty）集成，以提供HTTP访问日志功能。

另外还支持基于logback-core模块构建自定义模块。

##### 日志格式

![](/Users/andyron/Library/Application Support/typora-user-images/image-20200305172625832.png)

- 时间日期：显示日志打印时间，精确到毫秒。
- 日志级别：日志级别分为FATAL、ERROR、WARN、INFO、DEBUG、TRACE。
- 进程ID：进程ID指的是当前应用对应的PID。
- 分隔符：分隔符用于区分实际日志消息的开始。
- 线程名称：括在方括号中（可能会截断控制台输出）。
- 记录器名称：一般使用类名。
- 日志内容：日志输出的具体内容。



##### 日志文件输出

##### 日志配置



#### 6.2 Log4j日志

**不在推荐使用**





#### 6.3 Log4j 2日志

?? 报错

#### 6.4 ELK日志收集

在微服务的场景下，每个服务都部署在不同的服务器中，如果每次排查问题都需要挨个服务器查看日志。需要对日志进行集中收集，然后统一查看所有日志。

ELK， Elasticsearch + Logstash + Kibana

**Logstash**作为Elasicsearch常用的实时数据采集引擎，可以采集来自不同数据源的数据，并对数据进行处理后输出到多种输出源，是Elastic Stack 的重要组成部分。

**Kibana** 是一款开源的数据分析和可视化平台，它是 Elastic Stack 成员之一，设计用于和 Elasticsearch 协作。



##### Elasticsearch 安装

1. 下载解压

下载页面 https://www.elastic.co/cn/downloads/elasticsearch

`wget https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-7.6.0-darwin-x86_64.tar.gz`

`tar -xvf elasticsearch-7.6.0-darwin-x86_64.tar.gz`

2. 运行  `bin/elasticsearch`
3. `curl http://localhost:9200`

```
{
  "name" : "Mac.local",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "J57HojK-RhufWB-Vk7k1pA",
  "version" : {
    "number" : "7.6.0",
    "build_flavor" : "default",
    "build_type" : "tar",
    "build_hash" : "7f634e9f44834fbc12724506cc1da681b0c3b1e3",
    "build_date" : "2020-02-06T00:09:00.449973Z",
    "build_snapshot" : false,
    "lucene_version" : "8.4.0",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```



##### kibana 安装

https://www.elastic.co/cn/downloads/kibana

`wget https://artifacts.elastic.co/downloads/kibana/kibana-7.6.0-darwin-x86_64.tar.gz`

`tar -xvf`

`bin/kibana`

http://localhost:5601

##### Logstash 安装

https://www.elastic.co/cn/downloads/logstash



?? 各自安装成功，配置出问题





### 7 安全

#### 7.1 Shiro

Apache Shiro（官网地址：http://shiro.apache.org/）是一个功能强大且易于使用的Java安全框架。

Shiro的用户：

- 验证用户身份。
- 为用户执行访问控制，例如确定是否为用户分配了某个安全角色或确定是否允许用户执行某些操作。
- 在任何环境中使用Session API，即使没有Web容器或EJB容器也是如此。
- 在身份验证、访问控制或会话生命周期内对事件做出反应。
- 聚合用户安全数据的一个或多个数据源，并将其全部显示为单个复合用户“视图”。
- 启用单点登录（SSO）功能。
- 无须登录即可为用户关联启用“记住我”服务。

??



#### 7.2 Spring Security

??

### 8 监控



#### 8.1 actuator

`http://localhost:8080/actuator/`  查看所有开启功能

??

#### 8.2 Spring Boot Admin



??

##### Spring Cloud Eureka



#### 8.3 Prometheus+Grafana监控





### 9 消息

消息队列，Message Queue，简称为**MQ**。

MQ是一种应用程序对应用程序的通信方法。消息队列是分布式系统中不可或缺的组件，主要解决应用解耦、异步消息、流量削峰等问题，实现高性能、高可用、可伸缩和最终一致性的架构。如今常用的开源消息队列组件有**RabbitMQ**、**Kafka**、**ActiveMQ**、**RocketMQ**等。

#### 9.1 RabbitMQ

##### mac 下 安装RabbitMQ

```
brew install rabbitmq

## 进入安装目录
cd /usr/local/Cellar/rabbitmq/3.7.5

# 启动
brew services start rabbitmq
# 当前窗口启动
rabbitmq-server
```

`http://localhost:15672/`



### 9.2 Kafka



### 9.3 RocketMQ





### 9.4 消息队列对比



### 10 搜索

#### 10.1 Solr

安装



#### 10.2 Elasticsearch

安装





#### 10.3 搜索引擎对比



### 11 Spring Boot 的小彩蛋



#### 11.1 修改启动Banner





### 12 Spring Boot 打包部署











