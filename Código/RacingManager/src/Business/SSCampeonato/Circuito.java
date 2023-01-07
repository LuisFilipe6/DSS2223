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
    //private long tempoMedio;
    private Map<String, Double> dificuldadeCaminho;

    /* Construtores */
    public Circuito()
    {
        this.nome = "";
        this.distancia = 0;
        this.voltas = 0;
        this.temposMedios = new HashMap<String, Long>();
        this.tempoDesvio = 0;
        this.tempoBox = 0;
    }

    public Circuito(String n,int d, int v, Map<String, Long> m, long ds, long b)
    {
        this.nome = n;
        this.distancia = d;
        this.voltas = v;
        HashMap<String,Long> aux = new HashMap<String, Long>();
        if(m == null)
        {
            this.temposMedios = new HashMap<String, Long>();
        }
        else
        {
            for(String g : m.keySet())
            {
                aux.put(g, m.get(g));
            }
        }
        this.temposMedios = aux;
        this.tempoDesvio = ds;
        this.tempoBox = b;

    }
    
    public Circuito(Circuito c)
    {
        this.nome = c.getNome();
        this.distancia = c.getDistancia();
        this.voltas = c.getVoltas();
        this.temposMedios = c.getTemposMedios();
        this.tempoDesvio = c.getTempoDesvio();
        this.tempoBox = c.getTempoBox();
    }
    
    /* Gets e Sets */
    public String getNome()
    {
        return this.nome;
    }
    
    public int getDistancia()
    {
        return this.distancia;
    }
    
    public int getVoltas()
    {
        return this.voltas;
    }
    
    public Map<String,Long> getTemposMedios()
    {
        HashMap<String,Long> aux = new HashMap<String, Long>();
        for(String g : this.temposMedios.keySet())
        {
            aux.put(g, this.temposMedios.get(g));
        }
        return aux;
    }
    
    public long getTempoDesvio()
    {
        return this.tempoDesvio;
    }
    
    public long getTempoBox()
    {
        return this.tempoBox;
    }

    
    public void setNome(String n)
    {
        this.nome = n;
    }
    
    public void setDistancia(int d)
    {
        this.distancia = d;
    }
    
    public void setVoltas(int v)
    {
        this.voltas = v;
    }
    
    public void setTempoDesvio(long ds)
    {
        this.tempoDesvio = ds;
    }
    
    public void setTempoBox(long b)
    {
        this.tempoBox = b;
    }
    

    public void setTempoMedio(String categoria, long tempo)
    {
        this.temposMedios.put(categoria, tempo);
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
        sb.append("\nDistancia: ");sb.append(this.distancia);
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
                this.distancia == c.getDistancia() &&
                this.voltas == c.getVoltas() &&
                //this.tempoMedio == c.getTempoMedio() &&
                this.tempoDesvio == c.getTempoDesvio() &&
                this.tempoBox == c.getTempoBox());
    }
    
}
