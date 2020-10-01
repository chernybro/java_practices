import javax.swing.*;

public class Loader {
    public static void main(String[] args) {
        Team team1 = new Team("RED");
        Team team2 = new Team("BLUE");

        new MyForm(team1, team2);
    }
}
