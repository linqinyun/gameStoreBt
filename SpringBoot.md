# 项目整合与部署存在的问题

## SSM手动整合存在的问题

1. 步骤多，配置繁琐
   1. 创建Maven项目
   2. 部署Mybatis：添加依赖、创建配置文件
   3. 部署Spring、SpringMVC：添加依赖、创建配置文件
   4. 添加整合依赖
   5. 整合配置
2. 项目进行服务器部署步骤繁琐、需要手动完成

### 如何简化繁琐配置和部署步骤

- SpringBoot是一个可以简化整合中复杂配置的框架
  
## SpringBoot简介

### 概念

- 随着动态语言的流行，Java语言的开发就显得格外笨重，配置繁琐、开发效率低、项目的部署变得复杂、集成第三方难度大。。。

### 优点

### 缺点

- 由于配置都是内置的，报错时定位比较困难
- 版本迭代速度比较快、有些版本改动比较大

## SpringBoot原理

### SpringBoot starter

一个starter就是一个开发场景的支持（依赖+配置）  
SpringBoot为我们提供了简化企业级开发绝大多数场景的支持（提供了多个starter），我们进行项目开发的过程中只需引入对应的starter，相应的依赖和配置就回被内置到项目中（消除人工配置）

- Spring Web --- spring-boot-starter-web
- 。。。
- starter依赖，一个starter依赖表示某种开发环境所需的一组依赖
- starter = 依赖 + 配置
- start配置
  - 不仅包含所需依赖，还包含了其所需的对应配置

### pom

1. 基于Spring官方创建的SpringBoot应用
2. 基于aliyun服务器创建应用

### Java配置方式

如果我们需要在SpringBoot应用中整合一种新的开发场景，只需在pom.xml引入对应的starter即可  
一个starter不仅包含依赖，还包含相应的配置，starter中包含的配置都是通过Java类实现的--Java配置方式

### Spring版本发展

随着Spring版本的迭代，配置方式也在发生变化

- xml配置
  - applicationContext.xml配置
- 注解配置
- Java配置

### SpringBoot自动配置过程

1. 运行SpringBoot应用的启动类
   1. @SpringBootApplication
      1. @SpringBoootConfiguration 继承@Configuration，表示启动类也可以作为一个配置类使用
      2. EnableAutoConfiguration 启动SpringBoot内置的自动配置功能
      3. CommponentScan 扫描bean，扫描范围为当前应用启动类所在的包
2. SpringApplication的run方法
   1. getSpringFactoriesInstances
3. SpringFacoriesloader -- loadFacoryBanes
   1. 加载spring.factories文件（starter依赖中通常会存在这个文件）
   2. 扫描所有依赖中的META-INF目录中的spring.factories文件
   3. 当获取所有自动配置类路径之后，就会依次扫描并加载这些自动配置
   4. 依次判断是否满足自动配置类的初始化条件，如果不满足则跳过，如果满足则进行初始化

### SpringBoot全局配置文件

>SpringBoot针对不同的开发场景提供默认的属性配置，如果默认的配置不能满足开发的需要，我们需要对属性进行修改

- SpringBoot应用提供给了一个全局配置文件，application.properties用于进行自定义配置
- 某些starter的自动配置类需要相关的属性配置，但是SpringBoot提供了默认配置时无需进行手动配置
- 全局配置文件支持两种语法配置：
  - properties键值对配置
  - yaml语法的配置
