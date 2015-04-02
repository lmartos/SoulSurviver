package nl.spookystoriesinc.model;

import java.util.Collections;
import java.util.Observable;

import nl.spookystoriesinc.coolgame.objects.Book;
import nl.spookystoriesinc.coolgame.objects.Chair;
import nl.spookystoriesinc.coolgame.objects.Chest;
import nl.spookystoriesinc.coolgame.objects.DiningTable;
import nl.spookystoriesinc.coolgame.objects.Door;
import nl.spookystoriesinc.coolgame.objects.Enemy;
import nl.spookystoriesinc.coolgame.objects.Key;
import nl.spookystoriesinc.coolgame.objects.Lamp;
import nl.spookystoriesinc.coolgame.objects.Player;
import nl.spookystoriesinc.coolgame.objects.Table;
import nl.spookystoriesinc.coolgame.objects.Wall;
import nl.spookystoriesinc.spookystories.R;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * The game board, which is a rectangular array of GameObject.
 * 
 * You should subclass this for your own game.
 * There you will (among other things) implement
 *    public void onEmptyTileClicked(int x, int y);
 * which will be called when the user clicked on a tile which had no game object
 * on it.
 * 
 * @author Paul de Groot
 */
public abstract class GameBoard extends Observable {
	private static final String TAG = "Playground";

	/** The game this game board is a part of. */
	private Game game;
	
	/** The game objects on the board. */
	private GameObject[][] gameBoard;
	private GameObject[][] mainHall;
	private GameObject[][] diningRoom;
	private GameObject[][] roomHall;
	private Player player;
	private Enemy enemy;
	private Context context;
	private int random;
	private String currentRoom;
	/**
	 * Create a new game board.
	 * 
	 * @param width   The width of the board, in tiles.
	 * @param height  The height of the board, in tiles.
	 */
	public GameBoard(int width, int height, Context context) {
		this.gameBoard = new GameObject[width][height];
		this.mainHall = new GameObject[width][height];
		this.diningRoom = new GameObject[width][height];
		this.roomHall = new GameObject[width][height];
		this.context = context;
		this.currentRoom = "";
		
		resetGame();
	}
	
	public void resetGame(){
		//init main hall
			
				player = null;
				enemy = null;
				this.removeAllRooms();
				
				initMainHall();
				
				for( int x = 0; x < getWidth(); x++ ) {
					for( int y = 0; y < getHeight(); y++ ) {
						mainHall[x][y] = gameBoard[x][y];
					}
				}
				
				this.removeAllObjects();
				
				initDiningRoom();
				
				for( int x = 0; x < getWidth(); x++ ) {
					for( int y = 0; y < getHeight(); y++ ) {
						diningRoom[x][y] = gameBoard[x][y];
					}
				}
				
				this.removeAllObjects();
				
				initHall();
				
				for( int x = 0; x < getWidth(); x++ ) {
					for( int y = 0; y < getHeight(); y++ ) {
						roomHall[x][y] = gameBoard[x][y];
					}
				}
				this.removeAllObjects();
				
				initMainHall();
				this.currentRoom = "MainHall";
				this.updateView();
				
	}
	
