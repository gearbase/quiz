package com.example.homework.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
    //TODO
   /* @Around("@target(com.example.homework.myannotations.ForMyLogging)")
    public Object logAll (ProceedingJoinPoint pjp) throws Throwable {
        Object obj = pjp.proceed();
        System.out.println("Вызов метода : " + pjp.getSignature().getName());
        System.out.println("Аргументы метода : "+ Arrays.toString(pjp.getArgs()));
        System.out.println("Возвращенное значение метода : " + obj);
        System.out.println("******************");
        System.out.println();
        return obj;
    }*/

    @Before("within(com.example.homework..*)")
    public void logBefore(JoinPoint pjp) {
        System.out.println("Вызов метода : " + pjp.getSignature().getName());
        System.out.println("********************");
    }
}
