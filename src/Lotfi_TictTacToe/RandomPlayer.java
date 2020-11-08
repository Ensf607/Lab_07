package tictactoe;

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

	public RandomPlayer(String name, char mark) {
		super(name, mark);
	}

	/**
	 * Method for player to make move by placing mark
	 */
	@Override
	protected void makeMove() throws IOException {
		
		int randomNumOne;
		int randomNumTwo;
		RandomGenerator randomGenerator = new RandomGenerator();
		
		while(true) {
		
		randomNumOne = randomGenerator.discrete(0, 2);
		randomNumTwo = randomGenerator.discrete(0, 2);
		
		
		if(board.getMark(randomNumOne , randomNumTwo) != ' ') {
			continue;
		}
		else {
			System.out.println();
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
