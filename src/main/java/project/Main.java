package project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import project.dao.InterviewDAO;
import project.service.CheckInterview;

import java.io.IOException;

@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.getBean(CheckInterview.class).letsCheckInterview();
        //InterviewDAO interviewDAO = context.getBean(InterviewDAO.class);
        //System.out.println(interviewDAO.getInterviewList());


    }
}
