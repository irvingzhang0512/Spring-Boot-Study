package com.emmairving.springboot.day02;

/**
 * Created by irving on 17/1/5.
 */
public class ResultType {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer id;
    private String name;
    private Integer age;

}
