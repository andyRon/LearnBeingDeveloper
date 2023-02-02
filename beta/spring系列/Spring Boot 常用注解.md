# Spring Boot 常用注解

https://mp.weixin.qq.com/s/ngvRyBEVSqA1JVlB9E1ebg





## Bean处理

###  @Autowired

- 用法：用在属性、方法上
- 含义：byType 方式完成自动装配，把配置好的 Bean 拿来用，完成属性、方法的组装。当加上（required=false ）时，就算找不到 bean 也不报错。

<font color=#FF263D>依赖注入</font>

### @Component

- 泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。一般公共的方法我会用上这个注解

### @Respository

- 用于数据持久层，经常标记到DAO类上

### @Service

- 用于服务层，经常标注到Service类上，常需要注入DAO层

### @Controller

- MVC控制层Bean，常需要注入Service层

### @RestController

- @RestController 注解，它继承自 @Controller 注解。 4.0 之前的版本， Spring MVC 的组件都使用 @Controller 来标识当前类是一个控制器 servlet 。使用这个特性，我们可以开发 REST 服务的时候直接使用@RestController 。

### @Configuration

- 一般用来声明配置类

<font color=#FF263D>上面六个都标注类被spring容器管理</font>

### @Scope

- 声明 Spring Bean 的作用域

	- singleton

	  唯一 bean 实例，Spring 中的 bean 默认都是单例的。
	  
	- prototype

	  每次请求都会创建一个新的 bean 实例。
	  
	- request

	  每一次 HTTP 请求都会产生一个新的 bean，该 bean 仅在当前 HTTP request 内有效。
	  
	- session

	  每一次 HTTP 请求都会产生一个新的 bean，该 bean 仅在当前 HTTP session 内有效。
	  
## HTTP请求

### @GetMapping

等价于@RequestMapping(value="/test",method=RequestMethod.GET)

- GET请求，从服务器获取特定资源

### @PostMapping

- POST请求，在服务器上创建一个新的资源

### @PutMapping

- PUT请求，更新服务器上的资源

### @DeleteMapping

- DELETE 请求，从服务器删除特定的资源

## 前后端参数传递

### @RequestParam

- 用在方法的参数前面，获取请求中表单类型的key=value格式的数据

### @PathVariable

```java
RequestMapping("user/get/mac/{macAddress}")
public String getByMacAddress(@PathVariable String macAddress){
// TODO
}
```


- 路径变量，参数与大括号里的名字一样要相同。

### @RequestBody

用于读取 Request 请求（可能是 POST,PUT,DELETE,GET 请求）的 body 部分并且Content-Type 为 application/json 格式的数据，接收到数据之后会自动将数据绑定到 Java 对象上去。系统会使用HttpMessageConverter或者自定义的HttpMessageConverter将请求的 body 中的 json 字符串转换为 java 对象。

- 获取请求body中的数据，常用于搭配@PostMapping请求来提交对象数据

### @ResponseBody

- 表示该方法的返回结果直接写入HTTP response body 中，格式为 json

## 读取配置

### @value

- 直接读取各种配置源的属性名

### @ConfigurationProperties

- 读取配置信息并与 bean 绑定

### @PropertySource

- 指定加载自定义的配置文件

## 参数校验

### Bean字段验证注解

从Boot 2.3开始，我们还需要显式地添加spring-boot-starter-validation依赖项;

```xml
<dependency> 
    <groupId>org.springframework.boot</groupId> 
    <artifactId>spring-boot-starter-validation</artifactId> 
</dependency>
```



- @NotEmpty

  被注释的字符串的不能为 null 也不能为空
  
- @NotBlank 

  被注释的字符串非 null，并且必须包含一个非空白字符
  
- @Null 

  被注释的元素必须为 null
  
- @NotNull 

  被注释的元素必须不为 null
  
- @AssertTrue

  被注释的元素必须为 true
  
- @AssertFalse 

  被注释的元素必须为 false
  
- @Pattern(regex=,flag=)

  被注释的元素必须符合指定的正则表达式
  
- @Email

  被注释的元素必须是 Email 格式
  
- @Min(value) 

  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
  
- @Max(value) 

  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
  
- @DecimalMin(value) 

  被注释的元素必须是一个数字，其值必须大于等于指定的最小值
  
- @DecimalMax(value) 

  被注释的元素必须是一个数字，其值必须小于等于指定的最大值
  
- @Size(max=, min=) 

  被注释的元素的大小必须在指定的范围内
  
- @Digits (integer, fraction) 

  被注释的元素必须是一个数字，其值必须在可接受的范围内
  
- @Past

  被注释的元素必须是一个过去的日期
  
