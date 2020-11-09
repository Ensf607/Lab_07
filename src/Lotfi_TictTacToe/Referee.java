package Lotfi_TictTacToe;
import java.io.IOException;

/**
 * Referee monitors the Tic-Tac-Toe game. This class is used
 * to set the Tic-Tac-Toe game players, present the board, and
 * launch the first turn.
 *  
 * @author Lotfi Hasni
 * @version 1.0
 * @since September 25, 2020
 * 
 */
public class Referee {
	
	/**
	 * The player using the X mark
	 */
	private Player xPlayer;
	
	/**
	 * The player using the O mark
	 */
	private Player oPlayer;
	
	/**
	 * The game board object
	 */
	private Board board;

	/**
	 * No-parameter constructor for Referee object.
	 */
	public Referee() {}
	
	/**
	 * Constructs Referee object.
	 * @param xPlayer the player using the X mark
	 * @param oPlayer the player using the O mark
	 * @param board the game board
	 */
	public Referee(Player xPlayer, Player oPlayer, Board board) {
		this.xPlayer = xPlayer;
		this.oPlayer = oPlayer;
		this.board = board;
	}
	
	/**
	 * Starts the Tic-Tac-Toe game by setting player opponents,
	 * displaying the original board and calling the first player's
	 * play() method.
	 * @throws IOException
	 */
	public void runTheGame() throws IOException{
		System.out.println("\nReferee started the game...\n");
		xPlayer.setOpponent(oPlayer);
		oPlayer.setOpponent(xPlayer);
		board.display();
		xPlayer.play();
	}
	
	/**
	 * Sets Tic-Tac-Toe game board object.
	 * @param board the board to be used
	 */
	public void setBoard(Board board) {
		this.board = board;
		return;
	}
	
	/**
	 * Sets the player object which will use 'O' marks
	 * @param oPlayer the O player
	 */
	public void setoPlayer(Player oPlayer) {
		this.oPlayer = oPlayer;
		return;
	}
	
	/**
	 * Sets the player object which will use 'X' marks
	 * @param xPlayer the X player
	 */
	public void setxPlayer(Player xPlayer) {
		this.xPlayer = xPlayer;
		return;
	}
}
