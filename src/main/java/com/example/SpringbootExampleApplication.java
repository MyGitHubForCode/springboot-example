package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan(value = "com.example.*.*")
public class SpringbootExampleApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootExampleApplication.class, args);
        System.out.println(

                "ヾ(◍°∇°◍)ﾉﾞ    bootdo启动成功      ヾ(◍°∇°◍)ﾉﾞ\n" +
                        " ______                    _   ______            \n" +
                        "|_   _ \\                  / |_|_   _ `.          \n" +
                        "  | |_) |   .--.    .--. `| |-' | | `. \\  .--.   \n" +
                        "  |  __'. / .'`\\ \\/ .'`\\ \\| |   | |  | |/ .'`\\ \\ \n" +
                        " _| |__) || \\__. || \\__. || |, _| |_.' /| \\__. | \n" +
                        "|_______/  '.__.'  '.__.' \\__/|______.'  '.__.'  "
        );
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(SpringbootExampleApplication.class);
    }
}
