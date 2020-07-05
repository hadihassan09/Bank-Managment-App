package sample.Classes.Person;

import sample.Classes.Account.customerAccount;

import java.sql.SQLException;

public class Customer extends Person {
    int customerID,accountID;

    public Customer(int customerID,int accountID,int personID, String fn, String mn, String ln, String add1,
                    String add2, String city, String country, String emailAddres, String homePhone, String workPhone,int currentBalance,int interestSavingsRateID)
            throws SQLException {
        super(personID, fn, mn, ln, add1, add2, city, country, emailAddres, homePhone, workPhone,new customerAccount(customerID,currentBalance,interestSavingsRateID));

        this.customerID=customerID;
        this.accountID=accountID;
    }

    public int checkCurrentBalance() throws SQLException {
        customerAccount account= (customerAccount) getAccount();
        return account.getCurrentBalance();
    }

    public int getCustomerID() {
        return customerID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }


}
