package sample.Classes.Person;

import sample.Classes.Account.Account;
import sample.Classes.databaseClasses.databaseConnection;

import java.sql.SQLException;

public abstract class Person {
    private int personID;
    private String firstName,middleName,lastName;
    private String city,country;
    private String address1,address2;
    private String emailAddress;
    private String homePhone,workPhone;
    private Account account;
    private databaseConnection databaseConnection;

    public Person(int personID,String fn,String mn,String ln,String add1,String add2,String city,String country,String emailAddres,String homePhone,String workPhone,Account account) throws SQLException {
        this.personID=personID;
        this.firstName=fn;
        this.middleName=mn;
        this.lastName=ln;
        this.city=city;
        this.country=country;
        this.address1=add1;
        this.address2=add2;
        this.emailAddress=emailAddres;
        this.homePhone=homePhone;
        this.workPhone=workPhone;
        this.account=account;
        databaseConnection= sample.Classes.databaseClasses.databaseConnection.getInstance();

    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public sample.Classes.databaseClasses.databaseConnection getDatabaseConnection() {
        return databaseConnection;
    }

    public void setDatabaseConnection(sample.Classes.databaseClasses.databaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }
}
