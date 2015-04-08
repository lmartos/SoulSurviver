package nl.spookystoriesinc.coolgame.objects;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.Log;
import android.widget.Toast;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;

public class Lever extends GameObject {
	
	public static final String LEVER_IMAGE_UP = "lever_up";
	public static final String LEVER_IMAGE_DOWN = "lever_down";
	private String state = LEVER_IMAGE_UP;
	private int leverX;
	private int leverY;
	private MediaPlayer mediaPlayer;
	private Context context;
	
	private boolean leverPulled = false;

	public Lever (Context context) {
		super();
		this.context = context;
	}
	

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
		this.leverX = this.getPositionX();
		this.leverY = this.getPositionY();
		Log.d("Clicked Lever", "Lever X: " + leverX + "Lever Y: " + leverY);
		
		if (leverX == (gameBoard.getPlayer().getPositionX() + 1) && leverY == gameBoard.getPlayer().getPositionY()){
			pullLever(gameBoard);
		} else if (leverX == (gameBoard.getPlayer().getPositionX() - 1) && leverY == gameBoard.getPlayer().getPositionY()) {
			pullLever(gameBoard);
		} else if (leverY == (gameBoard.getPlayer().getPositionY() + 1) && leverX == gameBoard.getPlayer().getPositionX()) {
			pullLever(gameBoard);
		} else if (leverY == (gameBoard.getPlayer().getPositionY() - 1) && leverX == gameBoard.getPlayer().getPositionX()) {
			pullLever(gameBoard);
		} else {
			Toast.makeText(context, "Out of range!", Toast.LENGTH_SHORT).show();
		}
		
		gameBoard.updateView();
	}
	
	public void pullLever(GameBoard gameBoard) {
		if (leverPulled == false) {
			leverPulled = true;
			gameBoard.setEnemySpawnTrue();
			playPullLeverSound();
			Toast.makeText(context, "You hear a spooky sound!", Toast.LENGTH_LONG).show();
			state = LEVER_IMAGE_DOWN;
		}else {
			Toast.makeText(context, "The lever is pulled", Toast.LENGTH_SHORT).show();
		}
	}
	
	private void playPullLeverSound() {
		mediaPlayer = MediaPlayer.create(context, R.raw.pulling_lever);
		mediaPlayer.start();
		}


}
