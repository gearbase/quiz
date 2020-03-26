package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import project.dao.InterviewDAO;
import project.dao.StudentDAO;
import project.domain.Interview;
import project.domain.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckInterviewImpl implements CheckInterview{
    private InterviewDAO interviewDAO;
    private StudentDAO studentDAO;

    @Autowired
    public CheckInterviewImpl(InterviewDAO interviewDAO, StudentDAO studentDAO) {
        this.interviewDAO = interviewDAO;
        this.studentDAO = studentDAO;
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
        System.out.println("Введите имя и фамилию:");
        student.setFirstName(scanner.nextLine());
        student.setSecondName(scanner.nextLine());
        interviewList.forEach(interview -> {
            System.out.println(interview);
            student.getAnswers().add(Integer.valueOf(scanner.nextLine()));
        });
        scanner.close();
        int result = checkAnswers(interviewList, student.getAnswers());
        System.out.println(student.getFirstName() + " " + student.getSecondName() + ", " + "Ваш результат: " + result +
                " из " + interviewList.size());

    }

    private static int checkAnswers(List<Interview> interviews, List<Integer> answers) {
        return (int) interviews.stream()
                .filter(interview -> interview.getCorrectAnswer() == answers.get(interviews.indexOf(interview)))
                .count();
    }
}
