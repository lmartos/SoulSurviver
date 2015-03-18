package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.coolgame.objects.Chair;
import nl.spookystoriesinc.coolgame.objects.Chest;
import nl.spookystoriesinc.coolgame.objects.Door;
import nl.spookystoriesinc.coolgame.objects.Leaf;
import nl.spookystoriesinc.coolgame.objects.Rock;
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
		spriteCache.loadTile("empty", R.drawable.hardwoodfloor);
		setEmptyTile("empty");

		// Load the images for the GameObjects
		spriteCache.loadTile(Leaf.LEAF_IMAGE, R.drawable.leaf);
		
		spriteCache.loadTile(Player.DOWN_PLAYER_IMAGE, R.drawable.characterdown);
		spriteCache.loadTile(Player.LEFT_PLAYER_IMAGE, R.drawable.characterleft);
		spriteCache.loadTile(Player.RIGHT_PLAYER_IMAGE, R.drawable.characterright);
		spriteCache.loadTile(Player.UP_PLAYER_IMAGE, R.drawable.characterup);
		
		spriteCache.loadTile(Wall.WALL_IMAGE, R.drawable.darkwall);
		spriteCache.loadTile(Table.TABLE_IMAGE, R.drawable.tablesquare);
		
		spriteCache.loadTile(Door.CLOSED_DOOR_IMAGE, R.drawable.doorclosed);
		spriteCache.loadTile(Door.OPEN_DOOR_IMAGE, R.drawable.dooropen);
		
		spriteCache.loadTile(Chest.FRONT_CLOSED_CHEST_IMAGE, R.drawable.chestfrontclosed);
		spriteCache.loadTile(Chest.FRONT_OPEN_CHEST_IMAGE, R.drawable.chestfrontopen);
		
		spriteCache.loadTile(Chair.CHAIR_IMAGE, R.drawable.chair);
	}
}
