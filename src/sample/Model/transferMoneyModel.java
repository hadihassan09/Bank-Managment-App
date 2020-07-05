package sample.Model;

import sample.Classes.Account.customerAccount;
import sample.Classes.Account.managerAccount;
import sample.Classes.Account.reciptionestAccount;
import sample.Classes.Person.Customer;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Reception;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class transferMoneyModel {

    public int transferM(Manager manager,int senderID, int receiverID,double value) throws SQLException {
        if(checkExist(senderID)==0 || checkExist(receiverID)==0)
            return 0;
        managerAccount managerAccount= (sample.Classes.Account.managerAccount) manager.getAccount();
        return managerAccount.transferMoney(senderID,receiverID,value);
    }

    public int transferR(Reception reception,int senderID,int receiverID,double value) throws SQLException {
        if(checkExist(senderID)==0 || checkExist(receiverID)==0)
            return 0;
        reciptionestAccount reciptionestAccount= (sample.Classes.Account.reciptionestAccount) reception.getAccount();
        return reciptionestAccount.transferMoney(senderID, receiverID,value);
    }

    public int transferC(Customer c,int receiverID,double value) throws SQLException {
        if(checkExist(receiverID)==0)
            return 0;
        customerAccount customerAccount= (sample.Classes.Account.customerAccount) c.getAccount();
        return customerAccount.transferMoney(c.getAccountID(),receiverID,value);
    }

    public int checkExist(int id) throws SQLException {
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL checkExistCustomer(?,?)}");
        statement.setInt(1,id);
        statement.execute();
        int flag = statement.getObject(2,Integer.class);
        statement.close();
        return flag;
    }
}
