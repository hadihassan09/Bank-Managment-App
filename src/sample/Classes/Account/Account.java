package sample.Classes.Account;

import sample.Classes.transactionList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Account {

    public ArrayList<transactionList> transactionsHistory() throws SQLException;
    public int transferMoney(int senderID,int receiverID,double value) throws SQLException;
}
