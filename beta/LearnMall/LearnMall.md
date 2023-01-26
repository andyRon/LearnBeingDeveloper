学习开源项目mall
----



idea打开新项目时，先等待依赖下载，

> 此时，在项目录外会有一个，`mall.iml`的文件，依赖加载完，项目准备好后，这个文件消失？

建立对应项目所需的数据库，用idea连接到数据库，修改成自己数据库name、password



```json
{
  "username": "admin",
  "password": "macro123"
}
```

返回token：

```json
{
  "code": 200,
  "message": "操作成功",
  "data": {
    "tokenHead": "Bearer ",
    "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE2NTg4MjQ5NjQ5MjksImV4cCI6MTY1OTQyOTc2NH0.xz3lpQxdZB6AhWhgrz-om7TluCleIvqIbIE3xNGw_Cw-bo0q5pUjdSPTXm6MIzDRG3avPy8cCoKJsCyaIqEXCg"
  }
}
```



再在之后的请求头中加上Authorization字段：

```json
{
    "Content-Type": "application/x-www-form-urlencoded",
    "Authorization": "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImNyZWF0ZWQiOjE2NTg4MjQ5NjQ5MjksImV4cCI6MTY1OTQyOTc2NH0.xz3lpQxdZB6AhWhgrz-om7TluCleIvqIbIE3xNGw_Cw-bo0q5pUjdSPTXm6MIzDRG3avPy8cCoKJsCyaIqEXCg"
}
```



http://localhost:8080/swagger-ui



Swagger的访问  登录

前端项目的启动



