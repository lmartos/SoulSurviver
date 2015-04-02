package nl.spookystoriesinc.coolgame;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.view.GameBoardView;
import nl.spookystoriesinc.view.InventoryView;
import nl.spookystoriesinc.coolgame.objects.Enemy;
import nl.spookystoriesinc.coolgame.objects.Player;

/**
 * The game board for CoolGame.
 * 
 * @author Paul de Groot
 */
public class CoolGameBoard extends GameBoard {
	private static final int GAMEBOARD_WIDTH = 9;
	private static final int GAMEBOARD_HEIGHT = 7;
	private Intent gameIsOver;
	private Timer timer;
	Handler handler = new Handler();
	
	private boolean gameOver = false;
	
	// The difference between the players position and the clicked tile
	private int difX;
	private int difY;
	// the x where the player is moving to
	private int newX;
	private int newY;
	
	// The x pos. and y pos. from the player object
	private int oldX;
	private int oldY;
	private MainActivity mainActivity;
	private GameObject objectAtNewPos;

	/**
	 * Create a new game board.
	 */
	public CoolGameBoard(MainActivity mainActivity, Context context) {
		super(GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT, context);
		this.mainActivity = mainActivity;
	}
	
	
	@Override
	public void changeRoom(String room){
		timer.cancel();
		timer.purge();
		super.changeRoom(room);
		init();
	}
	public void reset(){
		gameOver = false;
		this.resetGame();
		timer = new Timer();
		init();
	}
	
	public void gameOver(){
		gameOver = true;
		timer.cancel();
		timer.purge();
		mainActivity.initGameOverState();
	}
	
	public void init(){
		if(getEnemy() == null){
			return;
		}
		timer = new Timer();
		timer.scheduleAtFixedRate(new MoveEnemyTask(), 1500, 1500);
		
	}
	class MoveEnemyTask extends TimerTask{
		
		// The difference between the players position and the clicked tile
		private int enemyDifX;
		private int enemyDifY;
		// the x where the player is moving to
		private int enemyNewX;
		private int enemyNewY;
		
		// The x pos. and y pos. from the player object
		private int enemyOldX;
		private int enemyOldY;
		
		@Override
		public void run() {
			
			if(gameOver){
				gameOver();
				return;
			}
			
			if(getEnemy().getPositionX() == (getPlayer().getPositionX() + 1) && getEnemy().getPositionY() == getPlayer().getPositionY()){
				gameOver();
				return;
			}
			else if(getEnemy().getPositionX() == (getPlayer().getPositionX() - 1) && getEnemy().getPositionY() == getPlayer().getPositionY()){
				gameOver();
				return;
			}
			else if(getEnemy().getPositionY() == (getPlayer().getPositionY() + 1) && getEnemy().getPositionX() == getPlayer().getPositionX()){
				gameOver();
				return;
			}
			else if(getEnemy().getPositionY() == (getPlayer().getPositionY() - 1) && getEnemy().getPositionX() == getPlayer().getPositionX()){
				gameOver();
				return;
			}
			// The x pos. and y pos. from the enemy object
						enemyOldX = getEnemy().getPositionX();
						enemyOldY = getEnemy().getPositionY();

						// Calculate the difference between the players position and enemy
						enemyDifX = getPlayer().getPositionX() - enemyOldX;
						enemyDifY = getPlayer().getPositionY() - enemyOldY;
						
						// links naar beneden
						if (enemyDifX <= 0 && enemyDifY >= 0) {
							moveChar(-1 , 1, getEnemy(), enemyDifX, enemyDifY);
						}
						// links naar boven
						else if (enemyDifX <= 0 && enemyDifY <= 0) {
							moveChar(-1, -1, getEnemy(), enemyDifX, enemyDifY);
						}
						// rechts naar boven
						else if (enemyDifX >= 0 && enemyDifY <= 0) {
							moveChar(1, -1, getEnemy(), enemyDifX, enemyDifY);
						}
						// rechts naar onder!
						else if(enemyDifX >= 0 && enemyDifY >= 0){
							moveChar(1, 1, getEnemy(), enemyDifX, enemyDifY);
						}
						else {
							return;		
						}		
						handler.post(new Runnable(){
							@Override
							public void run() {
								updateView();
							}	
						});
					}
				}
				/**
				 * 
				 */
				@Override
				public void onEmptyTileClicked(int x, int y) {
					
					if(gameOver){
						timer.cancel();
						timer.purge();
						return;
					}
					
					// The x pos. and y pos. from the object
					oldX = getPlayer().getPositionX();
					oldY = getPlayer().getPositionY();
					// Calculate the difference between the players position and the clicked tile
					difX = x - oldX;
					difY = y - oldY;
				
					// links naar beneden
					if (difX <= 0 && difY >= 0) {
						moveChar(-1, 1, this.getPlayer(), difX, difY);
					}
					// links naar boven
					else if (difX <= 0 && difY <= 0) {
						moveChar(-1, -1, this.getPlayer(), difX, difY);
					}
					// rechts naar boven
					else if (difX >= 0 && difY <= 0) {
						moveChar(1, -1, this.getPlayer(), difX, difY);
					}
					// rechts naar onder!
					else if(difX >= 0 && difY >= 0){
						moveChar(1, 1, this.getPlayer(), difX, difY);
					}
					else {
						return;		
					}
					updateView();
				}

