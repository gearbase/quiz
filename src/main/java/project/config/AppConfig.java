package project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.dao.InterviewDAO;
import project.dao.InterviewDAOImp;
import project.dao.StudentDAO;
import project.dao.StudentDAOImp;
import project.domain.Interview;
import project.service.CheckInterview;
import project.service.CheckInterviewImpl;

import java.io.IOException;
import java.util.List;
/*
@Configuration
public class AppConfig {
    @Bean
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
    }


}
*/