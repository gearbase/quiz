package project;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import project.service.CheckInterview;


@EnableAspectJAutoProxy
@ComponentScan
@Configuration
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        context.getBean(CheckInterview.class).letsCheckInterview();
        /*InterviewDAO interviewDAO = context.getBean(InterviewDAO.class);
        System.out.println(interviewDAO.getInterviewList());*/


    }
}
