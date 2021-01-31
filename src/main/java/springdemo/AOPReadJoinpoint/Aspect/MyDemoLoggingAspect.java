package springdemo.AOPReadJoinpoint.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springdemo.AOPReadJoinpoint.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    // need fully qualified class name: package + class
    @Before("springdemo.AOPReadJoinpoint.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
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
