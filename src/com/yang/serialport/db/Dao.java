package com.yang.serialport.db;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.Date;

/**
 * Created by Yingjie.Lu on 2018/12/19.
 */
public class Dao {

    DriverManagerDataSource dataSource=null;
    JdbcTemplate jdbcTemplate=null;

    public Dao() {
        // JDBC模板依赖于连接池来获得数据的连接，所以必须先要构造连接池
        dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.jdbc.Driver");//连接mysql
        dataSource.setUrl("jdbc:mysql://localhost:3306/bishe");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");

        // 创建JDBC模板
        jdbcTemplate= new JdbcTemplate(dataSource);

    }

    //插入数据
    public void insertData(float data, Date time){
        jdbcTemplate.update("INSERT INTO distance (data,time) VALUES(?,?)", new Object[] {data, time});
    }

    public static void main(String[] args) {
        new Dao().insertData((float) 0.0123,new Date());
    }

}
