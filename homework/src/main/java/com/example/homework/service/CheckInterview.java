package com.example.homework.service;

import com.example.homework.domain.Interview;
import com.example.homework.domain.Student;

import java.io.IOException;
import java.util.List;

public interface CheckInterview {
    List<Interview> getQuestions() throws IOException;

    void letsCheckInterview();

    Student getStudent();
}
