package com.mardoner.mall.admin;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication()
@MapperScan(basePackages = {"com.mardoner.mall.admin.mapper.*"})
@EnableTransactionManagement
public class MallAdminApp {

    public static void main(String[] args) {
        SpringApplication.run(MallAdminApp.class, args);
    }

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
