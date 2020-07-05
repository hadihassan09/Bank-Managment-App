package sample.Classes.databaseClasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class databaseConnection {
    private String DBURL="jdbc:mysql://localhost:3306/bank_system";
    private String DBusername="root";
    private  String DBpassword="root";
    private  Connection connection;
    private static databaseConnection instance;


    private databaseConnection() throws SQLException {
        this.connection=DriverManager.getConnection(this.DBURL,this.DBusername,this.DBpassword);
        System.out.println();
    }

    public Connection getConnection(){
        return connection;
    }

    public static databaseConnection getInstance() throws SQLException{
        if(instance==null){
            instance=new databaseConnection();
        }
        else if(instance.getConnection().isClosed()){
            instance=new databaseConnection();
        }
        return instance;
    }
}
