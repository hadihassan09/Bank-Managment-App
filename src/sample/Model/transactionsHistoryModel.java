package sample.Model;


import sample.Classes.Account.customerAccount;
import sample.Classes.Person.Customer;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Person;
import sample.Classes.Person.Reception;
import sample.Classes.TransactionLog;
import sample.Classes.databaseClasses.databaseConnection;
import sample.Classes.transactionList;

import java.sql.SQLException;
import java.util.ArrayList;


public class transactionsHistoryModel  {
    private databaseConnection databaseConnection;

    public transactionsHistoryModel() throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
    }
    public ArrayList<transactionList> getAllTransactions(Person p, int level) throws SQLException {
        if(level==3){
            Customer c= (Customer) p;
            customerAccount customerAccount= (sample.Classes.Account.customerAccount) c.getAccount();
            return customerAccount.transactionsHistory();
        }
        if(level==2){
            Reception r = (Reception) p;
            return r.getAccount().transactionsHistory();
        }
        if(level==1){
            Manager m = (Manager) p;
            return m.getAccount().transactionsHistory();
        }
        return null;
    }
}

