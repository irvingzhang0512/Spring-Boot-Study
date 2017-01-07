package com.emmairving.springboot.day03;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by irving on 17/1/8.
 */
@Mapper
public interface XmlMapper {
    User selectXml(int id);

    @Insert("INSERT INTO t_table(id, name) VALUES(#{id}, #{name})")
    int insertAnnotation(User user);
}
