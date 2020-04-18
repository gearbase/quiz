package com.example.homework.dao;

import com.example.homework.domain.Interview;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public interface InterviewDAO {
    List<Interview> getInterviewList() throws IOException;
    void setLocale(Locale locale);
}
