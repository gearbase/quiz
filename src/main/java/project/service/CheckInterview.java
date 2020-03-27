package project.service;

import project.domain.Interview;
import project.domain.Student;

import java.io.IOException;
import java.util.List;

public interface CheckInterview {
    List<Interview> getQuestions() throws IOException;
    void letsCheckInterview();
    Student getStudent();
}
