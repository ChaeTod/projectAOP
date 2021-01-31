package springdemo.AOPafter_finally.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExpressions {
    @Pointcut("execution(* springdemo.AOPafter_throwing.DAO.*.*(..))") // declaring a pointcut declaration
    public void forDaoPackage() {}

    // create point cut for getter method
    @Pointcut("execution(* springdemo.AOPafter_throwing.DAO.*.get*(..))")  // match getter methods
    public void getter() {}  // name of pointcut declaration (can have any name)

    // create pointcut for setter method
    @Pointcut("execution(* springdemo.AOPafter_throwing.DAO.*.set*(..))") // match setter methods
    public void setter() {}

    // create point: include package ... exclude getter/setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {} // can have any name
}
