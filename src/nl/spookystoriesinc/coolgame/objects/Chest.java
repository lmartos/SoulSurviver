package nl.spookystoriesinc.coolgame.objects;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import nl.spookystoriesinc.coolgame.CoolGameBoard;
import nl.spookystoriesinc.coolgame.MainActivity;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;
import nl.spookystoriesinc.view.InventoryView;

public class Chest extends GameObject{
	public static final String FRONT_CLOSED_CHEST_IMAGE = "FrontClosedChest";
	public static final String FRONT_OPEN_CHEST_IMAGE = "FrontOpenChest";
	private String state = FRONT_CLOSED_CHEST_IMAGE;
	private ArrayList<GameObject> items = new ArrayList<GameObject>();
	private int chestX;
	private int chestY;
	private Context context;
	
	public Chest(Context context){
		super();
		this.context = context;
		
	}
	
	/**
	 * 				Adds a key to the loot of the chest
	 * @param key	The key that you want to be added
	 */
	public void addKey(Key key){
		items.add(key);
	}

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return state;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		checkChest(gameBoard);
	}

	/** Returns the R.drawable generated unique code for the image
	 * or 0 when not needed*/
	@Override
	public int getImageIdInt() {
		return 0;
	}
	
	/**
	 * 						The method will check first what the X and Y position of the chest are
	 * 						then it will check if the chest is not already opened if so it returns
	 * 						then it will look if there's a player object left, right, above or beneath the chest.
	 * 						if there is a player object there, then the chest will open
	 * 						if the player object is out of range then it will stay closed
	 * @param gameBoard		The gameboard the chest is at
	 */
	public void checkChest(GameBoard gameBoard){
		this.chestX = this.getPositionX();
		this.chestY = this.getPositionY();
		Log.d("Chest", "You clicked the chest X: " + chestX + " Y: " + chestY);
		
		if(this.state == FRONT_OPEN_CHEST_IMAGE){
			Toast.makeText(context, "You've already opened this chest!", Toast.LENGTH_LONG).show();
			return;
		}
		
		if(chestX == (gameBoard.getPlayer().getPositionX() + 1) && chestY == gameBoard.getPlayer().getPositionY()){
			state = FRONT_OPEN_CHEST_IMAGE;
			for(GameObject item: items){
				InventoryView.addItemToInventory(item);
			}	
			this.items.removeAll(items);
			Toast.makeText(context, "You've opened a chest!", Toast.LENGTH_LONG).show();
		}
		else if(chestX == (gameBoard.getPlayer().getPositionX() - 1) && chestY == gameBoard.getPlayer().getPositionY()){
			state = FRONT_OPEN_CHEST_IMAGE;
			for(GameObject item: items){
				InventoryView.addItemToInventory(item);
			}	
			this.items.removeAll(items);
			Toast.makeText(context, "You've opened a chest!",Toast.LENGTH_LONG).show();
		}
		else if(chestY == (gameBoard.getPlayer().getPositionY() + 1) && chestX == gameBoard.getPlayer().getPositionX()){
			state = FRONT_OPEN_CHEST_IMAGE;
			for(GameObject item: items){
				InventoryView.addItemToInventory(item);
			}	
			this.items.removeAll(items);
			Toast.makeText(context, "You've opened a chest!", Toast.LENGTH_LONG).show();
		}
		else if(chestY == (gameBoard.getPlayer().getPositionY() - 1) && chestX == gameBoard.getPlayer().getPositionX()){
			state = FRONT_OPEN_CHEST_IMAGE;
			for(GameObject item: items){
				InventoryView.addItemToInventory(item);
			}
			this.items.removeAll(items);
			Toast.makeText(context, "You've opened a chest!",Toast.LENGTH_LONG).show();
		}
		else{
			Toast.makeText(context, "Out of range!", Toast.LENGTH_SHORT).show();
		}
		gameBoard.updateView();
	}

}
