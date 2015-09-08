package com.wangyi.website;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.wangyi.website"})
public class ApplicationInitializer extends
        SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ApplicationInitializer.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationInitializer.class,
                args);
    }

}
