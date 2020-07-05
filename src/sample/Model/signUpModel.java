package sample.Model;

import sample.Classes.Account.managerAccount;
import sample.Classes.Account.reciptionestAccount;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Person;
import sample.Classes.Person.Reception;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class signUpModel {
    private databaseConnection databaseConnection;

    public signUpModel() throws SQLException {
        databaseConnection=sample.Classes.databaseClasses.databaseConnection.getInstance();
    }

    //Need to change the query
    public int addCustomer(Person p,String fn, String mn, String ln, String fa, String sa, String country, String city, String hp, String wp, String email,
                           int interestSavingRateID, double currentBalance, String username, String password,int income) throws SQLException {

        if(checkIfExist(username)==1){
            return -1;
        }
        if(p instanceof Manager){
            Manager m= (Manager) p;
            managerAccount managerAccount= (sample.Classes.Account.managerAccount) m.getAccount();
            managerAccount.addCustomer(fn,mn,ln,fa,sa,country,city,hp,wp,email,interestSavingRateID,currentBalance,username,password,income);
        }
        if(p instanceof Reception){
            Reception r= (Reception) p;
            reciptionestAccount reciptionestAccount= (sample.Classes.Account.reciptionestAccount) r.getAccount();
            reciptionestAccount.addCustomer(fn,mn,ln,fa,sa,country,city,hp,wp,email,interestSavingRateID,currentBalance,username,password,income);
        }
        return 1;
    }

    public int checkIfExist(String username) throws SQLException {
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL checkExistUser(?,?)}");
        statement.setString(1,username);
        statement.execute();
        int flag = statement.getObject(2,Integer.class);
        statement.close();
        return flag;
    }

}
