package nl.spookystoriesinc.coolgame.objects;

import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Player extends GameObject {
	
	// the images of the different states of the player
	public static final String DOWN_PLAYER_IMAGE = "PlayerDown";
	public static final String LEFT_PLAYER_IMAGE = "PlayerLeft";
	public static final String RIGHT_PLAYER_IMAGE = "PlayerRight";
	public static final String UP_PLAYER_IMAGE = "PlayerUp";
	
	// The current state where the player is in (moving Down, Left, Right or Up)
	private String state = DOWN_PLAYER_IMAGE;

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return state;
	}
	
	public void setImageId(String state){
		this.state = state;
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
