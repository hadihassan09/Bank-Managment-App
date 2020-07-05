package sample.Classes.Person;

import sample.Classes.Account.managerAccount;

import java.sql.SQLException;

public class Manager extends Person {
    int managerID;
    int accountID;
    private managerAccount managerAccount;

    public Manager(int managerID, int accountID, int personID, String fn, String mn, String ln, String add1, String add2, String city, String country, String emailAddress, String homePhone, String workPhone) throws SQLException {
        super(personID, fn, mn, ln, add1, add2, city, country, emailAddress, homePhone, workPhone, new managerAccount(managerID));
        this.managerID = managerID;
        this.accountID = accountID;
    }

    public int getManagerID() {
        return managerID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public sample.Classes.Account.managerAccount getManagerAccount() {
        return managerAccount;
    }




}