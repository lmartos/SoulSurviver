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


	/** Called when the user touched this wombat. */
	@Override
	public void onTouched(GameBoard gameBoard) {
		Log.d(CoolGame.TAG, "Touched wombat");

		// Wombats always move a square to the right
		int newPosX = getPositionX();
		int newPosY = getPositionY();

		// If new position is over the edge of the board, do nothing
		if (newPosX >= gameBoard.getWidth()) {
			return;
		}

		// Check if there is a object on the new position
		GameObject objectAtNewPos = gameBoard.getObject(newPosX, newPosY);
		if (objectAtNewPos != null) {

			// Wombats can't move through rocks
			if (objectAtNewPos instanceof Rock) {
				return;
			}

			// Caught a leaf? Score!
			if (objectAtNewPos instanceof Leaf) {
				gameBoard.removeObject(objectAtNewPos);
				((CoolGame) gameBoard.getGame()).increaseScore();
			}
		}

		// Move wombat to the new position and redraw the app
		gameBoard.moveObject(this, newPosX, newPosY);
		gameBoard.updateView();
	}

	@Override
	public int getImageIdInt() {
		// TODO Auto-generated method stub
		return 0;
	}

}
