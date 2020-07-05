package sample.Model;

import sample.Classes.Account.customerAccount;
import sample.Classes.Person.Customer;

import java.sql.SQLException;

public class RequestLoanModel {

    public void sendRequest(Customer customer,int amount,String string) throws SQLException {
        customerAccount customerAccount= (sample.Classes.Account.customerAccount) customer.getAccount();
        customerAccount.requestLoan(amount,string);
    }
}
