package springdemo.AOPafter_returning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo.AOPafter_returning.DAO.AccountDAO;
import springdemo.AOPafter_returning.DAO.MembershipDAO;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accountList = accountDAO.findAccounts(); // will match for out @AfterReturningAdvice

        // display the accounts
        System.out.println("\n Main program: AfterReturningDemoApp");
        System.out.println("-------------");
        System.out.println(accountList);

        // close the context
        context.close();
    }
}
