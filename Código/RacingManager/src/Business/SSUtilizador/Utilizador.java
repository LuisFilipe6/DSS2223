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

    public abstract boolean isAdmin();

}
