package com.karaman.schoolmanagmentsystem.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
public class WebConfig implements WebMvcConfigurer{


    @Override
    public void addViewControllers(ViewControllerRegistry registry)
    {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login/postlogin").setViewName("teacherShow");
        //registry.addViewController("/home").setViewName("userhome");
        registry.addViewController("/teacher/getTeacherPage").setViewName("teacherShow");
        registry.addViewController("/teacher/getTeacherPage").setViewName("student");
        //registry.addViewController("/403").setViewName("403");
    }



}
