package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Classes.Person.Customer;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Reception;
import sample.Model.CheckLoansModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CheckLoansController implements Initializable {
    private Manager manager;
    private Reception reception;
    private int level;
    private ArrayList<String> list;
    private ArrayList<Integer> integers;
    private CheckLoansModel checkLoansModel;
    @FXML
    private ChoiceBox loanStatus;
    @FXML
    private ChoiceBox loanID;
    @FXML
    private ListView loanList;
    @FXML
    private Button submitBtn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkLoansModel = new CheckLoansModel();
        loanStatus.getItems().addAll("Accept","Reject");
        try {
            integers = checkLoansModel.getWaitingLoans();
            for (int i = 0; i < integers.size(); i++) {
                loanID.getItems().add(integers.get(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        submitBtn.setOnMouseClicked(mouseEvent -> {
            if(loanStatus.getSelectionModel().getSelectedItem().toString().isEmpty() || loanID.getSelectionModel().getSelectedItem().toString().isEmpty()){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING");
                alert.setHeaderText(null);
                alert.setContentText("Please select a loanID and status");
                alert.showAndWait();
            }
            else {
                try {
                    if (level == 1) {
                        checkLoansModel.submitM(manager,Integer.parseInt(loanID.getSelectionModel().getSelectedItem().toString()),loanStatus.getSelectionModel().getSelectedItem().toString());
                        list = checkLoansModel.getLoansM(manager);
                    } else if (level == 2) {
                        checkLoansModel.submitR(reception,Integer.parseInt(loanID.getSelectionModel().getSelectedItem().toString()),loanStatus.getSelectionModel().getSelectedItem().toString());
                        list = checkLoansModel.getLoansR(reception);
                    }
                    if(loanStatus.getSelectionModel().getSelectedItem().toString().equals("Accept")){
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("");
                        alert.setHeaderText(null);
                        alert.setContentText("See customer new balance and transaction list");
                        alert.showAndWait();
                    }
                    else {
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("");
                        alert.setHeaderText(null);
                        alert.setContentText("Loan Rejected");
                        alert.showAndWait();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            loanList.getItems().clear();
            for (int i = 0; i < list.size(); i++)
                loanList.getItems().add(list.get(i));
        });
    }

    public void setManager(Manager manager,int level) throws SQLException {
        this.manager=manager;
        this.level=level;

        list=checkLoansModel.getLoansM(manager);
        for(int i=0;i<list.size();i++)
            loanList.getItems().add(list.get(i));
    }

    public void setReception(Reception reception,int level) throws SQLException {
        this.reception=reception;
        this.level=level;

        list=checkLoansModel.getLoansR(reception);
        for(int i=0;i<list.size();i++)
            loanList.getItems().add(list.get(i));

    }

}
