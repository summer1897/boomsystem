package com.boom.rbac.main;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by Intellij IDEA
 *
 * @Author summer
 * @Date 2017/12/8 上午12:10
 * @Description
 */
@SpringBootApplication
@MapperScan("com.boom.rbac.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
