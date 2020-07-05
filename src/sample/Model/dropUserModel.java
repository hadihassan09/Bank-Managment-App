package sample.Model;

import sample.Classes.Account.managerAccount;
import sample.Classes.Account.reciptionestAccount;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Person;
import sample.Classes.Person.Reception;
import sample.Classes.databaseClasses.databaseConnection;

import javax.swing.plaf.nimbus.State;
import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class dropUserModel {
    private databaseConnection databaseConnection;

    public dropUserModel() throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
    }
    public ArrayList<String> getUsers() throws SQLException {
        ArrayList<String> list=new ArrayList<>();
        String query="SELECT customerID,personID FROM Customer";
        Statement statement=databaseConnection.getConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            String query2="SELECT firstName,middleName,lastName FROM Person where personID="+resultSet.getInt("personID");
            Statement statement1=databaseConnection.getConnection().createStatement();
            ResultSet resultSet1=statement1.executeQuery(query2);
            if(resultSet1.next()) {
                String tmp = "CustomerID :" + resultSet.getInt("customerID") + "  |  Name :" + resultSet1.getString("firstName") + " " + resultSet1.getString("middleName") + " " + resultSet1.getString("lastName");
                list.add(tmp);
            }
        }
        return list;
    }

    public int removeUserM(Manager manager,int id) throws SQLException {
        managerAccount managerAccount= (sample.Classes.Account.managerAccount) manager.getAccount();
        return managerAccount.removeCustomer(id);
    }

    public int removeUserR(Reception reception, int id) throws SQLException {
        reciptionestAccount reciptionestAccount= (sample.Classes.Account.reciptionestAccount) reception.getAccount();
        return reciptionestAccount.removeCustomer(id);
    }
}
