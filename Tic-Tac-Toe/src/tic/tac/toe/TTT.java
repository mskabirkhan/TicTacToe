import java.util.Scanner;

/**
 *This is a command base tic Tac toe game to can played by a single 
 * user. 
 * @author kabir
 */
public class TTT {

    /**
     * this is a filed declaration to for row and colum
     */
    public static int row, col;

    /**
     * declaring and initialising scanner to scan the input
     */
    public static Scanner scan = new Scanner(System.in);

    /**
     *declaring and initialising board as a character
     */
    public static char[][] board = new char[3][3];

    /**
     *
     */
    public static char turn = 'X';

    /**
     *This is the main method of the class 
     * @param args
     */
    public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '_';
			}
		}
		Play();
	}

    /**
     *Play method prints the welcome text and board in the screen 
     * This method also checkes if "X" or "O"
     * are repeated in the same colums 3 times
     * when its repeated 3 times, its prints the game over screen
     */
    public static void Play() {
		boolean playing = true;
                System.out.println("Welcome to the Tic-Toc-Toe");
		PrintBoard();
		while (playing) {
                    System.out.println("\nEnter a number for the row and ONE for the column \n*Please only enter[1 - 3] otherwise this game will crash ");
			row = scan.nextInt() - 1;
			col = scan.nextInt() - 1;
			board[row][col] = turn;
			if (GameOver(row, col)) {
				playing = false;
				
			}
                        
			PrintBoard();
			if (turn == 'X')
				turn = 'O';
			else
				turn = 'X';
		}
                System.out.println("Game over!, player " + turn + " Wins! \nThank you for playing TicTacToe");

	}

    /**
     *This method prints the board in the screen
     */
    public static void PrintBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.println();
			for (int j = 0; j < 3; j++) {
				if (j == 0)
					System.out.print("| ");
				System.out.print(board[i][j] + " | ");
			}
		}
		System.out.println();
	}

    /**
     *
     * @param rMove means the right move 
     * @param cMove means the left move 
     * every conditional statements checks if colum 0 is equal to 1 or
     * colum 0 is equal to 2, if all the colums are equals the methods end
     * the game
     * @return true or false considering condition
     */
    public static boolean GameOver(int rMove, int cMove) {
		if (board[0][cMove] == board[1][cMove]
				&& board[0][cMove] == board[2][cMove])
			return true;
		if (board[rMove][0] == board[rMove][1]
				&& board[rMove][0] == board[rMove][2])
			return true;
		if (board[0][0] == board[1][1] && board[0][0] == board[2][2]
				&& board[1][1] != '_')
			return true;
		if (board[0][2] == board[1][1] && board[0][2] == board[2][0]
				&& board[1][1] != '_')
			return true;
		return false;
	}
}