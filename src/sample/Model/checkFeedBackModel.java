package sample.Model;

import javafx.collections.ObservableList;
import sample.Classes.Account.managerAccount;
import sample.Classes.Account.reciptionestAccount;
import sample.Classes.FeedBack;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Reception;

import java.sql.SQLException;

public class checkFeedBackModel {

    public ObservableList<FeedBack> getFeedBacksM(Manager manager) throws SQLException {
        managerAccount managerAccount= (sample.Classes.Account.managerAccount) manager.getAccount();
        return managerAccount.getFeedBacks();
    }

    public ObservableList<FeedBack> getFeedBacksR(Reception reception) throws SQLException {
        reciptionestAccount reciptionestAccount= (sample.Classes.Account.reciptionestAccount) reception.getAccount();
        return reciptionestAccount.getFeedBacks();
    }
}
