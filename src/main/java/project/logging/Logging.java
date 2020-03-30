package project.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class Logging {
    @Around("@target(project.annotations.ForLogging)")
    public Object logAll (ProceedingJoinPoint pjp) throws Throwable {
        Object obj = pjp.proceed();
        System.out.println("Вызов метода : " + pjp.getSignature().getName());
        System.out.println("Аргументы метода : "+ Arrays.toString(pjp.getArgs()));
        System.out.println("Возвращенное значение метода : " + obj);
        System.out.println("******************");
        System.out.println();
        return obj;
    }
}
