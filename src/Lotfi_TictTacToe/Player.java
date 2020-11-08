package tictactoe;
import java.io.*;

/**
 *  The Player class represents one of the participants in a game of
 *  Tic-Tac-Toe and allows for this player to take their turn in the game, 
 *  displaying results and ending the game as necessary.
 *  
 * @author Lotfi Hasni
 * @version 1.0
 * @since September 25, 2020
 * 
 */
public abstract class Player {

	/**
	 * The player's name
	 */
	protected String name;
	
	/**
	 * The game board associated with the player
	 */
	protected Board board;
	
	/**
	 * The player's opponent in the game
	 */
	protected Player opponent;
	
	/**
	 * The mark (X or O) that the player uses
	 */
	protected char mark;
	
	
	protected abstract void play() throws IOException;
	protected abstract void makeMove() throws IOException; 
	
	
	/**
	 * Constructs player object.
	 * @param name the player's name
	 * @param mark the symbol (X or O) that the player uses
	 */
	public Player(String name, char mark){
		this.name = name;
		this.mark = mark;
	}

	/**
	 * Gets the mark (X or O) being used by 
	 * the player in the Tic-Tac-Toe game.
	 * @return player's mark
	 */
	public char getMark() {
		return mark;
	}
	
	/**
	 * Gets the name of the player.
	 * @return the player's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Assigns an opponent player to this player.
	 * @param opponent the opposing player
	 */
	protected void setOpponent(Player opponent) {
		this.opponent = opponent;
	}
	
	/**
	 * Assigns a Tic-Tac-Toe game board 
	 * object that this player will use.
	 * @param theBoard the board object to be used
	 */
	protected void setBoard(Board theBoard) {
		board = theBoard;
	}
}
