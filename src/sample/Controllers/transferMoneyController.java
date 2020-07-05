package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Classes.Person.Customer;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Person;
import sample.Classes.Person.Reception;
import sample.Model.transferMoneyModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class transferMoneyController implements Initializable {
    private Manager manager;
    private Reception reception;
    private Customer customer;
    private transferMoneyModel transferMoneyModel;
    private int level;
    @FXML
    private TextField senderID,receiverID;
    @FXML
    private CheckBox a5,a10,a20,a50,a100,a200,a500,a1000;
    @FXML
    private Label totalCheck;
    @FXML
    private Button transferBtn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        transferMoneyModel=new transferMoneyModel();

        a5.setOnMouseClicked(mouseEvent -> {
            if(a5.isSelected()) {
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp += 5000;
                totalCheck.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp -= 5000;
                totalCheck.setText(tmp + "");
            }
        });

        a10.setOnMouseClicked(mouseEvent -> {
            if(a10.isSelected()) {
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp += 10000;
                totalCheck.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp -= 10000;
                totalCheck.setText(tmp + "");
            }
        });

        a20.setOnMouseClicked(mouseEvent -> {
            if(a20.isSelected()) {
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp += 20000;
                totalCheck.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp -= 20000;
                totalCheck.setText(tmp + "");
            }
        });

        a50.setOnMouseClicked(mouseEvent -> {
            if(a50.isSelected()) {
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp += 50000;
                totalCheck.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp -= 50000;
                totalCheck.setText(tmp + "");
            }
        });

        a100.setOnMouseClicked(mouseEvent -> {
            if(a100.isSelected()) {
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp += 100000;
                totalCheck.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp -= 100000;
                totalCheck.setText(tmp + "");
            }
        });

        a200.setOnMouseClicked(mouseEvent -> {
            if(a200.isSelected()) {
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp += 200000;
                totalCheck.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp -= 200000;
                totalCheck.setText(tmp + "");
            }
        });

        a500.setOnMouseClicked(mouseEvent -> {
            if(a500.isSelected()) {
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp += 500000;
                totalCheck.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp -= 500000;
                totalCheck.setText(tmp + "");
            }
        });

        a1000.setOnMouseClicked(mouseEvent -> {
            if(a1000.isSelected()) {
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp += 1000000;
                totalCheck.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(totalCheck.getText());
                tmp -= 1000000;
                totalCheck.setText(tmp + "");
            }
        });

        transferBtn.setOnMouseClicked(mouseEvent -> {
            if (!receiverID.getText().equals(senderID.getText())) {
                if(!totalCheck.getText().equals("0.0")) {
                    try {

                        if (level == 1) {
                            if (transferMoneyModel.transferM(manager, Integer.parseInt(senderID.getText().trim()), Integer.parseInt(receiverID.getText().trim()), Double.parseDouble(totalCheck.getText().trim())) == 0) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText(null);
                                alert.setContentText("Something Error Please try again later or check accountIDs");
                                alert.showAndWait();
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Succeed");
                                alert.setHeaderText(null);
                                alert.setContentText("Transfer Done Successfully");
                                alert.showAndWait();
                            }
                        }
                        if (level == 2) {
                            if (transferMoneyModel.transferR(reception, Integer.parseInt(senderID.getText().trim()), Integer.parseInt(receiverID.getText().trim()), Double.parseDouble(totalCheck.getText().trim())) == 0) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText(null);
                                alert.setContentText("Something Error Please try again later or check accountIDs");
                                alert.showAndWait();
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Succeed");
                                alert.setHeaderText(null);
                                alert.setContentText("Transfer Done Successfully");
                                alert.showAndWait();
                            }
                        }
                        if (level == 3) {
                            if (transferMoneyModel.transferC(customer, Integer.parseInt(receiverID.getText().trim()), Double.parseDouble(totalCheck.getText().trim())) == 0) {
                                Alert alert = new Alert(Alert.AlertType.ERROR);
                                alert.setTitle("Error");
                                alert.setHeaderText(null);
                                alert.setContentText("Something Error Please try again later or check accountIDs");
                                alert.showAndWait();
                            } else {
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Succeed");
                                alert.setHeaderText(null);
                                alert.setContentText("Transfer Done Successfully");
                                alert.showAndWait();
                            }
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("WARNING");
                    alert.setHeaderText(null);
                    alert.setContentText("Please Select an amount to transfer");
                    alert.showAndWait();
                }
                }
            else {
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("WARNING");
                alert.setHeaderText(null);
                alert.setContentText("You can't send to same Account");
                alert.showAndWait();
            }


        });



    }

    public void setUser(Person p,int level){
        if(level==1){
            this.manager= (Manager) p;
        }
        if (level == 2) {
            this.reception= (Reception) p;
        }
        if (level == 3) {
            this.customer= (Customer) p;
            senderID.setText(customer.getAccountID()+"");
            senderID.setDisable(true);
        }
        this.level=level;
    }
}
