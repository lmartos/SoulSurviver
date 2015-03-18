package nl.spookystoriesinc.coolgame.objects;

import java.util.ArrayList;

import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGameBoard;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;

public class Chest extends GameObject{
	public static final String FRONT_CLOSED_CHEST_IMAGE = "FrontClosedChest";
	public static final String FRONT_OPEN_CHEST_IMAGE = "FrontOpenChest";
	private String state = FRONT_CLOSED_CHEST_IMAGE;
	private ArrayList<GameObject> items = new ArrayList<GameObject>();
	private int chestX;
	private int chestY;
	
	public Chest(){
		super();
		this.chestX = this.getPositionX();
		this.chestY = this.getPositionY();
	}

	@Override
	public String getImageId() {
		return state;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		this.chestX = this.getPositionX();
		this.chestY = this.getPositionY();
		Log.d("Chest", "You clicked the chest X: " + chestX + "Y" + chestY);
		
		if(chestX == (gameBoard.getPlayer().getPositionX() + 1) && chestY == gameBoard.getPlayer().getPositionY()){
			state = FRONT_OPEN_CHEST_IMAGE;
		}
		else if(chestX == (gameBoard.getPlayer().getPositionX() - 1) && chestY == gameBoard.getPlayer().getPositionY()){
			state = FRONT_OPEN_CHEST_IMAGE;
		}
		else if(chestY == (gameBoard.getPlayer().getPositionY() + 1) && chestX == gameBoard.getPlayer().getPositionX()){
			state = FRONT_OPEN_CHEST_IMAGE;
		}
		else if(chestY == (gameBoard.getPlayer().getPositionY() - 1) && chestX == gameBoard.getPlayer().getPositionX()){
			state = FRONT_OPEN_CHEST_IMAGE;
		}
		gameBoard.updateView();
	}

	@Override
	public int getImageIdInt() {
		// TODO Auto-generated method stub
		return 0;
	}

}
