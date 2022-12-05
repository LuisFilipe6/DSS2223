import Business.Database.JogadorDAO;
import Business.Database.MainDAO;
import Business.SSUtilizador.Jogador;

public class Main {
    public static void main(String[] args) {
        MainDAO dao = new MainDAO("localhost", "root", "", "racingmanager", 3306);
        JogadorDAO j = new JogadorDAO(dao.getConnection());
        Jogador jog = j.get(2);
        j.put("Rita1", "passw@rd");

        //j.remove(3);
        System.out.println(jog.printInfo());
    }
}