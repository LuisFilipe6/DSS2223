import Business.Database.UtilizadorDAO;
import Business.Database.MainDAO;
import Business.SSUtilizador.Jogador;
import UI.TextUI;


public class Main {
    public static void main(String[] args) {
        MainDAO dao = new MainDAO();
        UtilizadorDAO j = new UtilizadorDAO();
        Jogador jog = j.get(2);

        try {
            new TextUI();
        } catch(Exception e){
            System.out.println("Impossible to run UI.TextUI");
        }

        //j.remove(3);
        System.out.println(jog.printInfo());
    }
}