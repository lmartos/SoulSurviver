package nl.spookystoriesinc.coolgame;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.view.GameBoardView;
import nl.spookystoriesinc.view.InventoryView;
import nl.spookystoriesinc.coolgame.objects.Player;

/**
 * The game board for CoolGame.
 * 
 * @author Paul de Groot
 */
public class CoolGameBoard extends GameBoard {
	private static final int GAMEBOARD_WIDTH = 9;
	private static final int GAMEBOARD_HEIGHT = 7;
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
	private GameObject objectAtNewPos;

	/**
	 * Create a new game board.
	 */
	public CoolGameBoard() {
		super(GAMEBOARD_WIDTH, GAMEBOARD_HEIGHT);
		timer = new Timer();
	}
	
	public void init(){
		if(getEnemy() == null){
			return;
		}
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
			
			if(getEnemy().getPositionX() == (getPlayer().getPositionX() + 1) && getEnemy().getPositionY() == getPlayer().getPositionY()){
				gameOver = true;
				return;
			}
			else if(getEnemy().getPositionX() == (getPlayer().getPositionX() - 1) && getEnemy().getPositionY() == getPlayer().getPositionY()){
				gameOver = true;
				return;
			}
			else if(getEnemy().getPositionY() == (getPlayer().getPositionY() + 1) && getEnemy().getPositionX() == getPlayer().getPositionX()){
				gameOver = true;
				return;
			}
			else if(getEnemy().getPositionY() == (getPlayer().getPositionY() - 1) && getEnemy().getPositionX() == getPlayer().getPositionX()){
				gameOver = true;
				return;
			}
			// The x pos. and y pos. from the player object
			enemyOldX = getEnemy().getPositionX();
			enemyOldY = getEnemy().getPositionY();

			// Calculate the difference between the players position and the clicked tile
			enemyDifX = getPlayer().getPositionX() - enemyOldX;
			enemyDifY = getPlayer().getPositionY() - enemyOldY;
			
			Log.d("Enemy", "Enemy Xdif: " + enemyDifX + " YDif: " + enemyDifY);
			
			// links naar beneden
			if (enemyDifX <= 0 && enemyDifY >= 0) {
				EnemyLeftDown(enemyOldX, enemyOldY);
			}
			// links naar boven
			else if (enemyDifX <= 0 && enemyDifY <= 0) {
				EnemyLeftUp(enemyOldX, enemyOldY);
			}

			// rechts naar boven
			else if (enemyDifX >= 0 && enemyDifY <= 0) {
				EnemyRightUp(enemyOldX, enemyOldY);
			}

			// rechts naar onder!
			else if(enemyDifX >= 0 && enemyDifY >= 0){
				EnemyRightDown(enemyOldX, enemyOldY);
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
		public void EnemyLeftDown(int oldX, int oldY){
			Log.d("EnemyLeftDown", "moving enemy left down");
				// links
				if (haalMinWeg(enemyDifX) >= haalMinWeg(enemyDifY)) {
					enemyNewX = oldX - 1;
					enemyNewY = oldY;
					objectAtNewPos = getObject(enemyNewX, enemyNewY);
					if (objectAtNewPos != null) {
						enemyNewX = oldX;
						enemyNewY = oldY + 1;
						objectAtNewPos = getObject(enemyNewX, enemyNewY);
						if (objectAtNewPos != null) {
							return;
						} else {
							moveObject(getEnemy(), (oldX), (oldY + 1));
						}
					} else {
						moveObject(getEnemy(), (oldX - 1), oldY);
					}
				}
				// beneden
				else {
					enemyNewX = oldX;
					enemyNewY = oldY + 1;
					objectAtNewPos = getObject(enemyNewX, enemyNewY);
					if (objectAtNewPos != null) {
						enemyNewX = oldX - 1;
						enemyNewY = oldY;
						objectAtNewPos = getObject(enemyNewX, enemyNewY);
						if (objectAtNewPos != null) {
							return;
						} else {
							moveObject(getEnemy(), (oldX - 1), (oldY));
						}
					} else {
						moveObject(getEnemy(), (oldX), (oldY + 1));
					}
			}
		}
		public void EnemyLeftUp(int oldX, int oldY){
			Log.d("EnemyLeftUp", "moving enemy left up");

				// links
				if (haalMinWeg(enemyDifX) >= haalMinWeg(enemyDifY)) {
					enemyNewX = oldX - 1;
					enemyNewY = oldY;
					objectAtNewPos = getObject(enemyNewX, enemyNewY);
					if (objectAtNewPos != null) {
						enemyNewX = oldX;
						enemyNewY = oldY - 1;
						objectAtNewPos = getObject(enemyNewX, enemyNewY);
						if (objectAtNewPos != null) {
							return;
						} else {
							moveObject(getEnemy(), (oldX), (oldY - 1));
						}
					} else {
						moveObject(getEnemy(), (oldX - 1), oldY);
					}
				}
				// boven
				else {
					enemyNewX = oldX;
					enemyNewY = oldY - 1;
					objectAtNewPos = getObject(enemyNewX, enemyNewY);
					if (objectAtNewPos != null) {
						enemyNewX = oldX - 1;
						enemyNewY = oldY;
						objectAtNewPos = getObject(enemyNewX, enemyNewY);
						if (objectAtNewPos != null) {
							return;
						} else {
							moveObject(getEnemy(), (oldX - 1), (oldY));
						}
					} else {
						moveObject(getEnemy(), (oldX), (oldY - 1));
					}
				
			}
		}
		public void EnemyRightUp(int oldX, int oldY){
			Log.d("EnemyLRightUp", "moving enemy right up");
				// rechts
				if (haalMinWeg(enemyDifX) >= haalMinWeg(enemyDifY)) {
					enemyNewX = oldX + 1;
					enemyNewY = oldY;
					objectAtNewPos = getObject(enemyNewX, enemyNewY);
					if (objectAtNewPos != null) {
						enemyNewX = oldX;
						enemyNewY = oldY - 1;
						objectAtNewPos = getObject(enemyNewX, enemyNewY);
						if (objectAtNewPos != null) {
							return;
						} else {
							moveObject(getEnemy(), (oldX), (oldY - 1));
						}
					} else {
						moveObject(getEnemy(), (oldX + 1), oldY);
					}
				}
				// omhoog
				else {
					enemyNewX = oldX;
					enemyNewY = oldY - 1;
					objectAtNewPos = getObject(enemyNewX, enemyNewY);
					if (objectAtNewPos != null) {
						enemyNewX = oldX + 1;
						enemyNewY = oldY;
						objectAtNewPos = getObject(enemyNewX, enemyNewY);
						if (objectAtNewPos != null) {
							return;
						} else {
							moveObject(getEnemy(), (oldX + 1), (oldY));
						}
					} else {
						moveObject(getEnemy(), (oldX), (oldY - 1));
					}
			}
		}
		public void EnemyRightDown(int oldX, int oldY){
			Log.d("EnemyRightDown", "moving enemy Right down");
				// rechts
				if (haalMinWeg(enemyDifX) >= haalMinWeg(enemyDifY)) {
					enemyNewX = oldX + 1;
					enemyNewY = oldY;
					objectAtNewPos = getObject(enemyNewX, enemyNewY);
					if (objectAtNewPos != null) {
						enemyNewX = oldX;
						enemyNewY = oldY + 1;
						objectAtNewPos = getObject(enemyNewX, enemyNewY);
						if (objectAtNewPos != null) {
							return;
						} else {
							moveObject(getEnemy(), (oldX), (oldY + 1));
						}
					} else {
						moveObject(getEnemy(), (oldX + 1), oldY);
					}
				}
				// beneden
				else {
					enemyNewX = oldX;
					enemyNewY = oldY + 1;
					objectAtNewPos = getObject(enemyNewX, enemyNewY);
					if (objectAtNewPos != null) {
						enemyNewX = oldX + 1;
						enemyNewY = oldY;
						objectAtNewPos = getObject(enemyNewX, enemyNewY);
						if (objectAtNewPos != null) {
							return;
						} else {
							moveObject(getEnemy(), (oldX + 1), (oldY));
						}
					} else {
						moveObject(getEnemy(), (oldX), (oldY + 1));
					}
				}
		}
	}
	/**
	 * 
	 */
	@Override
	public void onEmptyTileClicked(int x, int y) {
		if(gameOver){
			timer.cancel();
			return;
		}
		//timer.schedule(new MoveEnemyTask(), 1500);
		
		// The x pos. and y pos. from the player object
		oldX = getPlayer().getPositionX();
		oldY = getPlayer().getPositionY();

		// Calculate the difference between the players position and the clicked tile
		difX = x - oldX;
		difY = y - oldY;
		
		// links naar beneden
		if (difX <= 0 && difY >= 0) {
			moveLeftDown(oldX, oldY);
		}
		// links naar boven
		else if (difX <= 0 && difY <= 0) {
			moveLeftUp(oldX, oldY);
		}

		// rechts naar boven
		else if (difX >= 0 && difY <= 0) {
			moveRightUp(oldX, oldY);
		}

		// rechts naar onder!
		else if(difX >= 0 && difY >= 0){
			moveRightDown(oldX, oldY);
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
	
	public void moveLeftDown(int oldX, int oldY){

		// links naar beneden
		if (difX <= 0 && difY >= 0) {
			// links
			if (haalMinWeg(difX) >= difY) {
				newX = oldX - 1;
				newY = oldY;
				objectAtNewPos = this.getObject(newX, newY);
				if (objectAtNewPos != null) {
					newX = oldX;
					newY = oldY + 1;
					objectAtNewPos = this.getObject(newX, newY);
					if (objectAtNewPos != null) {
						return;
					} else {
						((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX), (oldY + 1));
					}
				} else {
					((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
					this.moveObject(getPlayer(), (oldX - 1), oldY);
				}
			}
			// beneden
			else {
				newX = oldX;
				newY = oldY + 1;
				objectAtNewPos = this.getObject(newX, newY);
				if (objectAtNewPos != null) {
					newX = oldX - 1;
					newY = oldY;
					objectAtNewPos = this.getObject(newX, newY);
					if (objectAtNewPos != null) {
						return;
					} else {
						((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX - 1), (oldY));
					}
				} else {
					((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
					this.moveObject(getPlayer(), (oldX), (oldY + 1));
				}
			}
		}
	}
	
	
	public void moveLeftUp(int oldX, int oldY){
		
		if (haalMinWeg(difX) >= haalMinWeg(difY)) {
			newX = oldX - 1;
			newY = oldY;
			objectAtNewPos = this.getObject(newX, newY);
			if (objectAtNewPos != null) {
				newX = oldX;
				newY = oldY - 1;
				objectAtNewPos = this.getObject(newX, newY);
				if (objectAtNewPos != null) {
					return;
				} else {
					((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
					this.moveObject(getPlayer(), (oldX), (oldY - 1));
				}
			} else {
				Log.d(CoolGame.TAG, "Going left");
				((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
				this.moveObject(getPlayer(), (oldX - 1), (oldY));
			}
		}
		else {
			newX = oldX;
			newY = oldY - 1;

			objectAtNewPos = this.getObject(newX, newY);

			if (objectAtNewPos != null) {

				newX = oldX - 1;
				newY = oldY;
				objectAtNewPos = this.getObject(newX, newY);

				if (objectAtNewPos != null) {
					return;

				} else {
					((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
					this.moveObject(getPlayer(), (oldX - 1), (oldY));

				}
			} else {
				((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
				this.moveObject(getPlayer(), (oldX), (oldY - 1));
			}
		}
	}
	
	public void moveRightUp(int oldX, int oldY){
		if (difX >= haalMinWeg(difY)) {
			newX = oldX + 1;
			newY = oldY;
			objectAtNewPos = this.getObject(newX, newY);
			if (objectAtNewPos != null) {
				newX = oldX;
				newY = oldY - 1;
				objectAtNewPos = this.getObject(newX, newY);
				if (objectAtNewPos != null) {
					return;
				} else {
					((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
					this.moveObject(getPlayer(), (oldX), (oldY - 1));
				}
			} else {
				((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
				this.moveObject(getPlayer(), (oldX + 1), (oldY));
			}
		}
		else {
			newX = oldX;
			newY = oldY - 1;
			objectAtNewPos = this.getObject(newX, newY);
			if (objectAtNewPos != null) {
				newX = oldX + 1;
				newY = oldY;
				objectAtNewPos = this.getObject(newX, newY);
				if (objectAtNewPos != null) {
					return;
				} else {
					((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
					this.moveObject(getPlayer(), (oldX + 1), (oldY));
				}
			} else {
				((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
				this.moveObject(getPlayer(), (oldX), (oldY - 1));
				Log.d(CoolGame.TAG, "Going up");
			}
		}
	}

	public void moveRightDown(int oldX, int oldY){

		if (difX >= difY) {
			newX = oldX + 1;
			newY = oldY;
			objectAtNewPos = this.getObject(newX, newY);
			if (objectAtNewPos != null) {
				newX = oldX;
				newY = oldY + 1;
				objectAtNewPos = this.getObject(newX, newY);
				if (objectAtNewPos != null) {
					return;
				} else {
					((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
					this.moveObject(getPlayer(), (oldX), (oldY + 1));
				}
			} else {
				((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
				this.moveObject(getPlayer(), (oldX + 1), oldY);
			}
		}
		else if (difX < difY) {
			newX = oldX;
			newY = oldY + 1;
			objectAtNewPos = this.getObject(newX, newY);
			if (objectAtNewPos != null) {
				newX = oldX + 1;
				newY = oldY;
				objectAtNewPos = this.getObject(newX, newY);
				if (objectAtNewPos != null) {
					return;
				} else {
					((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
					this.moveObject(getPlayer(), (oldX + 1), (oldY));
				}
			} else {
				((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
				this.moveObject(getPlayer(), (oldX), oldY + 1);
			}
		}
	}
}
