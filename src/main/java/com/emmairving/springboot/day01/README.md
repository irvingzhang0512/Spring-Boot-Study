# 第一篇 使用Intellij IDEA社区版构建SpringBoot项目

## 1. 背景
+ 为什么选择选择Intellij IDEA：之前一直都使用Eclipse，但总感觉运行速度太慢。听说Intellij IDEA不错，就想尝试一下。
+ Intellij IDEA付费版的买不起（等工作了再买），另外本人一直都是正版支持者，能用正版的时候都不用盗版，所以就先熟悉下社区版。
+ 付费版的尝试使用过，创建Spring Boot项目非常便捷，但也把自己弄的云里雾里的，刚好趁现在这个机会，熟悉一下通过maven创建Spring Boot项目的过程，可以更好理解Spring Boot。

## 2. 最简单的Spring Boot项目创建过程
+ 在pom文件中添加parent。
+ 为了实现web功能，添加spring-boot-starter-web依赖；为了能够打包，添加spring-boot-maven-plugin插件。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.emmairving</groupId>
    <artifactId>springboot</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <spring.boot.starter.version>1.4.2.RELEASE</spring.boot.starter.version>
    </properties>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <!-- 不能在这里使用${spring.boot.starter.version}，原因不明，可能是xml加载顺序的原因？ -->
        <version>1.4.2.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>${spring.boot.starter.version}</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <!-- 该插件用于打包 -->
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <version>${spring.boot.starter.version}</version>
            </plugin>
        </plugins>
    </build>

</project>
```

+ 构建项目入口程序。


```java
@SpringBootApplication
@RestController
public class Bootstrap {
    // mvn spring-boot:run 执行
    // mvn package 打包

    // 一个项目中main函数只能有一个，否则会报错
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
```

+ 用shell进入项目目录下，运行mvn spring-boot:run，进入网页localhost:8080，看到Hello World。

## 3. 其他事项
+ 版本选择问题：最新版本为1.4.3.RELEASE，但下载不了spring-boot-starter-parent包，所以选用1.4.2.RELEASE版本。
+ 如果项目中有多个main函数，在运行时报错。
+ 在parent中不能使用properties中定义的参数。原因不明，猜测跟加载顺序有关。


## 4. 资料来源
spring-boot官方文档第11章