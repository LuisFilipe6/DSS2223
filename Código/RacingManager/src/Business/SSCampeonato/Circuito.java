package Business.SSCampeonato;
/**
 * Write a description of class Business.SSCampeonato.Circuito here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.Serializable;

public class Circuito implements Serializable
{
    /* Variaveis instancia */
    private String nome;
    private int voltas;
    private Map<String, Double> dificuldadeCaminho;

    /* Construtores */
    public Circuito()
    {
        this.nome = "";
        this.voltas = 0;
        this.dificuldadeCaminho = new HashMap<>();

    }

    public Circuito(String n, int v, Map<String, Double> m)
    {
        this.nome = n;
        this.voltas = v;
        HashMap<String,Double> aux = new HashMap<>();
        if(m == null)
        {
            for(String s : m.keySet()){
                aux.put(s, m.get(s));
            }
        }
        this.dificuldadeCaminho = aux;
    }
    
    public Circuito(Circuito c)
    {
        this.nome = c.getNome();
        this.voltas = c.getVoltas();
        this.dificuldadeCaminho = c.getDficuldadesCaminho();
    }
    
    /* Gets e Sets */
    public String getNome()
    {
        return this.nome;
    }

    public int getVoltas()
    {
        return this.voltas;
    }

    public Map<String, Double> getDficuldadesCaminho()
    {
        return this.dificuldadeCaminho;
    }

    
    public void setNome(String n)
    {
        this.nome = n;
    }

    public void setVoltas(int v)
    {
        this.voltas = v;
    }

    public void setDificuldadeCaminho(HashMap<String, Double> b)
    {
        this.dificuldadeCaminho = b;
    }

    /* Metodos usuais */
    public Circuito clone()
    {
        return new Circuito(this);
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nNome: ");sb.append(this.nome);
        sb.append("\nNumero de voltas: ");sb.append(this.voltas);
        //sb.append("\nTempo Medio: ");sb.append(TimeConverter.toTimeFormat(this.tempoMedio));
        return sb.toString();
    }
    
    public boolean equals(Object o)
    {
       if(this == o)
       return true;
       
       if(o == null || this.getClass() != o.getClass())
       return false;
       
       Circuito c = (Circuito) o;
       return ( this.nome.equals(c.getNome()) &&
               this.voltas == c.getVoltas() &&
                this.dificuldadeCaminho == c.getDficuldadesCaminho());
    }
    
}
