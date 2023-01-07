package Business;

import Business.Database.JogadorDAO;
import Business.Database.MainDAO;
import Business.SSCampeonato.Campeonato;
import Business.SSCampeonato.Carro;
import Business.SSCampeonato.Corrida;
import Business.SSCampeonato.Piloto;
import Business.SSUtilizador.Jogador;
import Business.SSUtilizador.Utilizador;
import Exceptions.*;

import java.util.List;
import java.util.Map;

public class RacingManager implements IRacingManager{

    private Map<Integer, Utilizador> utilizadores;
    private Map<Integer, Carro> carros;
    private List<Campeonato> campeonatos;
    private List<Corrida> corridas;
    private List<Piloto> pilotos;

    private MainDAO mainDAO;

    public RacingManager(){
        this.mainDAO = new MainDAO();
    }
    @Override
    public Map<Integer, Utilizador> getUtilizadores() {
        return this.utilizadores;
    }

    @Override
    public Map<Integer, Carro> getCarros() {
        return this.carros;
    }

    @Override
    public List<Campeonato> getCampeonatos() {
        return this.campeonatos;
    }

    @Override
    public List<Corrida> getCorridas() {
        return this.corridas;
    }

    @Override
    public List<Piloto> getPilotos() {
        return this.pilotos;
    }

    @Override
    public void setUtilizadores(Map<Integer, Utilizador> u) throws SetItemFailed {
        this.utilizadores = u;
    }

    @Override
    public void setCarros(Map<Integer, Carro> c) throws SetItemFailed {
        this.carros = c;
    }

    @Override
    public void setCampeonatos(List<Campeonato> c) throws SetItemFailed {
        this.campeonatos = c;
    }

    @Override
    public void setCorridas(List<Corrida> c) throws SetItemFailed {
        this.corridas = c;
    }

    @Override
    public void setPilotos(List<Piloto> p) throws SetItemFailed {
        this.pilotos = p;
    }

    @Override
    public void adicionaUtilizador(Utilizador u) throws AdicionaItemError {
        this.utilizadores.put(u.getId(), u);
    }

    @Override
    public void adicionaCarro(Carro u) throws AdicionaItemError {
        this.carros.put(u.getId(), u);
    }

    @Override
    public void adicionaCampeonato(Campeonato u) throws AdicionaItemError {
        this.campeonatos.add(u);
    }

    @Override
    public void adicionaCorrida(Corrida u) throws AdicionaItemError {
        this.corridas.add(u);
    }

    @Override
    public void adicionaPiloto(Piloto u) throws AdicionaItemError {
        this.pilotos.add(u);
    }

    @Override
    public void removerUtilizador(Utilizador u) throws RemoveItemError {
        this.utilizadores.remove(u.getId());
    }

    @Override
    public void removerCarro(Carro u) throws RemoveItemError {
        this.carros.remove(u.getId());
    }

    @Override
    public void removerCampeonato(Campeonato u) throws RemoveItemError {
        this.campeonatos.remove(u);
    }

    @Override
    public void removerCorrida(Corrida u) throws RemoveItemError {
        this.corridas.remove(u);
    }

    @Override
    public void removerPiloto(Piloto u) throws RemoveItemError {
        this.pilotos.remove(u);
    }

    @Override
    public Utilizador verificaCredenciais(String username, String password) throws UtilizadorNaoEncontrado {
        Jogador j = new JogadorDAO().get(username, password);

        if(j == null)
            return null;
        else
            return new Utilizador(j);

    }

    public void simulaCorrida() throws ImpossivelSimularCorrida {

    }
}
