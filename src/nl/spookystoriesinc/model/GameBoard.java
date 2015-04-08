package nl.spookystoriesinc.model;

import java.util.Collections;
import java.util.Observable;

import nl.spookystoriesinc.coolgame.objects.Book;
import nl.spookystoriesinc.coolgame.objects.Chair;
import nl.spookystoriesinc.coolgame.objects.Chest;
import nl.spookystoriesinc.coolgame.objects.Desk;
import nl.spookystoriesinc.coolgame.objects.DiningTable;
import nl.spookystoriesinc.coolgame.objects.Bookcase;
import nl.spookystoriesinc.coolgame.objects.Door;
import nl.spookystoriesinc.coolgame.objects.Enemy;
import nl.spookystoriesinc.coolgame.objects.Key;
import nl.spookystoriesinc.coolgame.objects.Lamp;
import nl.spookystoriesinc.coolgame.objects.Lever;
import nl.spookystoriesinc.coolgame.objects.Player;
import nl.spookystoriesinc.coolgame.objects.Sink;
import nl.spookystoriesinc.coolgame.objects.Sofa;
import nl.spookystoriesinc.coolgame.objects.Stove;
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
	private GameObject[][] studyRoom;
	private GameObject[][] corridor;
	private GameObject[][] library;
	private GameObject[][] livingRoom;
	private GameObject[][] kitchen;
	private GameObject[][] guestBedroom;
	private Player player;
	private Enemy enemy;
	private Context context;
	private int random;
	private String currentRoom;
	
	private boolean enemySpawn = false;
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
		this.studyRoom = new GameObject[width][height];
		this.corridor = new GameObject[width][height];
		this.library = new GameObject[width][height];
		this.livingRoom = new GameObject[width][height];
		this.kitchen = new GameObject[width][height];
		this.guestBedroom = new GameObject[width][height];
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
				
				initRoom(mainHall);
				
				this.removeAllObjects();
				
				initDiningRoom();
				
				initRoom(diningRoom);
				
				
				this.removeAllObjects();
				
				initHall();
				
				initRoom(roomHall);
				
				this.removeAllObjects();
				
				initStudyRoom();

				initRoom(studyRoom);
				
				this.removeAllObjects();
				
				initCorridor();
				
				initRoom(corridor);
				
				this.removeAllObjects();
				
				initLibrary();
				
				initRoom(library);
				
				this.removeAllObjects();
				
				initLivingRoom();
				
				initRoom(livingRoom);
				
				this.removeAllObjects();
				
				initKitchen();
				
				initRoom(kitchen);
				
				this.removeAllObjects();
				
				initGuestBedroom();
				
				initRoom(guestBedroom);
				
				this.removeAllObjects();
			
				
				//het spel start
				initMainHall();
				this.currentRoom = "MainHall";
				this.updateView();
				
	}
	
		public void initRoom(GameObject[][] room){
		
		for( int x = 0; x < getWidth(); x++ ) {
			for( int y = 0; y < getHeight(); y++ ) {
				room[x][y] = gameBoard[x][y];
			}
		}
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
		
		// walls of the Main hall
		addWalls();
	
		this.addGameObject(new Table(Table.TABLE_IMAGE), 2, 1);
		this.addGameObject(new Table(Table.TABLE_IMAGE), 6, 1);
		
		//north door | id 1
		this.addGameObject(new Door(1, Door.NORTH_OPEN_DOOR_IMAGE, this, context, "Hall", true), 4, 0);
		//west door | id 2 deze deur zit "op slot" kaars is nodig om te kunnen betreden.
		this.addGameObject(new Door(2, Door.WEST_OPEN_DOOR_IMAGE, this, context, "DiningRoom", true), 0, 3);
		//east door | id 3
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8, 3);
		//south door | id 4
		this.addGameObject(new Door(4, Door.SOUTH_OPEN_DOOR_IMAGE, this, context, "Outside", true), 4, 6);

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
		this.addGameObject(new Door(1, Door.NORTH_OPEN_DOOR_IMAGE, this, context, "Kitchen", true), 4, 0);
		//east door | id 3
		this.addGameObject(new Door(3, Door.EAST_OPEN_DOOR_IMAGE, this, context, "MainHall", true), 8, 3);


	}
	
	public void initHall(){
		this.removeAllObjects();
		// Add a player object
		this.addGameObject(new Player(),4, 5);
		
		// walls of the Hall
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,3);
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
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 2,0);
		this.addGameObject(new Wall(Wall.WALL_PAINTING), 3,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 5,0);
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 6,0);
		this.addGameObject(new Wall(Wall.WALL_CRACK), 7,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,0);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,4);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,5);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,6);
		
		
		//lamp
		this.addGameObject(new Lamp(), 1, 1);
		this.addGameObject(new Lamp(), 7, 1);
		this.addGameObject(new Lamp(), 1, 5);
		this.addGameObject(new Lamp(), 7, 5);
		
		//north door | id 7
		this.addGameObject(new Door(7, Door.NORTH_STAIRS_UP, this, context, "Corridor", true), 4, 0);
		//east door | id 8
		this.addGameObject(new Door(8, Door.EAST_OPEN_DOOR_IMAGE, this, context, "StudyRoom", true), 8, 3);
		//south door | id 9
		this.addGameObject(new Door(9, Door.SOUTH_OPEN_DOOR_IMAGE, this, context, "MainHall", true), 4, 6);

		
		
	}
	
	public void initStudyRoom(){
		this.removeAllObjects();
		//Add a player object
		this.addGameObject(new Player(), 1, 3);
		
		//walls of the Study room
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
		this.addGameObject(new Wall(Wall.WALL_SHELF), 3,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 5,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 6,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 7,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,0);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,4);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,5);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,6);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8, 3);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 4, 0);
		
		//add west door | id 9
		this.addGameObject(new Door(9, Door.WEST_OPEN_DOOR_IMAGE,this , context, "Hall", true), 0, 3);
		//add south door | id 10
		this.addGameObject(new Door(10, Door.SOUTH_OPEN_DOOR_IMAGE,this , context, "Library", true), 4, 6);
		
		//bookcases
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_DOWN_IMAGE), 6, 1);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_CORNER_IMAGE), 7, 1);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_IMAGE), 7, 2);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_IMAGE), 7, 3);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_IMAGE), 7, 4);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_CORNER_DOWN_IMAGE), 7, 5);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_UP_IMAGE), 6, 5);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_UP_IMAGE), 5, 5);
		
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_LEFT_CORNER_DOWN_IMAGE), 1, 5);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_LEFT_IMAGE), 1, 4);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_UP_IMAGE), 2, 5);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_UP_IMAGE), 3, 5);
		
		//desk
		Book book1 = new Book(R.drawable.book_souls_page1, context);
		book1.addPage(R.drawable.book_souls_page_2);
		this.addGameObject(new Desk(Desk.DESK_LEFT_IMAGE, context), 3, 1);
		this.addGameObject(book1, 4, 1);
		
		//chair
		this.addGameObject(new Chair(Chair.CHAIR_UP_IMAGE), 4, 2);
		
		//table
		this.addGameObject(new Table(Table.TABLE_CANDLE_IMAGE), 1, 1);
		
		
	}
	
	public void initLibrary(){
		this.removeAllObjects();
		//Add a player object
		this.addGameObject(new Player(), 4, 1);
		
		//walls of the Library
		addWalls();
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8, 3);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0, 3);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 4, 6);
		
		
		//add north door | id 14
		this.addGameObject(new Door(14, Door.NORTH_OPEN_DOOR_IMAGE,this , context, "StudyRoom", true), 4, 0);
		
		//bookcases
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_LEFT_CORNER_IMAGE), 1, 1);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_DOWN_IMAGE), 2, 1);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_DOWN_IMAGE), 3, 1);
		
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_LEFT_IMAGE), 1, 2);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_LEFT_IMAGE), 1, 3);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_LEFT_IMAGE), 1, 4);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_LEFT_CORNER_DOWN_IMAGE), 1, 5);
		
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_DOWN_IMAGE), 5, 1);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_DOWN_IMAGE), 6, 1);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_CORNER_IMAGE), 7, 1);
		
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_IMAGE), 7, 2);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_IMAGE), 7, 3);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_IMAGE), 7, 4);
		
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_CORNER_DOWN_IMAGE), 7, 5);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_UP_IMAGE), 6, 5);

		//secret door by lever
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_UP_IMAGE), 5, 5);
		//
		
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_UP_IMAGE), 4, 5);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_UP_IMAGE), 3, 5);
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_UP_IMAGE), 2, 5);
		
		//table
		this.addGameObject(new Table(Table.TABLE_IMAGE), 4, 3);
		
		
		
	}
	
	public void initKitchen(){
		this.removeAllObjects();
		//Add a player object
		this.addGameObject(new Player(), 4, 5);
		
		//walls of the Kitchen
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,3);
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
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 4,0);
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 6,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 7,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,0);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,4);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,5);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,6);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8, 3);

		
		
		//add south door | id 15
		this.addGameObject(new Door(15, Door.SOUTH_OPEN_DOOR_IMAGE,this , context, "DiningRoom", true), 4, 6);
	
		//sink
		this.addGameObject(new Sink(), 2, 1);
		
		//stove
		this.addGameObject(new Stove(), 3, 1);
		
		//tables
		this.addGameObject(new Desk(Desk.DESK_LEFT_IMAGE, context),6, 1);
		this.addGameObject(new Desk(Desk.DESK_RIGHT_IMAGE, context), 7, 1);
		
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_RIGHT_IMAGE), 7, 5);
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_LEFT_IMAGE), 6, 5);
		
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_LEFT_IMAGE), 1, 3);
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_MIDDLE_IMAGE), 2, 3);
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_MIDDLE_IMAGE), 3, 3);
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_RIGHT_IMAGE), 4, 3);
		
		//lever
		this.addGameObject(new Lever(context), 5, 0);
		
	}
	public void initCorridor(){
		this.removeAllObjects();
		//Add a player object
		this.addGameObject(new Player(), 4, 5);
		

		//walls of the Corridor
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
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 2,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 3,0);
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 4,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 5,0);
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 6,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 7,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,0);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,4);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,5);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,6);


		
		//add west door | id 11
		this.addGameObject(new Door(11, Door.WEST_OPEN_DOOR_IMAGE,this , context, "LivingRoom", true), 0, 3);
		//add east door | id 12
		this.addGameObject(new Door(12, Door.EAST_OPEN_DOOR_IMAGE,this , context, "MasterBedroom", true), 8, 3);
		//add south door | id 13
		this.addGameObject(new Door(13, Door.SOUTH_STAIRS_DOWN,this , context, "Hall", true), 4, 6);
		
		//lamp
		this.addGameObject(new Lamp(), 1, 1);
		this.addGameObject(new Lamp(), 7, 1);
	
		//tables
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_LEFT_IMAGE), 3, 1);
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_MIDDLE_IMAGE), 4, 1);
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_RIGHT_IMAGE), 5, 1);
	
		//chair
		this.addGameObject(new Chair(Chair.CHAIR_UP_IMAGE), 4, 2);
	}
	
	public void initLivingRoom(){
		this.removeAllObjects();
		//Add a player object
		this.addGameObject(new Player(), 7, 3);
		
		//walls of the Living Room
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0, 3);
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
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 2,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 3,0);
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 4,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 5,0);
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 6,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 7,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,0);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,4);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,5);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,6);
		
		//sofa
		this.addGameObject(new Sofa(Sofa.SOFA_TOP_IMAGE), 3, 2);
		this.addGameObject(new Sofa(Sofa.SOFA_MIDDLE_IMAGE), 3, 3);
		this.addGameObject(new Sofa(Sofa.SOFA_DOWN_IMAGE), 3, 4);
		
		//bookcase
		this.addGameObject(new Bookcase(Bookcase.BOOKCASE_RIGHT_CORNER_IMAGE), 7, 1);
		
		//lamps
		this.addGameObject(new Lamp(), 1, 1);
		this.addGameObject(new Lamp(), 1, 5);
		
		//table
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_RIGHT_IMAGE), 7, 5);
		this.addGameObject(new DiningTable(DiningTable.DININGTABLE_LEFT_IMAGE), 6, 5);
		
		

		//add east door | id 16
		this.addGameObject(new Door(16, Door.EAST_OPEN_DOOR_IMAGE,this , context, "Corridor", true), 8, 3);
		//add south door | id 17
		this.addGameObject(new Door(17, Door.SOUTH_OPEN_DOOR_IMAGE,this , context, "GuestBedroom", true), 4, 6);
		
	}
	
	public void initGuestBedroom(){
		this.removeAllObjects();
		//Add a player object
		this.addGameObject(new Player(), 7, 3);
		
		//walls of the Guest Bedroom
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 0,3);
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
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 2,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 3,0);

		this.addGameObject(new Wall(Wall.WALL_IMAGE), 5,0);
		this.addGameObject(new Wall(Wall.WALL_WINDOW), 6,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 7,0);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,0);
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,1);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,2);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,4);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,5);
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 8,6);		
		
		this.addGameObject(new Wall(Wall.WALL_IMAGE), 4, 6);
		
		this.addGameObject(new Note(Note.))
		//beds
		
		

		//add north door | id 18
		this.addGameObject(new Door(18, Door.NORTH_OPEN_DOOR_IMAGE,this , context, "LivingRoom", true), 4, 0);
		//add east door | id 19
		this.addGameObject(new Door(19, Door.EAST_OPEN_DOOR_IMAGE,this , context, "Bathroom", true), 8, 3);
		
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
			
		}else if(room.equals("StudyRoom")){
			load(studyRoom, this.currentRoom);
			this.currentRoom = "StudyRoom";
			
		}else if(room.equals("Corridor")){
			load(corridor, this.currentRoom);
			this.currentRoom = "Corridor";
			
		}else if(room.equals("Library")){
			load(library, this.currentRoom);
			this.currentRoom = "Library";
			
		}else if(room.equals("LivingRoom")){
			load(livingRoom, this.currentRoom);
			this.currentRoom = "LivingRoom";
		}else if(room.equals("Kitchen")){
			load(kitchen, this.currentRoom);
			this.currentRoom = "Kitchen";
		}else if(room.equals("GuestBedroom")){
			load(guestBedroom, this.currentRoom);
			this.currentRoom = "GuestBedroom";
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
		}else if(currentRoom.equals("StudyRoom")){
			save(studyRoom);
		}else if(currentRoom.equals("Corridor")){
			save(corridor);
		}else if(currentRoom.equals("Library")){
			save(library);
		}else if(currentRoom.equals("LivingRoom")){
			save(livingRoom);
		}else if(currentRoom.equals("Kitchen")){
			save(kitchen);
		}else if(currentRoom.equals("GuestBedroom")){
			save(guestBedroom);
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

	public void setEnemySpawnTrue(){
		enemySpawn = true;
	}
	
	public void spawnEnemy(int chance){
		// Add a enemy object
		if(enemySpawn){
			random = (int) (Math.random() * chance);
			if(random <= 1){
				Enemy currentEnemy = new Enemy();
				enemy = currentEnemy;
				this.addGameObject(currentEnemy, 7, 5);	
			}
		}
	}
}
