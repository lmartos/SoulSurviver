package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Door extends GameObject{
	
	public static final String CLOSED_DOOR_IMAGE = "ClosedDoor";
	public static final String OPEN_DOOR_IMAGE = "OpenDoor";
	private final int id;
	
	public Door(int id){
		this.id = id;
	}
	
	@Override
	public String getImageId() {
		return CLOSED_DOOR_IMAGE;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// You should get the inventory filled with the keys
		// and look which keys are there
		// getInventory();
		
		//for(int i = 0; i < getInventory.size() ; i++)
			//if(getInventory(i).getKeyId == this.id ) {
				//this.unlock();
			//}
			//else{
				//this.lock();
			//}
		
		
		
	}

	@Override
	public int getImageIdInt() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
