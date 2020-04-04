package com.example.homework.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class AppConfig {
    /*@Bean
    InterviewDAO interviewDAO(){
        return new InterviewDAOImp();
    }

    @Bean
    StudentDAO studentDAO(){
        return new StudentDAOImp();
    }

    @Bean
    CheckInterview checkInterview(){
        return new CheckInterviewImpl(interviewDAO(), studentDAO());
    }*/
    @Bean
    public MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/bundle");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }

}
