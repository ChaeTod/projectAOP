package springdemo.AOPReadJoinpoint.DAO;

import org.springframework.stereotype.Component;
import springdemo.AOPReadJoinpoint.Account;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

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
