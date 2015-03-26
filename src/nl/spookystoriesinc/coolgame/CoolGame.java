package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.coolgame.objects.Book;
import nl.spookystoriesinc.coolgame.objects.Chair;
import nl.spookystoriesinc.coolgame.objects.Chest;
import nl.spookystoriesinc.coolgame.objects.Door;
import nl.spookystoriesinc.coolgame.objects.Enemy;
import nl.spookystoriesinc.coolgame.objects.Key;
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
	 *	Clears the board
	 *	Calls the method which room to build 
	 */
	public void initNewGame() {
		GameBoard board = getGameBoard();
		board.removeAllObjects();

		initMainHall(board);
		board.init();
	}
	public void initMainHall(GameBoard board){
		// Add a player object
		board.addGameObject(new Player(),4, 3);
		
		// Add a enemy object
		random = (int) (Math.random() * 10);
		if(random <= 1){
			board.addGameObject(new Enemy(), 7, 5);
		}
		
		// walls of the Main hall
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 0,0);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 0,1);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 0,2);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 0,4);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 0,5);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 0,6);
		
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 1,6);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 2,6);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 3,6);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 5,6);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 6,6);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 7,6);
		
		board.addGameObject(new Wall(Wall.WALL_PAINTING), 1,0);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 2,0);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 3,0);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 5,0);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 6,0);
		board.addGameObject(new Wall(Wall.WALL_SHELF), 7,0);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 8,0);
		
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 8,1);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 8,2);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 8,4);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 8,5);
		board.addGameObject(new Wall(Wall.WALL_IMAGE), 8,6);
			
		// chest (6,1)
		Chest chestOne;
		board.addGameObject(chestOne = new Chest(), 6, 1);
		chestOne.addKey(new Key(1));
		
		// Chest (2,1)
		Chest chestTwo;
		board.addGameObject(chestTwo = new Chest(), 2, 1);
		chestTwo.addKey(new Key(2));
		
		// Chest (7,4)
		//Chest chestThree;
		//board.addGameObject(chestThree = new Chest(), 7, 4);
		//chestThree.addKey(new Key(3));
		//chestThree.addKey(new Key(4));

		board.addGameObject(new Table(), 3, 1);
		board.addGameObject(new Table(), 5, 1);
		
		// add a book
		Book book = new Book(R.drawable.book_souls_page1);
		book.addPage(R.drawable.book_souls_page_2);
		board.addGameObject(book, 3, 4);
		
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
}
