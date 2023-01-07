package Business.SSCampeonato;
/**
 * Write a description of class Business.Carros.Carro here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Map;
import java.io.Serializable;
import java.util.Random;

public abstract class Carro implements Comparable<Carro>,Serializable
{
    //Variaveis de instancia
    private int id;
    private String marca;
    private String modelo;
    private int cilindrada;
    private int potencia;
    private int fiabilidade;
    private long tempo;
    private boolean dnf;
    
    /* Construtores */
    public Carro()
    {
        this.id = new Random().nextInt(1000000);
        this.marca = "";
        this.modelo = "";
        this.cilindrada = 0;
        this.potencia = 0;
        this.fiabilidade = 0;
        this.tempo = 0;
        this.dnf = false;
    }
    
    public Carro(int id, String marca, String modelo, int cilindrada, int potencia, int fiabilidade)
    {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.cilindrada = cilindrada;
        this.potencia = potencia;
        this.fiabilidade = fiabilidade;
        this.tempo = 0;
        this.dnf = false;
    }
    
    public Carro(Carro c)
    {
        this.id = c.getId();
       this.marca = c.getMarca();
       this.modelo = c.getModelo();
       this.cilindrada = c.getCilindrada();
       this.potencia = c.getPotencia();
       this.fiabilidade = c.getFiabilidade();
       this.tempo = c.getTempo();
       this.dnf = c.getDNF();
    }
    
    /* Gets e sets */
    public long getTempo()
    {
        return this.tempo;
    }

    public int getId() { return this.id; }
    
    public String getMarca()
    {
        return this.marca;
    }
    
    public String getModelo()
    {
        return this.modelo;
    }
    
    public int getCilindrada()
    {
        return this.cilindrada;
    }
    
    public int getPotencia()
    {
        return this.potencia;
    }
    

    public int getFiabilidade()
    {
        return this.fiabilidade;
    }
    
    public boolean getDNF()
    {
        return this.dnf;
    }
    
    public void setMarca(String marca)
    {
        this.marca = marca;
    }
    
    public void setModelo(String modelo)
    {
        this.modelo = modelo;
    }
    
    public void setCilindrada(int cilindrada)
    {
        this.cilindrada = cilindrada;
    }
    
    public void setPotencia(int potencia)
    {
        this.potencia = potencia;
    }
    

    public void setTempo(long t)
    {
        this.tempo = t;
    }
    
    public void setDNF(boolean b)
    {
        this.dnf = b;
    }
    /* Metodos usuais */
    public abstract Carro clone();
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\nMarca: ");sb.append(this.marca);
        sb.append("\nModelo: ");sb.append(this.modelo);
        sb.append("\nCilindrada: ");sb.append(this.cilindrada);
        sb.append("\nPotencia: ");sb.append(this.potencia);
        sb.append("\nFiabiliade: ");sb.append(this.fiabilidade);
        sb.append("\nTempo: ");sb.append(this.tempo);
        sb.append("\nDNF: ");sb.append(this.dnf);
        return sb.toString();
    }
    
    public boolean equals(Object o)
    {
        if(this==o)
        return true;
        
        if(o==null || this.getClass()!=o.getClass())
        return false;
        
        Carro c = (Carro) o;
        return( this.marca.equals(c.getMarca()) &&
                this.modelo.equals(c.getModelo()) &&
                this.cilindrada == c.getCilindrada() &&
                this.potencia == c.getPotencia() &&
                this.fiabilidade == c.getFiabilidade() &&
                this.tempo == c.getTempo() &&
                this.dnf == c.getDNF());
    }
    
    public int compareTo(Carro c)
    {
        if(this.tempo < c.getTempo())
            return -1;
        if(this.tempo > c.getTempo())
            return 1;
        else 
            return 0;
    }
    
    //Outros metodos
    /**
     * Tempo em milisegundos de uma volta
     */
    public long tempoProximaVolta(Circuito c, int clima, int volta)
    {
        Map<String,Long> aux = c.getTemposMedios();
        long t_medio = aux.get(this.getClass().getName());
        long t_chuva = c.getTempoDesvio();
        long minimum = 0;
        long maximum = 5000;
        long fator_sorte = minimum + Double.valueOf(Math.random()*(maximum-minimum)).intValue();
        long maximum_chuva = 2000;
        long fator_sorte_chuva= minimum + Double.valueOf(Math.random()*(maximum_chuva-minimum)).intValue();
        /** FAZER
        if(volta<(c.getVoltas()/2))
        {

            return (t_medio + ((this.getCilindrada()/this.getPotencia())-p1.getQualidade())*1000) - fator_sorte 
                    + (clima*(t_chuva - p1.getQualidadeChuva()*1000)) - fator_sorte_chuva;
        }
        else
        {   
            if(volta == (c.getVoltas()/2))
            {
                return (t_medio + ((this.getCilindrada()/this.getPotencia())-p2.getQualidade())*1000) - fator_sorte 
                    + (clima*(t_chuva - p2.getQualidadeChuva()*1000)) - fator_sorte_chuva + c.getTempoBox();
            }
            else
            return (t_medio + ((this.getCilindrada()/this.getPotencia())-p2.getQualidade())*1000) - fator_sorte 
                    + (clima*(t_chuva - p2.getQualidadeChuva()*1000)) - fator_sorte_chuva;
        }

         **/
        return 0;
    }
    
    /**
     * define se o carro desiste (true desiste, false continua em prova)
     */
    public abstract boolean DNF(int volta,int totalvoltas,int clima);
    
}
