package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Key extends GameObject{

	private final int id;
	
	public Key(int id){
		this.id = id;
	}
	
	@Override
	public String getImageId() {
		return null;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}

}
