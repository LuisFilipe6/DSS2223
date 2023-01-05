package Business;

import Business.SSCampeonato.Campeonato;
import Business.SSCampeonato.Carro;
import Business.SSCampeonato.Corrida;
import Business.SSCampeonato.Piloto;
import Business.SSUtilizador.Utilizador;
import Exceptions.AdicionaItemError;
import Exceptions.RemoveItemError;
import Exceptions.SetItemFailed;
import Exceptions.UtilizadorNaoEncontrado;

import java.util.List;
import java.util.Map;

public class RacingManager implements IRacingManager{
    @Override
    public Map<Integer, Utilizador> getUtilizadores() {
        return null;
    }

    @Override
    public Map<Integer, Carro> getCarros() {
        return null;
    }

    @Override
    public List<Campeonato> getCampeonatos() {
        return null;
    }

    @Override
    public List<Corrida> getCorridas() {
        return null;
    }

    @Override
    public List<Piloto> getPilotos() {
        return null;
    }

    @Override
    public void setUtilizadores(Map<Integer, Utilizador> u) throws SetItemFailed {

    }

    @Override
    public void setCarros(Map<Integer, Carro> c) throws SetItemFailed {

    }

    @Override
    public void setCampeonatos(List<Campeonato> c) throws SetItemFailed {

    }

    @Override
    public void setCorridas(List<Corrida> c) throws SetItemFailed {

    }

    @Override
    public void setPilotos(List<Piloto> p) throws SetItemFailed {

    }

    @Override
    public void adicionaUtilizador(Utilizador u) throws AdicionaItemError {

    }

    @Override
    public void adicionaCarro(Carro u) throws AdicionaItemError {

    }

    @Override
    public void adicionaCampeonato(Campeonato u) throws AdicionaItemError {

    }

    @Override
    public void adicionaCorrida(Corrida u) throws AdicionaItemError {

    }

    @Override
    public void adicionaPiloto(Piloto u) throws AdicionaItemError {

    }

    @Override
    public void removerUtilizador(Utilizador u) throws RemoveItemError {

    }

    @Override
    public void removerCarro(Carro u) throws RemoveItemError {

    }

    @Override
    public void removerCampeonato(Campeonato u) throws RemoveItemError {

    }

    @Override
    public void removerCorrida(Corrida u) throws RemoveItemError {

    }

    @Override
    public void removerPiloto(Piloto u) throws RemoveItemError {

    }

    @Override
    public Utilizador verificaCredenciais(String username, String password) throws UtilizadorNaoEncontrado {
        return null;
    }
}
