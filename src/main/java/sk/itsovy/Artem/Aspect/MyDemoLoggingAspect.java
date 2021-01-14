package sk.itsovy.Artem.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice
    // @Before("execution(public void sk.itsovy.Artem.DAO.AccountDAO.addAccount())")
    //  @Before("execution(public void add*())")
    //  @Before("execution( * add*(sk.itsovy.Artem.Account,..))")
    //  @Before("execution( * add*(..))")
    @Before("execution( * sk.itsovy.Artem.DAO.*.*(..))") // pointcut expression - run this code BEFORE target object method "public void addAccount()"
    public void beforeAddAccount(){
        System.out.println("\n ==> Executing @Before addAccount method");
    }
}
