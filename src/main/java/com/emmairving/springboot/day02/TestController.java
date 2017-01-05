package com.emmairving.springboot.day02;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by irving on 17/1/5.
 */

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
