package sample.Model;

import javafx.scene.control.TextInputDialog;
import sample.Classes.Person.Customer;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Person;
import sample.Classes.Person.Reception;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

public class mainPageModel {
    private databaseConnection databaseConnection;

    public mainPageModel() throws SQLException {
        databaseConnection = sample.Classes.databaseClasses.databaseConnection.getInstance();
    }

    public int checkLevel(String username) throws SQLException {
        Statement statement=databaseConnection.getConnection().createStatement();
        String query="SELECT accountID FROM login WHERE username='"+username+"'";
        ResultSet resultSet=statement.executeQuery(query);
        int accountID=0;
        if(resultSet.next()){
            accountID =resultSet.getInt("accountID");
        }

        String query2="SELECT accountTypeID FROM Account WHERE accountID='"+accountID+"'";
        ResultSet resultSet2=statement.executeQuery(query2);
        if(resultSet2.next()){
            return resultSet2.getInt("accountTypeID");
        }
        return 2;
    }

    public Manager createManager(String user) throws SQLException {
        int accountID=0,managerID=0,personID=0;
        String fn = null,mn = null,ln = null,add1 = null,add2 = null,city = null,country = null,email = null,hp = null,wp = null;

        Statement statement=databaseConnection.getConnection().createStatement();
        String query1="SELECT accountID FROM login WHERE username='"+user+"'";
        ResultSet resultSet1=statement.executeQuery(query1);
        if(resultSet1.next()){
            accountID=resultSet1.getInt("accountID");
        }

        if(accountID==0)
            return null;

        String query2="SELECT managerID,personID FROM Manager where accountId='"+accountID+"'";
        ResultSet resultSet2=statement.executeQuery(query2);
        if(resultSet2.next()){
            managerID=resultSet2.getInt("managerID");
            personID=resultSet2.getInt("personID");
        }

        if(managerID==0 || personID==0)
            return null;

        String query3="SELECT * FROM Person WHERE personID='"+personID+"'";
        ResultSet resultSet3=statement.executeQuery(query3);
        if (resultSet3.next()){
            fn=resultSet3.getString("firstName");
            mn=resultSet3.getString("middleName");
            ln=resultSet3.getString("lastName");
            add1=resultSet3.getString("address1");
            add2=resultSet3.getString("address2");
            city=resultSet3.getString("city");
            country=resultSet3.getString("country");
            email=resultSet3.getString("emailAddres");
            hp=resultSet3.getString("homePhone");
            wp=resultSet3.getString("workPhone");
        }


        return new Manager(managerID,accountID,personID,fn,mn,ln,add1,add2,city,country,email,hp,wp);
    }

    public Reception createReception(String user) throws SQLException {
        int accountID=0,employeeID=0,personID=0;
        String fn = null,mn = null,ln = null,add1 = null,add2 = null,city = null,country = null,email = null,hp = null,wp = null;

        Statement statement=databaseConnection.getConnection().createStatement();
        String query1="SELECT accountID FROM login WHERE username='"+user+"'";
        ResultSet resultSet1=statement.executeQuery(query1);
        if(resultSet1.next()){
            accountID=resultSet1.getInt("accountID");
        }

        if(accountID==0)
            return null;

        String query2="SELECT employeeID,personID FROM Employee where accountID='"+accountID+"'";
        ResultSet resultSet2=statement.executeQuery(query2);
        if(resultSet2.next()){
            employeeID=resultSet2.getInt("employeeID");
            personID=resultSet2.getInt("personID");
        }

        if(employeeID==0 || personID==0)
            return null;

        String query3="SELECT * FROM Person WHERE personID='"+personID+"'";
        ResultSet resultSet3=statement.executeQuery(query3);
        if (resultSet3.next()){
            fn=resultSet3.getString("firstName");
            mn=resultSet3.getString("middleName");
            ln=resultSet3.getString("lastName");
            add1=resultSet3.getString("address1");
            add2=resultSet3.getString("address2");
            city=resultSet3.getString("city");
            country=resultSet3.getString("country");
            email=resultSet3.getString("emailAddres");
            hp=resultSet3.getString("homePhone");
            wp=resultSet3.getString("workPhone");
        }

        return new Reception(employeeID,accountID,personID,fn,mn,ln,add1,add2,city,country,email,hp,wp);
    }

    public Customer createCustomer(String user) throws SQLException {
        int accountID=0,customerID=0,personID=0;
        String fn = null,mn = null,ln = null,add1 = null,add2 = null,city = null,country = null,email = null,hp = null,wp = null;
        int currentBalance=0,interestSavingRateID=0;

        Statement statement=databaseConnection.getConnection().createStatement();
        String query1="SELECT accountID FROM login WHERE username='"+user+"'";
        ResultSet resultSet1=statement.executeQuery(query1);
        if(resultSet1.next()){
            accountID=resultSet1.getInt("accountID");
        }

        if(accountID==0)
            return null;

        String query2="SELECT customerID,personID FROM Customer where accountID='"+accountID+"'";
        ResultSet resultSet2=statement.executeQuery(query2);
        if(resultSet2.next()){
            customerID=resultSet2.getInt("customerID");
            personID=resultSet2.getInt("personID");
        }

        if(customerID==0 || personID==0)
            return null;

        String query3="SELECT * FROM Person WHERE personID='"+personID+"'";
        ResultSet resultSet3=statement.executeQuery(query3);
        if (resultSet3.next()){
            fn=resultSet3.getString("firstName");
            mn=resultSet3.getString("middleName");
            ln=resultSet3.getString("lastName");
            add1=resultSet3.getString("address1");
            add2=resultSet3.getString("address2");
            city=resultSet3.getString("city");
            country=resultSet3.getString("country");
            email=resultSet3.getString("emailAddres");
            hp=resultSet3.getString("homePhone");
            wp=resultSet3.getString("workPhone");
        }

        String query4="SELECT * FROM customerAccount WHERE customerID='"+customerID+"'";
        ResultSet resultSet4=statement.executeQuery(query4);
        if(resultSet4.next()){
            currentBalance=resultSet4.getInt("currentBalance");
            interestSavingRateID=resultSet4.getInt("interestSavingRateID");
        }

        return new Customer(customerID,accountID,personID,fn,mn,ln,add1,add2,city,country,email,hp,wp,currentBalance,interestSavingRateID);
    }

    public void setLLValue() {
        TextInputDialog dialog = new TextInputDialog("walter");
        dialog.setTitle("Set Value Of L.L");
        dialog.setHeaderText("Please Enter Value Of L.L");
        dialog.setContentText("1$ =");

// Traditional way to get the response value.
        Optional<String> result;
            result = dialog.showAndWait();
            if (result.isPresent()){
            System.out.println("1$ = " + result.get());
        }

// The Java 8 way to get the response value (with lambda expression).
        result.ifPresent(name -> System.out.println("1$ = " + name));
    }

    public int getID(Person p,int level) throws SQLException {
        if(level==1){
            String query="SELECT accountId FROM Manager WHERE personID="+p.getPersonID();
            Statement statement=databaseConnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next())
                return resultSet.getInt("accountID");
        }
        if(level==2){
            String query="SELECT accountID FROM Employee WHERE personID="+p.getPersonID();
            Statement statement=databaseConnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next())
                return resultSet.getInt("accountID");
        }
        if(level==3){
            String query="SELECT accountID FROM Customer WHERE personID="+p.getPersonID();
            Statement statement=databaseConnection.getConnection().createStatement();
            ResultSet resultSet=statement.executeQuery(query);
            if(resultSet.next())
                return resultSet.getInt("accountID");
        }
        return 0;
    }
}
