package sample.Model;

import sample.Classes.Account.customerAccount;
import sample.Classes.Account.managerAccount;
import sample.Classes.Account.reciptionestAccount;
import sample.Classes.Person.Customer;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Person;
import sample.Classes.Person.Reception;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class depositMoneyModel {
    private databaseConnection databaseConnection;

    public depositMoneyModel() throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
    }

    public int deposit(Person p,int level,String accountID,int value) throws SQLException {

        if(checkAccount(accountID)==false)
            return 0;

        if(level==1){
            Manager manager= (Manager) p;
            managerAccount managerAccount= (sample.Classes.Account.managerAccount) manager.getAccount();
            return managerAccount.depositMoney(accountID, value);
        }

        if(level==2){
            Reception reception= (Reception) p;
            reciptionestAccount reciptionestAccount= (sample.Classes.Account.reciptionestAccount) reception.getAccount();
            return reciptionestAccount.depositMoney(accountID, value);
        }

        //IF WE USE IT IN THE FUTURE WHEN WE NEED TO UPDATE OUR APP
        if(level==3){
            Customer customer= (Customer) p;
        }
        return 1;
    }

    public boolean checkAccount(String accountID) throws SQLException {
        String query="SELECT * FROM Customer where accountID='"+Integer.parseInt(accountID)+"'";
        Statement statement=databaseConnection.getConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        if(resultSet.next()){
            return true;
        }
        return false;
    }
}
