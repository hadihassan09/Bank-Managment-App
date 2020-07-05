package sample.Classes.Person;

import sample.Classes.Account.reciptionestAccount;

import java.sql.SQLException;

public class Reception extends Person {
    private int employeeID,accountID;
    private reciptionestAccount reciptionestAccount;

    public Reception(int employeeID,int accountID,int personID, String fn, String mn, String ln, String add1, String add2, String city, String country, String emailAddress, String homePhone, String workPhone) throws SQLException {
        super(personID, fn, mn, ln, add1, add2, city, country, emailAddress, homePhone, workPhone,new reciptionestAccount(employeeID));
        this.employeeID=employeeID;
        this.accountID=accountID;
    }

    public int getEmployeeID() {
        return employeeID;
    }


    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public sample.Classes.Account.reciptionestAccount getReciptionestAccount() {
        return reciptionestAccount;
    }

}
