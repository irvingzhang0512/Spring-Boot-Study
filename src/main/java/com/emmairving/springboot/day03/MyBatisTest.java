package com.emmairving.springboot.day03;

import com.emmairving.springboot.Bootstrap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by irving on 17/1/7.
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Bootstrap.class)
public class MyBatisTest {
    @Autowired
    private AnnotationMapper annotationMapper;

    @Autowired
    private XmlMapper xmlMapper;

    @Test
    public void test() {
//        System.out.println(annotationMapper.selectName());
//        System.out.println(annotationMapper.selectUser());
//        System.out.println(annotationMapper.selectUser1());
//        System.out.println(annotationMapper.insertFromValues(666,"emma"));
        User user = new User();
        user.setId(11);
        user.setName("daves");
//        System.out.println(annotationMapper.insertFromUserPojo(user));
//        System.out.println(new SqlBuilder().insert());
//        System.out.println(new SqlBuilder().update());
        System.out.println(xmlMapper.insertAnnotation(user));
        System.out.println(xmlMapper.selectXml(1));
    }
}
