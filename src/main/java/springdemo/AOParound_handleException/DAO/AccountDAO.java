package springdemo.AOParound_handleException.DAO;

import org.springframework.stereotype.Component;
import springdemo.AOParound_handleException.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    // add a new method: findAccounts()
    public List<Account> findAccounts(boolean trigger){
        if (trigger){
            throw new RuntimeException("No soup for you!");
        }

        List<Account> accounts = new ArrayList<>();

        // add them to our accounts list
        accounts.add(createSampleAcc("John", "Silver"));
        accounts.add(createSampleAcc("Madhu", "Platinum"));
        accounts.add(createSampleAcc("Luca", "Gold"));

        return accounts;
    }

    private Account createSampleAcc(String name, String level) {
        return new Account(name, level);
    }

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + "doing my DB work: adding an account"); // give a class name to display
    }

    public boolean work(){
        System.out.println(getClass() + ": in getName()");
        return false;
    }

    public String getName() {
        System.out.println(getClass() + ": in setName");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in GetServiceCode()");
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;
    }

}
