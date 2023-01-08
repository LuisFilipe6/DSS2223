package Business.Database;

import Business.SSCampeonato.Circuito;
import Business.SSUtilizador.Administrador;
import Business.SSUtilizador.Jogador;
import Business.SSUtilizador.Utilizador;

import java.sql.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class CircuitoDAO implements Map {

    private Connection con;

    public static CircuitoDAO singleton;

    public CircuitoDAO(){
        this.con = new MainDAO().getConnection();
    }

    public static void buildInstance(){
        if(CircuitoDAO.singleton == null)
            CircuitoDAO.singleton = new CircuitoDAO();
    }

    public Circuito get(String id){
        String sql = "SELECT * FROM circuito WHERE id = ? ";
        try {
            PreparedStatement select = this.con.prepareStatement(sql);
            select.setString(1, id);
            ResultSet rs = select.executeQuery();

            if(rs.next())
                return new Circuito(rs.getString(0), rs.getString(1)
                        rs.getInt(1), rs.getString(2), rs.getString(3));


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
                return new  Circuito(rs.getString("id"), rs.getString("nome"),
                        rs.getInt("Chicane"), rs.getInt("Retas"), rs.getInt("Curvas"),
                        rs.getInt("Distancia"),
                        rs.getInt("Nvoltas"), rs.getDouble("Tempomedio"),
                        rs.getDouble("Record"), rs.getDouble("TempoBox"),
                        rs.getDouble("TempoDesvio"), rs.getString("DificuldadeRetas"),
                        rs.getString("DificuldadeCurvas"));

        return throw
        } catch (SQLException e){
            System.out.println("Impossible to find user with nome = " + nome + ": " + e.getMessage());
            return null;
        }


        return null;
    }

    public int put(String nome, String password, int admin){
        if(this.get(nome) != null){
            return -1; // VERIFICAR NA AULA
        }

        String sql = "INSERT INTO jogador (`nome`, `password`, `admin`)" +
                "                      VALUES (?, ?, ?)";
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


    @Override
    public int size() {
        int size = 0;
        String query = "SELECT count(*)  from circuitos";
        try {
            PreparedStatement preparedStmt = this.con.prepareStatement(query);

            ResultSet rs = preparedStmt.executeQuery();

            if(rs.next())
                size = rs.getInt(1);

        } catch (SQLException e){
            System.out.println("Impossible to delete user: " + e.getMessage());
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size() == 0) return true; else return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object key) {
        if(key instanceof String) {
            return get((String) key);
        }
        if(key instanceof Integer) {
            return get((Integer) key);
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        return null;
    }

    @Override
    public Object remove(Object key) {
        if(!(key instanceof Integer)) return null;
        String query = "DELETE from jogador WHERE id = ?";
        try {
            PreparedStatement preparedStmt = this.con.prepareStatement(query);
            preparedStmt.setInt(1, (Integer) key);

            if(preparedStmt.execute())
                return true;
        } catch (SQLException e){
            System.out.println("Impossible to delete user: " + e.getMessage());
        }

        return false;
    }


    /* Do I need to define */
    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Entry> entrySet() {
        return null;
    }
}