- @Future

  被注释的元素必须是一个将来的日期
  
### @Valid

- 用于标注验证对象的级联属性

### @Validated

- Spring提供的注解，于SpringMVC一起使用，标注方法参数需要检查

## 统一异常处理

### @ControllerAdvice

- 注解定义全局异常处理类，包含@Component所以可以被Spring扫描到

### @ExceptionHandler 

- 注解声明异常处理方法，表示遇到这个异常，就执行标注的方法

## JPA数据持久化

### @Entity

- 声明数据库实体类

### @Table 

- 设置表明

### @Id

- 声明一个字段为主键

### @GeneratedValue

GenerationType.TABLE 持久化引擎通过关系数据库的一张特定的表格来生成主键
GenerationType.SEQUENCE 随机序列
GenerationType.IDENTITY 主键自增长
GenerationType.AUTO 持久化引擎会根据数据库在以上三种主键生成策略中选择


- 声明主键的生成策略

### @Column 

```java
@Column(columnDefinition = "tinyint(1) default 1")
```

设置字段类型添加默认值

- 声明字段，经常用于属性名和表字段的映射

### @Transient

- 指定不需要持久化的字段

### @Lob

- 声明某个字段为大字段

### @Enumerated

- 声明枚举类型的字段

### @Modifying

- 加在DAO方法上，提示是修改操作

###  @Transactional

Exception 分为运行时异常 RuntimeException 和非运行时异常。在@Transactional注解中如果不配置rollbackFor属性,那么事物只会在遇到RuntimeException的时候才会回滚,加上rollbackFor=Exception.class,可以让事物在遇到非运行时异常时也回滚。



- 作用于类上

	- 表示所有该类的public 方法都配置相同的事务属性信息

- 作用于方法上

	- 当类配置了@Transactional，方法也配置了@Transactional，方法的事务会覆盖类的事务配置信息

## JSON格式处理

### @JsonIgnoreProperties

- 作用在类上用于过滤掉特定字段不返回或者不解析

  //生成json时将userRoles属性过滤
  @JsonIgnoreProperties({"userRoles"})
  public class User {
      private String userName;
      private String fullName;
      private String password;
      @JsonIgnore
      private List<UserRole> userRoles = new ArrayList<>();
  }
  
  
### @JsonIgnore

- 一般用于属性上，作用和上面的@JsonIgnoreProperties 一样

### @JsonFormat

@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone="GMT")
private Date date;

- 用来格式化 json 数据

### @JsonUnwrapped 

- 扁平化对象

## 测试处理

### @ActiveProfiles

- 常作用于测试类上， 用于声明生效的 Spring 配置文件

### @Test

- 声明一个方法为测试方法

### @Transactional

- 被声明的测试方法的数据会回滚，避免污染测试数据

### @WithMockUser 

@Test
@Transactional
@WithMockUser(username = "user-id-18163138155", authorities = "ROLE_TEACHER")
void should_import_student_success() throws Exception {
    ......
}


- Spring Security 提供的，用来模拟一个真实用户，并且可以赋予权限

## 配置启动

### @SpringBootApplication

- 等价于以默认属性使用 @Configuration、@EnableAutoConfiguration、@ComponentScan

### @Configuration

- Spring Boot 提倡基于 Java 的配置，相当于你之前在 xml 中配置 bean

### @EnableAutoConfiguration

- 类级别的注解，这个注解告诉 Spring Boot 根据添加的 jar 依赖猜测你想如何配置 Spring

### @ComponentScan

- 标注哪些路径下的类需要被Spring扫描

### @Conditional

Spring4 新提供的注解，通过 @Conditional 注解可以根据代码中设置的条件装载不同的 bean，也是SpringBoot实现自动配置的基石。

- @ConditionalOnBean

	- 配置了某个特定的Bean

- @ConditionalOnMissingBean

	- 没有配置特定的Bean

- @ConditionalOnClass

	- Classpath里有指定的类

- @ConditionalOnMissingClass

	- Classpath里没有指定的类

- @ConditionalOnExpression

	- 给定的SpEL表达式计算结果为true

- @ConditionalOnJava

	- Java的版本匹配特定值或者一个范围值

- @ConditionalOnJndi

	- 参数中给定的JNDI位置必须存在一个，如果没有给参数，则要有JNDI InitialContext

- @ConditionalOnProperty

	- 指定的配置属性要有一个明确的值

- @ConditionalOnResource

	- Classpath里没有指定的资源

- @ConditionalOnWebApplication

	- 这是一个Web应用程序

- @ConditionalOnNotWebApplication

	- 这不是一个Web应用程序

