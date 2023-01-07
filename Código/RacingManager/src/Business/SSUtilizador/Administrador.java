package Business.SSUtilizador;

import java.util.Random;

public class Administrador extends Jogador {

    public Administrador()
    {
        super();
    }

    public Administrador(int id, String nome, String password)
    {
        super(id, nome, password);
    }

    public Administrador(Administrador a)
    {
        self(a.getId(), a.getNome(), a.getPassword());
    }
    public boolean isAdmin(){
        return true;
    }
}
