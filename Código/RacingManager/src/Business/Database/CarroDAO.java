package Business.Database;

import Business.SSCampeonato.Carro;
import Business.SSCampeonato.PC2H;
import Business.SSCampeonato.SC;
import Business.SSUtilizador.Jogador;

import java.sql.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


public class CarroDAO implements Map {

    private Connection con;

    public CarroDAO(){
        this.con = new MainDAO().getConnection();
    }

    public Carro get(int id){
        String sql = "SELECT * FROM carros WHERE id= ? ";
        try {
            PreparedStatement select = this.con.prepareStatement(sql);
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                String marca = rs.getString(3);
                String modelo = rs.getString(4);
                Integer cilindrada = rs.getInt(5);
                Integer potencia = rs.getInt(6);
                if(rs.getString(2).equals("SC")){
                    return new SC(marca, modelo, cilindrada, potencia);
                }
                //String marca, String modelo, int cilindrada, int potencia, int p_mecanica, int eletrico
                //criar funçao
                if(rs.getString(2).equals("PC2H")){
                    return new PC2H(marca, modelo, cilindrada, potencia, 0, 0);
                }
                if(rs.getString(2).equals("SC")){
                    return new SC(marca, modelo, cilindrada, potencia);
                }
                if(rs.getString(2).equals("SC")){
                    return new SC(marca, modelo, cilindrada, potencia);
                }

            }



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


    @Override
    public int size() {
        int size = 0;
        String query = "SELECT count(*)  from jogador";
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
