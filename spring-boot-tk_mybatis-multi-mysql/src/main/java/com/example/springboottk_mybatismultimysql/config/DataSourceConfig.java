package com.example.springboottk_mybatismultimysql.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.springboottk_mybatismultimysql.dao.firstdao",
        sqlSessionTemplateRef = "FirstSqlSessionTemplate")
public class DataSourceConfig {

    @Bean(name = "dataSource")
    @Primary
    @Qualifier("dataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        return dataSource;
//        return DataSourceBuilder.create().build();
    }


    @Bean(name = "FirstSqlSessionFactory")
    @Primary
    public SqlSessionFactory FirstSqlSessionFactory(@Qualifier("dataSource") DataSource datasource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(datasource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));// 设置mybatis的xml所在位置
        return bean.getObject();
    }


    @Bean("FirstSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate FirstSqlSessionTemplate(@Qualifier("FirstSqlSessionFactory") SqlSessionFactory sessionfactory) {
        return new SqlSessionTemplate(sessionfactory);
    }

}
