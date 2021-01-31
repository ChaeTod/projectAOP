package springdemo.AOPafter_returning.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springdemo.AOPafter_returning.Account;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // add a new advice for @AfterReturning on the findAccounts method
    @AfterReturning(
            pointcut = "execution(* springdemo.AOPafter_returning.DAO.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result){

        // print out which method we are advising on
        String method = joinPoint.getSignature().toShortString(); // get the method name
        System.out.println("\n ====> Executing @AfterReturning on method: " + method);

        // print out the result of the method call
        System.out.println("\n ===> result is: " + result);
    }

    // let's post-process the data
    private void convertToUpperCase(List<Account> result) {
        for(Account account: result){
            String name = account.getName().toUpperCase();
            String level = account.getLevel().toUpperCase();

            account.setName(name);
            account.setLevel(level);
        }
    }




    // need fully qualified class name: package + class
    @Before("springdemo.AOPafter_returning.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
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
        for (Object temp : args){
            System.out.println(temp);

            if (temp instanceof Account){
                // downcast and print Account specific stuff
                Account account = (Account) temp;

                System.out.printf("Account name: " + account.getName());
                System.out.printf("Account level: " + account.getLevel());

            }

        }

    }

}
