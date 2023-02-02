

# Spring学习记录

## Spring Boot  学习资源



https://github.com/dyc87112/SpringBoot-Learning/tree/master/2.1.x

https://github.com/YunaiV/SpringBoot-Labs

https://github.com/xkcoding/spring-boot-demo



## 学习记录

### 项目结构

- `src/main/java`下的程序入口：`Chapter11Application`
- `src/main/resources`下的配置文件：`application.properties`
- `src/test/`下的测试入口：`Chapter11ApplicationTests`



#### pom.xml 文件

- parent：继承`spring-boot-starter-parent`的依赖管理，控制版本与打包等内容
- dependencies：项目具体依赖，这里包含了`spring-boot-starter-web`用于实现HTTP接口（该依赖中包含了Spring MVC）；`spring-boot-starter-test`用于编写单元测试的依赖包。更多功能模块的使用我们将在后面的教程中逐步展开。
- build：构建配置部分。默认使用了`spring-boot-maven-plugin`，配合`spring-boot-starter-parent`就可以把Spring Boot应用打包成JAR来直接运行。

### 工程结构推荐

```shell
com
  +- example
    +- myproject
      +- Application.java
      |
      +- domain
      |  +- Customer.java
      |  +- CustomerRepository.java
      |
      +- service
      |  +- CustomerService.java
      |
      +- web
      |  +- CustomerController.java
      |
```

- `root package`：`com.example.myproject`，所有的类和其他package都在root package之下。
- 应用主类：`Application.java`，该类直接位于`root package`下。通常我们会在应用主类中做一些框架配置扫描等配置，我们放在root package下可以帮助程序减少手工配置来加载到我们希望被Spring加载的内容
- `com.example.myproject.domain`包：用于定义实体映射关系与数据访问相关的接口和实现
- `com.example.myproject.service`包：用于编写业务逻辑相关的接口与实现
- `com.example.myproject.web`：用于编写Web层相关的实现，比如：Spring MVC的Controller等

