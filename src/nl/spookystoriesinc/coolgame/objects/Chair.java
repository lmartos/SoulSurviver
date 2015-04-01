package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Chair extends GameObject{
	public static final String CHAIR_DOWN_IMAGE = "Chair Down";
	public static final String CHAIR_UP_IMAGE = "Chair Up";
	public static final String CHAIR_RIGHT_IMAGE = "Chair Right";
	public static final String CHAIR_LEFT_IMAGE = "Chair Left";
	
	private String state;
	
	public Chair(String state) {
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
