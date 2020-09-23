## 常用依赖

```xml
<dependency>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.6.RELEASE</version>
</dependency>
```

## 注解使用

1. 导入约束(context约束)

   

2. 配置注解的支持(context:annotation-config)

  ```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
    <context:annotation-config/>
</beans>
  ```

- `@Component`注解就相当于定义了一个Bean，它有一个可选的名称，默认是小写开头的类名。

- `@Autowired`就相当于把指定类型的Bean注入到指定的字段中。

- `@Configuration`，表示它是一个配置类，因为我们创建`ApplicationContext`时：

  ```
  ApplicationContext context = new AnnotationConfigApplicationContext(****.class);
  ```

  使用的实现类是`AnnotationConfigApplicationContext`，必须传入一个标注了`@Configuration`的类名。

- `@ComponentScan`，它告诉容器，自动搜索当前类所在的包以及子包，把所有标注为`@Component`的Bean自动创建出来，并根据`@Autowired`进行装配。

- `@Scope`原型注入，每次调用`getBean(Class)`，容器都返回一个新的实例。

- `@Order`注解用来排序，用法：@Order(1)

  

3. 初始化与销毁

- 依赖：

```
<dependency>
    <groupId>javax.annotation</groupId>
    <artifactId>javax.annotation-api</artifactId>
    <version>1.3.2</version>
</dependency>
```

在Bean的初始化和清理方法上标记`@PostConstruct`（初始化）和`@PreDestroy`（销毁）



4. 使用别名

   - 用`@Bean("name")`指定别名，也可以用`@Bean`+`@Qualifier("name")`指定别名。

   - 还有一种方法是把其中某个Bean指定为`@Primary`，作为主bean。

   

5. 读取文件

   - Spring提供了一个`org.springframework.core.io.Resource`，可通过 @Value(）来指定文件地址

   

6. 导入配置文件

   - 在`@Configuration`配置类上再添加一个注解`@PropertySource("app.properties")` 表示读取classpath的app.properties，使用时直接通过value注入。

     ```
     @Value("${app.zone:Z}")
         String zoneId;
     ```

     表示读取key为`app.zone`的value，但如果key不存在，就使用默认值`Z`。

   - 另一种注入配置的方式是先通过一个简单的JavaBean持有所有的配置，然后，在需要读取的地方，使用   `@value("#{smtpConfig.host}")`获取smtpConfig中的host属性并注入。