package sample.Classes;

public class TransactionLog {
    private int transactionID;
    private int customerID;
    private int accountID;
    private int transactionTypeID;
    private String transactionDate;
    private int transactionAmount;
    private int newBalance;

    public TransactionLog(int transactionID,int customerID,int accountID,int transactionTypeID,String transactionDate,int transactionAmount,int newBalance){
        this.transactionID=transactionID;
        this.customerID=customerID;
        this.accountID=accountID;
        this.transactionTypeID=transactionTypeID;
        this.transactionDate=transactionDate;
        this.transactionAmount=transactionAmount;
        this.newBalance=newBalance;
    }
    

    public int getAccountID(){
        return this.accountID;
    }

    public int getCustomerID(){
        return this.customerID;
    }


    public void setAccountID(int accountID){
        this.accountID=accountID;
    }

    public void setCustomerID(int customerID){
        this.customerID=customerID;
    }

}
