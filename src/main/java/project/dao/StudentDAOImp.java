package project.dao;

import org.springframework.stereotype.Service;
import project.annotations.ForLogging;
import project.domain.Student;
@Service
@ForLogging
public class StudentDAOImp implements StudentDAO{
    @Override
    public Student getStudentDAO() {
        return new Student();
    }
}
