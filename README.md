# gameStore
游戏商城，J2EE开发

## alpha.0.1开发计划目标

1. 商城首页、商城商品管理
2. 后台管理
3. 登录

- 前端使用REST
- 后端使用MVC传统模板渲染
- 使用Maven构建

## 数据库

#### 数据库表

- 物品表
- 分类表
- 管理员表

### 流程

1. 设计
2. 数据库
3. 目录结构
4. maven项目配置pom，加载jar包
5. 实体类
6. 自下而上配置
   1. 数据库jdbc配置
   2. mybatis-config配置
   3. spring配置
      1. spring-dao配置
      2. spring-service配置
      3. spring-web配置
   4. web.xml整合配置、spring配置
7. 测试
   1. 测试配置
   2. 测试结构
8. 日志文件-logback
   1. logback.xml配置
   2. 配置在controller、service层中使用

#### 记录

1. 配置文件/目录结构
2. 编写数据库
3. 编写实体类
