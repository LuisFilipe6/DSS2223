package Business.SSUtilizador;

import java.util.Random;

public abstract class Utilizador {

    private int id;
    private String nome;
    private String password;

    public Utilizador(){
        this(new Random().nextInt(10000), "", "");
    }
    public Utilizador(int id, String nome, String password){
        this.id = id;
        this.nome = nome;
        this.password = password;
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getPassword(){
        return this.password;
    }

    public void setId(int id){ this.id = id; }
    public void setNome(String nome){ this.nome = nome; }
    public void setPassword(String pass){ this.password = pass; }


    public abstract boolean isAdmin();

}
