package sample.Model;

import sample.Classes.Account.customerAccount;
import sample.Classes.Person.Customer;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class withdawMoneyModel {
    private databaseConnection databaseConnection;
    private static final int DOLLAR_TRANS = 1;
    private static final int LEBANESE_TRANS = 500;

    public withdawMoneyModel() throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
    }

    public double getCurrentBalance(Customer customer) throws SQLException {
        customerAccount customerAccount= (sample.Classes.Account.customerAccount) customer.getAccount();
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL getCurrentBalance(?,?,?)}");
        statement.setInt(1,customerAccount.getCustomerID());
        statement.execute();
        double balance = statement.getObject(2,Double.class);
        int flag = statement.getObject(3,Integer.class);
        statement.close();
        if(flag == 1)
            return balance;
        return flag;
    }

    public boolean withdraw(Customer customer,double lebanese,double dollar) throws SQLException {
        customerAccount customerAccount = (sample.Classes.Account.customerAccount) customer.getAccount();
        int flag = 0;
        if (lebanese > 0) {
            CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL withdraw(?,?,?,?,?,?)}");
            statement.setInt(1,customerAccount.getCustomerID());
            statement.setInt(2,customer.getAccountID());
            statement.setDouble(3,lebanese);
            statement.setDouble(4,getCurrentBalance(customer));
            statement.setInt(5,2);
            statement.execute();
            flag = statement.getObject(6, Integer.class);
            statement.close();
        }
        if (dollar > 0) {
            CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL withdraw(?,?,?,?,?,?)}");
            statement.setInt(1,customerAccount.getCustomerID());
            statement.setInt(2,customer.getAccountID());
            statement.setDouble(3,lebanese);
            statement.setDouble(4,getCurrentBalance(customer));
            statement.setInt(5,1);
            statement.execute();
            flag = statement.getObject(6, Integer.class);
            statement.close();
        }
        if(flag == 1)
            return true;
        return false;
    }
}
