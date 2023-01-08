package UI;

import Business.RacingManager;
import Business.SSCampeonato.Campeonato;
import Business.SSCampeonato.Carro;
import Business.SSCampeonato.Piloto;
import Business.SSUtilizador.Utilizador;
import Exceptions.UtilizadorNaoEncontrado;

import java.util.*;

public class TextUI {

    private RacingManager rm;
    public void TextUI(){
        this.rm = new RacingManager();
    }
    private Scanner input;

    public TextUI() {
        this.input = new Scanner(System.in);
        String nome;
        String pw;
        Utilizador utilizadorAutenticado;
        int tipo;
        int opcao;
        System.out.println("Bem vindo ao Racing Manager");
        System.out.println("Pretende entrar como \n1: Jogador\n2: Convidado\n3: Admin\n0: Sair\nOpcao: ");
        opcao = Integer.parseInt(this.input.next());
        if (opcao == 1) {
            System.out.println("Introduza as suas credenciais");
            System.out.println("Nome de utilizador:");
            nome = input.next();
            System.out.println("Introduza a password:");
            pw = input.next();
            try{
                rm.verificaCredenciais(nome,pw);
            }catch (Exception UtilizadorNaoEncontrado){
                System.out.println("As credenciais estão erradas!\n");
                return;
            }

            System.out.println("Introduza a opcao que preferir:\n" +
                    "0: Sair\n" +
                    "1: Simular campeonato\n" +
                    "2: Ver ranking\n");
            System.out.println("Opcao:");
            opcao = Integer.parseInt(this.input.next());
            tipo = 0;
            run(tipo, opcao);
        } else if (opcao == 2) {
            System.out.println("Introduza o seu nome:");
            nome = input.next();
            // loginCovidado(nome);

            System.out.println("Introduza a opcao que preferir\n" +
                    "0: Sair\n" +
                    "1: Entrar num campeonato iniciado");
            opcao = Integer.parseInt(this.input.next());
            tipo = 1;
            // mostrar os campeonatos iniciados
            // adcionaConvidado(nome, campeonato)
            run(tipo, opcao);
        } else if (opcao == 3) {
            boolean verificado = false;
            while(!verificado){
                System.out.println("Introduza as suas credenciais;");
                System.out.println("Nome de admin:");
                nome = input.next();
                System.out.println("Introduza a password:");
                pw = input.next();
                try {
                    utilizadorAutenticado = rm.verificaCredenciais(nome, pw);
                    verificado = true;
                } catch (UtilizadorNaoEncontrado e){
                    System.out.println(e.getMessage());
                }
            }

            while(verificado){
                System.out.println("Introduza a opcao que preferir:\n" +
                        "0: Sair\n" +
                        "1: Criar campeontato\n" +
                        "2: Criar carro\n" +
                        "3: Criar piloto\n" +
                        "4: Criar circuito\n" +
                        "5: Adicionar novos admins\n" +
                        "6: Sair");
                System.out.println("Opcao:");
                opcao = Integer.parseInt(this.input.next());

                run(2, opcao);
            }


        } else System.out.println("Opcao Invalida");
    }

    public void run(Integer tipo, Integer opcao) {
        // tipo=0 -> jogador deu login e escolheu alguma coisa
        // tipo=1 -> convidado escolheu o campeonato
        // topo=2 -> admin deu login e escolheu alguma coisa
        //this.menu.run();
        int op;
        if (tipo == 0) {
            switch (opcao) {
                case 0:
                    System.out.println("Aplicacao Terminada.");
                    break;
                case 1:
                    //simularCampeonato()
                    System.out.println("Seleciona um dos seguintes campeonatos\n" +
                            "Opcao: ");
                    // dar print aos campeonatos
                    op = Integer.parseInt(this.input.next());
                    System.out.println("Selecione o seu piloto: ");
                    // dar print aos pilotos
                    String piloto = input.next();
                    System.out.println("Selecione o seu carro: ");
                    String carro = input.next();
                    // dar print aos carros
                    // MUDAR ISTO
                    Campeonato c = new Campeonato();
                    c.simularCampeonato();
                case 2:
                    // verRanking();
            }
        } else if (tipo == 1) {
            switch (opcao) {
                case 0:
                    System.out.println("Aplicacao Terminada.");
                    break;
                case 1:
                    //adicionarAoCampeonato()
                    System.out.println("Selcione o seu piloto: ");
                    // dar print aos pilotos
                    String piloto = input.next();
                    System.out.println("Selecione o seu carro: ");
                    // dar print aos carros
                    String carro = input.next();

            }
        } else if (tipo == 2) {
            switch (opcao) {
                case 0:
                    System.out.println("Aplicacao Terminada.");
                    break;
                case 1:
                    //criarCampeonato();
                    System.out.println("Selecione a quantidade de circuitos que quer: ");
                    int nCir = Integer.parseInt(this.input.next());
                    List<Integer> circuitos = new ArrayList<>();
                    for(int i=0;i<nCir;i++){
                        // print aos circuitos todos
                        System.out.println("Selecione um destes circuitos: ");
                        int op1 = Integer.parseInt(this.input.next());
                        circuitos.add(op1);
                        // MUDAR ISTO PARA TER UMA LISTA COM OS CIRCUITOS
                    }
                    Map<String, Integer> classificacao = Collections.emptyMap();
                    Map<String, Utilizador> participantes = Collections.emptyMap();
                    Map<String, Piloto> pilotos = Collections.emptyMap();
                    List<Carro> carro = Collections.emptyList();
                    int nafinacoes = nCir*(2/3);
                    Campeonato camp = new Campeonato(,classificacao,participantes,pilotos,carro,nafinacoes);
                    break;
                case 2:
                    //criarCarro();
                    System.out.println("Selecione o tipo de carro: " +
                            "Hibrido (1): " +
                            "Combustão (2): ");
                    int tipoCarro = Integer.parseInt(this.input.next());
                    System.out.println("Diga a celindrada do carro: ");
                    int celindrada = Integer.parseInt(this.input.next());
                    System.out.println("Indica a potência: ");
                    int potencia = Integer.parseInt(this.input.next());
                    System.out.println("Indique o p.a.c (0-1) float: ");
                    float pac = Float.parseFloat(this.input.next());
                    System.out.println("Indique o downforce float (0-1): ");
                    float downf = Float.parseFloat(this.input.next());
                    System.out.println("Indiquie o tipo de peneu\n" +
                            "1: Chuva\n" +
                            "2: Macio\n " +
                            "3: Duro\n ");
                    System.out.println("Opcao: ");
                    int peneu = Integer.parseInt(this.input.next());

                    break;
                case 3:
                    //criarPiloto();
                    //pedir coisas
                    break;
                case 4:
                    //criarCircuito();
                    //pedir coisas
                    break;
                case 5:
                    //adicionadaAdmin();
                    //pedir coisas
                    break;
                default:
                    System.out.println("Opcao Invalida");
                    break;
            }
        }
    }
}