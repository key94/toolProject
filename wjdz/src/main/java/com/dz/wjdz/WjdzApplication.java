package com.dz.wjdz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WjdzApplication {

    public static void main(String[] args) {
        SpringApplication.run(WjdzApplication.class, args);
        System.err.println("WjdzApplication启动完毕...");
    }

}
