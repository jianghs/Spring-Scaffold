package me.jianghs.springscaffold.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jianghs430
 */
@SpringBootApplication(scanBasePackages = "me.jianghs.springscaffold")
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

}
