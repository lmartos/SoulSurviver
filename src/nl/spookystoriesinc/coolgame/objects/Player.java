package nl.spookystoriesinc.coolgame.objects;

import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

/**
 * The Wombat is our 'player object'. It should try to eat leafs.
 * 
 * @author Paul de Groot
 */
public class Player extends GameObject {
	public static final String DOWN_PLAYER_IMAGE = "PlayerDown";
	public static final String LEFT_PLAYER_IMAGE = "PlayerLeft";
	public static final String RIGHT_PLAYER_IMAGE = "PlayerRight";
	public static final String UP_PLAYER_IMAGE = "PlayerUp";
	
	private String imageId = DOWN_PLAYER_IMAGE;

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return imageId;
	}
	
	public void setImageId(String imageId){
		this.imageId = imageId;
	}


	@Override
	public void onTouched(GameBoard gameBoard) {
		
	}

	@Override
	public int getImageIdInt() {
		return 0;
	}

}
