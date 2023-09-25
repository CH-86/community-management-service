package com.limin.commanser;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//配置扫描mapper
@MapperScan("com.limin.commanser.mapper")
public class CommunityManagementServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityManagementServiceApplication.class, args);
    }

}
