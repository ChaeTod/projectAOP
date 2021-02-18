package springdemo.AOParound.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springdemo.AOParound.Account;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* springdemo.AOParound.Service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        // print out method we are advising on
        System.out.println("\n ====> Executing @Around on method: " + proceedingJoinPoint.getSignature().toShortString());

        // get begin timestamp
        long begin = System.currentTimeMillis();

        // execute the method
        Object result = proceedingJoinPoint.proceed();  // handle to target method && execute the target method

        // get end timestamp
        long end = System.currentTimeMillis();

        // compute duration and display it
        long duration = end - begin;
        System.out.println("====> Duration: " + duration / 1000.0 + " seconds");

        return result;
    }

    @After("execution(* springdemo.AOParound.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint) {

        // print out which method we are advising on
        System.out.println("\n ====> Executing @After (Finally) on method: " + joinPoint.getSignature().toShortString());

    }

    @AfterThrowing(
            pointcut = "execution(* springdemo.AOParound.DAO.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Throwable exc) {

        // print out which method we are advising on
        System.out.println("\n ====> Executing @AfterThrowing on method: " + joinPoint.getSignature().toShortString());

        // print out the result of the method call
        System.out.println("\n ===> result is: " + exc);

    }

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* springdemo.AOParound.DAO.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        // print out which method we are advising on
        // String method = joinPoint.getSignature().toShortString(); // get the method name
        System.out.println("\n ====> Executing @AfterReturning on method: " + joinPoint.getSignature().toShortString());

        // print out the result of the method call
        System.out.println("\n ===> result is: " + result);

    }

    // let's post-process the data
    private void convertToUpperCase(List<Account> result) {
        for (Account account : result) {
            String name = account.getName().toUpperCase();
            String level = account.getLevel().toUpperCase();

            account.setName(name);
            account.setLevel(level);
        }
    }

    // need fully qualified class name: package + class
    @Before("springdemo.AOParound.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
    // apply pointcut declaration to advice
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n ===> Executing @Before advice on method");

        // display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.printf("Method: " + methodSignature);

        // display method arguments


        // get args
        Object[] args = joinPoint.getArgs(); // get an array of arguments

        // loop thru args
        for (Object temp : args) {
            System.out.println(temp);

            if (temp instanceof Account) {
                // downcast and print Account specific stuff
                Account account = (Account) temp;

                System.out.printf("Account name: " + account.getName());
                System.out.printf("Account level: " + account.getLevel());

            }
        }
    }
}
