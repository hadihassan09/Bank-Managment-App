package sample.Classes;

import sample.Classes.Account.Account;

public class AccountType {
    int accountTypeID;
    String accountTypeDescription;

    public AccountType(int accountTypeID){
        this.accountTypeID=accountTypeID;
        if(accountTypeID==0){
            this.accountTypeDescription="manager";
        }
        if(accountTypeID==1){
            this.accountTypeDescription="reception";
        }
        else {
            this.accountTypeDescription="customer";
        }
    }

    public int getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(int accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public String getAccountTypeDescription() {
        return accountTypeDescription;
    }

    public void setAccountTypeDescription(String accountTypeDescription) {
        this.accountTypeDescription = accountTypeDescription;
    }
}
