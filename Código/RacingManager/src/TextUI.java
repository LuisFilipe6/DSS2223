import java.util.Scanner;

public class TextUI {
    private Scanner input;

    public TextUI(){
        String nome;
        String pw;
        int opcao;
        System.out.println("Bem vindo ao Racing Manager");
        System.out.println("Pretende entrar como 0:utilizador, 1:convidado ou 2:Admin?:");
        opcao = Integer.parseInt(this.input.next());
        if (opcao == 0) {
            System.out.println("Introduza as suas credenciais");
            System.out.println("Nome de utilizador:");
            nome = input.next();
            System.out.println("Introduza a password:");
            pw = input.next();
            // loginJogador(none,pw);

            System.out.println("Introduza a opçao que preferir:\n" +
                    "0: Sair\n" +
                    "1: Simular campeonato\n" +
                    "2: Ver ranking\n");
            System.out.println("Opcao:");
            opcao = Integer.parseInt(this.input.next());
            // run(opcao);
        }
        else if (opcao == 1){
            System.out.println("Introduza o seu nome:");
            nome = input.next();
            // loginCovidado(nome);

            System.out.println("Introduza a opcao que preferir\n" +
                    "0: Sair\n" +
                    "1: Entrar num campeonato iniciado");
            opcao = Integer.parseInt(this.input.next());
            // mostrar os campeonatos iniciados
            // adcionaConvidado(nome, campeonato)
        }
        else if (opcao == 2){
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
            // run(opcao);
        }
    }
    public void run(){
        //this.menu.run();
    }
}
