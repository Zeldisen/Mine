import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Menu {
    Scanner scanner = new Scanner(System.in);
    int rulesOrGame;
    final ScoreTotal scoreTotal;
   // ScoreTotal ScoreTotal = new ScoreTotal();


    public Menu() {
        this.scoreTotal = new ScoreTotal();
    }

    /**
     * function that presents a menu.
     * First with options 1. Rules, 2. Start game.
     * Second with options for difficulty.
     * Error handling added.
     */
    public void menu() {

        System.out.println("What do you want to do: \n" +
                "1. Read the rules.\n" +
                "2. Start the game!\n");
        try {
            rulesOrGame = scanner.nextInt();
           // scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("What do you want to do: \n" +
                    "1. Read the rules.\n" +
                    "2. Start the game!\n");
            scanner.nextLine();
            menu();
            return;
        }
        switch (rulesOrGame) {
            case 1:
                System.out.println("To win a game of Minesweeper, all non-mine cells must be opened without opening a mine.\n" +
                        "Put flags where you think there might be a mine.\n" +
                        "Difficulty can be increased by adding mines or starting with a larger grid.\n" +
                        "Good luck!\n");
                menu();

                break;
            case 2:
                secondMenu();

                break;
            default:
                System.out.println("Ogiltig inmatning. Välj:\n" +
                        "1. Läs reglerna!\n" +
                        "2. Starta spelet!\n");
                scanner.nextLine();
                menu();
                break;
        }
    }

    public void secondMenu() {
        // int rulesOrGame;
       // int winTimes = 0;
        //int lostTimes = 0;
        boolean isRunning = true;

        while (isRunning) {//checks is input is either 1 or 2, crashes if input is anything but number, need try catch
            try {
                //scanner.nextLine();
                System.out.println("Please choose difficulty level: ");
                System.out.println("1. Easy");
                System.out.println("2. Medium");
                System.out.println("3. Hard");
                System.out.println("4. Custom");
                System.out.println("5. Quit\n");
            }
                 catch (InputMismatchException e) {
                    System.out.println("Invalid input. Choose again!\n " +
                            "1. Easy\n" +
                            "2. Medium\n" +
                            "3. Hard\n" +
                            "4. Custom\n" +
                            "5. Quit\n");
                    scanner.nextLine();
                }
                int a;

                //while (isRunning) { // loops until user choose 1, 2 or 3, 4 , 5 crashes if input is not a number, need try catch

                        a = scanner.nextInt();
                        //if (a == 1 || a == 2 || a == 3 || a == 4 || a == 5) {
                            Game game = new Game();
                            switch (a) {
                                case 1:
                                    Board easyBoard = new Board(2, 2, 1 , scoreTotal);
                                    game.game(easyBoard);

                                    break;
                                case 2:
                                    Board mediumBoard = new Board(12, 12, 20,scoreTotal);
                                    game.game(mediumBoard);
                                    break;
                                case 3:
                                    Board hardBoard = new Board(15, 15, 100, scoreTotal);
                                    game.game(hardBoard);
                                    break;
                                case 4:
                                    Game Custom = new Game();
                                    Custom.customGame();
                                    break;
                                case 5:
                                    scanner.nextLine();
                                    System.out.println("säker på att du vill avsluta? yes or no.");
                                    String answer;
                                    String answerLowerCase;

                                        answer = scanner.nextLine();
                                        answerLowerCase = answer.toLowerCase();

                                        if (answerLowerCase.equals("yes") || answerLowerCase.equals("y") || answerLowerCase.equals("ja") || answerLowerCase.equals("j")) {
                                            System.out.println("Goodbye! ");
                                            isRunning = false;
                                            break;
                                        } else if (answerLowerCase.equals("no") || answerLowerCase.equals("n") || answerLowerCase.equals("nej")) {

                                            secondMenu();
                                            //scanner.nextLine();
                                        } else {
                                            System.out.println("Invalid choice, try again! ");
                                            secondMenu();
                                           // scanner.nextLine();
                                        }


                                    break;
                                default:
                                    System.out.println("Invalid input. Choose again!\n " +
                                            "1. Easy\n" +
                                            "2. Medium\n" +
                                            "3. Hard\n" +
                                            "4. Custom\n" +
                                            "5. Quit\n");
                                    scanner.nextLine();
                            }
            }
        }
    }
