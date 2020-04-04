package com.example.homework.dao;

import com.example.homework.annotations.ForLogging;
import com.example.homework.domain.Student;
import org.springframework.stereotype.Service;

@Service
@ForLogging
public class StudentDAOImp implements StudentDAO{
    @Override
    public Student getStudentDAO() {
        return new Student();
    }
}
