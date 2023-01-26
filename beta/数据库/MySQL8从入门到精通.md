MySQL8从入门到精通
---------



### 1 初识MySQL



#### SQL语言

SQL语言的四个组成部分

1. 数据定义语言（DDL）：DROP、CREATE、ALTER等语句。
2. 数据操作语言（DML）：INSERT（插入）、UPDATE（修改）、DELETE（删除）语句。
3. 数据查询语言（DQL）：SELECT语句。
4. 数据控制语言（DCL）：GRANT、REVOKE、COMMIT、ROLLBACK等语句。



#### MySQL命令行服务器端实用工具

1. mysqld：SQL后台程序（MySQL服务器进程）。必须在该程序运行之后，客户端才能通过连接服务器来访问数据库。
2. mysqld_safe：服务器启动脚本。在UNIX和NetWare中推荐使用mysqld_safe来启动mysqld服务器。mysqld_safe增加了一些安全特性，例如当出现错误时重启服务器并向错误日志文件写入运行时间信息。
3. mysql.server：服务器启动脚本。该脚本用于使用包含为特定级别的、运行启动服务的脚本的、运行目录的系统。它调用mysqld_safe来启动MySQL服务器。
4. mysql_multi：服务器启动脚本，可以启动或停止系统上安装的多个服务器。
5. myisamchk：用来描述、检查、优化和维护MyISAM表的实用工具。
6. mysqlbug：MySQL缺陷报告脚本。它可以用来向MySQL邮件系统发送缺陷报告。
7. mysql_install_db：该脚本用默认权限创建MySQL授权表。通常只是在系统上首次安装MySQL时执行一次。

#### MySQL命令行客户端实用工具

1. myisampack：压缩MyISAM表，以产生更小的只读表的一个工具。
2. mysql：交互式输入SQL语句或从文件以批处理模式执行它们的命令行工具。
3. mysqlaccess：检查访问主机名、用户名和数据库组合的权限的脚本。
4. mysqladmin：执行管理操作的客户程序，例如创建或删除数据库、重载授权表、将表刷新到硬盘上以及重新打开日志文件。mysqladmin还可以用来检索版本、进程，以及服务器的状态信息。
5. mysqlbinlog：从二进制日志读取语句的工具。在二进制日志文件中包含执行过的语句，可用来帮助系统从崩溃中恢复。
6. mysqlcheck：检查、修复、分析以及优化表的表维护客户程序。
7. mysqldump：将MySQL数据库转储到一个文件（例如SQL语句或tab分隔符文本文件）的客户程序。
8. mysqlhotcopy：当服务器在运行时，快速备份MyISAM或ISAM表的工具。
9. mysqlimport：使用LOAD DATA INFILE将文本文件导入相关表的客户程序。
10. mysqlshow：显示数据库、表、列以及索引相关信息的客户程序。
11. perror：显示系统或MySQL错误代码含义的工具。



### 14 数据备份与恢复

保证数据安全最重要的一个措施是确保对数据进行定期备份。

#### 14.1 数据备份

##### mysqldump

`mysqldump`将数据库备份成一个文本文件，该文件中实际包含了多个CREATE和INSERT语句，使用这些语句可以重新创建表和插入数据。

基本语法：

```shell
$ mysqldump -u user -h host -p password dbname[tbname, [tbname...]] > filename.sql
```

dbname为需要备份的数据库名称；tbname为dbname数据库中需要备份的数据表，可以指定多个需要备份的表。

###### 1.备份单个数据库中的所有表

```shell
$ mysqldump -u root -p booksdb > booksdb_20210202.sql
```

备份文件中的`SET`语句将一些系统变量值赋给用户定义变量，以确保被恢复的数据库的系统变量和原来备份时的变量相同。

###### 2.备份数据库中的某个表

```shell
$ mysqldump -u root  -p booksDB books > books_20210202.sql
```

###### 3.备份多个数据库

```shell
$ mysqldump -u root -p --databases booksDB test_db > books_testDB_20210202.sql
```

多个数据库名称之间用空格隔开。

`--all-databases`表示备份所有数据库：

```shell
$ mysqldump -u root -p --all-databases > all_20210202.sql
```



