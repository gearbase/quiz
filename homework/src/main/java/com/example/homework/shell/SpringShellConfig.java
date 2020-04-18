package com.example.homework.shell;

import com.example.homework.service.CheckInterview;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class SpringShellConfig {
    private final CheckInterview checkInterview;
    //@Value("#{application['locale'].equals(\"ru_RU\")?\"старт\":\"start\"}")
    @Value("#{'${application.locale}'.equals(\"ru_RU\")?\"старт\":\"start\"}")
    public String value;

    public SpringShellConfig(CheckInterview checkInterview) {
        this.checkInterview = checkInterview;
    }

    @ShellMethod(key = {"s","start"}, value = "Проведеине интервью")
    public void checkInterview(){
        System.out.println(value);
        checkInterview.letsCheckInterview();
    }
}
