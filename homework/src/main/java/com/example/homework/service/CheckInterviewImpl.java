package com.example.homework.service;

import com.example.homework.dao.InterviewDAO;
import com.example.homework.dao.StudentDAO;
import com.example.homework.domain.Interview;
import com.example.homework.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Service
public class CheckInterviewImpl implements CheckInterview{
    private InterviewDAO interviewDAO;
    private StudentDAO studentDAO;
    private MessageSource ms;

    @Autowired
    public CheckInterviewImpl(InterviewDAO interviewDAO, StudentDAO studentDAO, MessageSource ms) {
        this.interviewDAO = interviewDAO;
        this.studentDAO = studentDAO;
        this.ms = ms;
    }

    @Override
    public Student getStudent() {
        return studentDAO.getStudentDAO();
    }

    @Override
    public List<Interview> getQuestions() {
        try {
            return interviewDAO.getInterviewList();
        } catch (IOException e) {
            System.out.println("Проблема с получением списка вопросов");
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    public void letsCheckInterview(){
        List<Interview> interviewList = getQuestions();
        if (interviewList.isEmpty()) return;
        Student student = getStudent();
        Scanner scanner = new Scanner(System.in);
        System.out.println(ms.getMessage("enter.name", null, Locale.getDefault()));
        student.setFirstName(scanner.nextLine());
        student.setSecondName(scanner.nextLine());
        interviewList.forEach(interview -> {
            System.out.println(interview);
            student.getAnswers().add(Integer.valueOf(scanner.nextLine()));
        });
        scanner.close();
        int result = checkAnswers(interviewList, student.getAnswers());
        System.out.println(student.getFirstName() + " " + student.getSecondName() + ", " +
                ms.getMessage("student.result1", null, Locale.getDefault())+ result +
                ms.getMessage("student.result2",null, Locale.getDefault())+ interviewList.size());

    }

    private static int checkAnswers(List<Interview> interviews, List<Integer> answers) {
        return (int) interviews.stream()
                .filter(interview -> interview.getCorrectAnswer() == answers.get(interviews.indexOf(interview)))
                .count();
    }
}