##### 直接复制整个数据库目录



#### 14.2 数据恢复

##### 命令恢复

```shell
$ mysql -u user -p [dbname] < filename.sql
```

已登录MySQL服务器，可使用：

```shell
> source filename
```

##### 直接复制数据库文件到数据库目录



#### 14.3 数据库迁移

数据库迁移就是把数据从一个系统移动到另一个系统上。

迁移的原因一般有：

1. 需要安装新的数据库服务器。
2. MySQL版本更新。
3. 数据库管理系统的变更（如从Microsoft SQL Server迁移到MySQL）。



#### 14.4 表的导出和导入



### 15 MySQL日志

MySQL日志主要分为4类：

- **错误日志**：记录MySQL服务的启动、运行或停止MySQL服务时出现的问题。
- **查询日志**：记录建立的客户端连接和执行的语句。
- **二进制日志**：记录所有更改数据的语句，可以用于数据复制。
- **慢查询日志**：记录所有执行时间超过`long_query_time`的所有查询或不使用索引的查询。

启动日志功能会降低一些MySQL数据库的性能。

#### 二进制日志



#### 错误日志



#### 通用查询日志



#### 慢查询日志



#### MySQL8.0的新特性——日志分类更详细

错误信息编号[MY-010311]和错误所属子系统[Server]



### 16 性能优化

MySQL性能优化就是通过合理安排资源，调整系统参数使MySQL运行更快、更节省资源。

MySQL数据库优化是多方面的，原则是**减少系统的瓶颈，减少资源的占用，增加系统的反应速度。**例如，通过优化文件系统，提高磁盘I\O的读写速度；通过优化操作系统调度策略，提高MySQL在高负荷情况下的负载能力；优化表结构、索引、查询语句等使查询响应更快。

```shell
Show Status Like 'value';
```

value是要查询的参数值，一些常用的性能参数：

- Connections：连接MySQL服务器的次数。
- Uptime：MySQL服务器的上线时间。
- Slow_queries：慢查询的次数。
- Com_select：查询操作的次数。
- Com_insert：插入操作的次数。
- Com_update：更新操作的次数。
- Com_delete：删除操作的次数。



#### 优化查询

##### 分析查询语句

```mysql
Explain [Extended] Select select_options
```





#### 优化数据库结构

##### 将字段很多的表分解成多个表



##### 增加中间表



##### 增加冗余字段

合理地加入冗余字段可以提高查询速度。



##### 优化插入记录的速度

插入记录时，影响插入速度的主要是索引、唯一性校验、一次插入记录条数等。

MyISAM引擎的表常见优化方法：

1. 禁用索引
2. 禁用唯一性检查
3. 使用批量插入
4. 使用LOAD DATA INFILE批量导入

InnoDB引擎的表常见的优化方法：

1. 禁用唯一性检查
2. 禁用外键检查
3. 禁止自动提交



##### 分析表、检查表和优化表

分析表主要是分析关键字的分布；检查表主要是检查表中是否存在错误；优化表主要是消除删除或者更新造成的空间浪费。





#### 优化MySQL服务器

##### 优化服务器硬件



##### 优化MySQL的参数

key_buffer_size

table_cache

query_cache_size

sort_buffer_size

read_buffer_size 

read_rnd_buffer_size

innodb_buffer_pool_size

max_connections

innodb_flush_log_at_trx_commit

back_log

interactive_timeout

sort_buffer_size

thread_cache_size

wait_timeout

#### 临时表性能优化



#### 服务器语句超时处理

max_execution_time



#### 创建全局通用表空间

MySQL 8.0支持创建全局通用表空间，全局表空间可以被所有数据库的表共享，而且相比于独享表空间，手动创建共享表空间可以节约元数据方面的内存。可以在创建表的时候指定属于哪个表空间，也可以对已有表进行表空间修改。



### 17 MySQL Replication

MySQL复制是指从一个MySQL主服务器（master）将数据复制到另一台或多台MySQL从服务器（slaves）的过程，将主数据库的DDL和DML操作通过二进制日志传到从服务器上，然后在从服务器上对这些日志重新执行，从而使得主从服务器的数据保持同步。