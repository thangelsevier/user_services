package com.thangdtran.user_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServicesApplication.class, args);
    }
}