				@Override
				public String getBackgroundImg(int mx, int my) {
					return null;
				}

				/**
				 * 					A method to remove the - from a number
				 * @param getal		the number you want to remove the - from
				 * @return			the number
				 */
				public int haalMinWeg(int getal) {
					if(getal >= 0 ){
						return getal;
					}
					else {
						return getal * -1;
					}
				}
				
				/**
				 * 
				 * @param x			which way you want to move in the x direction
				 * @param y			which way you want to move in the y direction
				 * @param obj		The object you want to move
				 * @param difX		the x difference between the object you want to move and where it has to move
				 * @param difY		the x difference between the object you want to move and where it has to move
				 */
				public void moveChar(int x, int y, GameObject obj, int difX, int difY){
					
					// The x pos. and y pos. from the object
					oldX = obj.getPositionX();
					oldY = obj.getPositionY();

						if (haalMinWeg(difX) >= haalMinWeg(difY)) {
							newX = oldX + x;
							newY = oldY;
							objectAtNewPos = this.getObject(newX, newY);
							if (objectAtNewPos != null) {
								newX = oldX;
								newY = oldY + y;
								objectAtNewPos = this.getObject(newX, newY);
								if (objectAtNewPos != null) {
									newX = oldX;
									newY = oldY - y;
									objectAtNewPos = this.getObject(newX, newY);
									if(objectAtNewPos != null){
										return;
									}
									else{
										if(y > 0){
											if(obj instanceof Player){
											((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
											}else{
												((Enemy) getEnemy()).setImageId(Enemy.UP_GHOST_IMAGE);
											}
										}
										else{
											if(obj instanceof Player){
												((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
											}else{
												((Enemy) getEnemy()).setImageId(Enemy.DOWN_GHOST_IMAGE);
											}
										}
										this.moveObject(obj, (oldX), (oldY - y));
									}
								} else {
									if(y > 0){
										if(obj instanceof Player){
										((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
										}else{
											((Enemy) getEnemy()).setImageId(Enemy.DOWN_GHOST_IMAGE);
										}
									}
									else{
										if(obj instanceof Player){
										((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
										}else{
											((Enemy) getEnemy()).setImageId(Enemy.UP_GHOST_IMAGE);
										}
									}
									this.moveObject(obj, (oldX), (oldY + y));
								}
							} else {
								if(x >= 0){
									if(obj instanceof Player){
									((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
									}else{
										((Enemy) getEnemy()).setImageId(Enemy.RIGHT_GHOST_IMAGE);
									}
								}
								else{
									if(obj instanceof Player){
									((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
									}else{
										((Enemy) getEnemy()).setImageId(Enemy.LEFT_GHOST_IMAGE);
									}
								}
								this.moveObject(obj, (oldX + x), oldY);
							}
						}
						else {
							newX = oldX;
							newY = oldY + y;
							objectAtNewPos = this.getObject(newX, newY);
							if (objectAtNewPos != null) {
								newX = oldX + x;
								newY = oldY;
								objectAtNewPos = this.getObject(newX, newY);
								if (objectAtNewPos != null) {
									newX = oldX - x;
									newY = oldY;
									objectAtNewPos = this.getObject(newX, newY);
									if(objectAtNewPos != null){
										return;
									}
									else{
										if(x >= 0){
											if(obj instanceof Player){
											((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
											}
											else{
												((Enemy) getEnemy()).setImageId(Enemy.RIGHT_GHOST_IMAGE);
											}
										}
										else{
											if(obj instanceof Player){
											((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
											}else{
												((Enemy) getEnemy()).setImageId(Enemy.LEFT_GHOST_IMAGE);
											}
										}
										this.moveObject(obj, (oldX - x), (oldY));
									}
								} else {
									if(x >= 0){
										if(obj instanceof Player){
										((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
										}else{
											((Enemy) getEnemy()).setImageId(Enemy.RIGHT_GHOST_IMAGE);
										}
									}
									else{
										if(obj instanceof Player){
										((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
										}else{
											((Enemy) getEnemy()).setImageId(Enemy.LEFT_GHOST_IMAGE);
										}
									}
									this.moveObject(obj, (oldX + x), (oldY));
								}
							} else {
								if(y >= 0){
									if(obj instanceof Player){
									((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
									}else{
										((Enemy) getEnemy()).setImageId(Enemy.DOWN_GHOST_IMAGE);
									}
								}
								else{
									if(obj instanceof Player){
									((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
									}else{
										((Enemy) getEnemy()).setImageId(Enemy.UP_GHOST_IMAGE);
									}
								}
								this.moveObject(obj, (oldX), (oldY + y));
						}
					}
				}
				
			}
