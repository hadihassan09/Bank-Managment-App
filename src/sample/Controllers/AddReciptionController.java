package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import sample.Classes.Person.Manager;
import sample.Model.addReciptionModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddReciptionController implements Initializable {
    private addReciptionModel addReciptionModel;
    private Manager manager;
    @FXML
    private TextField firstName,middleName,lastName,firstAddress,secondAddress,city,homePhone,workPhone,userName,email,password,confirmPassword;
    @FXML
    private Button addBtn;
    @FXML
    private ChoiceBox<String> country;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            addReciptionModel=new addReciptionModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        country.getItems().addAll("Lebanon","Syria","America","Germany","Canada","France");

        addBtn.setOnMouseClicked(mouseEvent -> {
            if(!password.getText().equals(confirmPassword.getText())){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Password");
                alert.setHeaderText(null);
                alert.setContentText("Password Doesn't match,Please Renter enter it");
                alert.showAndWait();
            }
            else {
                if(addReciptionModel.addReciption(manager,
                                                firstName.getText(),
                                                middleName.getText(),
                                                lastName.getText(),
                                                firstAddress.getText(),
                                                secondAddress.getText(),
                                                country.getSelectionModel().getSelectedItem(),
                                                city.getText(),
                                                homePhone.getText(),
                                                workPhone.getText(),
                                                email.getText(),
                                                userName.getText(),
                                                password.getText())==1){
                    Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                    alert1.setTitle("Success");
                    alert1.setHeaderText(null);
                    alert1.setContentText("New Receptionist Added Successfully");
                    alert1.showAndWait();
                }
                else {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
                    alert1.setTitle("Failed");
                    alert1.setHeaderText(null);
                    alert1.setContentText("Failed To Add New Receptionist");
                    alert1.showAndWait();
                }
            }
        });
    }

    public void setManager(Manager m){
        manager=m;
    }
}
