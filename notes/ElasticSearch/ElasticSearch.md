ElasticSearch
-----------
https://www.bilibili.com/video/BV17a4y1x7zq



6.X 和 7.X的区别十分大

全文检索

ELK



## Lucene创始人——Doug Cutting

Doug Cutting是Lucene、Nutch 、Hadoop等项目的发起人。

Lucene是Java写的，全文检索

> 大数据的两个问题：**存储+计算**！

2003年，Google发表了一篇技术学术论文，公开介绍了自己的谷歌文件系统**GFS**（Google File System）。这是Google公司为了存储海量搜索数据而设计的专用文件系统。
第二年，也就是2004年，Doug Cutting基于Google的GFS论文，实现了**分布式文件存储系统**，并将它命名为NDFS（NutchDistributed File System)。

还是2004年，Google又发表了一篇技术学术论文，介绍自己的**MapReduce编程模型**。这个编程模型，用于大规模数据集（大于1TB）的并行分析运算。
第二年（2005年），Doug Cutting又基于MapReduce，在Nutch搜索引擎实现了该功能。

2006年，Doug Cutting加盟Yahoo后，将NDFS和MapReduce进行了升级改造，并重新命名为**Hadoop**（NDFS也改名为**HDFS**，Hadoop Distributed File System）。

Hadoop这个名字，实际上是Doug Cutting他儿子的黄色玩具大象的名字。所以，Hadoop的Logo，就是一只奔跑的黄色大象。

我们继续往下说。
还是2006年，Google又发论文了。
这次，它们介绍了自己的**BigTable**。这是一种**分布式数据存储系统**，一种用来处理海量数据的非关系型数据库。Doug Cutting当然没有放过，在自己的hadoop系统里面，引入了BigTable，并命名为**HBase**。

![image-20211024010830363](/Users/andyron/Library/Application Support/typora-user-images/image-20211024010830363.png)

![image-20211024010953788](/Users/andyron/Library/Application Support/typora-user-images/image-20211024010953788.png)



Lucene是一套信息检索工具包！Jar包！不包含搜索引擎系统！

包含的：索引结构！读写索引的工具！排序，搜索规则...工具类！

**Lucene和ElasticSearch关系：**

ElasticSearch是基于Lucene做了一些封装和增强。



## ElasticSearch概述

https://www.elastic.co/cn/elasticsearch/

Elaticsearch ，简称为es，es是一个开源的高扩展的**分布式全文检索引擎**，它可以近乎**实时的存储、检索数据**；本身扩展性很好，可以扩展到上百台服务器，处理**PB级别**（大数据时代）的数据。es也使用Java开发并使用Lucene作为其核心来实现所有索引和搜索的功能，但是它的目的是通过简单的**RESTful API** （/user get post put delete）来隐藏Lucene的复杂性，从而让全文搜索变得简单。
据国际权威的数据库产品评测机构DB Engines的统计，在2016年1月，Elasticsearch己超过Solr等，**成为排名第一的搜索引擎类应用。**

### 历史

多年前，一个叫做Shay Banon的刚结婚不久的失业开发者，由于妻子要去伦敦学习厨师，他便跟着也去了。在他找工作的过程中，为了给妻子构建一个食谱的搜索引擎，他开始构建一个早期版本的Lucene。

直接基于Lucene工作会比较困难，所以Shay开始抽象Lucene代码以便java程序员可以在应用中添加搜索功能。他发布了他的第：个开源项目，叫做"Compass"。

后来Shav找到一份工作，这份工作处在高性能和内存数据网格的分布式环境中， 因此高性能的， 实时的， 分布式的搜索引擎也理所当然需要的。然后他决定重写Compass库使其成为一个独立的服务叫做Elasticsearch。



第一个公开版本出现在2010年2月，在那之后Elasticsearch己经成为 Github 上最受欢迎的项目之一
，代码贡献者超过300人。一家主营Elasticsearch的公司就此成立，他们一边提供商业支持一边开发新功能，不过Elasticsearch将永远开源旦对所有人可用。

Shay的妻子依旧等待着她的食谱搜索…



**谁在使用：**

