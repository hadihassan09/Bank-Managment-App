package sample.Model;

import sample.Classes.Account.customerAccount;
import sample.Classes.Person.Customer;

import java.sql.SQLException;

public class SendFeedBackModel {

    public int send(Customer customer,String text) throws SQLException {
        customerAccount customerAccount= (sample.Classes.Account.customerAccount) customer.getAccount();
        return customerAccount.sendFeedBack(text);
    }
}
