package nl.spookystoriesinc.coolgame;

import android.content.Context;
import nl.spookystoriesinc.coolgame.objects.Book;
import nl.spookystoriesinc.coolgame.objects.Chair;
import nl.spookystoriesinc.coolgame.objects.Chest;
import nl.spookystoriesinc.coolgame.objects.DiningTableLeft;
import nl.spookystoriesinc.coolgame.objects.DiningTableMiddle;
import nl.spookystoriesinc.coolgame.objects.DiningTableRight;
import nl.spookystoriesinc.coolgame.objects.Door;
import nl.spookystoriesinc.coolgame.objects.Enemy;
import nl.spookystoriesinc.coolgame.objects.Key;
import nl.spookystoriesinc.coolgame.objects.Lamp;
import nl.spookystoriesinc.coolgame.objects.Note;
import nl.spookystoriesinc.coolgame.objects.Table;
import nl.spookystoriesinc.coolgame.objects.Wall;
import nl.spookystoriesinc.coolgame.objects.Player;
import nl.spookystoriesinc.model.Game;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.spookystories.R;
import nl.spookystoriesinc.coolgame.CoolGameBoard;

/**
 * Awesome game for the Speelveld-project.
 * 
 * @author Paul de Groot
 */



public class CoolGame extends Game {
	
	
	/** Tag used for log messages */
	public static final String TAG = "CoolGame";
	private Context context;

	/** Reference to the main activity, so some labels can be updated. */
	private MainActivity activity;
	private int random;
	
	/**
	 * Constructor.
	 * 
	 * @param activity  The main activity
	 */
	public CoolGame(MainActivity activity) {
		// Create a new game board and couple it to this game
		super(new CoolGameBoard(activity, activity.getApplicationContext()));
		
		// Store reference to the main activity
		this.activity = activity;
		
		context = this.activity.getApplicationContext();

		// Reset the game
		

		// Tell the game board view which game board to show
		CoolGameBoardView gameView = activity.getGameBoardView();
		GameBoard gameBoard = getGameBoard();
		gameView.setGameBoard(gameBoard);
		
		// Set size of the view to that of the game board
		gameView.setFixedGridSize(gameBoard.getWidth(), gameBoard.getHeight());
	}

	/**
	 *	Clears the board
	 *	Calls the method which room to build 
	 */
	public void initNewGame() {
		GameBoard board = getGameBoard();
		board.reset();
		board.updateView();
	}

	

	

	
}
