package sample.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Reception;
import sample.Classes.clientsList;
import sample.Model.showAllClientsModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ShowAllClientsController implements Initializable {
    private showAllClientsModel showAllClientsModel;
    private Reception reception;
    private Manager manager;
    private int level;
    @FXML
    private TableView clientsTable;
    @FXML
    private TableColumn customerID,accountID,firstName,middleName,lastName,workPhone,emailAddress,currentBalance;
    private ObservableList<clientsList> observableLists;
    private ArrayList<clientsList> clientsLists;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showAllClientsModel=new showAllClientsModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setManager(Manager manager,int level) throws SQLException {
        this.manager=manager;
        this.level=level;

        clientsLists=showAllClientsModel.showAllClientsM(manager);
        observableLists= FXCollections.observableArrayList(clientsLists);
        customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        accountID.setCellValueFactory(new PropertyValueFactory<>("accountID"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        workPhone.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
        emailAddress.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        currentBalance.setCellValueFactory(new PropertyValueFactory<>("currentBalance"));
        clientsTable.setItems(observableLists);
    }

    public void setReception(Reception reception,int level) throws SQLException {
        this.reception=reception;
        this.level=level;
        clientsLists=showAllClientsModel.showAllClientsR(reception);
        observableLists= FXCollections.observableArrayList(clientsLists);
        customerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));
        accountID.setCellValueFactory(new PropertyValueFactory<>("accountID"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        workPhone.setCellValueFactory(new PropertyValueFactory<>("workPhone"));
        emailAddress.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        currentBalance.setCellValueFactory(new PropertyValueFactory<>("currentBalance"));
        clientsTable.setItems(observableLists);
    }
}
