package Business.SSUtilizador;

import java.util.Random;

public class Administrador extends Utilizador {

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
        super(a.getId(), a.getNome(), a.getPassword());
    }
    public boolean isAdmin(){
        return true;
    }
}
