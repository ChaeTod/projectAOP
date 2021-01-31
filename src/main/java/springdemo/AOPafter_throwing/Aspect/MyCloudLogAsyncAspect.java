package springdemo.AOPafter_throwing.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1) // specify the actual order in a way that I want to run it (lower number - has higher priority
public class MyCloudLogAsyncAspect {

    @Before("springdemo.AOPafter_throwing.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")  // applied pointcut declaration to advices
    public void logToCloudAsync() {
        System.out.println("\n ===> Logging to Cloud in async fashion");
    }

}