1. 维基百科，类似百度百科，全文检索，高亮，搜索推荐/2（权重，百度）
2. The Guardian（国外新闻网站），类似搜狐新间，用户行为日志（点击，浏览，收藏，评论）＋社交网络数据（对某某新间的相关看法），数据分析，给到每篇新闻文章的作者，让他知道他的文章的公众反馈（好，坏，热门，垃圾，鄙视，崇拜）
3. Stack Overflow（国外的程序异常讨论论坛），IT问题，程序的报错，提交上去， 全文检索，搜索相关问题和答案，程序报错了，就会将报错信息粘贴到里面去，搜索有没有对应的答案
4. GitHub（开源代码管理），搜索上千亿行代码
5. 电商网站，检索商品
6. 日志数据分析，logstash采集日志，ES进行复杂的数据分析，**ELK技术**，elasticsearch+logstash+kibana
7. 商品价格监控网站，用户设定某商品的价格國值，当低于该國值的时候，发送通知消息给用户，比如说订阅牙膏的监控，如果高露洁牙言的家庭套装低于50块钱，就通知我，我就去买
8. BI系统，商业智能，Business Intelligence。比如说有个大型商场集团，BI，分析一下某某区域最近3年的用户消费金额的趋势以及用户群体的组成构成，产出相关的数张报表，**区，最近3年，每年消费金额呈现100%的增长，而且用户群体85%是高级白领，开一个新商场。ES执行数据分析和挖掘，Kibana进行数据可视化。
9. 国内：站内搜索（电商，招聘，门户，等等），IT系统搜索（OA,CRM,ERP，等等），数据分析（ES热门
   的一个使用场景）



## ES和solr的差别

### ES

用于**全文搜索、结构化搜索、分析**以及将这三者混合使用：

维基百科使用Elasticsearch提供全文搜索并**高亮关键字**，以及**输入实时搜索(search-asyou-type)**和**搜索纠错(did-you-mean)**等搜索建议功能。

英国卫报使用Elasticsearch结合用户日志和社交网络数据提供给他们的编辑以实时的反馈，以便及时了解公众对新发表的文章的回应。

Stackoverflow结合全文搜索与地理位置查询，以及**more-like-this**功能来找到相关的问题和答案。

Github使用Elasticsearch检索1300亿行的代码。

但是Elasticsearch不仅用于大型企业，它还让像DataDog以及Klout这样的创业公司将最初的想法变成可扩展的解决方案。

Elasticsearch可以在你的笔记本上运行，也可以在数以百计的服务器上处理PB级别的数据。
Elasticsearch是一个基于Apache Lucene(TM)的开源搜索引擎。无论在开源还是专有领域，Lucene可以被认为是迄今为止最先进性能最好的、功能最全的搜素引擎库。

但是，Lucene只是一个库。想要使用它，你必须使用lava来作为开发语言并将其直接集成到你的应用中，更糟糕的是，Lucene非常复杂，你需要深入了解检索的相关知识来理解它是如何工作的。

Elasticsearch也使用lava开发并使用Lucene作为其核心来实现所有索引和搜索的功能，但是它的目的是通过简单的 RESTful API 来隐藏Lucene的复杂性，从而让全文搜索变得简单。

### Solr简介

Solr 是Apache下的一个顶级开源项目，采用Java开发，它是基于Lucene的全文搜索服务器。Solr提供了比Lucene更为丰富的查询语言，同时实现了可配置、可扩展，并对索引、搜索性能进行了优化。

Solr可以独立运行，运行在jetty、Tomcat等这些Servlet容器中，Solr 索引的实现方法很简单，**用 POST 方法向 Solr 服务器发送一个描述 Field 及其内容的XML 文档，Solr根据xml文档添加、删除、更新索引**。Solr搜索只需要发送 HTTP GET 请求，然后对 solr返回xml、json等格式的查询结果进行解析，组织页面布局。Solr不提供构建UI的功能，Solr提供了一个管理界面，通过管理界面可以查询Solr的配置和运行情况。

solr是基于lucene开发企业级搜索服务器，实际上就是封装了lucene。

Solr是一个独立的企业级搜索应用服务器，它对外提供类似于**Web-service的APl接口**。用户可以通过http请求，向搜索引擎服务器提交一定格式的文件，生成索引；也可以通过提出查找请求，并得到返回结果。

### Lucene简介

Lucene是apache软件基金会4 jakarta项目组的一个子项目，是一个开放源代码的全文检素引擎工具包，但它不是一个完整的全文检索引擎，而是一个全文检索引擎的架构，提供了完整的查询引擎和索引引擎，部分文本分析引擎（英文与德文两种西方语言）。

