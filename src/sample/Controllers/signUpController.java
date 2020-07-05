package sample.Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import sample.Classes.Person.Person;
import sample.Model.signUpModel;


import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
public class signUpController implements Initializable {
    private signUpModel signUpModel;
    private Person person;
    @FXML
    private Button signUpBtn;
    @FXML
    private TextField firstName,middleName,lastName,firstAddress,secondAddress,city,homePhone,workPhone,userName,email,password,confirmPassword,balanceTXT;
    @FXML
    private ChoiceBox<String> country;
    @FXML
    private TextField incomeValue;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            signUpModel=new signUpModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        country.getItems().addAll("Lebanon","Syria","America","Germany","Canada","France");

        signUpBtn.setOnAction(actionEvent ->  {
                if(!password.getText().equals(confirmPassword.getText())){
                    Alert alert111=new Alert(Alert.AlertType.ERROR);
                    alert111.setTitle("Wrong Password");
                    alert111.setHeaderText(null);
                    alert111.setContentText("Password does not Match");
                    alert111.showAndWait();
                    return;
                }
                try {
                    Double.parseDouble(balanceTXT.getText());
                    int tmp;
                    if((tmp=signUpModel.addCustomer(person,firstName.getText(),
                                                middleName.getText(),
                                                lastName.getText(),
                                                firstAddress.getText(),
                                                secondAddress.getText(),
                                                country.getSelectionModel().getSelectedItem(),
                                                city.getText(),
                                                homePhone.getText(),
                                                workPhone.getText(),
                                                email.getText(), 1,Double.parseDouble(balanceTXT.getText()),
                                                userName.getText(),
                                                password.getText(),
                                                Integer.parseInt(incomeValue.getText().trim())))==1){
                        Alert alert1=new Alert(Alert.AlertType.INFORMATION);
                        alert1.setTitle("Success");
                        alert1.setHeaderText(null);
                        alert1.setContentText("New Customer Added Successfully");
                        alert1.showAndWait();
                    }
                    if(tmp==-1){
                        Alert alert4=new Alert(Alert.AlertType.ERROR);
                        alert4.setTitle("Error");
                        alert4.setHeaderText(null);
                        alert4.setContentText("username Exist");
                        alert4.showAndWait();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }   catch (NumberFormatException e){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter number in balance field");
                    alert.showAndWait();
                }
        });
    }

    public void setPerson(Person p){
        person=p;
    }
}
