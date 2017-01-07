# 配置MyBatis

## 0. 参考资料
+ [mybatis-spring-boot-documents](http://www.mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/index.html#)
+ [mybatis-documents](http://www.mybatis.org/mybatis-3/index.html)
+ [mybatis-spring-document](http://www.mybatis.org/spring/mappers.html#scan)
+ [mybatis-spring-boot-starter-codes(including examples)](https://github.com/mybatis/spring-boot-starter)

## 1. 使用xml配置MyBatis

个人比较常用这种方式，因为xml文件中可以对sql语句进行个性化配置，而且很清楚。
具体需要配置如下：

+ spring-boot提供的一些参数，在application.properties中。
+ mybatis配置可以在application.properties中的spring.configuration.*中进行设置
+ 添加mapper接口，并进行@Mapper注释
+ xml文件（包括动态sql的xml文件）都需要放在resources文件夹中

## 2. 使用注释配置MyBatis

如果sql语句比较简单，那用注释的方式也很好。
注释配置的前三步与xml一致

+ spring-boot提供的一些参数，在application.properties中。
+ mybatis配置可以在application.properties中的spring.configuration.*中进行设置
+ 添加mapper接口，并进行@Mapper注释
+ 在mapper接口文件中，对方法进行注释

## 3. 举例

### 3.1. 在application.properties中进行配置
```properties
# 只对必要的进行配置，其他配置可以查资料自行处理
spring.datasource.url=jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false
spring.datasource.username=test
spring.datasource.password=123456
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
```

### 3.2. Mapper接口
```java
@Mapper
public interface XmlMapper {
    User selectXml(int id);

    @Insert("INSERT INTO t_table(id, name) VALUES(#{id}, #{name})")
    int insertAnnotation(User user);
}

```

### 3.3. POJO
```java
public class User {
    private Integer id;
    private String name;
// 省略getter, setter,
}
```

### 3.4. xml文件
```xml
<!-- 该文件放在resources中 -->
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.emmairving.springboot.day03.XmlMapper">
    <select id="selectXml" resultType="com.emmairving.springboot.day03.User">
        select * from t_table where id = #{id}
    </select>
</mapper>
```

### 3.5. 进行单元测试
```java
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
public class MyBatisTest {
    @Autowired
    private XmlMapper xmlMapper;

    @Test
    public void test() {
        System.out.println(xmlMapper.insertAnnotation(user));
        System.out.println(xmlMapper.selectXml(1));
    }
}
```