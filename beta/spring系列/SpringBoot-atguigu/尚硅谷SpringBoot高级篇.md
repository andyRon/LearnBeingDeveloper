# 尚硅谷SpringBoot高级篇



## 九、SpringBoot与缓存

JSR-107缓存规范、Spring缓存抽象、整合Redis

高频热点数据  电商商品信息

临时数据   验证码

### 1、JSR107

Java Caching定义了5个核心接口，分别是**CachingProvider**, **CacheManager**, **Cache**, **Entry**

和 **Expiry**。

- **CachingProvider**定义了创建、配置、获取、管理和控制多个**CacheManager**。一个应用可

  以在运行期访问多个CachingProvider。

- **CacheManager**定义了创建、配置、获取、管理和控制多个唯一命名的**Cache**，这些Cache 存在于CacheManager的上下文中。一个CacheManager仅被一个CachingProvider所拥有。

- **Cache**是一个类似Map的数据结构并临时存储以Key为索引的值。一个Cache仅被一个 CacheManager所拥有。

- **Entry**是一个存储在Cache中的key-value对。

- **Expiry** 每一个存储在Cache中的条目有一个定义的有效期。一旦超过这个时间，条目为过期 的状态。一旦过期，条目将不可访问、更新和删除。缓存有效期可以通过ExpiryPolicy设置。

![image-20200526090748147](/Users/andyron/Library/Application Support/typora-user-images/image-20200526090748147.png)

javax.cache

JSR107实际用的比较少

### 2、Spring缓存抽象

Spring从3.1开始定义了org.springframework.cache.**Cache** 和org.springframework.cache.**CacheManager**接口来统一不同的缓存技术; 并支持使用**JCache(JSR-107)注解**简化我们开发;

- Cache接口为缓存的组件规范定义，包含缓存的各种操作集合;

- Cache接口下Spring提供了各种xxxCache的实现;如RedisCache，EhCacheCache ,ConcurrentMapCache等;

-  每次调用需要缓存功能的方法时，Spring会检查检查指定参数的指定的目标方法是否已经被调用过;如果有就直接从缓存中获取方法调用后的结果，如果没有就调用方法 并缓存结果后返回给用户。下次调用直接从缓存中获取。

- 使用Spring缓存抽象时我们需要关注以下两点; 

  1、确定方法需要被缓存以及他们的缓存策略 

  2、从缓存中读取之前缓存存储的数据

### 3、几个重要概念&缓存注解

| **Cache**          | **缓存接口，定义缓存操作。实现有:****RedisCache****、****EhCacheCache****、** **ConcurrentMapCache****等** |
| ------------------ | ------------------------------------------------------------ |
| **CacheManager**   | **缓存管理器，管理各种缓存(Cache)组件**                      |
| **@Cacheable**     | **主要针对方法配置，能够根据方法的请求参数对其结果进行缓存** |
| **@CacheEvict**    | **清空缓存**                                                 |
| **@CachePut**      | **保证方法被调用，又希望结果被缓存。** 	缓存更新          |
| **@EnableCaching** | **开启基于注解的缓存**                                       |
| **keyGenerator**   | **缓存数据时key生成策略**                                    |
| **serialize**      | **缓存数据时value序列化策略**                                |

