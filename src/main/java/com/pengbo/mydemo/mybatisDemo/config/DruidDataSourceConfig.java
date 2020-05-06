package com.pengbo.mydemo.mybatisDemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

//@Component
public class DruidDataSourceConfig {


    //@Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //sqlSessionFactoryBean.setTransactionFactory();
        return sqlSessionFactoryBean;
    }

    //@Bean
    //@ConfigurationProperties(prefix = "druid")
    public DataSource dataSource() {
        return new DruidDataSource();
    }

/*    @Bean
    public Properties properties() throws Exception {
        Properties properties = new Properties();
        File file = ResourceUtils.getFile("classpath:db/druid.properties");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        properties.load(bufferedReader);
        return properties;
    }*/
}
    