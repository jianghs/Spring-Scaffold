package me.jianghs.springscaffold.common;

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
public class CommonApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonApplication.class, args);
    }

}