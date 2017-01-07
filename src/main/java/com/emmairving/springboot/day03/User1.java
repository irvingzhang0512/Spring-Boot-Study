package com.emmairving.springboot.day03;

/**
 * Created by irving on 17/1/7.
 */
public class User1 {
    private Integer id1;
    private String name1;

    @Override
    public String toString() {
        return "User1{" +
                "id1=" + id1 +
                ", name1='" + name1 + '\'' +
                '}';
    }

    public Integer getId1() {
        return id1;
    }

    public void setId1(Integer id1) {
        this.id1 = id1;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }
}
