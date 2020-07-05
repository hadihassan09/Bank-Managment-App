package sample.Model;


import javafx.fxml.FXML;
import javafx.scene.control.Label;
import sample.Classes.Person.Customer;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class checkCurrentBalanceModel {
    private databaseConnection databaseConnection;
    private Statement myStatement;

    public checkCurrentBalanceModel() throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
    }


    public int getBalance(Customer c) throws SQLException {
        return c.checkCurrentBalance();
        }

}
