package Business.Database;

import java.sql.*;

public class MainDAO {

    private String hostname, username, password, bd;
    private int port;

    private Connection connection;

    public MainDAO(String host, String username, String password, String bd, int port){
        this.hostname = host;
        this.username = username;
        this.password = password;
        this.bd = bd;
        this.port = port;

        //Open database connection
        this.openConnection();
    }

    private void openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://"+ this.hostname +":" + this.port + "/" + this.bd,this.username, this.password);

            this.connection = con;
            System.out.println("Connected with database.");
        } catch(SQLException e){
            System.out.println("Impossible to connect with database: " + e.getMessage());
            this.connection = null;
        } catch (Exception e){
            System.out.println("Impossible to get class: " + e.getMessage());
        }
    }

    public Connection getConnection(){
        return (this.connection);
    }

    public void endConnection() {
        if(this.connection != null) {
            try { this.connection.close();}
            catch (SQLException e){ System.out.println("Impossible to close connection: " + e.getMessage());}
        }
    }

}
