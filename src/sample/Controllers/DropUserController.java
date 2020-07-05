package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Person;
import sample.Classes.Person.Reception;
import sample.Model.dropUserModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DropUserController implements Initializable {
    private dropUserModel dropUserModel;
    private Manager manager;
    private Reception reception;
    private int level;
    private ArrayList<String> list;
    @FXML
    private ListView userList;
    @FXML
    private Button removeBtn;
    @FXML
    private TextField idTXT;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            dropUserModel=new dropUserModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        removeBtn.setOnMouseClicked(mouseEvent -> {
            try {
            if(level==1){
                    if(dropUserModel.removeUserM(manager,Integer.parseInt(idTXT.getText().trim()))==0){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Something Error Please try again later or check customerID If true");
                        alert.showAndWait();
                    }
                    else {
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Succeed!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Customer removed Successfully");
                        alert.showAndWait();
                    }
            }
                if(level==2){
                    if(dropUserModel.removeUserR(reception,Integer.parseInt(idTXT.getText().trim()))==0){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Something Error Please try again later or check customerID If true");
                        alert.showAndWait();
                    }
                    else {
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Succeed!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Customer removed Successfully");
                        alert.showAndWait();
                    }
                }
            } catch (SQLException e) {
                    e.printStackTrace();
                }
            userList.getItems().clear();
            try {
                list=dropUserModel.getUsers();
                for(int i=0;i<list.size();i++){
                    userList.getItems().add(list.get(i));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            idTXT.setText("");

        });
    }

    public void setUser(Person p,int level) throws SQLException {
        this.level=level;
        if(level==1){
            this.manager= (Manager) p;
        }
        if(level==2){
            this.reception= (Reception) p;
        }
        list=dropUserModel.getUsers();

        for(int i=0;i<list.size();i++){
            userList.getItems().add(list.get(i));
        }

    }
}
