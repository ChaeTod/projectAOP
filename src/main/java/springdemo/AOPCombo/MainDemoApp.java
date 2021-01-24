package springdemo.AOPCombo;

import springdemo.AOPCombo.DAO.AccountDAO;
import springdemo.AOPCombo.DAO.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        // read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        // get membership bean from spring container
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        Account account = new Account();
        accountDAO.addAccount(account, true); // both will match
        accountDAO.work();

        // call the account getter/setter methods
        accountDAO.setName("foobar");
        accountDAO.setServiceCode("silver");

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
