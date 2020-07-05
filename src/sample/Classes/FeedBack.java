package sample.Classes;

public class FeedBack {
    int feedBackID,accountID;
    String feedBackDescription;

    public FeedBack(int feedBackID, int accountID, String feedBackDescription) {
        this.feedBackID = feedBackID;
        this.accountID = accountID;
        this.feedBackDescription = feedBackDescription;
    }


    public int getAccountID() {
        return accountID;
    }

    public int getFeedBackID() {
        return feedBackID;
    }

    public String getFeedBackDescription() {
        return feedBackDescription;
    }
}
