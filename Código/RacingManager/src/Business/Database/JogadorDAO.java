package Business.Database;

import Business.SSUtilizador.Jogador;

import java.sql.*;
import java.util.HashMap;


public class JogadorDAO  {

    private Connection con;

    public JogadorDAO(Connection con){
        this.con = con;
    }

    public Jogador get(int id){
        String sql = "SELECT * FROM jogador WHERE id = ? ";
        try {
            PreparedStatement select = this.con.prepareStatement(sql);
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();

            if(rs.next())
                return new Jogador(rs.getInt(1), rs.getString(2), rs.getString(3));


        } catch (SQLException e){
            System.out.println("Impossible to find user with id = " + id + ": " + e.getMessage());
            return null;
        }


        return null;
    }

    public Jogador get(String nome){
        String sql = "SELECT * FROM jogador WHERE nome = ? ";
        try {
            PreparedStatement select = this.con.prepareStatement(sql);
            select.setString(1, nome);
            ResultSet rs = select.executeQuery();

            if(rs.next())
                return new Jogador(rs.getInt(1), rs.getString(2), rs.getString(3));


        } catch (SQLException e){
            System.out.println("Impossible to find user with nome = " + nome + ": " + e.getMessage());
            return null;
        }


        return null;
    }
    public int put(String nome, String password){
        if(this.get(nome) != null){
            return -1; // VERIFICAR NA AULA
        }

        String sql = "INSERT INTO jogador (`nome`, `password`)" +
                "                      VALUES (?, ?)";
        try {
            PreparedStatement insert = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            insert.setString(1, nome);
            insert.setString(2, password);
            int error = insert.executeUpdate();

            if(error != 0) {
                try (ResultSet rs = insert.getGeneratedKeys()) {
                    if (rs.next()) {
                        return rs.getInt(1);
                    }
                }
            }


        } catch (SQLException e){
            System.out.println("Impossible to add user: " + e.getMessage());
            return -1;
        }

        return -1;
    }

    public boolean remove(int id){
        String query = "DELETE from jogador WHERE id = ?";
        try {
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, id);

            if(preparedStmt.execute())
                return true;
        } catch (SQLException e){
            System.out.println("Impossible to delete user: " + e.getMessage());
        }

        return false;
    }


}
