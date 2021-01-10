[Apache HTTP 服务器 2.4 文档](http://httpd.apache.org/docs/2.4/zh-cn/)

[Apache HTTP 服务器 2.4 中文文档](https://www.docs4dev.com/docs/zh/apache/2.4/reference/)



## 发行说明



## 参考手册

### 编译安装

仅涵盖类 Unix系统。

Apache httpd 使用`libtool`和`autoconf`。

#### 不耐烦的概述

在 Fedora/CentOS/Red Hat Enterprise Linux 上安装：

```shell
sudo yum install httpd
sudo systemctl enable httpd		// 开机启动
sudo systemctl start httpd
```

在 Ubuntu/Debian 上安装：

```shell
sudo apt install apache2
sudo service apache2 start
```

源码安装：

下载 [http://httpd.apache.org/download.cgi](http://httpd.apache.org/download.cgi#apache24)

```shell
# Extract，NN必须替换为当前版本号
$ gzip -d httpd-NN.tar.gz 
$ tar xvf httpd-NN.tar 
$ cd httpd-NN

# Configure，PREFIX替换要安装的文件路径，未指定默认位/usr/local/apache2
$ ./configure --prefix=PREFIX

# Compile	
$ make

# Install	
$ make install

# Customize	
$ vi PREFIX/conf/httpd.conf

# Test	
$ PREFIX/bin/apachectl -k start
```



## 用户指南





## 操作方法与教程





## 特定平台说明