Lucene的目的是为软件开发人员提供一个简单易用的工具包 ，以方便的在目标系统中实现全文检索的功能，或者是以此为基础建立起完整的全文检索引擎。Lucene是一套用于全文检索和搜寻的开源程式库，由Apache软件基金会支持和提供。 Lucene提供了一个简单却强大的应用程式接口 ，能够做全文索引和搜寻。在Java开发环境里Lucene是一个成熟的免费开源工具。就其本身而言，Lucene是当前以及最近几年最受欢迎的免费ava信息检索程序库。人们经常提到信息检索程序库，星然与搜素引擎有关，但不应该将信息检索程序库与搜索引擎相混淆。

Lucene是一个全文检索引擎的架构。那什么是全文搜索引擎？

全文搜素引擎是名副其实的搜素引擎，国外具代表性的有Google、Fast/AlThe Web、AltaVista、Inktomi.Teoma、WiseNut等，国内著名的有百度（Baidu）。它们都是通过火互联网上提取的各个网站的信息（以网页文字为主）而建立的数据库中，检索与用户查询条件匹配的相关记录，然后按一定的排列顺序将结果返回给用户，因此他们是真正的搜索引擎。

从搜索结果来源的角度，全文搜索引擎又可细分为两种，<u>一种是拥有自己的检索程序（Indexer），俗称“蜘蛛”( Spider)程序或机器人Robot）程序，并自建网页数据库，搜索结果直接从自身的数据库中调用，如上面提到的7家引擎；另一种则是租用其他引擎的数据库，并按自定的格式排列搜索结果，如Lycos引擎</u>。

### Elasticsearch和Solr比较

> 架构的选择

当单纯地对已有数据进行搜索是，solr更快。

![image-20211106200548664](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211106200548664.png)

当实时建立索引时，Solr会产生io阻塞，查询性能较差，Elasticsearch具有明显的有时。

![image-20211106200702725](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211106200702725.png)

随着数据量的增加，Solr的搜索效率会变得更低，而Elasticsearch却没有明显的变化。

![](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211106200826555.png)

![image-20211106200916286](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211106200916286.png)

#### Elasticsearch vs Solr 总结

1. es基本是开箱即用（解压就可以用），非常简单。Solr安装略微复杂一丢丢！
2. solr利用 Zookeeper 进行分布式管理，而 Elasticsearch 自身带有分布式协调管理功能。
3. Solr 支持更多格式的数据，比如JSON、XML、 CSV，而Elasticsearch 仅支持json文件格式。

4. Solr 官方提供的功能更多，而Elasticsearch 本身更注重于核心功能，高级功能多有第三方插件提供，例如图形化界面需要kibana友好支撑
5. Solr 查询快，但更新索引时慢（即插入别除慢），用于电商等查询多的应用；
   - ES建立索引快（ 即查询慢），**即实时性查询快**，用于facebook新浪等搜索。
   - solr 是传统搜索应用的有力解决方案，但Elasticsearch 更适用于新兴的实时搜索应用。
6. Solr比较成熟，有一个更大，更成熟的用户、开发和贡献者社区，而 Elasticsearch相对开发维护者较少，更新太快，学习使用成本较高。



## Elasticsearch 安装

JDK1.8 最低要求

windows和Linux上都可以学习！

ELK三剑客，解压即用！

### 熟悉目录

```
bin
config
		log4j2   		日志配置文件
		jvm.option	java虚拟机相关的配置
		elasticsearch.yml   elasticsearch的配置文件。默认端口9200！跨域！
lib					相关jar包
logs				日志
modules			功能模块
plugins			插件。ik

```

### 启动

```shell
./bin/elasticsearch
```

公开地址是9200，通信地址是9300

```
publish_address {127.0.0.1:9200}
```

### 访问测试

127.0.0.1:9200：

```
{
  "name" : "192.168.0.104",
  "cluster_name" : "elasticsearch",
  "cluster_uuid" : "sjBi10qMQ6mTC3HJHGb9wQ",
  "version" : {
    "number" : "7.15.1",
    "build_flavor" : "default",
    "build_type" : "tar",
    "build_hash" : "83c34f456ae29d60e94d886e455e6a3409bba9ed",
    "build_date" : "2021-10-07T21:56:19.031608185Z",
    "build_snapshot" : false,
    "lucene_version" : "8.9.0",
    "minimum_wire_compatibility_version" : "6.8.0",
    "minimum_index_compatibility_version" : "6.0.0-beta1"
  },
  "tagline" : "You Know, for Search"
}
```

