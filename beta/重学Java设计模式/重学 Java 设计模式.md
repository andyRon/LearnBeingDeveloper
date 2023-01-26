

https://github.com/fuzhengwei/itstack-demo-design

[《重学 Java 设计模式》](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzIxMDAwMDAxMw==&action=getalbum&album_id=1353903261098786818&scene=173&from_msgid=2650725639&from_itemidx=1&count=3&nolastread=1#wechat_redirect)



设计模式是由多年的经验提炼出来开发指导思想。

六大原则；单一职责(`一个类和方法只做一件事`)、里氏替换(`多态，子类可扩展父类`)、依赖倒置(`细节依赖抽象，下层依赖上层`)、接口隔离(`建立单一接口`)、迪米特原则(`最少知道，降低耦合`)、开闭原则(`抽象架构，扩展实现`)



创建型模式**提供创建对象的机制， 能够提升已有代码的灵活性和可复用性。**

结构型模式**如何将对象和类组装成较大的结构， 并同时保持结构的灵活和高效。**

行为模式**负责对象间的高效沟通和职责委派。**



### 1 工厂模式

也叫**工厂方法模式**，简单形式叫**简单工厂模式**。

工厂模式主要意图是定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。

简单说就是为了提供代码结构的扩展性，屏蔽每一个功能类中的具体实现逻辑。让外部可以更加简单的只是知道调用即可，同时，这也是去掉众多`ifeslse`的方式。

缺点：需要实现的类非常多，如何去维护，怎样减低开发成本等。

#### 案例1：模拟发奖多种商品

![图片](https://mmbiz.qpic.cn/sz_mmbiz_png/zTfAIs5rNXiaOIRoUSygFvaibovEiblOphdeEnZibGmeBD8rkawylOGibCA6WOeZukYrpYvNiao9vewKnEjZicsuL3v2w/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1)

```java
public interface ICommodity {
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;
}

public class CardCommodityService implements ICommodity {
	// ...
}
public class CouponCommodityService implements ICommodity {
	// ...
}
public class GoodsCommodityService implements ICommodity {
	// ...
}

public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }

}

```



### 2 抽象工厂模式

<img src="https://mmbiz.qpic.cn/sz_mmbiz_png/zTfAIs5rNXjLR3iaWWIqHbkIibmHV5QpRlLYCYhvBYjxBDzgVFkBmHkNYoKSZuRicMSxaeYIdOnUBTRxu1LmpgP3A/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1" alt="抽象工厂模式" style="zoom: 50%;" />

抽象工厂是一个中心工厂，创建其他工厂的模式。

#### 案例：模拟企业级双套Redis集群升级

<img src="https://mmbiz.qpic.cn/sz_mmbiz_png/zTfAIs5rNXjLR3iaWWIqHbkIibmHV5QpRl67jKTHGU0yq9FAVOzoIFKx6l6PH7fH79ANYtY1dHalCjM7X9JpIhPQ/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom: 50%;" />





### 3 建造者模式

**建造者模式所完成的内容就是通过将多个简单对象通过一步步的组装构建出一个复杂对象的过程。**

> 场景：
>
> 玩王者荣耀的时的初始化界面；有三条路、有树木、有野怪、有守卫塔等等，甚至依赖于你的网络情况会控制清晰度。而当你换一个场景进行其他不同模式的选择时，同样会建设道路、树木、野怪等等，但是他们的摆放和大小都有不同。这里就可以用到建造者模式来初始化游戏元素。

**将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。**

#### 案例：装修套餐选择(豪华、田园、简约)

<img src="https://mmbiz.qpic.cn/sz_mmbiz_png/zTfAIs5rNXhtVo05UmoZNnvLvKGeqE0WWhxaVVEWljXkaYIHubicTIrTaDGxNGIttuFBlV94wAO16MCHeURDaLg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1" alt="图片" style="zoom:50%;" />



#### 什么时候会选择建造者模式？

一些基本物料不会变，而其组合经常变化的时候



### 4 原型模式

原型模式主要解决的问题就是创建重复对象，而这部分`对象`内容本身比较复杂，生成过程可能从库或者RPC接口中获取数据的耗时较长，因此采用克隆的方式节省时间。

场景：

1. 你经常`Ctrl+C`、`Ctrl+V`，复制粘贴代码。
2. Java多数类中提供的API方法；`Object clone()`。
3. 细胞的有丝分裂。



### 5 单例模式

单例模式主要解决的是，一个全局使用的类频繁的创建和消费，从而提升提升整体的代码的性能。



场景：

1. 数据库的连接池不会反复创建
2. spring中一个单例模式bean的生成和使用
3. 在我们平常的代码中需要设置全局的的一些属性保存
