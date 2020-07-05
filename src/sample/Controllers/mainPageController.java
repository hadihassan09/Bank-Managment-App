package sample.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.Classes.Person.Customer;
import sample.Classes.Person.Manager;
import sample.Classes.Person.Reception;

import sample.Model.mainPageModel;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class mainPageController implements Initializable {
    private Manager manager;
    private Reception receptionist;
    private Customer customer;
    private int level;
    @FXML
    private BorderPane borderPane;
    @FXML
    private Label usernameLabel,addUserBtn,dropUserBtn;
    @FXML
    private Label addReceptionBtn,removeReceptionBtn;
    @FXML
    private Label logoutBtn;
    @FXML
    private Label transferMoneyBtn,checkCurrentBalanceBtn,depositMoneyBtn,withdrawMoneyBtn,transactionsHistoryBtn,showAllClientsBtn;
    @FXML
    private Button getAccountIDBtn;
    private mainPageModel mainPageModel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            mainPageModel=new mainPageModel();
        } catch (SQLException e) { e.printStackTrace(); }

        getAccountIDBtn.setOnMouseClicked(mouseEvent -> {
            int accountID=0;
                try {
                    if(level==1){
                        accountID=mainPageModel.getID(manager,level);
                    }
                    if(level==2){
                        accountID=mainPageModel.getID(receptionist,level);
                    }
                    if(level==3){
                        accountID=mainPageModel.getID(customer,level);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(accountID==0){
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText(null);
                    alert.setContentText("Something went Error please try again later");
                    alert.showAndWait();
                    Parent root11= null;
                    try {
                        root11 = FXMLLoader.load(getClass().getResource("../Views/title_bar.fxml"));
                        Scene loginScene=new Scene(root11,800,650);
                        Stage second=new Stage();
                        second.setScene(loginScene);
                        Stage current= (Stage) logoutBtn.getScene().getWindow();
                        current.close();
                        second.show();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else{
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Getting AccountID");
                    alert.setHeaderText(null);
                    alert.setContentText("Your AccountID is : "+accountID);
                    alert.showAndWait();
                }
        });

        checkCurrentBalanceBtn.setOnMouseClicked(even->{
            if(level==3) {
                try {
                    FXMLLoader loader1 = new FXMLLoader(getClass().getResource("../Views/checkCurrentBalance.fxml"));
                    Parent root1 = loader1.load();
                    checkCurrentBalanceController checkCurrentBalanceController = loader1.getController();
                    checkCurrentBalanceController.setUsername(customer);
                    borderPane.setCenter(root1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/checkLoans.fxml"));
                    Parent root = loader.load();
                    CheckLoansController checkLoansController = loader.getController();
                        if (level == 1) {
                            checkLoansController.setManager(manager, level);
                        } else if (level == 2) {
                            checkLoansController.setReception(receptionist, level);
                        }
                    borderPane.setCenter(root);
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }

            }
        });

        depositMoneyBtn.setOnMouseClicked(event->{
            if (level == 3) {
                FXMLLoader loader=new FXMLLoader(getClass().getResource("../Views/requestLoan.fxml"));
                try {
                    Parent root=loader.load();
                    RequestLoanController requestLoanController=loader.getController();
                    requestLoanController.setCustomer(customer);
                    borderPane.setCenter(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                try {
                    FXMLLoader loader2 = new FXMLLoader(getClass().getResource("../Views/depositMoney.fxml"));
                    Parent root2 = loader2.load();
                    DepositMoneyController depositMoneyController = loader2.getController();

                    if (level == 1)
                        depositMoneyController.setUserName(manager, level);

                    if (level == 2)
                        depositMoneyController.setUserName(receptionist, level);

                    if (level == 3)
                        depositMoneyController.setUserName(customer, level);

                    borderPane.setCenter(root2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        withdrawMoneyBtn.setOnMouseClicked(even->{
            if(level==3) {
                FXMLLoader loader3 = new FXMLLoader(getClass().getResource("../Views/withdrawMoney.fxml"));
                Parent root3 = null;
                try {
                    root3 = loader3.load();
                    WithdrawMoneyController withdrawMoneyController = loader3.getController();
                    withdrawMoneyController.setUserName(customer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                borderPane.setCenter(root3);
            }
            else {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../Views/checkFeedBacks.fxml"));
                    Parent root=loader.load();
                    CheckFeedBacksController checkFeedBacksController=loader.getController();
                    if(level==1){
                        checkFeedBacksController.setManager(manager,level);
                    } else if (level == 2) {
                        checkFeedBacksController.setReception(receptionist,level);
                    }
                    borderPane.setCenter(root);
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        transactionsHistoryBtn.setOnMouseClicked(event->{
            FXMLLoader loader4=new FXMLLoader(getClass().getResource("../Views/transactionsHistory.fxml"));
            Parent root4= null;
            try {
                root4 = loader4.load();
                transactionsHistory transactionsHistory=loader4.getController();
                if(level==1) {
                    transactionsHistory.setUsername(manager, level);
                }
                if(level==2){
                    transactionsHistory.setUsername(receptionist,level);
                }
                if(level==3){
                    transactionsHistory.setUsername(customer,level);
                }
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
            borderPane.setCenter(root4);
        });

        transferMoneyBtn.setOnMouseClicked(mouseEvent -> {
            FXMLLoader loader11=new FXMLLoader(getClass().getResource("../Views/transferMoney.fxml"));
            try {
                Parent root11=loader11.load();
                transferMoneyController transferMoneyController=loader11.getController();
                if (level == 1) {
                    transferMoneyController.setUser(manager,level);
                }
                if (level == 2) {
                    transferMoneyController.setUser(receptionist,level);
                }
                if (level == 3) {
                    transferMoneyController.setUser(customer,level);
                }
                borderPane.setCenter(root11);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        showAllClientsBtn.setOnMouseClicked(event->{
            try {
                FXMLLoader loader6=new FXMLLoader(getClass().getResource("../Views/showAllClients.fxml"));
                Parent root6 = loader6.load();
                ShowAllClientsController showAllClientsController=loader6.getController();
                if (level == 1) {
                    showAllClientsController.setManager(manager,level);
                } else if (level == 2) {
                    showAllClientsController.setReception(receptionist,level);
                }
                borderPane.setCenter(root6);
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });

        addReceptionBtn.setOnMouseClicked(event->{
            Parent root7= null;
            try {
                FXMLLoader loader7=new FXMLLoader(getClass().getResource("../Views/addReciption.fxml"));
                root7 = loader7.load();
                AddReciptionController addReciptionController=loader7.getController();
                addReciptionController.setManager(manager);
            } catch (IOException e) {
                e.printStackTrace();
            }
            borderPane.setCenter(root7);
        });

        removeReceptionBtn.setOnMouseClicked(event->{

            try {
                FXMLLoader loader8=new FXMLLoader(getClass().getResource("../Views/removeReciption.fxml"));
                Parent root8= null;
                root8 = loader8.load();
                RemoveReciptionController removeReciptionController=loader8.getController();
                removeReciptionController.setManager(manager);
                borderPane.setCenter(root8);

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        });

        addUserBtn.setOnMouseClicked( event -> {
            try {
                FXMLLoader loader9=new FXMLLoader(getClass().getResource("../Views/signUpPage.fxml"));
                Parent root9=loader9.load();
                signUpController signUpController=loader9.getController();
                if(level==1){
                    signUpController.setPerson(manager);
                }
                if(level==2){
                    signUpController.setPerson(receptionist);
                }

                borderPane.setCenter(root9);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        dropUserBtn.setOnMouseClicked(event->{
            if(level==3){
                try {
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("../Views/sendFeedBack.fxml"));
                    Parent root=loader.load();
                    SendFeedBackController sendFeedBackController=loader.getController();
                    sendFeedBackController.setCustomer(customer);
                    borderPane.setCenter(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            else {
                try {
                    FXMLLoader loader10 = new FXMLLoader(getClass().getResource("../Views/dropUser.fxml"));
                    Parent root10 = loader10.load();
                    DropUserController dropUserController = loader10.getController();
                    if (level == 1) {
                        dropUserController.setUser(manager, level);
                    }
                    if (level == 2)
                        dropUserController.setUser(receptionist, level);

                    borderPane.setCenter(root10);
                } catch (IOException | SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        logoutBtn.setOnMouseClicked(event->{
            Parent root11= null;
            try {
                root11 = FXMLLoader.load(getClass().getResource("../Views/title_bar.fxml"));
                Scene loginScene=new Scene(root11,800,650);
                Stage second=new Stage();
                second.setScene(loginScene);
                Stage current= (Stage) logoutBtn.getScene().getWindow();
                current.close();
                second.setResizable(false);
                second.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    public void setUsername(String txt) throws SQLException {
        usernameLabel.setText(txt);

        if((level=mainPageModel.checkLevel(usernameLabel.getText()))==1) {
                addUserBtn.setMouseTransparent(false);
                dropUserBtn.setMouseTransparent(false);
                addReceptionBtn.setMouseTransparent(false);
                removeReceptionBtn.setMouseTransparent(false);
                showAllClientsBtn.setMouseTransparent(false);
                //checkCurrentBalanceBtn.setMouseTransparent(true);
                //checkCurrentBalanceBtn.setStyle("-fx-text-fill: #a9a9a9;");
                //withdrawMoneyBtn.setMouseTransparent(true);
                //withdrawMoneyBtn.setStyle("-fx-text-fill: #a9a9a9;");
                withdrawMoneyBtn.setText("Check FeedBacks");
                checkCurrentBalanceBtn.setText("Check Loans");
                manager=mainPageModel.createManager(txt);
            }

        if(level==2){
                addUserBtn.setMouseTransparent(false);
                dropUserBtn.setMouseTransparent(false);
                showAllClientsBtn.setMouseTransparent(false);
                 addReceptionBtn.setMouseTransparent(true);
                addReceptionBtn.setStyle("-fx-text-fill: #a9a9a9;");
                removeReceptionBtn.setMouseTransparent(true);
                removeReceptionBtn.setStyle("-fx-text-fill: #a9a9a9;");
               // checkCurrentBalanceBtn.setMouseTransparent(true);
               // checkCurrentBalanceBtn.setStyle("-fx-text-fill: #a9a9a9;");
               // withdrawMoneyBtn.setMouseTransparent(true);
               // withdrawMoneyBtn.setStyle("-fx-text-fill: #a9a9a9;");
                 withdrawMoneyBtn.setText("Check FeedBacks");
                checkCurrentBalanceBtn.setText("Check Loans");

                receptionist=mainPageModel.createReception(txt);
        }

        else if(level==3){
                addUserBtn.setMouseTransparent(true);
                addUserBtn.setStyle("-fx-text-fill: #a9a9a9;");
             //   dropUserBtn.setMouseTransparent(true);
              //  dropUserBtn.setStyle("-fx-text-fill: #a9a9a9;");
                addReceptionBtn.setMouseTransparent(true);
                addReceptionBtn.setStyle("-fx-text-fill: #a9a9a9;");
                removeReceptionBtn.setMouseTransparent(true);
                removeReceptionBtn.setStyle("-fx-text-fill: #a9a9a9;");
                showAllClientsBtn.setMouseTransparent(true);
                showAllClientsBtn.setStyle("-fx-text-fill: #a9a9a9;");
                //depositMoneyBtn.setMouseTransparent(true);
                //depositMoneyBtn.setStyle("-fx-text-fill: #a9a9a9;");
            depositMoneyBtn.setText("Request Loan");
                dropUserBtn.setText("Send FeedBack");
                this.customer=mainPageModel.createCustomer(txt);
            }
    }

}
