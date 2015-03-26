package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Enemy extends GameObject{
	public static final String DOWN_GHOST_IMAGE = "GhostDown";
	public static final String LEFT_GHOST_IMAGE = "GhostLeft";
	public static final String RIGHT_GHOST_IMAGE = "GhostRight";
	public static final String UP_GHOST_IMAGE = "GhostUp";
	
	private String state = DOWN_GHOST_IMAGE;

	@Override
	public String getImageId() {
		return state;
	}

	@Override
	public int getImageIdInt() {
		return 0;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		
	}

}
