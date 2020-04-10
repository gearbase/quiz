package com.example.homework.dao;

import com.example.homework.domain.Student;
import com.example.homework.myannotations.ForMyLogging;
import org.springframework.stereotype.Service;

@Service
@ForMyLogging
public class StudentDAOImp implements StudentDAO{
    @Override
    public Student getStudentDAO() {
        return new Student();
    }
}
