package Lotfi_TictTacToe;

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

	private BufferedReader stdin;
	public HumanPlayer(String name, char mark) {
		super(name, mark);
		
		stdin = new BufferedReader(new InputStreamReader(System.in));
	}
	
	/**
	 * Accepts player input and makes the 
	 * corresponding move on the Tic-Tac-Toe game board.
	 * @throws IOException
	 */
	@Override
	protected void makeMove() throws IOException {
	
		int row,col;
		row=getRow();
		col=getCol();
		addMark(row,col);
		
			}
	
	private void addMark(int row, int col) throws IOException {
		// TODO Auto-generated method stub
		if(board.getMark(row, col) != ' ') {
			System.out.println("Sorry, there is already a mark there. Please try again.");
			makeMove();
		}
		else {
			System.out.println();
			board.addMark(row,col, mark);
			return;
	}
	}
	private int getRow() {
		int row;
	
		try{
			System.out.print("\n" + name + ", what row should your next " + mark + " be placed in?");
			 row = Integer.parseInt(stdin.readLine());
			if(row<0 ||row>2)
				{System.out.print("Please try again: ");
				row= getRow();
			}}catch (Exception e) {
				System.out.println("Please enter a valind Integer number");
				row= getRow();
			}
		return row;
	}
	private int getCol() {
		int col;
		
		try{
			System.out.print("\n" + name + ", what col should your next " + mark + " be placed in?");
			 col = Integer.parseInt(stdin.readLine());
			if(col<0 ||col>2)
				{System.out.print("Please try again: ");
				col=getCol();
			}}catch (Exception e) {
				System.out.println("Please enter a valind Integer number");
				col=getCol();
			}
		return col;
	}
	/**
	 * The play method allows the player to make a move, displays
	 * the board, checks for a winner, and communicates the nature 
	 * of the end of the game if it is reached or passes the turn 
	 * over to the opponent player if the game is not yet over.
	 * @throws IOException
	 */
	protected void play() throws IOException {
		
	
		// Checks for winner
		if(checkWinner())
			return;
		makeMove();
		board.display();
		// Passes turn to other player
		opponent.play();
		
	}
	
}
