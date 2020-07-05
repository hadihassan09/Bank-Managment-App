package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import sample.Classes.Person.Manager;
import sample.Model.removeReciptionModel;

import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RemoveReciptionController implements Initializable {
    private removeReciptionModel removeReciptionModel;
    private Manager manager;
    private ArrayList<String> list;
    @FXML
    private Button removeBtn;
    @FXML
    private ListView receptionList;
    @FXML
    private TextField idTXT;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            removeReciptionModel=new removeReciptionModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        removeBtn.setOnMouseClicked(mouseEvent -> {
            try {
                if(removeReciptionModel.removeReception(manager,Integer.parseInt(idTXT.getText().trim()))==0){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR!!");
                    alert.setHeaderText(null);
                    alert.setContentText("Something Error Please try again later or check receptionID If true");
                    alert.showAndWait();
                }
                else {
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Succeed!!");
                    alert.setHeaderText(null);
                    alert.setContentText("Reception removed Successfully");
                    alert.showAndWait();
                }
                list=removeReciptionModel.getReception();
                receptionList.getItems().clear();
                for(int i=0;i<list.size();i++)
                    receptionList.getItems().add(list.get(i));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            idTXT.setText("");
        });
    }

    public void setManager(Manager manager) throws SQLException {
        this.manager=manager;
        list=removeReciptionModel.getReception();
        for(int i=0;i<list.size();i++)
            receptionList.getItems().add(list.get(i));
    }
}
