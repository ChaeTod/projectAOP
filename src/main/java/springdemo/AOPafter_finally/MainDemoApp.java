package springdemo.AOPafter_finally;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springdemo.AOPafter_finally.DAO.AccountDAO;
import springdemo.AOPafter_finally.DAO.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();
        account.setName("Madhu");
        account.setLevel("Platinum");

        accountDAO.addAccount(account, true); // both will match
        accountDAO.work();

        String name = accountDAO.getName();
        String code = accountDAO.getServiceCode();

        System.out.println();

        membershipDAO.addMember(); // both will match
        membershipDAO.goToSleep();

        /*
        // call the business method
        accountDAO.addAccount(); // will match on the @Before advice

        // call the membership business method
        membershipDAO.addAccount();
        */

        // close the context
        context.close();
    }
}
