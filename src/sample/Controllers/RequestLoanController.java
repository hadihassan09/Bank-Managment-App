package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.Classes.Person.Customer;
import sample.Model.RequestLoanModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class RequestLoanController implements Initializable {
    private Customer customer;
    private RequestLoanModel requestLoanModel;
    private int amount;
    @FXML
    private CheckBox a5,a10,a20,a50,a100,a200,a500,a1000;
    @FXML
    private Label lebaneseTotal;
    @FXML
    private TextArea descriptionTXT;
    @FXML
    private Button requestBtn;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        requestLoanModel=new RequestLoanModel();

        a5.setOnMouseClicked(mouseEvent -> {
            if(a5.isSelected()) {
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp += 5000;
                lebaneseTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp -= 5000;
                lebaneseTotal.setText(tmp + "");
            }
        });

        a10.setOnMouseClicked(mouseEvent -> {
            if(a10.isSelected()) {
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp += 10000;
                lebaneseTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp -= 10000;
                lebaneseTotal.setText(tmp + "");
            }
        });

        a20.setOnMouseClicked(mouseEvent -> {
            if(a20.isSelected()) {
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp += 20000;
                lebaneseTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp -= 20000;
                lebaneseTotal.setText(tmp + "");
            }
        });

        a50.setOnMouseClicked(mouseEvent -> {
            if(a50.isSelected()) {
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp += 50000;
                lebaneseTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp -= 50000;
                lebaneseTotal.setText(tmp + "");
            }
        });

        a100.setOnMouseClicked(mouseEvent -> {
            if(a100.isSelected()) {
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp += 100000;
                lebaneseTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp -= 100000;
                lebaneseTotal.setText(tmp + "");
            }
        });

        a200.setOnMouseClicked(mouseEvent -> {
            if(a200.isSelected()) {
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp += 200000;
                lebaneseTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp -= 200000;
                lebaneseTotal.setText(tmp + "");
            }
        });

        a500.setOnMouseClicked(mouseEvent -> {
            if(a500.isSelected()) {
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp += 500000;
                lebaneseTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp -= 500000;
                lebaneseTotal.setText(tmp + "");
            }
        });

        a1000.setOnMouseClicked(mouseEvent -> {
                    if (a1000.isSelected()) {
                        double tmp = Double.parseDouble(lebaneseTotal.getText());
                        tmp += 1000000;
                        lebaneseTotal.setText(tmp + "");
                    } else {
                        double tmp = Double.parseDouble(lebaneseTotal.getText());
                        tmp -= 1000000;
                        lebaneseTotal.setText(tmp + "");
                    }
                });

        requestBtn.setOnMouseClicked(mouseEvent -> {
            if(descriptionTXT.getText().trim().isEmpty()){
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Required");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the description Field");
                alert.showAndWait();
            }
            else {
                double a=Double.parseDouble(lebaneseTotal.getText().trim());
                amount= (int) a;
                try {
                    requestLoanModel.sendRequest(customer,amount,descriptionTXT.getText());
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("DOne");
                    alert.setHeaderText(null);
                    alert.setContentText("We will reply for you in a short time,thank you");
                    alert.showAndWait();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    public void setCustomer(Customer customer){
        this.customer=customer;
    }

}
