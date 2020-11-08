package tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  The HumanPlayer class allows a human player to make their
 *  move in a game of tic-tac-toe through user input.
 *  
 * @author Lotfi Hasni
 * @version 1.0
 * @since October 15, 2020
 * 
 */
public class HumanPlayer extends Player {

	
	public HumanPlayer(String name, char mark) {
		super(name, mark);
	}
	
	/**
	 * Accepts player input and makes the 
	 * corresponding move on the Tic-Tac-Toe game board.
	 * @throws IOException
	 */
	@Override
	protected void makeMove() throws IOException {
		BufferedReader stdin;
		stdin = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.print("\n" + name + ", what row should your next " + mark + " be placed in?");
			String row = stdin.readLine();
			while (row.equals("0") == false && row.equals("1") == false && row.equals("2") == false) {
				System.out.print("Please try again: ");
				row = stdin.readLine();
			}
			System.out.print("\n" + name + ", what column should your next " + mark + " be placed in?");
			String col = stdin.readLine();
			while (col.equals("0") == false && col.equals("1") == false && col.equals("2") == false) {
				System.out.print("Please try again: ");
				col = stdin.readLine();
			}
			
			if(board.getMark(Integer.parseInt(row), Integer.parseInt(col)) != ' ') {
				System.out.println("Sorry, there is already a mark there. Please try again.");
			}
			else {
				System.out.println();
				board.addMark(Integer.parseInt(row), Integer.parseInt(col), mark);
				break;
			}
		}
		
	}
	
	
	/**
	 * The play method allows the player to make a move, displays
	 * the board, checks for a winner, and communicates the nature 
	 * of the end of the game if it is reached or passes the turn 
	 * over to the opponent player if the game is not yet over.
	 * @throws IOException
	 */
	protected void play() throws IOException {
		
		if(board.xWins() == false && board.oWins() == false && board.isFull() == false) {
			// Player makes move
			makeMove();
			// Displays the board after each move
			board.display();
		}
		
		// Checks for winner
		if(board.oWins() == true && mark == 'O') {
			System.out.print("\nTHE GAME IS OVER: ");
			System.out.println(name + " is the winner!");
			System.out.println("Game Ended ...");
			return;
		}
		else if(board.oWins() == true && opponent.getMark() == 'O') {
			System.out.print("\nTHE GAME IS OVER: ");
			System.out.println(opponent.getName() + " is the winner!");
			System.out.println("Game Ended ...");
			return;
		}
		else if(board.xWins() == true && mark == 'X') {
			System.out.print("\nTHE GAME IS OVER: ");
			System.out.println(name + " is the winner!");
			System.out.println("Game Ended ...");
			return;
		}
		else if(board.xWins() == true && opponent.getMark() == 'X') {
			System.out.print("\nTHE GAME IS OVER: ");
			System.out.println(opponent.getName() + " is the winner!");
			System.out.println("Game Ended ...");
			return;
		}
		else if(board.isFull() == true && board.xWins() == false && board.oWins() == false) {
			System.out.print("\nTHE GAME IS OVER: ");
			System.out.println("The game ended in a tie!");
			System.out.println("Game Ended ...");
			return;
		}
		
		// Passes turn to other player
		opponent.play();
		
		return;
	}
	
}
