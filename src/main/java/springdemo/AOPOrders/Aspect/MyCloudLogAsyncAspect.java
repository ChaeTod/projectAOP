package springdemo.AOPOrders.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAsyncAspect {

    @Before("springdemo.AOPOrders.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")  // applied pointcut declaration to advices
    public void logToCloudAsync() {
        System.out.println("\n ===> Logging to Cloud in async fashion");
    }

}
