package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Model.titleBarModel;


import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TitleBarController implements Initializable {
    private titleBarModel titleBarModel;
    @FXML
    private TextField emailTXT;
    @FXML
    private PasswordField passwordTXT;
    @FXML
    private Button loginBtn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            titleBarModel=new titleBarModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        loginBtn.setOnAction(event -> {
            Parent root= null;
            String userName=emailTXT.getText();
            String password=passwordTXT.getText();
            try {

                if(titleBarModel.check(userName,password)==false){//Wrong username or password
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Failed to Login");
                    alert.setHeaderText("Wrong username or Password");
                    alert.setContentText("Please check them");
                    alert.showAndWait();
                }

                else {//go to the mainPage Activity after check done
                    try {
                        FXMLLoader loader=new FXMLLoader(getClass().getResource("../Views/mainPage.fxml"));
                        root =loader.load();
                        mainPageController mainPageController=loader.getController();

                        Stage stage = new Stage();
                        stage.setTitle("MainPage");
                        stage.setScene(new Scene(root, 1300, 750));
                        mainPageController.setUsername(emailTXT.getText());
                        stage.show();
                        stage.setResizable(false);
                        ((Node) event.getSource()).getScene().getWindow().hide();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        });

    }
}

