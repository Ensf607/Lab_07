package Lotfi_TictTacToe;

import java.io.IOException;

/**
 *  The RandomPlayer class represents a computer player that uses a 
 *  random generator to pick a vacant space on the tic-tac-toe game
 *  board, where it then places its mark.
 *  
 * @author Lotfi Hasni
 * @version 1.0
 * @since October 15, 2020
 * 
 */
public class RandomPlayer extends Player{
	protected RandomGenerator randomGenerator;
	private int randomNumOne,randomNumTwo; 
	public RandomPlayer(String name, char mark) {
		super(name, mark);
		randomGenerator = new RandomGenerator();
	}

	/**
	 * Method for player to make move by placing mark
	 */
	@Override
	protected void makeMove() throws IOException {
		
		while(true) {
		
		randomNumOne = randomGenerator.discrete(0, 2);
		randomNumTwo = randomGenerator.discrete(0, 2);
		
		if(board.getMark(randomNumOne , randomNumTwo) == ' ') {
			board.addMark(randomNumOne, randomNumTwo, mark);
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

		// Checks for winner
		if(checkWinner())
			return;
		makeMove();
		board.display();
		// Passes turn to other player
		opponent.play();
	}
}
