package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.coolgame.objects.Book;
import nl.spookystoriesinc.coolgame.objects.Bookcase;
import nl.spookystoriesinc.coolgame.objects.Chair;
import nl.spookystoriesinc.coolgame.objects.Chest;
import nl.spookystoriesinc.coolgame.objects.Desk;
import nl.spookystoriesinc.coolgame.objects.DiningTable;
import nl.spookystoriesinc.coolgame.objects.Door;
import nl.spookystoriesinc.coolgame.objects.Enemy;
import nl.spookystoriesinc.coolgame.objects.Lamp;
import nl.spookystoriesinc.coolgame.objects.Note;
import nl.spookystoriesinc.coolgame.objects.Table;
import nl.spookystoriesinc.coolgame.objects.Wall;
import nl.spookystoriesinc.coolgame.objects.Player;
import nl.spookystoriesinc.spookystories.R;
import nl.spookystoriesinc.view.GameBoardView;
import nl.spookystoriesinc.view.SpriteCache;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

/**
 * A view on the CoolGame game board.
 * 
 * @author Jan Stroet
 * @author Paul de Groot
 */
public class CoolGameBoardView extends GameBoardView {
	private static final String TAG = "GameView";

	/**
	 * Constructor.
	 */
	public CoolGameBoardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		initGameView();
	}

	/**
	 * Constructor.
	 */
	public CoolGameBoardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		initGameView();
	}

	/**
	 * Loads all images that will be used for the game.
	 */
	private void initGameView() {
		Log.d(TAG, "Loading all images");

		SpriteCache spriteCache = SpriteCache.getInstance(); 
		spriteCache.setContext(this.getContext());		

		// Load the 'empty' cell bitmap and tell the tile view that this is the
		// image to use for cells without GameObject
		spriteCache.loadTile("empty", R.drawable.floor_hardwoodfloor);
		setEmptyTile("empty");

		// Load the images for the GameObjects
		
		spriteCache.loadTile(Player.DOWN_PLAYER_IMAGE, R.drawable.player_characterdown);
		spriteCache.loadTile(Player.LEFT_PLAYER_IMAGE, R.drawable.player_characterleft);
		spriteCache.loadTile(Player.RIGHT_PLAYER_IMAGE, R.drawable.player_characterright);
		spriteCache.loadTile(Player.UP_PLAYER_IMAGE, R.drawable.player_characterup);
		
		spriteCache.loadTile(Enemy.DOWN_GHOST_IMAGE, R.drawable.enemy_enemydown);
		spriteCache.loadTile(Enemy.LEFT_GHOST_IMAGE, R.drawable.enemy_enemyleft);
		spriteCache.loadTile(Enemy.RIGHT_GHOST_IMAGE, R.drawable.enemy_enemyright);
		spriteCache.loadTile(Enemy.UP_GHOST_IMAGE, R.drawable.enemy_enemyup);
		
		spriteCache.loadTile(Wall.WALL_IMAGE, R.drawable.wall_darkwall);
		spriteCache.loadTile(Wall.WALL_PAINTING, R.drawable.wall_wallpainting1);
		spriteCache.loadTile(Wall.WALL_SHELF, R.drawable.wall_wallshelf1);
		spriteCache.loadTile(Wall.WALL_CRACK, R.drawable.wall_with_hole);
		spriteCache.loadTile(Wall.WALL_WINDOW, R.drawable.wall_window);

		spriteCache.loadTile(Table.TABLE_IMAGE, R.drawable.collidable_tablesquare);
		
		spriteCache.loadTile(DiningTable.DININGTABLE_LEFT_IMAGE, R.drawable.table_diningtableleft);
		spriteCache.loadTile(DiningTable.DININGTABLE_MIDDLE_IMAGE, R.drawable.table_diningtablemiddle);
		spriteCache.loadTile(DiningTable.DININGTABLE_RIGHT_IMAGE, R.drawable.table_diningtableright);
		
		spriteCache.loadTile(Bookcase.BOOKCASE_LEFT_IMAGE, R.drawable.bookcase_left);
		spriteCache.loadTile(Bookcase.BOOKCASE_DOWN_IMAGE, R.drawable.bookcase_down);
		spriteCache.loadTile(Bookcase.BOOKCASE_RIGHT_IMAGE, R.drawable.bookcase_right);
		spriteCache.loadTile(Bookcase.BOOKCASE_UP_IMAGE, R.drawable.bookcase_up);
		spriteCache.loadTile(Bookcase.BOOKCASE_RIGHT_CORNER_IMAGE, R.drawable.bookcase_right_corner);
		spriteCache.loadTile(Bookcase.BOOKCASE_LEFT_CORNER_IMAGE, R.drawable.bookcase_left_corner);
		spriteCache.loadTile(Bookcase.BOOKCASE_RIGHT_CORNER_DOWN_IMAGE, R.drawable.bookcase_right_down_corner);
		spriteCache.loadTile(Bookcase.BOOKCASE_LEFT_CORNER_DOWN_IMAGE, R.drawable.bookcase_left_down_corner);
		
		spriteCache.loadTile(Desk.DESK_RIGHT_IMAGE, R.drawable.desk_right);
		spriteCache.loadTile(Desk.DESK_RIGHT_IMAGE_BOOK, R.drawable.desk_right_book);
		spriteCache.loadTile(Desk.DESK_LEFT_IMAGE, R.drawable.desk_left);


		
		spriteCache.loadTile(Chair.CHAIR_DOWN_IMAGE, R.drawable.chair_chair_down);
		spriteCache.loadTile(Chair.CHAIR_UP_IMAGE, R.drawable.chair_chair_up);
		spriteCache.loadTile(Chair.CHAIR_LEFT_IMAGE, R.drawable.chair_chair_left);
		spriteCache.loadTile(Chair.CHAIR_RIGHT_IMAGE, R.drawable.chair_chair_right);
		
		spriteCache.loadTile(Lamp.LAMP_IMAGE, R.drawable.lamp_lamp);
		
		spriteCache.loadTile(Door.NORTH_CLOSED_DOOR_IMAGE, R.drawable.door_northcloseddoor);
		spriteCache.loadTile(Door.NORTH_OPEN_DOOR_IMAGE, R.drawable.door_northopendoor);
		spriteCache.loadTile(Door.NORTH_STAIRS_UP, R.drawable.stairs_up);
		spriteCache.loadTile(Door.SOUTH_STAIRS_DOWN, R.drawable.stairs_down);
		spriteCache.loadTile(Door.WEST_CLOSED_DOOR_IMAGE, R.drawable.door_westcloseddoor);
		spriteCache.loadTile(Door.WEST_OPEN_DOOR_IMAGE, R.drawable.door_westopendoor);
		spriteCache.loadTile(Door.EAST_CLOSED_DOOR_IMAGE, R.drawable.door_eastcloseddoor);
		spriteCache.loadTile(Door.EAST_OPEN_DOOR_IMAGE, R.drawable.door_eastopendoor);
		spriteCache.loadTile(Door.SOUTH_CLOSED_DOOR_IMAGE, R.drawable.door_southcloseddoor);
		spriteCache.loadTile(Door.SOUTH_OPEN_DOOR_IMAGE, R.drawable.door_southopendoor);
		
		spriteCache.loadTile(Chest.FRONT_CLOSED_CHEST_IMAGE, R.drawable.chest_chestfrontclosed);
		spriteCache.loadTile(Chest.FRONT_OPEN_CHEST_IMAGE, R.drawable.chest_chestfrontopen);
		
		
	}
}
