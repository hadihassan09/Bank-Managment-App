package sample.Model;

import sample.Classes.Person.Customer;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class titleBarModel {
    private databaseConnection databaseConnection;

    public titleBarModel() throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
    }

    public  boolean check(String username,String password) throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
        Statement myStatement=databaseConnection.getConnection().createStatement();
        ResultSet resultSet=myStatement.executeQuery("select * from login where username='"+username+"'");
        while (resultSet.next()){
            if(resultSet.getString("password").equals(password)){
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

}

