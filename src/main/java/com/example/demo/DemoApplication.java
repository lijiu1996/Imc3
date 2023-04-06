package com.example.demo;

import com.example.demo.init.SnmpInit;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.conf","com.example.demo.protocol",
        "com.example.demo.entity","com.example.demo.service","com.example.demo.init","com.example.demo.config",
        "com.example.demo.controller"
})
@MapperScan({"com.example.demo.mapper"})
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.addListeners(new SnmpInit());
//        SpringApplication.run(DemoApplication.class, args);
        springApplication.run();
    }

}
