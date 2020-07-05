package sample.Model;

import sample.Classes.Account.managerAccount;
import sample.Classes.Person.Manager;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class removeReciptionModel {
    private databaseConnection databaseConnection;

    public removeReciptionModel() throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
    }

    public ArrayList<String> getReception() throws SQLException {
        ArrayList<String> list=new ArrayList<>();
        String query="SELECT * FROM Employee";
        Statement statement=databaseConnection.getConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){

            String query2="SELECT firstName,middleName,lastName FROM Person where personID="+resultSet.getInt("personID");
            Statement statement1=databaseConnection.getConnection().createStatement();
            ResultSet resultSet1=statement1.executeQuery(query2);
            if(resultSet1.next()) {
                String tmp = "ReceptionID :" + resultSet.getInt("employeeID") + "  |  Name :" + resultSet1.getString("firstName") + " " + resultSet1.getString("middleName") + " " + resultSet1.getString("lastName");
                list.add(tmp);
            }
        }
        return list;
    }

    public int removeReception(Manager manager,int id) throws SQLException {
        if(checkExist(id)==0){
            return 0;
        }
        managerAccount managerAccount= (sample.Classes.Account.managerAccount) manager.getAccount();
        return managerAccount.removeReception(id);
    }

    public int checkExist(int id) throws SQLException {
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL checkExistEmployee(?,?)}");
        statement.setInt(1,id);
        statement.execute();
        int flag = statement.getObject(2,Integer.class);
        statement.close();
        return flag;
    }
}
