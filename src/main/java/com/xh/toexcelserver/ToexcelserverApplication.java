package com.xh.toexcelserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ToexcelserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToexcelserverApplication.class, args);
    }

}

//@SpringBootApplication
//public class ToexcelserverApplication extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(ToexcelserverApplication.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(ToexcelserverApplication.class, args);
//        System.out.println("toexcel 项目启动");
//    }
//}
