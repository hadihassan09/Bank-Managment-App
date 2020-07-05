package sample.Classes;

public class Loan {
    private int loanID,accountID,loanAmount,customerIncome;
    private String loanDescription,status;

    public Loan(int loanID, int accountID, int loanAmount, int customerIncome, String loanDescription, String status) {
        this.loanID = loanID;
        this.accountID = accountID;
        this.loanAmount = loanAmount;
        this.customerIncome = customerIncome;
        this.loanDescription = loanDescription;
        this.status = status;
    }
}
