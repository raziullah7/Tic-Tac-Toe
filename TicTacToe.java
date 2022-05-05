import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        // Contains the current state of the
        // tic-tac-toe board
        char [][] board = { {' ', ' ', ' '},    // Row # 1
                            {' ', ' ', ' '},    // Row # 2
                            {' ', ' ', ' '} };  // Row # 3

        // getting user input for player's turn through
        // the method and placing it
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // player's turn
            playerMove(board, scanner);

            // checking if game is finished after player's turn
            if (isGameFinished(board))
                break;

            // current condition of the board
            printBoard(board);

            // computer's turn
            computerTurn(board);

            // checking if game is finished after player's turn
            if (isGameFinished(board))
                break;

            // current condition of the board
            printBoard(board);
        }
        scanner.close();
    }

    // method to check if the game has finished or not
    private static boolean isGameFinished(char[][] board) {
        // checks if the player won
        if (anyoneVictorious(board, 'X')) {
            printBoard(board);
            System.out.println("Player Wins!");
            return true;
        }

        // checks if the computer won
        if (anyoneVictorious(board, 'O')) {
            printBoard(board);
            System.out.println("Computer Wins!");
            return true;
        }

        // is the board full?
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        printBoard(board);
        System.out.println("The game ended in a tie!");
        return true;
    }

    // method to check if there is a winner
    // simply checks and returns the result of the huge condition
    private static boolean anyoneVictorious(char[][] board, char indicator) {
        // checking all rows
        return (board[0][0] == indicator && board[0][1] == indicator && board[0][2] == indicator) ||
                (board[1][0] == indicator && board[1][1] == indicator && board[1][2] == indicator) ||
                (board[2][0] == indicator && board[2][1] == indicator && board[2][2] == indicator) ||
                // checking all columns
                (board[0][0] == indicator && board[1][0] == indicator && board[2][0] == indicator) ||
                (board[0][1] == indicator && board[1][1] == indicator && board[2][1] == indicator) ||
                (board[0][2] == indicator && board[1][2] == indicator && board[2][2] == indicator) ||
                // checking diagonals
                (board[0][0] == indicator && board[1][1] == indicator && board[2][2] == indicator) ||
                (board[0][2] == indicator && board[1][1] == indicator && board[2][0] == indicator);
    }

    // method for computer's turn to place a move
    private static void computerTurn(char[][] board) {
        // computer's turn is selected randomly
        Random rand = new Random();
        int computerMove;
        // checking if the selected is open or not and keep
        // guessing until an empty spot is found
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (isValidMove(board, computerMove)) {
                break;
            }
        }
        // displaying computer's move explicitly
        System.out.println("Computer chose " + computerMove);

        // applying computer's move using placeMove method
        placeMove(board, Integer.toString(computerMove), 'O');
    }

    // method to check validity of the move on
    // the specified position
    private static boolean isValidMove (char[][] board, int position) {
        switch (position) {
            case 1 -> {
                return (board[0][0] == ' ');
            }
            case 2 -> {
                return (board[0][1] == ' ');
            }
            case 3 -> {
                return (board[0][2] == ' ');
            }
            case 4 -> {
                return (board[1][0] == ' ');
            }
            case 5 -> {
                return (board[1][1] == ' ');
            }
            case 6 -> {
                return (board[1][2] == ' ');
            }
            case 7 -> {
                return (board[2][0] == ' ');
            }
            case 8 -> {
                return (board[2][1] == ' ');
            }
            case 9 -> {
                return (board[2][2] == ' ');
            }
            default -> {
                return false;
            }
        }
    }

    // method to use input from the user and put X
    // in the given location
    private static void playerMove(char[][] board, Scanner scanner) {
        String userInput;
        while (true) {
            System.out.println("Where would you like to play(1 - 9)?");
            userInput = scanner.nextLine();
            if (isValidMove(board, Integer.parseInt(userInput)))
                break;
            else
                System.out.println(userInput + " is not a valid move.");
        }

        // placing values in the board
        placeMove(board, userInput, 'X');
    }

    // method to remove redundancy of the switch statement
    // and for placing the computer or player's indicator(X/O)
    private static void placeMove(char[][] board, String position, char playerIndicator) {
        switch (position) {
            case "1" -> board[0][0] = playerIndicator;
            case "2" -> board[0][1] = playerIndicator;
            case "3" -> board[0][2] = playerIndicator;
            case "4" -> board[1][0] = playerIndicator;
            case "5" -> board[1][1] = playerIndicator;
            case "6" -> board[1][2] = playerIndicator;
            case "7" -> board[2][0] = playerIndicator;
            case "8" -> board[2][1] = playerIndicator;
            case "9" -> board[2][2] = playerIndicator;
            default -> System.out.println(":(");
        }
    }

    // method to print the board in tic-tac-toe format
    private static void printBoard(char[][] board) {
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("--+---+--");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("--+---+--");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}