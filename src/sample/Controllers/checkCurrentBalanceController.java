package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.Classes.Person.Customer;
import sample.Model.checkCurrentBalanceModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class checkCurrentBalanceController implements Initializable {
    private checkCurrentBalanceModel checkCurrentBalanceModel;
    private  Customer c;
    @FXML
    private Label balanceLabel;
    @FXML
    private Button check;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            checkCurrentBalanceModel = new checkCurrentBalanceModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        check.setOnMouseClicked(e->{
            int balance= 0;
            try {
                balance = checkCurrentBalanceModel.getBalance(c);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            balanceLabel.setText(balance+"");
        });
    }

    public void setUsername(Customer p){
        c=p;
    }
}
