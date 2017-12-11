package com.boom;

import com.boom.utils.RandomIdGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.session.mgt.eis.RandomSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;
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
//        System.out.println("uuid: " + RandomIdGenerator.geneateUUID()) ;
//        System.out.println("random id: " + RandomIdGenerator.generateRandomId()) ;
        SpringApplication.run(App.class,args);
    }
}
