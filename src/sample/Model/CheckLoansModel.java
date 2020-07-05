package sample.Model;

import sample.Classes.Account.managerAccount;
import sample.Classes.Account.reciptionestAccount;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Reception;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckLoansModel {

    public ArrayList<String> getLoansM(Manager manager) throws SQLException {
        managerAccount managerAccount= (sample.Classes.Account.managerAccount) manager.getAccount();
        return managerAccount.getLoans();
    }

    public ArrayList<String> getLoansR(Reception reception) throws SQLException {
        reciptionestAccount reciptionestAccount= (sample.Classes.Account.reciptionestAccount) reception.getAccount();
        return reciptionestAccount.getLoans();
    }

    public ArrayList<Integer> getWaitingLoans() throws SQLException {
        ArrayList<Integer> integers=new ArrayList<>();
        String query="SELECT loanID FROM loans WHERE status='waiting'";
        ResultSet resultSet=databaseConnection.getInstance().getConnection().createStatement().executeQuery(query);
        while (resultSet.next()) {
            int tmp=resultSet.getInt("loanID");
            integers.add(tmp);
        }
        return integers;
    }

    public int submitM(Manager manager,int loanID,String loanStatus) throws SQLException {
        managerAccount managerAccount= (sample.Classes.Account.managerAccount) manager.getAccount();
        return managerAccount.submit(loanID,loanStatus);
    }

    public int submitR(Reception reception,int loanID,String loanStatus) throws SQLException {
        reciptionestAccount reciptionestAccount= (sample.Classes.Account.reciptionestAccount) reception.getAccount();
        return reciptionestAccount.submit(loanID,loanStatus);
    }

}
