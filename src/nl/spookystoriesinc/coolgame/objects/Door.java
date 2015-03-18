package nl.spookystoriesinc.coolgame.objects;

import android.util.Log;
import nl.spookystoriesinc.coolgame.*;
import nl.spookystoriesinc.model.*;
import nl.spookystoriesinc.view.*;



public class Door extends GameObject{
	
	public static final String NORTH_CLOSED_DOOR_IMAGE = "NorthClosedDoor";
	public static final String NORTH_OPEN_DOOR_IMAGE = "NorthOpenDoor";
	public static final String WEST_CLOSED_DOOR_IMAGE = "WestClosedDoor";
	public static final String WEST_OPEN_DOOR_IMAGE = "WestOpenDoor";
	public static final String SOUTH_CLOSED_DOOR_IMAGE = "SouthClosedDoor";
	public static final String SOUTH_OPEN_DOOR_IMAGE = "SouthOpenDoor";
	public static final String EAST_CLOSED_DOOR_IMAGE = "EastClosedDoor";
	public static final String EAST_OPEN_DOOR_IMAGE = "EastOpenDoor";
	private String state;
	private int doorX;
	private int doorY;
	private final int id;
	
	public Door(int id, String state){
		this.id = id;
		this.state = state;
	}
	
	@Override
	public String getImageId() {
		return state;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		this.doorX = this.getPositionX();
		this.doorY = this.getPositionY();
		Log.d("Chest", "You clicked the chest X: " + doorX + " Y: " + doorY);
		
		if(doorX == (gameBoard.getPlayer().getPositionX() + 1) && doorY == gameBoard.getPlayer().getPositionY()){
			if(InventoryView.checkForKey(this.id)){
				state = SOUTH_OPEN_DOOR_IMAGE;	
			}
		}
		else if(doorX == (gameBoard.getPlayer().getPositionX() - 1) && doorY == gameBoard.getPlayer().getPositionY()){
			if(InventoryView.checkForKey(this.id)){
				state = WEST_OPEN_DOOR_IMAGE;	
			}
		}
		else if(doorY == (gameBoard.getPlayer().getPositionY() + 1) && doorX == gameBoard.getPlayer().getPositionX()){
			if(InventoryView.checkForKey(this.id)){
				state = EAST_OPEN_DOOR_IMAGE;	
			}
		}
		else if(doorY == (gameBoard.getPlayer().getPositionY() - 1) && doorX == gameBoard.getPlayer().getPositionX()){
			if(InventoryView.checkForKey(this.id)){
				state = NORTH_OPEN_DOOR_IMAGE;	
			}
		}
		gameBoard.updateView();
		
	}

	@Override
	public int getImageIdInt() {
		return 0;
	}

	public int getId() {
		return id;
	}
	
}
