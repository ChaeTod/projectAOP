package springdemo.AOP.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // let's start with an @Before advice

    @Pointcut("execution(* springdemo.AOP.DAO.*.*(..))") // declaring a pointcut declaration
    private void forDaoPackage() {}

    @Before("forDaoPackage()") // apply pointcut declaration to advice
    public void beforeAddAccountAdvice(){
        System.out.println("\n ===> Executing @Before advice on method");
    }

    @Before("forDaoPackage()")
    public void performApiAnalitics() {
        System.out.println("\n ===> Performing API analytics");
    }





}
