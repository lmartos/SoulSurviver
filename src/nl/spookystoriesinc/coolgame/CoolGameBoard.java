package nl.spookystoriesinc.coolgame;

import android.util.Log;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.view.GameBoardView;
import nl.spookystoriesinc.coolgame.objects.Player;

/**
 * The game board for CoolGame.
 * 
 * @author Paul de Groot
 */
public class CoolGameBoard extends GameBoard {
	private static final int GAMEBOARD_WIDTH = 9;
	private static final int GAMEBOARD_HEIGHT = 7;

	// The difference between the players position and the clicked tile
	private int difX;
	private int difY;
	// the x where the wombat is moving to
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
	}

	/**
	 * 
	 */
	@Override
	public void onEmptyTileClicked(int x, int y) {
		
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
		return getal * -1;
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
