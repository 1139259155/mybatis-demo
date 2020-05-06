package com.pengbo.mydemo.mybatisDemo.main;

import com.fasterxml.jackson.databind.ser.std.CollectionSerializer;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.pengbo.mydemo.mybatisDemo.service.inf.IUserService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

@Configuration
@ComponentScan("com.pengbo.mydemo.mybatisDemo")
@MapperScan("com.pengbo.mydemo.mybatisDemo.mapper")
public class App {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(com.pengbo.mydemo.mybatisDemo.main.App.class);
        IUserService userService = context.getBean(IUserService.class);
        userService.queryUserById("1");
        userService.queryUserByName("21");

    }

    @Bean
    @Autowired
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }

    /**
     * hsql db  -- apache dbcp datasource
     *
     * @return
     */
    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:hsqldb:mem:public:test_db");
        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
//        dataSource.setConnectionInitSqls(
//                Arrays.asList(
//                        "create table user1(id varchar(36), name varchar(36))",
//                        "insert into user1 values('1','张三')",
//                        "insert into user1 values('2','李四')"));
        return dataSource;
    }

    /**
     * hsql db  -- c3p0 datasource
     *
     * @return
     */
//    @Bean
//    public DataSource dataSource() throws Exception{
//        ComboPooledDataSource dataSource = new ComboPooledDataSource();
//        dataSource.setJdbcUrl("jdbc:hsqldb:mem:test_db");
//        dataSource.setDriverClass("org.hsqldb.jdbcDriver");
//        dataSource.setUser("root");
//        dataSource.setPassword("");
//        return dataSource;
//    }


    /**
     * h2 db  -- DriverManagerDataSource
     * @return
     */
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:h2:mem:TEST_DB;DB_CLOSE_DELAY=-1;MODE=Mysql");
//        dataSource.setDriverClassName("org.h2.Driver");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        return dataSource;
//    }


    /**
     * hsql db  --  DriverManagerDataSource
     * @return
     */
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl("jdbc:hsqldb:mem:test_db");
//        dataSource.setDriverClassName("org.hsqldb.jdbcDriver");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        dataSource
//        return dataSource;
//    }
}
    