### 可视化界面

1. 安装es head插件 https://github.com/mobz/elasticsearch-head

```bash
git clone git://github.com/mobz/elasticsearch-head.git
cd elasticsearch-head
```

2. 启动

```bash
npm install
npm run start
```

3. 访问 http://localhost:9100/      

因为跨域问题，暂时不能访问，配置elasticsearch.yml，重启elasticsearch。

```yaml
# 配置跨域，开启，运行所有人访问
http.cors.enabled: true 
http.cors.allow-origin: "*"
```

4. 再次访问

![image-20211106221452987](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211106221452987.png)

>  elasticsearch-head和elasticsearch的关系，类似mysql客服端和mysql的关系。  

之后就把elasticsearch-head当作是数据展示工具，查询的工作交给kibana



### 了解ELK

ELK是Elasticsearch、Logstash、Kibana三大开源框架首字母大写简称。市面上也被成为Elastic Stack。 其中Elasticsearch是基于Lucene、分布式、通过Restful方式进行交互的近实时搜索平台框架。像类似百度、谷歌这种大数据全文搜索引擎的场景都可以使用Elasticsearch作为底层支持框架，可见Elasticsearch提供的搜索能力确实强大,市面上很多时候我们简称Elasticsearch为es。

Logstash是ELK的**中央数据流引擎**，用于从不同目标（文件/数据存储/MQ）收集的不同格式数据，经过过滤后支持输出到不同目的地（文件/MQ/redis/elasticsearch/kafka等）。

kibana可以将elasticsearch的数据通过友好的页面展示出来，提供实时分析的功能。

>  收集清洗数据 --＞ ES(分析、搜索、存储)  --> Kibana

市面上很多开发只要提到ELK能够一致说出它是一个日志分析架构技术栈总称，但实际上ELK不仅仅适用于日志分析，它还可以支持其它任何数据分析和收集的场景，日志分析和收集只是更具有代表性。并非唯一性。

![image-20211106223049448](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211106223049448.png)

### 安装Kibana

https://www.elastic.co/cn/kibana/

Kibana版本要和ES一致

下载解压，启动 

```
./bin/kibana
```

http://localhost:5601

![](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211106225200400.png)

之后所有操作在上面进行编写。 

界面可汉化，翻译文件具体位置：`./x-pack/plugins/translations/translations/zh-CN.json`，只需要修改一下配置文件`config/kibana.yml`，重启即可

```yaml
#i18n.locale: "en"
i18n.locale: "zh-CN"
```



## ES核心概念

集群、节点、索引、类型、文档、分片、映射

ES是<font color=#FF263D>**面向文档**</font>，一切都是JSON

| 关系行数据库       | Elasticsearch         |
| ------------------ | --------------------- |
| 数据库（database） | 索引（indices）       |
| 表（tables）       | types（慢慢会被弃用） |
| 行（rows）         | documents             |
| 字段（columns）    | fields                |

elasticsearch(集群)中可以包含多个索引数据库)，每个索引中可以包含多个类型(表)，每个类型下又包含多 个文档(行)，每个文档中又包含多个字段（列）。

#### **物理设计：**

elasticsearch 在后台**把每个索引划分成多个分片** ，每分分片可以在集群中的不同服务器问迁移。

一个就是一个集群！默认的集群名称就是`elasticsearch`。



#### **逻辑设计：**

一个索引类型中，包含多个文档，比如说文档1，文档2。当我们索引引一篇文档时，可以通过这样的一各顺序找到它：索引 >> 类型 >>文档ID，通过这个组合我们就能索引到某个具体的文档。注意：ID不必是整数，实际上它是个字符串。

#### **文档**

之前说elasticsearch是面向文档的，那么就意味着索引和搜索数据的**最小单位是文档**，elasticsearch中，文档有几个 重要属性：

