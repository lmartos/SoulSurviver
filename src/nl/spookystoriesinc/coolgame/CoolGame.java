package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.coolgame.objects.Book;
import nl.spookystoriesinc.coolgame.objects.Chair;
import nl.spookystoriesinc.coolgame.objects.Chest;
import nl.spookystoriesinc.coolgame.objects.Door;
import nl.spookystoriesinc.coolgame.objects.Key;
import nl.spookystoriesinc.coolgame.objects.Leaf;
import nl.spookystoriesinc.coolgame.objects.Note;
import nl.spookystoriesinc.coolgame.objects.Rock;
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

	/** Reference to the main activity, so some labels can be updated. */
	private MainActivity activity;
	
	/** The number of leafs eaten. */
	private int score;

	/**
	 * Constructor.
	 * 
	 * @param activity  The main activity
	 */
	public CoolGame(MainActivity activity) {
		// Create a new game board and couple it to this game
		super(new CoolGameBoard());
		
		// Store reference to the main activity
		this.activity = activity;

		// Reset the game
		initNewGame();

		// Tell the game board view which game board to show
		CoolGameBoardView gameView = activity.getGameBoardView();
		GameBoard gameBoard = getGameBoard();
		gameView.setGameBoard(gameBoard);
		
		// Set size of the view to that of the game board
		gameView.setFixedGridSize(gameBoard.getWidth(), gameBoard.getHeight());
	}

	/**
	 * Starts a new game.
	 * Resets the score and places all objects in the right place.
	 */
	public void initNewGame() {
		// Set the score and update the label
		score = 0;
		activity.updateScoreLabel(score);

		GameBoard board = getGameBoard();
		board.removeAllObjects();

		// Add a player object
		board.addGameObject(new Player(),4, 3);
		
		// walls of the game
		board.addGameObject(new Wall(), 0,0);
		board.addGameObject(new Wall(), 0,1);
		board.addGameObject(new Wall(), 0,2);
		board.addGameObject(new Wall(), 0,4);
		board.addGameObject(new Wall(), 0,5);
		board.addGameObject(new Wall(), 0,6);
		
		board.addGameObject(new Wall(), 1,6);
		board.addGameObject(new Wall(), 2,6);
		board.addGameObject(new Wall(), 3,6);
		board.addGameObject(new Wall(), 5,6);
		board.addGameObject(new Wall(), 6,6);
		board.addGameObject(new Wall(), 7,6);
		
		board.addGameObject(new Wall(), 1,0);
		board.addGameObject(new Wall(), 2,0);
		board.addGameObject(new Wall(), 3,0);
		board.addGameObject(new Wall(), 5,0);
		board.addGameObject(new Wall(), 6,0);
		board.addGameObject(new Wall(), 7,0);
		board.addGameObject(new Wall(), 8,0);
		
		board.addGameObject(new Wall(), 8,1);
		board.addGameObject(new Wall(), 8,2);
		board.addGameObject(new Wall(), 8,4);
		board.addGameObject(new Wall(), 8,5);
		board.addGameObject(new Wall(), 8,6);
			
		// right chest
		Chest chestOne;
		board.addGameObject(chestOne = new Chest(), 6, 1);
		chestOne.addKey(new Key(1));
		
		// left chest
		Chest chestTwo;
		board.addGameObject(chestTwo = new Chest(), 2, 1);
		chestTwo.addKey(new Key(2));

		board.addGameObject(new Table(), 3, 1);
		board.addGameObject(new Table(), 5, 1);
		
		Book book = new Book(R.drawable.book_souls_page1);
		book.addPage(R.drawable.book_souls_page_2);
		board.addGameObject(book, 3, 5);
		board.addGameObject(new Note(), 5, 5);
		
		//north door | id 1
		board.addGameObject(new Door(1, Door.NORTH_CLOSED_DOOR_IMAGE), 4, 0);
		//west door | id 2
		board.addGameObject(new Door(2, Door.WEST_CLOSED_DOOR_IMAGE), 0, 3);
		//east door | id 3
		board.addGameObject(new Door(3, Door.EAST_CLOSED_DOOR_IMAGE), 8, 3);
		//south door | id 4
		board.addGameObject(new Door(4, Door.SOUTH_CLOSED_DOOR_IMAGE), 4, 6);

		// Redraw the game view
		board.updateView();
	}

	/**
	 * Called by Wombat if it ate a leaf. Increases the score.
	 */
	public void increaseScore() {
		score++;
		activity.updateScoreLabel(score);
	}
}
