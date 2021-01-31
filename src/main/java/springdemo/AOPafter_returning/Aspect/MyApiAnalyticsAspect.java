package springdemo.AOPafter_returning.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

    @Before("springdemo.AOPafter_returning.Aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")  // applied pointcut declaration to advices
    public void performApiAnalitics() {
        System.out.println("\n ===> Performing API analytics");
    }

}
