package ru.spbstu.java.spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"ru.spbstu.java.spring.controllers", "ru.spbstu.java.spring.config"})
public class WebConfig {
}
