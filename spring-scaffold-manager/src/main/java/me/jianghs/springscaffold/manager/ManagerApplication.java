package me.jianghs.springscaffold.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @className: Application
 * @description:
 * @author: jianghs430
 * @createDate: 2020/8/17 15:56
 * @version: 1.0
 */
@SpringBootApplication(scanBasePackages = "me.jianghs.springscaffold")
public class ManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class, args);
    }

}