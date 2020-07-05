package sample.Classes;

public class transactionList {
    int transactionID,accountID,transactionAmount,newBalance,transactionFeeAmount;
    String transactionDate,transactionDescription;

    public transactionList(int transactionID,int accountID,String transactionDate,int transactionAmount,int newBalance,String transactionDescription,int transactionFeeAmount){
        this.transactionID=transactionID;
        this.accountID=accountID;
        this.transactionDate=transactionDate;
        this.transactionAmount=transactionAmount;
        this.newBalance=newBalance;
        this.transactionDescription=transactionDescription;
        this.transactionFeeAmount=transactionFeeAmount;
    }

    public int getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(int transactionID) {
        this.transactionID = transactionID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(int transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public int getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(int newBalance) {
        this.newBalance = newBalance;
    }

    public int getTransactionFeeAmount() {
        return transactionFeeAmount;
    }

    public void setTransactionFeeAmount(int transactionFeeAmount) {
        this.transactionFeeAmount = transactionFeeAmount;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }
}
