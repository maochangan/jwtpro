package net.magicreal.module;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author
 * spring boot application start class
 */
@ComponentScan(basePackages = {"net.magicreal"})
@MapperScan("net.magicreal.module.dao")
@EnableAutoConfiguration
public class ModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApplication.class, args);
    }
}
