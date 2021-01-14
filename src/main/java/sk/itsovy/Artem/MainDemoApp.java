package sk.itsovy.Artem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.Artem.DAO.AccountDAO;
import sk.itsovy.Artem.DAO.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();
        accountDAO.addAccount(account, true);

        accountDAO.work();

        System.out.println();

        membershipDAO.addMember();

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
