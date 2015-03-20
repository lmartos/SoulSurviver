package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Chair extends GameObject{

	public static final String CHAIR_IMAGE = "Chair";
	
	public Chair() {
		super();
	}

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return CHAIR_IMAGE;
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
