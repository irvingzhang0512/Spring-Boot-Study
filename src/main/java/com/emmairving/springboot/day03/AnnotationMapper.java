package com.emmairving.springboot.day03;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * Created by irving on 17/1/7.
 */
@Mapper
public interface AnnotationMapper {
    // 普通获取字段
    @Select("SELECT NAME FROM t_table WHERE id = 1")
    String selectName();

    // 将查询结果放入POJO
    // POJO中属性名与数据库表中属性相同
    @Select("SELECT * FROM t_table WHERE id = 1")
    User selectUser();

    // POJO中属性名与数据库表中属性名不相同，通过@Results注释，可以实现resultmap的功能
    @Select("SELECT * FROM t_table WHERE id = 1")
    @Results(value = {
            @Result(id = true, property = "id1", javaType = Integer.class,column = "id", jdbcType = JdbcType.INTEGER),
            @Result(property = "name1", column = "name")
    })
    // 语句中的选项，可以使用@Options来进行配置
    @Options(
        fetchSize = -1,
        useCache = true,
        timeout = -1,
        useGeneratedKeys = false
    )
    User1 selectUser1();

    // 使用变量进行插入时，必须使用@Param进行修饰，就算变量名与数据库列名相同也不行
    @Insert("INSERT INTO t_table(id, name) VALUES(#{id}, #{name})")
    int insertFromValues(@Param("id") int id, @Param("name") String name);
    // 如果POJO中属性名与数据库中相同，可以直接添加
    @Insert("INSERT INTO t_table(id, name) VALUES(#{id}, #{name})")
    int insertFromUserPojo(User user);

}
