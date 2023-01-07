package Business.SSCampeonato;
/**
 * Write a description of class Business.SSCampeonato.Corrida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

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
       for(Carro c : this.primeiroVolta)
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
    
    /**
     * Metodo auxiliar privado para determinar o carro que vai em 1o a cada volta
     */
    private void primeiroVolta(int volta, List<Carro> l)
    {
       Collections.sort(l);
       Iterator<Carro> it = l.iterator();
       boolean f = false;
       Carro c = null;
       while(it.hasNext() && f==false)
       {
           c = it.next();
           if(c.getDNF()==false)
                f=true;
       }
       if(c!=null)
            this.primeiroVolta.add(volta,c.clone());
    }
    
    /**
     * Lista o 1o classificado em cada volta
     */
    private String printPrimeiroVolta()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("\n||||| Primeiro carro a cada volta e desistentes |||||");
        for(int i=0; i<this.primeiroVolta.size();i++)
        {
            sb.append("\n");
            sb.append(i+1);sb.append("ª Volta: ");
            sb.append(this.primeiroVolta.get(i).getMarca());sb.append(" ");
            sb.append(this.primeiroVolta.get(i).getModelo());sb.append(" ");
            for(Carro c : this.dnf.keySet())
            {
                if(this.dnf.get(c) == i)
                {
                    sb.append("\n\t");sb.append("Desistente: ");
                    sb.append(c.getMarca());sb.append(" ");
                    sb.append(c.getModelo());sb.append(" ");
                }
            }
        }
        return sb.toString();
    }
    
    /**
     * Lista os resultados da corrida.
     */ 
   public String printResultados()
   {
       StringBuilder sb = new StringBuilder();
       int i = 1;
       sb.append("\n||||| ");sb.append(this.circuito.getNome());sb.append(" |||||");
       sb.append("\n||||| ");sb.append("Voltas: ");sb.append(this.circuito.getVoltas());sb.append(" |||||");
       sb.append("\n||||| ");sb.append("Distancia: ");sb.append(this.circuito.getDistancia());sb.append("km | ");
       sb.append("Condição meteorológica: ");
       if(this.clima == 0)
        {
            sb.append("Sol");
        }
       else
        {
            sb.append("Chuva");;
        }
       sb.append(" |||||");
       sb.append("\n\n||||| Classificacoes da corrida |||||");
       for(Carro c : this.resultados)
       {
            sb.append("\n");
            sb.append(i);sb.append("º: ");
            sb.append("\t Categoria: "); sb.append(c.getClass().getName()); sb.append(" ");
            sb.append("\t Business.Carros.Carro: "); sb.append(c.getMarca()); sb.append(" ");
            sb.append(c.getModelo());
            i++;
       }      
       for(int v=this.circuito.getVoltas();v>=0;v--)
       {
           for(Carro c : this.dnf.keySet())
           {
                   if(v==this.dnf.get(c))
                   {
                   sb.append("\n");
                   sb.append(i);sb.append("º: ");
                   sb.append("DNF");
                   sb.append("\t Categoria: "); sb.append(c.getClass().getName()); sb.append(" ");
                   sb.append("\t Business.Carros.Carro: "); sb.append(c.getMarca()); sb.append(" ");
                   sb.append(c.getModelo());
                   i++;
                }
           }
       }
       
       sb.append("\n\n||||| Classificacoes da corrida Hibridos |||||");
       i=1;
       for(Carro c : this.resultados)
       {
            if(c instanceof Hibrido)
            {
            sb.append("\n");
            sb.append(i);sb.append("º: ");
            sb.append("\t Categoria: "); sb.append(c.getClass().getName()); sb.append(" ");
            sb.append("\t Business.Carros.Carro: "); sb.append(c.getMarca()); sb.append(" ");
            sb.append(c.getModelo());
            i++;
            }
       }      
       for(int v=this.circuito.getVoltas();v>=0;v--)
       {
           for(Carro c : this.dnf.keySet())
           {
               if(c instanceof Hibrido)
               {
                   if(v==this.dnf.get(c))
                   {
                   sb.append("\n");
                   sb.append(i);sb.append("º: ");
                   sb.append("DNF");
                   sb.append("\t Categoria: "); sb.append(c.getClass().getName()); sb.append(" ");
                   sb.append("\t Business.Carros.Carro: "); sb.append(c.getMarca()); sb.append(" ");
                   sb.append(c.getModelo());
                   i++;
                }
               }
           }
       }
       sb.append(this.printPrimeiroVolta());
       return sb.toString();
   }
   
   /**
    * Lista de Acidentados DNF
    */
   public String printDNF()
   {
       StringBuilder sb = new StringBuilder();
       sb.append("Espetados!!!");
       for(Carro c : this.dnf.keySet())
       {
           sb.append("\n" + c.getMarca() + " \t\tVolta: " + this.dnf.get(c));
       }
       return sb.toString();
   }
   
   /**
    * Lista de participantes da corrida
    */
   public String listaCarrosParticipantes()
   {
       StringBuilder sb = new StringBuilder();
       int i = 1;
       for(Carro c : this.listaCarros)
       {
           sb.append("\n");
           sb.append(i);sb.append(" - ");sb.append(c.getMarca());sb.append(" ");sb.append(c.getModelo());
           i++;
       }
       return sb.toString();
   }
}
