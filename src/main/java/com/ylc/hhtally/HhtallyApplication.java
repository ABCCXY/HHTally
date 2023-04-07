package com.ylc.hhtally;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.ylc.hhtally.mapper")
@SpringBootApplication
public class HhtallyApplication {
    public static void main(String[] args) {
        SpringApplication.run(HhtallyApplication.class, args);
    }
}
