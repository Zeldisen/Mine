import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private ScoreTotal scoreTotal;

    /**
     * Starts game and allows degree of difficulty
     */
    public Game() {
        this.scoreTotal = new ScoreTotal();
    }
Scanner scanner = new Scanner(System.in);
    /**
     * Prints board, adds mines, sets flagsAvailible possible, prints wins and lost times.
     * @param board
     * @param// winTimes
     * @param //lostTimes
     */
    public void game(Board board) {

        board.initializeBoard();
        board.addMines();

        board.printBoard(board.board);
        int flagsAvailable = board.mines;
        board.makeMove(scoreTotal, flagsAvailable);

        System.out.println("Total wins " + scoreTotal.getWinTimes());
        System.out.println("Total losts " + scoreTotal.getLostTimes());


    }
    public void customGame(){
        int inputChooseRows = -1;
        int inputChooseColumns = -1;
        int inputChooseMines = -1;
       // int winTimes = 0;
        //int lostTimes = 0;

        while (true) {

            try {
                System.out.println("Minimum size is 2x2 and maximum is 50x26.\n");
                System.out.println("How many rows? Choose a number between 2-50!\n");

                inputChooseRows = scanner.nextInt();

                if (inputChooseRows > 50 || inputChooseRows < 2) {
                    System.out.println("Not a number between 2-50. Choose again.\n");
                    scanner.nextLine();
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please choose again!\n");
                scanner.nextLine();
            }
        }
        while (true) {

            try {

                System.out.println("How many columns? Choose a number between 2-26!\n");
                inputChooseColumns = scanner.nextInt();
                //No more than 25 columns because alphabet is only 26 letters (in english).
                if (inputChooseColumns < 2 || inputChooseColumns > 26) {
                    System.out.println("Not a number between 2-26. Choose again!\n");
                    scanner.nextLine();
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please choose again!\n");
                scanner.nextLine();
            }
        }
        while (true) {

            int rowsTimesColumns = (inputChooseColumns * inputChooseRows) - 1;
            try {
                System.out.println("How many mines? Choose a number between 1-" + rowsTimesColumns + "!\n");
                inputChooseMines = scanner.nextInt();

                //To make sure user doesn't put too many mines on board,
                // rowsTimesColumns show user how many cells -1 there is. So user can choose to put mines on every cell except for 1.
                if (inputChooseMines < 1 || inputChooseMines > rowsTimesColumns) {
                    System.out.println("Not a number between 1-" + rowsTimesColumns + ". Choose again!\n");
                    scanner.nextLine();
                    continue;
                }
                System.out.println("You have chosen a " + inputChooseRows + "x" + inputChooseColumns + " with " + inputChooseMines + " mines!\n");
                Board userBoard = new Board(inputChooseRows, inputChooseColumns, inputChooseMines, scoreTotal);
                game(userBoard);
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please choose again!\n");
                scanner.nextLine();
            }
        }
    }


}