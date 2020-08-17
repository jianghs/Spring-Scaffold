package me.jianghs.springscaffoldservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author jianghs430
 */
@SpringBootApplication
@ComponentScan(basePackages = "me.jianghs")
public class SpringScaffoldServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringScaffoldServiceApplication.class, args);
    }

}
