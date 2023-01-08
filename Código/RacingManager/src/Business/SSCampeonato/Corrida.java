package Business.SSCampeonato;
/**
 * Write a description of class Business.SSCampeonato.Corrida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import Business.Database.CircuitoDAO;
import Business.Database.UtilizadorDAO;
import Business.SSUtilizador.Utilizador;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.Random;
import java.util.Iterator;
import java.io.Serializable;

public class Corrida implements Serializable
{
   //variaveis de instancia
    private String id_Corrida;
   private List<Carro> listaCarros;
   private Circuito circuito;
   private Set<Carro> resultados;
   //private Map<Business.Carros.Carro,Long> bestLap;
   private List<Carro> primeiro_da_Volta;
   private Map<Carro, Integer> dnf;
   private int clima; //1-chove 0-sol

   //Construtores
   public Corrida()
   {
       this.id_Corrida = "#" + Math.random();
       this.listaCarros = new ArrayList<Carro>();
       this.circuito = new Circuito();
       this.resultados = new TreeSet<Carro>();
       //this.bestLap = new HashMap<Business.Carros.Carro,Long>();
       this.primeiro_da_Volta = new ArrayList<Carro>();
       this.dnf = new HashMap<Carro,Integer>();
       Random rand=new Random();
       int x=rand.nextInt(2);
       this.clima = x;
   }
   
   
   public Corrida(List<Carro> l, Circuito c)
   {
       this();
       for(Carro car: l)
       {
           this.listaCarros.add(car);
           this.resultados.add(car.clone());
           this.primeiro_da_Volta.add(car.clone());
       }
       this.circuito = c.clone();
       //this.clima = clima;
   }



   public Corrida(Corrida c)
   {
       this.id_Corrida = c.id_Corrida;
       this.listaCarros = c.getCarros();
       this.circuito = c.getCircuito();
       this.resultados = c.getResultados();
       this.primeiro_da_Volta = c.getPrimeiroVolta();
       this.dnf = c.getDNF();
       this.clima = c.getClima();
   }
   
   
   //Gets e sets
   public List<Carro> getCarros()
   {
       ArrayList<Carro> aux = new ArrayList<Carro>();
       for(Carro c: this.listaCarros)
       {
           aux.add(c.clone());
       }
       return aux;
   }
   
   public Circuito getCircuito()
   {
       return this.circuito.clone();
   }
   
   
   public Set<Carro> getResultados()
   {
       TreeSet<Carro> aux = new TreeSet<Carro>();
       for(Carro c : this.resultados)
       {
           aux.add(c.clone());
       }
       return aux;
   }
   
   public Map<Carro,Integer> getDNF()
   {
       HashMap<Carro,Integer> aux = new HashMap<Carro,Integer>();
       for(Carro c : this.dnf.keySet())
       {
           aux.put(c.clone(), this.dnf.get(c));
        }
        return aux;
   }
   
   public int getClima()
   {
       return this.clima;
   }
   
   
   public List<Carro> getPrimeiroVolta()
   {
       ArrayList<Carro> aux = new ArrayList<Carro>();
       for(Carro c : this.primeiro_da_Volta)
       {
           aux.add(c.clone());
       }
       return aux;
   }
   
   
   public void setCircuito(Circuito c)
   {
       this.circuito = c.clone();
   }
   
   //Metodos
   
   public Corrida clone()
   {
       return new Corrida(this);
    }
   
   /**
     * Adicionar um carro á lista
     */
    public void adicionarCarro(Carro c)
    {
        this.listaCarros.add(c.clone());
    }
    
    /**
     * adicionar lista de carros
     */
    public void adicionarCarro(List<Carro> l)
    {
        for(Carro c : l)
        {
            this.listaCarros.add(c.clone());
        }
    }
    
    /**
     * Numero total de carros
     */
    public int totalCarros()
    {
        return this.listaCarros.size();
    }
    
    /**
     * Remover um carro
     */
    public void removerCarro(Carro c)
    {
        this.listaCarros.remove(c);
    }
    
    /**
     * Limpa a lista de carros
     */
    public void limpaListaCarros()
    {
      this.listaCarros.clear();
    }
    
    /**
     * Simula a corrida
     */   
    public void simulaCorrida()
    {
        int voltas = this.circuito.getVoltas();
        long t_aux, t_volta;
        ArrayList<Carro> aux = new ArrayList<Carro>();
        HashMap<Carro,Integer> temp = new HashMap<Carro,Integer>();
        for(Carro c : this.listaCarros)
        {
            aux.add(c.clone());
        }
        for(int i=0; i<voltas; i++)
        {
            for(Carro c : aux)
            {
                if(c.getDNF()==false) //verifica se o carro esta acidentado
                {
                    if(c.DNF(i,voltas,this.clima)==true) //verifica se o carro tem acidente na volta
                    {
                        c.setDNF(true);
                        temp.put(c.clone(),i);
                    }
                    else
                    {
                       t_aux = c.getTempo(); //tempo feito ate ao momento
                       if(c instanceof Hibrido)
                       {
                           Hibrido h = (Hibrido)c;
                           int motor = h.getPotenciaMotorEletrico();
                           t_volta = c.tempoProximaVolta(this.circuito, 0, i) - motor*10;
                       }
                       else
                            t_volta = c.tempoProximaVolta(this.circuito, 0, i);
                       c.setTempo(t_aux +t_volta); 
                       //atualizar record
                    }
                }
            }
            this.primeiroVolta(i,aux); //metodo auxiliar para determinar o 1º a cada volta
        }
        for(Carro c : aux)
        {
            if(c.getDNF()==false)
            {
                    this.resultados.add(c);
            }
        }
        this.dnf = temp;
    }

    public int getNum(String tipo){
        int soma = 0;
        for(Terreno t : this.circuito.getCaminho()) {
            if(t.getType().equals(tipo)){
                soma++;
            }
        }

        return soma;
    }
    
    /**
     * Metodo auxiliar privado para determinar o carro que vai em 1o a cada volta
     */

    public List<String> simularCorrida() {
        Circuito c = CircuitoDAO.buildInstance().get(this.circuito);
        int nvoltas = c.getVoltas();
        int nretas = c.getRetas();

        Map<String, Utilizador> sets = new HashMap<>();
        for (Utilizador u : this.participantes) {
            sets.put(u.getId(), u);
        }
    }

}
