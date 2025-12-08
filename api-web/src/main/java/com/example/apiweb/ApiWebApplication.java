
package com.example.apiweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example"})
public class ApiWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiWebApplication.class, args);
    }
}
