package project.dao;

import org.springframework.stereotype.Service;
import project.domain.Student;
@Service
public class StudentDAOImp implements StudentDAO{
    @Override
    public Student getStudentDAO() {
        return new Student();
    }
}