- 自我包含，一篇文档同时包含字段和对应的值，也就是同时包含 key:value !
- 可以是层次型的，一个文档中包含自文档，复杂的逻辑实体就是这么来的！（就是一个json对象，通过fastjson进行自动转换）
- 灵活的结构，文档不依赖预先定义的模式，我们知道关系型数据库中，要提前定义字段才能使用，在elasticsearch中，对于字段是非常灵活的，有时候，我们可以忽略该字段，或者动态的添加一个新的字段。

尽管我们可以随意的新增或者忽略某个字段，但是，每个字段的类型非常重要，比如一个年龄字段类型，可以是字符串也可以是整型。因为elasticsearch会保存字段和类型之间的映射及其他的设置。这种映射具体到每个映射的每种类型，这也是为什么在elasticsearch中，类型有时候也称为**映射类型**。

#### 类型

类型是文档的逻辑容器，就像关系型数据库一样，表格是行的容器。类型中对于字段的定义称为映射，比如name 映射为字符串类型。我们说文档是无模式的，它们不需要拥有映射中所定义的所有字段，比如新增一个字段，那么elasticsearch是怎么做的呢？
elasticsearch会自动的将新字段加入映射 ，但是这个字段的不确定它是什么类型，elasticsearch就开始猜，如果这个值是18，那么elasticsearch会认为它是整形。但是elasticsearch可能猜不对，所以最安全的方式就是提前定义好所需要的映射，这点跟关系型数据库殊途同归了，先定义好字段，然后再使用，别整什么么蛾子。

#### 索引

就是数据库！
索引是映射类型的容器，elasticsearch中的索引是一个非常大的文档集合。索引存储了映射类型的字段和其他设置。然后它们被存储到了各个分片上了。我们来研究下分片是如何工作的。

#### 物理设计：节点和分片 如何工作

一个集群至少有一个节点，而一个节点就是一个elasricsearch进程 ，节点可以有多个素引默认的，如果你创建索引，那么索引将会有个5个分片（primary shard,又称**主分片**）构成的，每一个主分片会有一个副本(replica shard ,又称**复制分片**）

![](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211202203008826.png)

上图是一个有3个节点的集群，可以看到主分片和对应的复制分片都不会在同一个节点内，这样有利于某个节点挂掉 了，数据也不至于丢失。实际上，一个分片是一个Lucene索引，一个包含**倒排索引**的文件目录，倒排索引的结构使得elasticsearch在不扫描全部文档的情况下 ，就能告诉你哪些文档包含特定的关键字。不过，等等，倒排索引是什么鬼？

#### 倒排索引

elasticsearch使用的是一种称为倒排索引的结构，采用Lucene倒排索引作为底层。这种结构适用于快速的全文搜索，一个索引由文档中所有不重复的列表构成，对于每一个词，都有一个包含它的文档列表。例如，现在有两个文档，每个文档包含如下内容：

```
study every day, good good up to forever	# 文档1包含的内容
To forever, study every day, good good up # 文档2包含的内容
```

为了创建倒排索引，我们首先要将每个文档拆分成独立的词(或称为词条或者tokens)，然后创建一个包含所有不重复的词条的排序列表，然后列出每个词条出现在哪个文档：

![](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211202204150334.png)

现在，我们试图搜索to forever，只需要查看包含每个词条的文档score 

![](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211202204322607.png)

两个文档都匹配，但是第一个文档比第二个匹配程度更高。如果没有别的条件，现在，这两个包含关键字的文档都将返回。

再来看一个例子，比如我们通过博客标签来搜索博客文章。那么倒排索引列表就是这样的一个结构：

![](/Users/andyron/myfield/github/LearnBeingDeveloper/notes/ElasticSearch/images/image-20211202204614316.png)

如果要搜索含有 python 标签的文章，那相对于查找所有原始数据而言，查找倒排索引后的数据将会快的多。只需要查看标签这一栏，然后获取相关的文章ID即可。完全过滤掉无关的所有数据，提高效率！

**elasticsearch的索引和Lucene的索引对比**

在elasticsearch中，索引（库）这个词被频繁使用，这就是术语的使用。 在elasticsearch中，索引被分为多个分片，每份分片是一个Lucene的索引。所以**一个elasticsearch索引是由多个Lucene索引组成的**。别问为什么，谁让elasticsearch使用Lucene作为底层呢！ 如无特指，说起索引都是指elasticsearch的索引。

接下来的一切操作都在kibana中Dev Tools下的Console里完成。基础操作！

## IK分词插件

🔖p8
