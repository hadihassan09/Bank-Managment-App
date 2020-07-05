package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import sample.Classes.Person.Customer;
import sample.Model.withdawMoneyModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class WithdrawMoneyController implements Initializable {
    private withdawMoneyModel withdawMoneyModel;
    private Customer customer;
    @FXML
    private Label lebaneseTotal,dollarTotal;
    @FXML
    private CheckBox d5,d10,d20,d50,d100,d200,d500,d1000;
    @FXML
    private CheckBox a5,a10,a20,a50,a100,a200,a500,a1000;
    @FXML
    private Button withdrawBtn;
    @FXML
    private Label change;
    @FXML
    private HBox dollarBox,lebaneseBox;
    @FXML
    private Rectangle lebRec,dollRec;
    @FXML
    private Label leb1,leb2,doll1,doll2;
    private int i=1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            withdawMoneyModel=new withdawMoneyModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        change.setOnMouseClicked(mouseEvent -> {
            if(i%2==0){
                change.setText("withdraw in dollar");
                dollarBox.setVisible(false);
                lebaneseBox.setVisible(true);
                d5.setSelected(false);
                d10.setSelected(false);
                d20.setSelected(false);
                d50.setSelected(false);
                d100.setSelected(false);
                d200.setSelected(false);
                d500.setSelected(false);
                d1000.setSelected(false);
                dollarTotal.setText(0+"");
                leb1.setVisible(true);
                leb2.setVisible(true);
                lebRec.setVisible(true);
                doll1.setVisible(false);
                doll2.setVisible(false);
                dollRec.setVisible(false);
            }
            else {
                change.setText("withdraw in lebanese");
                dollarBox.setVisible(true);
                lebaneseBox.setVisible(false);
                a5.setSelected(false);
                a10.setSelected(false);
                a20.setSelected(false);
                a50.setSelected(false);
                a100.setSelected(false);
                a200.setSelected(false);
                a500.setSelected(false);
                a1000.setSelected(false);
                lebaneseTotal.setText(0+"");
                leb1.setVisible(false);
                leb2.setVisible(false);
                lebRec.setVisible(false);
                doll1.setVisible(true);
                doll2.setVisible(true);
                dollRec.setVisible(true);
            }
            i++;
        });

            d5.setOnMouseClicked(mouseEvent -> {
            if(d5.isSelected()) {
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp += 5;
                dollarTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp -= 5;
                dollarTotal.setText(tmp + "");
            }
        });

        d10.setOnMouseClicked(mouseEvent -> {
            if(d10.isSelected()) {
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp += 10;
                dollarTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp -= 10;
                dollarTotal.setText(tmp + "");
            }
        });

        d20.setOnMouseClicked(mouseEvent -> {
            if(d20.isSelected()) {
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp += 20;
                dollarTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp -= 20;
                dollarTotal.setText(tmp + "");
            }
        });

        d50.setOnMouseClicked(mouseEvent -> {
            if(d50.isSelected()) {
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp += 50;
                dollarTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp -= 50;
                dollarTotal.setText(tmp + "");
            }
        });

        d100.setOnMouseClicked(mouseEvent -> {
            if(d100.isSelected()) {
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp += 100;
                dollarTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp -= 100;
                dollarTotal.setText(tmp + "");
            }
        });

        d200.setOnMouseClicked(mouseEvent -> {
            if(d200.isSelected()) {
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp += 200;
                dollarTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp -= 200;
                dollarTotal.setText(tmp + "");
            }
        });

        d500.setOnMouseClicked(mouseEvent -> {
            if(d500.isSelected()) {
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp += 500;
                dollarTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp -= 500;
                dollarTotal.setText(tmp + "");
            }
        });

        d1000.setOnMouseClicked(mouseEvent -> {
            if(d1000.isSelected()) {
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp += 1000;
                dollarTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(dollarTotal.getText());
                tmp -= 1000;
                dollarTotal.setText(tmp + "");
            }
        });

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
            if(a1000.isSelected()) {
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp += 1000000;
                lebaneseTotal.setText(tmp + "");
            }
            else{
                double tmp = Double.parseDouble(lebaneseTotal.getText());
                tmp -= 1000000;
                lebaneseTotal.setText(tmp + "");
            }
        });

        withdrawBtn.setOnMouseClicked(mouseEvent -> {
            try {
                if(!withdawMoneyModel.withdraw(customer, Double.parseDouble(lebaneseTotal.getText()), Double.parseDouble(dollarTotal.getText()))){
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Not Enough Amount");
                    alert.setHeaderText(null);
                    alert.setContentText("You Don't have this amount of money!");

                    alert.showAndWait();
                }
                else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Success");
                    alert.setHeaderText(null);
                    alert.setContentText("Done!");

                    alert.showAndWait();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }

    public void setUserName(Customer c){
        customer=c;
    }
}
