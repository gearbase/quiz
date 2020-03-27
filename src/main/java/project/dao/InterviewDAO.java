package project.dao;

import project.domain.Interview;

import java.io.IOException;
import java.util.List;

public interface InterviewDAO {
    List<Interview> getInterviewList() throws IOException;
}
