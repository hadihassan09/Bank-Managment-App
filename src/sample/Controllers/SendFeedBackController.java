package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import sample.Classes.Person.Customer;
import sample.Model.SendFeedBackModel;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class SendFeedBackController implements Initializable {
    private Customer customer;
    @FXML
    private Button sendBtn;
    @FXML
    private TextArea feedTXT;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        SendFeedBackModel sendFeedBackModel=new SendFeedBackModel();

        sendBtn.setOnMouseClicked(mouseEvent -> {
            try {
                if((sendFeedBackModel.send(customer,feedTXT.getText()))==0){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Something Error!!\nPlease try again later.");
                    alert.showAndWait();
                }
                else {
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Done");
                    alert.setHeaderText(null);
                    alert.setContentText("Thanks for your feedback.");
                    alert.showAndWait();
                    feedTXT.setText("");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public void setCustomer(Customer customer){
        this.customer=customer;
    }
}
