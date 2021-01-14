package sk.itsovy.Artem.DAO;

import org.springframework.stereotype.Component;
import sk.itsovy.Artem.Account;

@Component
public class AccountDAO {
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + "doing my DB work: adding an account"); // give a class name to display
    }

    public boolean work(){
        System.out.println(getClass() + ": work()");
        return false;
    }
}
