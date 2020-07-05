package sample.Model;

import sample.Classes.Account.managerAccount;
import sample.Classes.Person.Manager;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.SQLException;

public class addReciptionModel {
    private databaseConnection databaseConnection;

    public addReciptionModel() throws SQLException {
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
    }

    public int addReciption(Manager m,String fn,String mn,String ln,String fa,String sa,String country,String city,String hp,String wp,String email,String username,String password){
        try {
            managerAccount managerAccount= (sample.Classes.Account.managerAccount) m.getAccount();
            managerAccount.addReception(fn,mn,ln,fa,sa,country,city,hp,wp,email,username,password);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
