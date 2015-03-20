package nl.spookystoriesinc.coolgame.objects;

import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Wall extends GameObject {
	public static final String WALL_IMAGE = "Wall";

	public Wall() {
		super();
	}

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return WALL_IMAGE;
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
