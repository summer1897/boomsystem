package com.boom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by Intellij IDEA
 *
 * @Author susmmer
 * @Date 2017/12/8 上午12:10
 * @Description main startup class
 */
@SpringBootApplication
@MapperScan("com.boom.**.mapper")
//@ComponentScan("com.boom.rbac.controller")
public class App {
    //extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }

    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }*/

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("http://localhost:9000");
            }
        };
    }
}
