

**代码开发文档**(内含详细开发过程):

[开发文档MD版](https://github.com/muyinchen/migo-security/blob/master/doc/%E8%BD%BB%E9%87%8F%E7%BA%A7%E6%9D%83%E9%99%90%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F.md)

[开发文档PDF版](https://github.com/muyinchen/migo-security/blob/master/doc/%E8%BD%BB%E9%87%8F%E7%BA%A7%E6%9D%83%E9%99%90%E7%AE%A1%E7%90%86%E7%B3%BB%E7%BB%9F.pdf)

**项目说明**

- migo-security是一个轻量级权限管理系统，其核心设计目标是开发迅速、学习简单、轻量级、易扩展
- 使用migo-security搭建项目，只需编写30%左右代码，其余的代码交给系统自动生成
- 部分代码使用Java8 Stream lambda 风格开发，已提供老式风格代码，可对比学习

<br>

**具有如下特点**

- 轻量级的权限系统，只涉及Spring、Shiro、Mybatis后端框架，降低学习使用成本
- 友好的代码结构及注释，便于阅读及二次开发
- 支持HTML、JSP、Velocity、Freemarker等视图，零技术门槛
- 灵活的权限控制，可控制到页面或按钮，满足绝大部分的权限需求
- 页面交互使用Vue2.x，极大的提高了开发效率
- 完善的代码生成机制，可在线生成entity、xml、dao、service、html、js、sql代码，减少70%以上的开发任务
- 引入quartz定时任务，可动态完成任务的添加、修改、删除、暂停、恢复及日志查看等功能
- 引入API模板，根据token作为登录令牌，极大的方便了APP接口开发
- 引入Hibernate Validator校验框架，轻松实现后端校验
- 引入云存储服务，已支持：七牛云、阿里云、腾讯云等
- 引入路由机制，刷新页面会停留在当前页

**项目结构**

```
migo-security
├─doc  项目开发过程文档
├─sql  项目SQL语句
├─migo-common 公共模块
│  ├─annotation 公共注解
│  ├─oss 云存储服务
│  ├─validator 后台校验
│  └─db.properties 数据库配置文件
│ 
├─migo-api API模块（接口开发）
│ 
├─migo-gen 代码生成器模块
│  ├─template 代码生成器模板（可增加或修改相应模板）
│  └─generator.properties 配置文件（配置包名、类型转换等）
│ 
├─migo-schedule 定时任务模块
│
├─migo-shiro 权限模块
│  
├──migo-web 管理后台模块
│  ├─js 系统业务js代码
│  ├─statics 第三方库、插件等静态资源
│  ├─index.html AdminLTE主题风格（默认主题）
│  └─index1.html Layui主题风格


```



**效果展示：** 

![](http://og0sybnix.bkt.clouddn.com/sp170410_182815.png)

![](http://og0sybnix.bkt.clouddn.com/sp170410_182916.png)



![](http://og0sybnix.bkt.clouddn.com/sp170410_182930.png)

![](http://og0sybnix.bkt.clouddn.com/sp170410_182807.png)



![](http://og0sybnix.bkt.clouddn.com/sp170410_182827.png)

![](http://og0sybnix.bkt.clouddn.com/sp170410_182848.png)

![](http://og0sybnix.bkt.clouddn.com/sp170410_182747.png)

![](http://og0sybnix.bkt.clouddn.com/sp170410_192009.png)

**技术选型：**

- 核心框架：Spring Framework 4.3
- 安全框架：Apache Shiro 1.3
- 视图框架：Spring MVC 4.3
- 持久层框架：MyBatis 3.3
- 定时器：Quartz 2.2
- 数据库连接池：Druid 1.0
- 日志管理：SLF4J 1.7、Log4j
- 页面交互：Vue2.x

**软件需求**

- JDK1.8+
- MySQL5.5+
- Tomcat7.0+
- Maven3.0+

**本地部署**

- 通过git下载源码
- 创建数据库migo-security，数据库编码为UTF-8
- 执行sql/migo-security.sql文件，初始化数据【按需导入表结构及数据】
- 修改migo-security.properties文件，更新MySQL账号和密码
- Eclipse、IDEA执行【clean package tomcat7:run】命令，即可运行项目
- 项目访问路径：[http://localhost:8080/](http://localhost:8080/)
- 账号密码：admin/admin