	public void addWalls(){
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,4);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,5);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,6);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 1,6);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 2,6);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 3,6);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 5,6);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 6,6);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 7,6);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 1,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 2,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 3,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 5,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 6,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 7,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,0);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,4);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,5);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,6);
	}
	
	public void initMainHall(){
		
		// Add a player object
		this.addGameObject(new Player(),4, 3);
		
		// Add a enemy object
		random = (int) (Math.random() * 2);
		if(random <= 1){
			Enemy currentEnemy = new Enemy();
			enemy = currentEnemy;
			this.addGameObject(currentEnemy, 7, 5);
			
		}
		
		// walls of the Main hall
		addWalls();
			
		// chest (6,1)
		Chest chestOne;
		this.addGameObject(chestOne = new Chest(context), 6, 1);
		chestOne.addKey(new Key(1));
		
		// Chest (2,1)
		Chest chestTwo;
		this.addGameObject(chestTwo = new Chest(context), 2, 1);
		chestTwo.addKey(new Key(2));
		

		this.addGameObject(new Table(), 3, 1);
		this.addGameObject(new Table(), 5, 1);
		
		// add a book
		Book book = new Book(R.drawable.book_souls_page1, context);
		book.addPage(R.drawable.book_souls_page_2);
		this.addGameObject(book, 3, 5);
		
		//north door | id 1
		this.addGameObject(new Door(1, Door.NORTH_CLOSED_DOOR_IMAGE, this, context, "Hall", true), 4, 0);
		//west door | id 2
		this.addGameObject(new Door(2, Door.WEST_CLOSED_DOOR_IMAGE, this, context, "DiningRoom", true), 0, 3);
		//east door | id 3
		this.addGameObject(new Door(3, Door.EAST_CLOSED_DOOR_IMAGE, this, context, "Library", true), 8, 3);
		//south door | id 4
		this.addGameObject(new Door(4, Door.SOUTH_CLOSED_DOOR_IMAGE, this, context, "Outside", true), 4, 6);

	}
	
	public void initDiningRoom(){
		// Add a player object
		this.addGameObject(new Player(),7, 3);
		
		// walls of the Dining room
		addWalls();
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,3);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 4,6);
		
		//dining table
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_LEFT_IMAGE), 3, 3);
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_MIDDLE_IMAGE), 4, 3);
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_RIGHT_IMAGE), 5, 3);
		
		//dining table chairs
		this.addGameObject(new Chair(Chair.CHAIR_UP_IMAGE), 3, 4);
		this.addGameObject(new Chair(Chair.CHAIR_UP_IMAGE), 4, 4);
		this.addGameObject(new Chair(Chair.CHAIR_UP_IMAGE), 5, 4);
		
		this.addGameObject(new Chair(Chair.CHAIR_RIGHT_IMAGE), 2, 3);
		this.addGameObject(new Chair(Chair.CHAIR_LEFT_IMAGE), 6, 3);
		
		this.addGameObject(new Chair(Chair.CHAIR_DOWN_IMAGE), 3, 2);
		this.addGameObject(new Chair(Chair.CHAIR_DOWN_IMAGE), 4, 2);
		this.addGameObject(new Chair(Chair.CHAIR_DOWN_IMAGE), 5, 2);
		
		//chest
				Chest chestThree;
				this.addGameObject(chestThree = new Chest(context), 1, 1);
				
		//lamp
				this.addGameObject(new Lamp(), 7, 5);
				this.addGameObject(new Lamp(), 1, 5);
		
		//north door | id 1
		this.addGameObject(new Door(1, Door.NORTH_CLOSED_DOOR_IMAGE, this, context, "Kitchen", true), 4, 0);
		//east door | id 3
		this.addGameObject(new Door(3, Door.EAST_CLOSED_DOOR_IMAGE, this, context, "MainHall", true), 8, 3);


	}
	
	public void initHall(){
		this.removeAllObjects();
		// Add a player object
		this.addGameObject(new Player(),4, 5);
		
		// walls of the Dining room
		addWalls();
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,3);
		
		//lamp
		this.addGameObject(new Lamp(), 1, 1);
		this.addGameObject(new Lamp(), 7, 1);
		this.addGameObject(new Lamp(), 1, 5);
		this.addGameObject(new Lamp(), 7, 5);
		
		//north door | id 7
		this.addGameObject(new Door(7, Door.NORTH_STAIRS_UP, this, context, "Corridor", true), 4, 0);
		//east door | id 8
		this.addGameObject(new Door(8, Door.EAST_CLOSED_DOOR_IMAGE, this, context, "Study Room", true), 8, 3);
		//south door | id 9
		this.addGameObject(new Door(9, Door.SOUTH_OPEN_DOOR_IMAGE, this, context, "MainHall", true), 4, 6);

		
		
	}
	
	public void changeRoom(String room){
		if(room.equals("MainHall")){
			load(mainHall, this.currentRoom);
			this.currentRoom = "MainHall";
		}else if(room.equals("Hall")){
			load(roomHall, this.currentRoom);
			this.currentRoom  = "Hall";
			
		}else if(room.equals("DiningRoom")){
			load(diningRoom, this.currentRoom);
			this.currentRoom = "DiningRoom";
			
		}else{
			Toast.makeText(context, "this is no joke", Toast.LENGTH_SHORT).show();
		}
		
		
	}
	
	public void load(GameObject[][] room, String currentRoom){
		player = null;
		enemy = null;
		
		if(currentRoom.equals("MainHall")){
			save(mainHall);
		}else if(currentRoom.equals("Hall")){
			save(roomHall);
		}else if(currentRoom.equals("DiningRoom")){
			save(diningRoom);
		}
		
		this.removeAllObjects();
		for( int x = 0; x < getWidth(); x++ ) {
			for( int y = 0; y < getHeight(); y++ ) {
				if(room[x][y] instanceof Player){
					player = (Player) room[x][y];
				}else if(room[x][y] instanceof Enemy){
					enemy = (Enemy) room[x][y];
				}
				gameBoard[x][y] = room[x][y];
			}
		}
		this.updateView();
	}
	
	public void save(GameObject[][] room){
		for( int x = 0; x < getWidth(); x++ ) {
			for( int y = 0; y < getHeight(); y++ ) {
				room[x][y] =gameBoard[x][y];
			}
		}
	}

	public abstract void reset();
	/**
	 * Returns the number of tiles in the X-direction of the board.
	 */
	public int getWidth() {
		return gameBoard.length;
	}

	/**
	 * Returns the number of tiles in the Y-direction of the board.
	 */
	public int getHeight() {
		return gameBoard[0].length;
	}

	/**
	 * Add a game object to the board.
	 * 
	 * @param obj  The object to place on the board.
	 * @param x    The X-coordinate to place the object at.
	 * @param y    The Y-coordinate to place the object at.
	 *
	 * @throws IllegalArgumentException if (x,y) is not empty
	 */
	public void addGameObject(GameObject obj, int x, int y) {
		if( gameBoard[x][y] != null ) {
			throw new IllegalArgumentException("Destination already contains an object");
		}
		
				if(obj instanceof Player){
					player = (Player) obj;
				}
				else if(obj instanceof Enemy){
					enemy = (Enemy) obj;
				}
				
		gameBoard[x][y] = obj;
		obj.setPosition(x,  y);
	}

	/**
	 * Retrieves the player object
	 * 
	 * @return		The player object
	 */
	public GameObject getPlayer(){
		return player;
	}
	
	public GameObject getEnemy(){
		return enemy;
	}
	public abstract void init();
	
	
	/**
	 * Move an object on the board.
	 * 
	 * @param obj   The object to move.
	 * @param newX  The new X-coordinate of the object.
	 * @param newY  The new Y-coordinate of the object.
	 *
	 * @throws IllegalArgumentException if (newX,newY) is not empty
	 */
	public void moveObject(GameObject obj, int newX, int newY) {
		int oldX = obj.getPositionX();
		int oldY = obj.getPositionY();

		gameBoard[oldX][oldY] = null;
		
		if( gameBoard[newX][newY] != null ) {
			throw new IllegalArgumentException("Destination already contains an object");
		}
		
		gameBoard[newX][newY] = obj;
		obj.setPosition(newX, newY);
	}

	/**
	 * Retrieves the object at the location (x, y) on the board.
	 * 
	 * @param x  The X-coordinate of the tile
	 * @param y  The Y-coordinate of the tile
	 * @return   The GameObject at (x, y) or null if there was none.
	 */
	public GameObject getObject(int x, int y) {
		return gameBoard[x][y];
	}

	/**
	 * Call this to notify the game board view that it should redraw.
	 * You should call this any time you are done changing things on the board
	 * and want to make your changes visible.
	 */
	public boolean updateView() {
		Log.d(TAG, "Updating game view");

		
		setChanged();
		notifyObservers();
		
		return true;
	}

	/**
	 * Remove an object from the board.
	 * 
	 * @param object  The object to remove from the board.
	 */
	public void removeObject(GameObject object) {
		int x = object.getPositionX();
		int y = object.getPositionY();
		gameBoard[x][y] = null;
	}
	
	/**
	 * Remove all objects from the game board.
	 */
	public void removeAllObjects() {
		for( int x = 0; x < getWidth(); x++ ) {
			for( int y = 0; y < getHeight(); y++ ) {
				gameBoard[x][y] = null;
			}
		}
	}
	
	public void removeAllRooms(){
		for( int x = 0; x < getWidth(); x++ ) {
			for( int y = 0; y < getHeight(); y++ ) {
				gameBoard[x][y] = null;
			}
		}
		for( int x = 0; x < getWidth(); x++ ) {
			for( int y = 0; y < getHeight(); y++ ) {
				mainHall[x][y] = null;
			}
		}
		for( int x = 0; x < getWidth(); x++ ) {
			for( int y = 0; y < getHeight(); y++ ) {
				roomHall[x][y] = null;
			}
		}
		for( int x = 0; x < getWidth(); x++ ) {
			for( int y = 0; y < getHeight(); y++ ) {
				diningRoom[x][y] = null;
			}
		}
	}

	/**
	 * Get a reference to the game class. You can use this to access the game
	 * state.
	 */
	public Game getGame() {
		return game;
	}

	/**
	 * Called if the user clicked on a tile, and no object was present on that tile.
	 * 
	 * @param x  The x-coordinate of the clicked tile
	 * @param y  The y-coordinate of the clicked tile
	 */
	public abstract void onEmptyTileClicked(int x, int y);

	/**
	 * Retrieves the background image that must be used for a specific tile.
	 * Return null to use the image set using setEmptyTile().
	 * 
	 * @param x  The x-coordinate of the tile
	 * @param y  The x-coordinate of the tile
	 * @return   A image identifier to draw on this tile, or null to use the empty tile.
	 */
	public String getBackgroundImg(int x, int y) {
		return null;
	}
	
	/** Used by Game. */
	void setGame(Game game) {
		this.game = game;
	}

}
