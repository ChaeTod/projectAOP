package springdemo.AOPCombo.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* springdemo.AOPCombo.DAO.*.*(..))") // declaring a pointcut declaration
    private void forDaoPackage() {}

    // create point cut for getter method
    @Pointcut("execution(* springdemo.AOPCombo.DAO.*.get*(..))")  // match getter methods
    private void getter() {}  // name of pointcut declaration (can have any name)

    // create pointcut for setter method
    @Pointcut("execution(* springdemo.AOPCombo.DAO.*.set*(..))") // match setter methods
    private void setter() {}

    // create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDaoPackageNoGetterSetter() {} // can have any name

    @Before("forDaoPackage()") // apply pointcut declaration to advice
    public void beforeAddAccountAdvice(){
        System.out.println("\n ===> Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")  // applied pointcut declaration to advices
    public void performApiAnalitics() {
        System.out.println("\n ===> Performing API analytics");
    }





}
