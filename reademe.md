# Mybatis
## 前提要求
mysql 5.7
maven 3.7
## 步骤
1. 导入maven依赖
2. 导入mybatis配置文件，并设置mysql连接驱动（mysql 8 需要修改时区）
3. 新建工具类 ，获取SqlSessionFactory 工厂
4. 写sqlmapper类 （注意要在配置文件中注册mapper.xml），注意也可以使用注解的方式来配置
> SqlSessionFactoryBuilder 工厂方法用来创建SqlSessionFactory，一旦创建就不需要它了。
> SqlSessionFactory使用的是单例模式（用静态类的创建方式）一旦创建就一直存在
> SqlSession：每个线程都有自己的SqlSession，但是他是线程不安全的，不能被共享，最佳是放在方法域里面，绝对不能将SqlSession实例的引用放在一个类的静态域。
> SqlSession使用完必须关闭。
## 配置解析
### 核心配置文件
mybatis-config.xml
1. configuration（配置）
2. properties（属性）
3. settings（设置）
4. typeAliases（类型别名）
5. typeHandlers（类型处理器）
6. objectFactory（对象工厂）
7. plugins（插件）
8. environments（环境配置）
    environment（环境变量）
        transactionManager（事务管理器）
        dataSource（数据源）
9. databaseIdProvider（数据库厂商标识）
10. mappers（映射器）(负责注册绑定的mapper)
> mybatis可以倒入外部配置文件.properties(有冲突优先使用外部配置)
> 事务管理器 有jdbc 和MANAGED两个
> dataSource 有pooled unpoolled JNDI
## ResultMap 结果集映射
用来处理数据库中的字段，跟实体类中的属性不一致的问题
当涉及多个类的时候很有用。
## 插件
mybatis-generator-core
[mybatis-plus](https://baomidou.com/)

##  参考文档
[官网](https://mybatis.org/mybatis-3/zh/index.html)