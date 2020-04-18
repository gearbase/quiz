package com.example.homework.shell;

import com.example.homework.dao.InterviewDAO;
import com.example.homework.service.CheckInterview;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.util.Locale;

@ShellComponent
public class SpringShellConfig {
    private final CheckInterview checkInterview;
    private final InterviewDAO interviewDAO;

    //@Value("#{application['locale'].equals(\"ru_RU\")?\"старт\":\"start\"}")
    @Value("#{'${application.locale}'.equals(\"ru_RU\")?\"старт\":\"start\"}")
    public String value;

    public SpringShellConfig(CheckInterview checkInterview, InterviewDAO interviewDAO) {
        this.checkInterview = checkInterview;
        this.interviewDAO = interviewDAO;
    }

    @ShellMethod(key = {"s", "start"}, value = "Проведеине интервью")
    public void checkInterview() {
        System.out.println(value);
        checkInterview.letsCheckInterview();
    }

    @ShellMethod(key = "l", value = "Установка локали")
    public void setLocale(@ShellOption({"l, loc, locale"}) String locale) {
        Locale loc = new Locale(locale);
        interviewDAO.setLocale(loc);
    }
}
