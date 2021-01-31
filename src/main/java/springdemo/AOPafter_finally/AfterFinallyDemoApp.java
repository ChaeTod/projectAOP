package springdemo.AOPafter_finally;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo.AOPafter_finally.DAO.AccountDAO;

import java.util.List;

public class AfterFinallyDemoApp {
    public static void main(String[] args) {

        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call method to find the accounts
        List<Account> accountList = null; // will match for out @AfterReturningAdvice

        try {
            // add a boolean flag to simulate an exception
            boolean trigger = false;
            accountList = accountDAO.findAccounts(trigger);
        } catch (Exception e){
            e.printStackTrace();
        }

        // display the accounts
        System.out.println("\n Main program: AfterThrowingDemoApp");
        System.out.println("-------------");
        System.out.println(accountList);

        // close the context
        context.close();
    }
}
