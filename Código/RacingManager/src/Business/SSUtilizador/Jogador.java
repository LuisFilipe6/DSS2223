package Business.SSUtilizador;
/**
 * Write a description of class Business.SSUtilizador.Jogador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import Business.SSCampeonato.Carro;

import java.util.*;
import java.io.Serializable;

public class Jogador implements Serializable
{
  private String nome;
  private String password;
  private int id;

  public Jogador()
  {
      this.id = new Random().nextInt(10000);
      this.nome = "";
      this.password = "";
  }
  
  public Jogador(int id, String nome, String password)
  {
      this();
      this.id = id;
      this.nome = nome;
      this.password = password;
  }
  
  public Jogador(Jogador j)
  {
      this.nome = j.getNome();
      this.id = j.getId();
      this.password = j.getPassword();
  }
  
  public String getNome()
  {
      return this.nome;
  }
  
  public String getPassword()
  {
      return this.password;
  }
  
  public int getId()
  {
    return this.id;
  }
  

  public Jogador clone()
  {
      return new Jogador(this);
  }

  /**
   * Fazer aposta
   */



  /**
   * atualizador de apostas
   */

  /**
   *
   */



  /**
   * Informacao do jogador
   */
  public String printInfo()
  {
      StringBuilder sb = new StringBuilder();
      sb.append("ID: " );sb.append(this.id);
      sb.append("\nNome: ");sb.append(this.nome);
      sb.append("\nPassword: "); sb.append(this.password);

      return sb.toString();
  }

}
