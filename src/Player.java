import java.util.Scanner;

public class Player {
    String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Welcomes and ask for name and prints name
     */
    public void playerName(){
        System.out.println("Welcome to Minesweeper!\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? ");
        String userName = scanner.nextLine();
        Player player = new Player(userName);
        System.out.println("Nice to meet you, " + player.getName() + "!\n");

    }


}


