package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Classes.Person.Customer;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Person;
import sample.Classes.Person.Reception;
import sample.Model.depositMoneyModel;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DepositMoneyController implements Initializable {
    private depositMoneyModel depositMoneyModel;
    private Customer customer;
    private Reception reception;
    private Manager manager;
    private int level;
    @FXML
    private Label valueText;
    @FXML
    private Button posBtn,negBtn,addBtn;
    @FXML
    private TextField accountIDTXT;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            depositMoneyModel=new depositMoneyModel();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        valueText.setText(0+"");

        posBtn.setOnMouseClicked(mouseEvent -> {
            int tmp=Integer.parseInt(valueText.getText().trim());
            if(tmp<100000000)
                tmp+=500;
            valueText.setText(tmp+"");
        });

        negBtn.setOnMouseClicked(mouseEvent -> {
            int tmp=Integer.parseInt(valueText.getText().trim());
            if(tmp>0)
                tmp-=500;
            valueText.setText(tmp+"");
        });

        addBtn.setOnMouseClicked(mouseEvent -> {
            int tmp=Integer.parseInt(valueText.getText().trim());

                try {
                    int res=0;
                    if(level==1) {
                         res=depositMoneyModel.deposit(manager,level,accountIDTXT.getText().trim(),tmp);
                    }
                    if(level==2)
                       res= depositMoneyModel.deposit(reception,level,accountIDTXT.getText().trim(),tmp);

                    if(level==3)
                       res= depositMoneyModel.deposit(customer,level,accountIDTXT.getText().trim(),tmp);

                    if(res==0){
                        Alert alert=new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Error!!");
                        alert.setHeaderText(null);
                        alert.setContentText("AccountID Not Exist!");
                        alert.showAndWait();
                    }
                    else if (res==1){
                        Alert alert=new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Success!!");
                        alert.setHeaderText(null);
                        alert.setContentText("Deposit is Done successfully!");
                        alert.showAndWait();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        });
    }

    public void setUserName(Person p,int level){
        if(level==1)
            manager= (Manager) p;

        if(level==2)
            reception = (Reception) p;

        if(level==3)
            customer= (Customer) p;

        this.level=level;
    }
}
