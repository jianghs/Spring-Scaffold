package me.jianghs.springscaffold.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jianghs430
 */
@SpringBootApplication(scanBasePackages = "me.jianghs.springscaffold")
public class SpringScaffoldServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringScaffoldServiceApplication.class, args);
    }

}
