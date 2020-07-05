package sample.Classes.Account;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.Classes.*;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class reciptionestAccount implements Account{
    int employeeID;
    private static AccountType accountType=new AccountType(1);

    public reciptionestAccount(int employeeID){
        this.employeeID=employeeID;
    }

    @Override
    public ArrayList<transactionList> transactionsHistory() throws SQLException {
        ArrayList<transactionList> transactionLists=new ArrayList<>();
        String query="SELECT * FROM transactionLog";
        databaseConnection databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
        Statement statement=databaseConnection.getConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            String tmp="SELECT transactionTypeDescription,transactionFeeAmount FROM transactionType WHERE transactionTypeID="+resultSet.getInt("transactionTypeID");
            Statement statement1=databaseConnection.getConnection().createStatement();
            ResultSet tmp1=statement1.executeQuery(tmp);
            String description="";
            int feeAmount=0;
            if(tmp1.next()){
                description=tmp1.getString("transactionTypeDescription");
                feeAmount=tmp1.getInt("transactionFeeAmount");
            }
            transactionList transactionList=new transactionList(
                    resultSet.getInt("transactionID"),
                    resultSet.getInt("accountID"),
                    resultSet.getString("transactionDate"),
                    resultSet.getInt("transactionAmount"),
                    resultSet.getInt("newBalance"),
                    description,feeAmount
            );

            transactionLists.add(transactionList);
        }
        return transactionLists;
    }

    public int addCustomer(String fn, String mn, String ln, String fa, String sa, String country, String city, String hp, String wp, String email,
                           int interestSavingRateID, double currentBalance, String username, String password,int income) throws SQLException {
        sample.Classes.databaseClasses.databaseConnection databaseConnection = sample.Classes.databaseClasses.databaseConnection.getInstance();
        CallableStatement statement = databaseConnection.getConnection().prepareCall("{CALL add_person(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
        statement.setString(1,fn);
        statement.setString(2,mn);
        statement.setString(3,ln);
        statement.setString(4,fa);
        statement.setString(5,sa);
        statement.setString(6,city);
        statement.setString(7,country);
        statement.setString(8,email);
        statement.setString(9,hp);
        statement.setString(10,wp);
        statement.setString(11,String.valueOf(interestSavingRateID));
        statement.setString(12,String.valueOf(currentBalance));
        statement.setString(13,String.valueOf(income));
        statement.setString(14,username);
        statement.setString(15,password);
        statement.execute();
        return 1;
    }

    public int depositMoney(String accountID,int value) throws SQLException {
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL depositMoney(?,?,?)}");
        statement.setString(1,accountID);
        statement.setInt(2,value);
        statement.execute();
        int flag = statement.getObject(3,Integer.class);
        statement.close();
        return flag;
    }

    public int removeCustomer(int id) throws SQLException {
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL removeCustomer(?,?)}");
        statement.setInt(1,id);
        statement.execute();
        int flag = statement.getObject(2,Integer.class);
        statement.close();
        return flag;
    }

    @Override
    public int transferMoney(int senderID, int receiverID,double value) throws SQLException {
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL transferMoney(?,?,?,?)}");
        statement.setInt(1,senderID);
        statement.setInt(2,receiverID);
        statement.setDouble(3,value);
        statement.execute();
        int flag = statement.getObject(4,Integer.class);
        statement.close();
        return flag;
    }

    public ArrayList<clientsList> getAllClients() throws SQLException {
        ArrayList<clientsList> clientsLists=new ArrayList<>();
        String query="SELECT customerID,accountID,currentBalance FROM customerAccount";
        Statement statement=databaseConnection.getInstance().getConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        while (resultSet.next()){
            int personID=0;
            String getPerson="SELECT personID FROM Customer WHERE customerID="+resultSet.getInt("customerID");
            Statement statement1=databaseConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet1=statement1.executeQuery(getPerson);
            if(resultSet1.next()){
                personID=resultSet1.getInt("personID");
            }

            String query2="SELECT firstName,middleName,lastName,workPhone,emailAddres FROM Person WHERE personID="+personID;
            Statement statement2=databaseConnection.getInstance().getConnection().createStatement();
            ResultSet resultSet2=statement2.executeQuery(query2);
            if(resultSet2.next()){
                clientsList clientsList=new clientsList(
                        resultSet.getInt("customerID"),
                        resultSet.getInt("accountID"),
                        resultSet.getInt("currentBalance"),
                        resultSet2.getString("workPhone"),
                        resultSet2.getString("firstName"),
                        resultSet2.getString("middleName"),
                        resultSet2.getString("lastName"),
                        resultSet2.getString("emailAddres")
                );

                clientsLists.add(clientsList);
            }
        }
        return clientsLists;
    }

    public ObservableList<FeedBack> getFeedBacks() throws SQLException {
        ArrayList<FeedBack> feedBacks=new ArrayList<>();
        Statement statement=databaseConnection.getInstance().getConnection().createStatement();
        String tmp="SELECT * FROM feedBacks";
        ResultSet resultSet=statement.executeQuery(tmp);
        while (resultSet.next()){
            int feedBackID=resultSet.getInt("feedBackID");
            int accountID=resultSet.getInt("accountID");
            String feedBackDescription=resultSet.getString("feedBackDescription");
            FeedBack feedBack=new FeedBack(feedBackID,accountID,feedBackDescription);
            feedBacks.add(feedBack);
        }
        return FXCollections.observableArrayList(feedBacks);
    }

    public ArrayList<String> getLoans() throws SQLException {
        ArrayList<String> list=new ArrayList<>();
        String query="SELECT * FROM loans WHERE status = ?";
        Connection con = databaseConnection.getInstance().getConnection();
        Statement statement=con.prepareStatement(query);
        ((PreparedStatement) statement).setString(1,"waiting");
        ResultSet resultSet=((PreparedStatement) statement).executeQuery();
        while (resultSet.next()) {
            String tmp="LoanID : "+resultSet.getInt("loanID") + ", loanAmount : " + resultSet.getInt("loanAmount")+", accountID : "+resultSet.getInt("accountID")+", loanDescription : "+resultSet.getString("loanDescription")+", Status:"+resultSet.getString("status");
            list.add(tmp);
        }
        return list;
    }

    public int submit(int loanID,String Status) throws SQLException {
        int flag = 0;
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL submit(?,?,?)}");
        statement.setInt(1, loanID);
        if (Status.equals("Accept")) {
            statement.setInt(2, 1);
            statement.execute();
            flag = statement.getObject(3, Integer.class);
        } else if (Status.equals("Reject")) {
            statement.setInt(2, 0);
            statement.execute();
            flag = statement.getObject(3, Integer.class);
        }
        statement.close();
        return flag;
    }
}

