import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Player player = new Player("");
        player.playerName();
         //int winTimes = 0;
         //int lostTimes = 0;

        Menu menu = new Menu();
        menu.menu();
    }
}