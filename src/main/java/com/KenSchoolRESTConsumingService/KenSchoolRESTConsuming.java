package com.KenSchoolRESTConsumingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.KenSchoolRESTConsumingService.Proxy")
public class KenSchoolRESTConsuming {
    public static void main(String[] args) {
        SpringApplication.run(KenSchoolRESTConsuming.class, args);
    }

}
