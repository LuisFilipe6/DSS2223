package UI;

import java.util.Scanner;

public class TextUI {
    public static void main(String[] args){
        new TextUI();
    }
    private Scanner input;

    public TextUI() {
        this.input = new Scanner(System.in);
        String nome;
        String pw;
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
            // loginJogador(none,pw);

            System.out.println("Introduza a opcao que preferir:\n" +
                    "0: Sair\n" +
                    "1: Simular campeonato\n" +
                    "2: Ver ranking\n");
            System.out.println("Opcao:");
            opcao = Integer.parseInt(this.input.next());
            tipo = 0;
            // run(tipo, opcao);
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
            // run(tipo, opcao);
        } else if (opcao == 3) {
            System.out.println("Introduza as suas credenciais;");
            System.out.println("Nome de admin:");
            nome = input.next();
            System.out.println("Introduza a password:");
            pw = input.next();
            // loginAdmin(nome,pw);

            System.out.println("Introduza a opcao que preferir:\n" +
                    "0: Sair\n" +
                    "1: Criar campeontato\n" +
                    "2: Criar carro\n" +
                    "3: Criar piloto\n" +
                    "4: Criar circuito\n" +
                    "5: Adicionar novos admins");
            System.out.println("Opcao:");
            opcao = Integer.parseInt(this.input.next());
            tipo = 2;
            // run(tipo, opcao);
        } else System.out.println("Opcao Invalida");
    }

    public void run(Integer tipo, Integer opcao) {
        //this.menu.run();
        if (tipo == 0) {
            switch (opcao) {
                case 0:
                    System.out.println("Aplicacao Terminada.");
                    break;
                case 1:
                    //simularCampeonato()
                    //pedir coisas (prints)
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
                    //pedir coisas
            }
        } else if (tipo == 2) {
            switch (opcao) {
                case 0:
                    System.out.println("Aplicacao Terminada.");
                    break;
                case 1:
                    //criarCampeonato();
                    //pedir coisas
                    break;
                case 2:
                    //criarCarro();
                    //pedir coisas
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