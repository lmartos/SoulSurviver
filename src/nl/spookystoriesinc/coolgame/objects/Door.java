package nl.spookystoriesinc.coolgame.objects;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;
import nl.spookystoriesinc.coolgame.*;
import nl.spookystoriesinc.model.*;
import nl.spookystoriesinc.spookystories.R;
import nl.spookystoriesinc.view.*;



public class Door extends GameObject{
	// The different states of a door that is placed on the north side
	public static final String NORTH_CLOSED_DOOR_IMAGE = "NorthClosedDoor";
	public static final String NORTH_OPEN_DOOR_IMAGE = "NorthOpenDoor";
	// stairs
	public static final String NORTH_STAIRS_UP = "NorthStairsUp";
	public static final String SOUTH_STAIRS_DOWN = "SouthStairsDown";
	// The different states of a door that is placed on the west side
	public static final String WEST_CLOSED_DOOR_IMAGE = "WestClosedDoor";
	public static final String WEST_OPEN_DOOR_IMAGE = "WestOpenDoor";
	// The different states of a door that is placed on the south side
	public static final String SOUTH_CLOSED_DOOR_IMAGE = "SouthClosedDoor";
	public static final String SOUTH_OPEN_DOOR_IMAGE = "SouthOpenDoor";
	// The different states of a door that is placed on the east side
	public static final String EAST_CLOSED_DOOR_IMAGE = "EastClosedDoor";
	public static final String EAST_OPEN_DOOR_IMAGE = "EastOpenDoor";
	// the state of the door 
	private String state;
	private int doorX;
	private int doorY;
	private final int id;
	private Context context;
	private MediaPlayer mediaPlayer;
	private String room;
	private GameBoard board;
	private boolean isVictoryDoor;

	
	/**
	 * 				Make a door object
	 * @param id	the unique id of the door that helps with locking and unlocking	
	 * @param state	the state where the door is in
	 */
	public Door(int id, String state, GameBoard board, Context context, String room, boolean b){
		this.id = id;
		this.state = state;
		this.context = context;
		this.room = room;
		this.board = board;
	}
	
	public void setVictoryDoor(boolean bool){
		isVictoryDoor = bool;
	}
	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return state;
	}
	public void setState(String state){
		this.state = state;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		doorCheck(gameBoard);
	}
	
	/** Returns the R.drawable generated unique code for the image
	 * or 0 when not needed*/
	@Override
	public int getImageIdInt() {
		return 0;
	}

	/**
	 * 			get the unique id of the door
	 * @return	returns the id
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 						The method will check first what the X and Y positions of the door are
	 * 						Then it will check if the door is not already open if so it returns
	 * 						then it will check if there is a player right, left, above or beneath it
	 * 						if so then it will open if the player has the right key
	 * 						else it will stay closed or say it is out of range
	 * @param gameBoard		The GameBoard where the door object is on
	 */
	public void doorCheck(GameBoard gameBoard){
		
		this.doorX = this.getPositionX();
		this.doorY = this.getPositionY();
		Log.d("Chest", "You clicked the chest X: " + doorX + " Y: " + doorY);
		
		
		if(doorX == (gameBoard.getPlayer().getPositionX() + 1) && doorY == gameBoard.getPlayer().getPositionY()){
				
				
			
				if(InventoryView.checkForKey(this.id) || this.id == 0){
					state = EAST_OPEN_DOOR_IMAGE;
					Toast.makeText(context, "You've opened a door!", Toast.LENGTH_SHORT).show();
					
					playOpenDoor();
					if(openCheck()){
						return;
					}
				
			}
			else{
				Toast.makeText(context, "The door is locked!", Toast.LENGTH_SHORT).show();
				playDoorLocked();
			}
		}
		else if(doorX == (gameBoard.getPlayer().getPositionX() - 1) && doorY == gameBoard.getPlayer().getPositionY()){
			
				
			
				if(InventoryView.checkForKey(this.id) || this.id == 0){
					state = WEST_OPEN_DOOR_IMAGE;	
					Toast.makeText(context, "You've opened a door!", Toast.LENGTH_SHORT).show();
					
					playOpenDoor();
					
					if(openCheck()){
						return;
					}
				
				
			}
			else{
				Toast.makeText(context, "The door is locked!", Toast.LENGTH_SHORT).show();
				playDoorLocked();
			}
		}
		else if(doorY == (gameBoard.getPlayer().getPositionY() + 1) && doorX == gameBoard.getPlayer().getPositionX()){
			
			
				
				if(InventoryView.checkForKey(this.id) || this.id == 0){
					state = SOUTH_OPEN_DOOR_IMAGE;	
					Toast.makeText(context, "You've opened a door!", Toast.LENGTH_SHORT).show();
					
					playOpenDoor();
					if(openCheck()){
						return;
					}
				
				
			}
			else{
				Toast.makeText(context, "The door is locked!", Toast.LENGTH_SHORT).show();
				playDoorLocked();
			}
		}
		else if(doorY == (gameBoard.getPlayer().getPositionY() - 1) && doorX == gameBoard.getPlayer().getPositionX()){
				
				
				
			if(InventoryView.checkForKey(this.id) || this.id == 0){
					state = NORTH_OPEN_DOOR_IMAGE;
					Toast.makeText(context, "You've opened a door!", Toast.LENGTH_SHORT).show();
					
					playOpenDoor();
					
					if(openCheck()){
						return;
					}
				
				
			}
			else{
				Toast.makeText(context, "The door is locked!", Toast.LENGTH_SHORT).show();
				playDoorLocked();
			}
				
	
		}
		else{
			Toast.makeText(context, "Out of range!", Toast.LENGTH_SHORT).show();
		}
	
		
		
		gameBoard.updateView();
		
	}
	
	public boolean openCheck(){
		if(isVictoryDoor){
			Intent victoryIntent = new Intent(context, GameOverScreenActivity.class);
			victoryIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			victoryIntent.putExtra("Victory", true);
			context.startActivity(victoryIntent);
		}else if(this.state == NORTH_OPEN_DOOR_IMAGE || this.state == WEST_OPEN_DOOR_IMAGE 
				|| this.state == EAST_OPEN_DOOR_IMAGE || this.state == SOUTH_OPEN_DOOR_IMAGE || this.state == NORTH_STAIRS_UP || this.state == SOUTH_STAIRS_DOWN){
			playOpenDoor();
			board.changeRoom(room);
			return true;
		}
		return false;	
	}

	private void playDoorLocked() {
		mediaPlayer = MediaPlayer.create(context, R.raw.door_locked);
		mediaPlayer.start();
	}
	
	public void playOpenDoor(){
		mediaPlayer = MediaPlayer.create(context, R.raw.opening_door);
		mediaPlayer.start();
	}
	
	
}
