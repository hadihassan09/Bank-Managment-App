package sample.Classes.Account;

import sample.Classes.AccountType;
import sample.Classes.databaseClasses.databaseConnection;
import sample.Classes.transactionList;
import sample.savingInterestsRates;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class customerAccount implements Account{
    private int customerID,currentBalance,interestSavingsRateID;
    private static AccountType accountType=new AccountType(2);
    private savingInterestsRates savingRates;

    public customerAccount(int customerID,int currentBalance,int interestSavingsRateID) throws SQLException {
        databaseConnection databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();
        this.customerID=customerID;
        this.currentBalance=currentBalance;
        this.interestSavingsRateID=interestSavingsRateID;

        int value=0;
        String description=null;
        String query="SELECT interestRateValue,interestRateDescription FROM savingInterestsRates WHERE interestSavingRateID='"+interestSavingsRateID+"'";
        Statement statement=databaseConnection.getConnection().createStatement();
        ResultSet resultSet=statement.executeQuery(query);
        if(resultSet.next()){
            value=resultSet.getInt("interestRateValue");
            description=resultSet.getString("interestRateDescription");
        }
        savingRates=new savingInterestsRates(interestSavingsRateID,value,description);
    }

    @Override
    public ArrayList<transactionList> transactionsHistory() throws SQLException{
        ArrayList<transactionList>transactionLists=new ArrayList<>();
        String transactionDate;
        String query="SELECT * from transactionLog WHERE customerID='"+customerID+"'";
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

    public int getCustomerID() {
        return customerID;
    }

    public int sendFeedBack(String text) throws SQLException {
        if(text.length()==0)
            return 0;
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL sendFeedBack(?,?,?)}");
        statement.setString(1,text);
        statement.setInt(2,getCustomerID());
        statement.execute();
        int flag = statement.getObject(3,Integer.class);
        statement.close();
        return flag;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getCurrentBalance() throws  SQLException{
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL getCurrentBalance(?,?,?)}");
        statement.setInt(1,this.customerID);
        statement.execute();
        int balance = statement.getObject(2,Integer.class);
        int flag = statement.getObject(3,Integer.class);
        statement.close();
        if(flag == 0)
            return flag;
        return balance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public void requestLoan(int amount,String description) throws SQLException {
        CallableStatement statement = databaseConnection.getInstance().getConnection().prepareCall("{CALL requestLoan(?,?,?)}");
        statement.setInt(1,amount);
        statement.setString(2,description);
        statement.setInt(3,getCustomerID());
        statement.execute();
        statement.close();
    }


}
