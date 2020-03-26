package project.dao;

import project.domain.Student;

public class StudentDAOImp implements StudentDAO{
    @Override
    public Student getStudentDAO() {
        return new Student();
    }
}
