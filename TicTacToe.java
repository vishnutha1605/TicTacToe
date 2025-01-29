
import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };
    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printBoard();
            playerMove(scanner);
            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                break;
            }
            switchPlayer();
            if (isBoardFull()) {
                printBoard();
                System.out.println("It's a draw!");
                break;
            }
        }
        scanner.close();
    }

    public static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " |");
            System.out.println("-------------");
        }
    }

    public static void playerMove(Scanner scanner) {
        int row, col;
        while (true) {
            System.out.println("Player " + currentPlayer + ", enter row (1-3) and column (1-3): ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;

            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                break;
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    public static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public static boolean checkWinner() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }
        return false;
    }

    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}