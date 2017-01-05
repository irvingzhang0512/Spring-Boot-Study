# 配置SpringFox

## 1. 参考资料
+ [SpringFox官网](http://springfox.github.io/springfox/)
+ [SpringFox文档](http://springfox.github.io/springfox/docs/current/)
+ [SpringFox API](http://springfox.github.io/springfox/javadoc/current/)
+ [SpringFox注解的一些简介](https://my.oschina.net/zzuqiang/blog/793606)
+ [SpringFox注解的官方介绍](https://github.com/swagger-api/swagger-core/wiki/Annotations#apioperation)

## 2.搭建
+ 添加maven依赖
```xml
        <!-- day02中使用到的springfox -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
            <version>${springfox.version}</version>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
            <version>${springfox.version}</version>
        </dependency>
```

+ 添加SpringFox的配置文件

```java
/**
 * Created by irving on 17/1/5.
 */
// SpringFox的配置文件
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket customDocket(){
        Contact contact = new Contact("irving","","irvingzhang0512@gmail.com");
        ApiInfo apiInfo = new ApiInfo(
                "Spring-Boot-Study", //项目标题
                "自学SpringBoot", //项目描述
                "1.0.0", //版本
                null, //应用url
                contact, //作者名称, 网页, 联系方式
                null, //许可
                null); //许可url
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo);
    }
}
```

+ 在Controller中添加相应的注解

```java

@RestController
@RequestMapping("/api/springfox")
@Api(
//        consumes = "application/json", //请求的内容类型，修改了之后ui上没有显示
//        produces = "application/json", //返回的内容类型，修改了之后ui上没有显示
//        position = 1, //如果配置多个Api 想改变显示的顺序位置
//        protocols = "http", //显然字面意思是所用的协议，如http, https, 但不知道有什么用
//        authorizations = , //高级认证使用，还没遇到过
        hidden = false,//是否隐藏
//        tags = "mytags", // 可以覆盖test-controller这个字符串
//        value = "测试springfox",
//        basePath = "", //基本路径，不知道干什么用的
        description = "简介" //该Controller的简介
)
public class TestController {
    @RequestMapping("hello")
    @ApiOperation(value = "ApiOperation value() hello", //下拉框左侧小标题，必须填写
//            nickname = "ApiOperation nickname() hello", //
            produces = "application/json", //返回类型，会在ui中显示
            consumes = "application/json", //发送类型，如果接口有参数，会在ui中显示
//            code = 202,// 还没看出来有什么用
            httpMethod = "POST", //对应的HTTP方法，大写字符串，好像不能选多个, "GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS", "PATCH"
            notes = "接口简介", //接口简介
            response = ResultType.class, // 显示返回json的类型
//            tags = "tags", //如果设置了，会新生成一个controller显示该接口，；原有controller中还保留有该接口。
//            tags = {"tags1", "tags2"}, // tags可以有多个
            hidden = false, // 可以设置隐藏
//            protocols = "http", //设置协议，没发现作用
//            responseContainer = "List", //"List", "Set" or "Map"
//            responseReference = "",//没发现作用
            position = 0)
    public Object hello(
            @ApiParam(
                    value = "values", // 对参数的描述
                    hidden = false,
//                    access = "access", // 没搞清楚干什么用的
                    allowableValues = "range[1,5]", // 可取值范围
//                    allowMultiple = true, // 是否允许多个值
//                    defaultValue = "123", // 默认值，没有发现作用
//                    example = "123", // 举例，没有发现作用
                    name = "ages", //参数名，不要有修改
                    required = true //是否必须
            )Integer age
    ) {
        return "hello test";
    }

    @RequestMapping("bye")
    @ApiOperation(value="", httpMethod = "GET")
    @ApiResponse(
            code = 401,
            message = "401 messages",
//            reference = "",
            response = ResultType.class,
            responseContainer = "List"
//            responseHeaders = ""
    )
    public Object bye() {
        return "bye test";
    }
}
```

+ 通过 http://localhost:8080/swagger-ui.html 进行查看

## 3. SpringFox常用注解

### 3.1. @Api
+ hidden：是否隐藏
+ description：Controller简介
+ tags：标签

### 3.2. @ApiOperation
+ produces：相应类型
+ consumes：发送类型
+ httpMethod：http方法
+ notes：简介
+ response：返回类型格式
+ tags：标签
+ hidden：是否隐藏

### 3.3. @ApiParam
+ name：变量名
+ value：变量介绍
+ required：是否必须
+ hidden：是否隐藏