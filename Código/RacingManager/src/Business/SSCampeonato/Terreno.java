package Business.SSCampeonato;

public class Terreno {
    private int tipo; // 0-reta, 1-curva, 2-chincane
    private int dificuldade; // 0-facil, 1-medio ...

    public Terreno(){
        this.tipo = 0;
        this.dificuldade = 0;
    }

    public Terreno(int t, int d){
        this.tipo = t;
        this.dificuldade = d;
    }

    public int getTipo(){
        return this.tipo;
    }

    public int getDificuldade(){
        return this.dificuldade;
    }

    public void setTipo(int t){
        this.tipo = t;
    }

    public void setDificuldade(int d){
        this.dificuldade = d;
    }
}
