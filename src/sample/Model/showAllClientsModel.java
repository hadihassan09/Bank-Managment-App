package sample.Model;

import sample.Classes.Account.managerAccount;
import sample.Classes.Account.reciptionestAccount;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Reception;
import sample.Classes.clientsList;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.SQLException;
import java.util.ArrayList;

public class showAllClientsModel {
    databaseConnection databaseConnection;

    public showAllClientsModel() throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
    }

    public ArrayList<clientsList> showAllClientsM(Manager manager) throws SQLException {
        managerAccount managerAccount= (sample.Classes.Account.managerAccount) manager.getAccount();
        return managerAccount.getAllClients();
    }

    public ArrayList<clientsList> showAllClientsR(Reception reception) throws SQLException {
        reciptionestAccount reciptionestAccount= (sample.Classes.Account.reciptionestAccount) reception.getAccount();
        return reciptionestAccount.getAllClients();
    }
}
