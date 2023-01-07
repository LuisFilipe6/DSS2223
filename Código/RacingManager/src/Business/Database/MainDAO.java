package Business.Database;

import java.sql.*;

public class MainDAO {

    private String hostname, username, password, bd;
    private int port;

    private Connection connection;

    public MainDAO(){
        //Open database connection
        this.openConnection();
    }

    private void openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    DAOConfig.URL,this.username, this.password);

            this.connection = con;
            System.out.println("Connected with database.");

            this.createTables();
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


    private void createTables(){
        //Users
        try {
            Statement stmt = this.connection.createStatement();

            String sql_user = "CREATE TABLE `jogador` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `nome` varchar(255) NOT NULL,\n" +
                    "  `password` varchar(255) NOT NULL,\n" +
                    "  `classificacao` int(11) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            stmt.executeQuery(sql_user);

            String sql_campeonato = "CREATE TABLE `campeonato` (\n" +
                    "  `participantes` varchar(2555) NOT NULL,\n" +
                    "  `nome` varchar(255) NOT NULL,\n" +
                    "  `lista_corridas` varchar(255) NOT NULL,\n" +
                    "  `pilotos` varchar(255) NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
            stmt.executeQuery(sql_campeonato);

            String sql_carro = "CREATE TABLE `carro` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `tipo_carro` tinyint(1) NOT NULL,\n" +
                    "  `marca` varchar(255) NOT NULL,\n" +
                    "  `modelo` varchar(255) NOT NULL,\n" +
                    "  `cilindrada` int(11) NOT NULL,\n" +
                    "  `potencia` int(11) NOT NULL,\n" +
                    "  `numero_voltas` int(11) NOT NULL,\n" +
                    "  `dnf` tinyint(1) NOT NULL,\n" +
                    "  `pneu` enum('CHUVA','MACIO','DURO') NOT NULL,\n" +
                    "  `motor` enum('CONSERVADOR','NORMAL','AGRESSIVO') NOT NULL,\n" +
                    "  `pac` double NOT NULL,\n" +
                    "  `downforce` double NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\n";
            stmt.executeQuery(sql_carro);

            String sql_piloto = "CREATE TABLE `piloto` (\n" +
                    "  `id` int(11) NOT NULL,\n" +
                    "  `nome` varchar(255) NOT NULL,\n" +
                    "  `sva` double NOT NULL\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;\n";

            stmt.executeQuery(sql_piloto);

            System.out.println("Created all tables successfully ! ");


        } catch (SQLException e) {
            System.out.println("Error while creating: " + e.getMessage());
        }

    }

    public void endConnection() {
        if(this.connection != null) {
            try { this.connection.close();}
            catch (SQLException e){ System.out.println("Impossible to close connection: " + e.getMessage());}
        }
    }

}
