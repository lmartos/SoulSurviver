package nl.spookystoriesinc.coolgame.objects;

import java.io.Serializable;

import nl.spookystoriesinc.coolgame.CodeslotActivity;
import nl.spookystoriesinc.coolgame.TekstOverlayActivity;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.view.InventoryView;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class CodelockDoor extends Door implements Serializable {
	
	private GameBoard board;
	private int code = 378;
	private Context context;
	private int doorY = this.getPositionY();
	private int doorX = this.getPositionY();
	private boolean opened = false;

	public CodelockDoor(int id, String state, GameBoard board, Context context, String room, boolean b) {
		super(id, state, board, context, room, b);
		this.board = board;
		this.context = context;
	}
	
	public void setOpened(boolean bool){
		this.opened = bool;
		this.setState(WEST_OPEN_DOOR_IMAGE);
	}
	
	
	@Override
	public void onTouched(GameBoard gameBoard){
	
	if(opened == false){
		
	
	if(doorX == (gameBoard.getPlayer().getPositionX() + 1) && doorY == gameBoard.getPlayer().getPositionY()){
		startOverlay();	
		
	}
	else if(doorX == (gameBoard.getPlayer().getPositionX() - 1) && doorY == gameBoard.getPlayer().getPositionY()){
		startOverlay();	
			
	}
	else if(doorY == (gameBoard.getPlayer().getPositionY() + 1) && doorX == gameBoard.getPlayer().getPositionX()){
		startOverlay();	
			
	}
	else if(doorY == (gameBoard.getPlayer().getPositionY() - 1) && doorX == gameBoard.getPlayer().getPositionX()){
		startOverlay();		
		

	}else{
		Toast.makeText(context, "Out of range!", Toast.LENGTH_SHORT).show();
		}
		
	}else{
		super.onTouched(gameBoard);
		}
		
	}
	
	public void startOverlay(){
				Intent intent = new Intent(context, CodeslotActivity.class);
				intent.putExtra("the door", this);
				context.startActivity(intent);
	}
}
