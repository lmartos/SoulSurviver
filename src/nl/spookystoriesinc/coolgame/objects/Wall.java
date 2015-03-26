package nl.spookystoriesinc.coolgame.objects;

import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Wall extends GameObject {
	public static final String WALL_IMAGE = "Wall";
	public static final String WALL_PAINTING = "WallPainting";
	public static final String WALL_SHELF = "WallShelf";
	
	private String state;

	public Wall(String state) {
		super();
		this.state = state;
	}

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return state;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
	}

	/** Returns the R.drawable generated unique code for the image
	 * or 0 when not needed*/
	@Override
	public int getImageIdInt() {
		return 0;
	}

}
