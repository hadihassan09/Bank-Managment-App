package sample.Controllers;

import com.mysql.cj.xdevapi.Table;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Reception;
import sample.Model.checkFeedBackModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CheckFeedBacksController implements Initializable {
    private checkFeedBackModel checkFeedBackModel;
    private Reception reception;
    private Manager manager;
    private int level;
    @FXML
    private TableView feedBackTable;
    @FXML
    private TableColumn feedBackID,accountID,feedBackDescription;
    ObservableList observableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkFeedBackModel=new checkFeedBackModel();
    }

    public void setReception(Reception reception,int level) throws SQLException {
        this.reception=reception;
        this.level=level;
        observableList=checkFeedBackModel.getFeedBacksR(reception);
        feedBackID.setCellValueFactory(new PropertyValueFactory<>("feedBackID"));
        accountID.setCellValueFactory(new PropertyValueFactory<>("accountID"));
        feedBackDescription.setCellValueFactory(new PropertyValueFactory<>("feedBackDescription"));
        feedBackTable.setItems(observableList);
    }

    public void setManager(Manager manager,int level) throws SQLException {
        this.manager=manager;
        this.level=level;
        observableList=checkFeedBackModel.getFeedBacksM(manager);
        feedBackID.setCellValueFactory(new PropertyValueFactory<>("feedBackID"));
        accountID.setCellValueFactory(new PropertyValueFactory<>("accountID"));
        feedBackDescription.setCellValueFactory(new PropertyValueFactory<>("feedBackDescription"));
        feedBackTable.setItems(observableList);
    }
}
