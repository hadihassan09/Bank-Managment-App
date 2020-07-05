package sample.Controllers;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.Person.Customer;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Person;
import sample.Classes.Person.Reception;
import sample.Classes.TransactionLog;

import sample.Classes.transactionList;
import sample.Model.transactionsHistoryModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class transactionsHistory implements Initializable {
    private transactionsHistoryModel transactionsHistoryModel;
    private ArrayList<transactionList> transactionLists;
    private Manager m;
    private Customer c;
    private Reception r;
    private Person person;
    private int level;
    private String username;
    @FXML
    private TableView transactionTable;
    @FXML
    TableColumn transactionID,accountID,transactionAmount,newBalance,transactionDescription,transactionFeeAmount,transactionDate;
    private ObservableList<transactionList> observableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            transactionsHistoryModel=new transactionsHistoryModel();
//           System.out.println(transactionLogs.toString());


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setUsername(Person p, int l) throws SQLException {
        level=l;
        person=p;
        if(level==2){
           r= (Reception) p;
            transactionLists = transactionsHistoryModel.getAllTransactions(r,level);
        }
        if(level==3){
            c= (Customer) p;
            transactionLists = transactionsHistoryModel.getAllTransactions(c,level);
        }
        if(level==1){
            m= (Manager) p;
            transactionLists = transactionsHistoryModel.getAllTransactions(m,level);
        }
        observableList= FXCollections.observableArrayList(transactionLists);
        transactionID.setCellValueFactory(new PropertyValueFactory<>("transactionID"));
        accountID.setCellValueFactory(new PropertyValueFactory<>("accountID"));
        transactionDate.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        transactionAmount.setCellValueFactory(new PropertyValueFactory<>("transactionAmount"));
        newBalance.setCellValueFactory(new PropertyValueFactory<>("newBalance"));
        transactionDescription.setCellValueFactory(new PropertyValueFactory<>("transactionDescription"));
        transactionFeeAmount.setCellValueFactory(new PropertyValueFactory<>("transactionFeeAmount"));
        transactionTable.setItems(observableList);
    }
}
