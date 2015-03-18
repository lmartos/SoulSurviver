package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Note extends GameObject{
	
	public static final String NOTE_IMAGE = "Note";
	
	public Note(){
		super();
	}

	@Override
	public String getImageId() {
		return NOTE_IMAGE;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getImageIdInt() {
		return 0;
	}

}
