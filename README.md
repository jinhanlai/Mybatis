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
> sqlSessionFactory.openssion()会产生sqlsession对象，参数true会自动提交事务，默认为false；
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
> dataSource 有pooled unpoolled JNDI
> MyBatis在启动时会加载所有的JDBC对应的类型处理器
> 插件允许你在映射语句执行过程中的某一点进行拦截调用 （比如拦截update语句）
> 事务管理器 有jdbc 和MANAGED两个 ；（jdbc支持提交和回滚）
## typeHandlers和ResultMap 结果集映射
### typeHandlers
typeHandlers 类型处理器可以映射字段类型；比如数据库里面是boolean 类型，映射到java的枚举类型
1. 先建立一个枚举类型，实现构造器和get方法
2. 建立一个EnabledTypeHandler类，实现TypeHandler接口
3. 在mybatis配置文件注册
### ResultMap
用来处理数据库中的字段，跟实体类中的属性不一致的问题，
它可以将从数据库结果集中查询到的复杂数据（比如查询到几个表中数据）映射到一个结果集当中。
当涉及多个类的时候很有用。
1. 在mapper.xml文件中写resultMap id为map名，type为对应的实体类
2. result 里面column为数据库查询出的列名，property为实体类中的属性名
> 如果实体类的数据库中的字段一致可以不用写result进行映射。

## 日志
LOG4j、STDOUT_LOGGING 需要掌握
### STDOUT_LOGGING
标准日志功能实现。直接在mybatis设置里面设置就行。
<setting name="logImpl" value="STDOUT_LOGGING"/>
### log4j
log4j：可以输出到控制台和GUI组件。可以控制每一条日志的输出格式；通过定义每一条日志信息的级别，能够更加细致地控制日志的生成过程
可以通过配置文件来配置，不需要修改代码。
1. 导入log4j依赖
2. 写log4j的配置文件
3. 配置log4j为日志的实现
4. 测试log4j
在使用log4j的类中导入log4j的包；
使用Logger.getLogger(class)获取log4j对象 （参数是当前类的class对象）；一般使用static修饰
> static 关键字不依赖于对象存在，可以直接通过类名.static方法访问。
> static修饰静态变量，静态变量被所有对象共享，在内存中只有一个副本
> static 也可以修改代码块，来提高性能，因为只会在类初次加载时才会执行一次
> static 也可以修饰类，但是智能作为内部类存在；被static修饰的内部类可以直接作为一个普通类来使用，而不需实例一个外部类

## 注解
可以直接在Mapper接口上面使用注解来写简单的sql语句，而不需要写mapper配置文件
`@Select("SELECT * FROM blog WHERE id = #{id}")`
### @Param{}注解
基本类型参数或者String类型需要加上
引用类型不需要加
如果只有一个基本类型的话可以省略，但是建议加上
在sql注解中引用的就是@Param{"id"}中的属性名

## 插件
mybatis-generator-core
[mybatis-plus](https://baomidou.com/)

##  参考文档
[官网](https://mybatis.org/mybatis-3/zh/index.html)
[类型处理器参考博客](https://www.cnblogs.com/zwwhnly/p/11238131.html)