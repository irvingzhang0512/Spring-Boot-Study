package com.emmairving.springboot.day03;

import org.apache.ibatis.jdbc.SQL;

/**
 * Created by irving on 17/1/7.
 */
public class SqlBuilder {
    public String insert() {
        return new SQL(){{
            INSERT_INTO("t_table");
            VALUES("id","11");
            VALUES("name","emmmmma");
        }}.toString();
    }

    public String update() {
        return new SQL() {{
            UPDATE("t_table");
            SET("id=1");
            SET("name=\"name\"");
            WHERE("id=1");
            WHERE("name=\"name\"");
            OR();
            WHERE("id=1");
            WHERE("name=\"name\"");

        }}.toString();
    }
}
