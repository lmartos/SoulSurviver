package nl.spookystoriesinc.coolgame;

import android.util.Log;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.view.GameBoardView;
import nl.spookystoriesinc.coolgame.objects.Leaf;
import nl.spookystoriesinc.coolgame.objects.Rock;
import nl.spookystoriesinc.coolgame.objects.Player;

/**
 * The game board for CoolGame.
 * 
 * @author Paul de Groot
 */
public class CoolGameBoard extends GameBoard {
	private static final int GAMEBOARD_WIDTH = 9;
	private static final int GAMEBOARD_HEIGHT = 7;

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
		int oldX = getPlayer().getPositionX();
		int oldY = getPlayer().getPositionY();
		// The difference between the players position and the clicked tile
		int difX;
		int difY;
		// the x where the wombat is moving to
		int newX;
		int newY;

		GameObject objectAtNewPos;
		// while the player has not yet reached the clicked position this while loop will execute
		//while (x != oldX || y != oldY) {
			updateView();

			oldX = getPlayer().getPositionX();
			Log.d(CoolGame.TAG, "oldX: " + oldX);
			oldY = getPlayer().getPositionY();
			Log.d(CoolGame.TAG, "oldY: " + oldY);

			// If the player reached the clicked position the method will end
			if (oldX == x && oldY == y) {
				return;
			}
			// Calculate the difference between the players position and the
			// clicked tile
			difX = x - oldX;
			Log.d(CoolGame.TAG, "difX: " + difX);
			difY = y - oldY;
			Log.d(CoolGame.TAG, "difY: " + difY);
			
			
			
			// links naar beneden
			if (difX <= 0 && difY >= 0) {
				// links
				if(haalMinWeg(difX) >= difY){
					newX = oldX - 1;
					newY = oldY;

					objectAtNewPos = this.getObject(newX, newY);

					if (objectAtNewPos != null) {

						// Wombats can't move through rocks
					
							newX = oldX;
							newY = oldY + 1;
							objectAtNewPos = this.getObject(newX, newY);

							if (objectAtNewPos != null) {
								return;

							
							}
							else {
								Log.d(CoolGame.TAG, "Going down");
								((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
								this.moveObject(getPlayer(), (oldX), (oldY + 1));

							

						}
					} else {
						Log.d(CoolGame.TAG, "Going left");
						((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX - 1), oldY);
						
				}
					
			}
					
				// beneden
				else{
					newX = oldX;
					newY = oldY + 1;

					objectAtNewPos = this.getObject(newX, newY);

					if (objectAtNewPos != null) {

					
							newX = oldX - 1;
							newY = oldY;
							objectAtNewPos = this.getObject(newX, newY);

							if (objectAtNewPos != null) {
								return;
					
						}
							else {
								Log.d(CoolGame.TAG, "Going left");
								((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
								this.moveObject(getPlayer(), (oldX - 1), (oldY));

							

						}
					} else {
						Log.d(CoolGame.TAG, "Going down");
						((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX), (oldY + 1));
						
					}
				}

			}
			// links naar boven
			else if (difX <= 0 && difY <= 0) {
				if(haalMinWeg(difX) >= haalMinWeg(difY)){
					newX = oldX - 1;
					newY = oldY;

					objectAtNewPos = this.getObject(newX, newY);

					if (objectAtNewPos != null) {

			
							newX = oldX;
							newY = oldY - 1;
							objectAtNewPos = this.getObject(newX, newY);

							if (objectAtNewPos != null) {
								return;
					
						}
							else {
								Log.d(CoolGame.TAG, "Going up");
								((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
								this.moveObject(getPlayer(), (oldX), (oldY - 1));

							}
						
						
					} else {
						Log.d(CoolGame.TAG, "Going left");
						((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX - 1), (oldY));
				
					}
				}
				
				
				
				
				else{
					newX = oldX;
					newY = oldY - 1;

					objectAtNewPos = this.getObject(newX, newY);

					if (objectAtNewPos != null) {

				
							newX = oldX - 1;
							newY = oldY;
							objectAtNewPos = this.getObject(newX, newY);

							if (objectAtNewPos != null) {
								return;
					
						}
							else {
								Log.d(CoolGame.TAG, "Going left");
								((Player) getPlayer()).setImageId(Player.LEFT_PLAYER_IMAGE);
								this.moveObject(getPlayer(), (oldX - 1), (oldY));

							

						}
					} else {
						Log.d(CoolGame.TAG, "Going up");
						((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX), (oldY - 1));
						
					}
				}
			}
			
	
			// rechts naar boven
			else if(difX >= 0 && difY <= 0){
				if(difX >= haalMinWeg(difY)){
					newX = oldX + 1;
					newY = oldY;

					objectAtNewPos = this.getObject(newX, newY);

					if (objectAtNewPos != null) {

					
							newX = oldX;
							newY = oldY - 1;
							objectAtNewPos = this.getObject(newX, newY);

							if (objectAtNewPos != null) {
								return;
				
						}
							else {
								Log.d(CoolGame.TAG, "Going up");
								((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
								this.moveObject(getPlayer(), (oldX), (oldY - 1));

							

						}
					} else {
						Log.d(CoolGame.TAG, "Going right");
						((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX + 1), (oldY));
						
					}
				
				}
		
				else{
					newX = oldX;
					newY = oldY - 1;

					objectAtNewPos = this.getObject(newX, newY);

					if (objectAtNewPos != null) {

					
							newX = oldX + 1;
							newY = oldY;
							objectAtNewPos = this.getObject(newX, newY);

							if (objectAtNewPos != null) {
								return;
			
						}
							else {
								((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
								this.moveObject(getPlayer(), (oldX + 1), (oldY));
								Log.d(CoolGame.TAG, "Going right");

							

						}
					} else {
						((Player) getPlayer()).setImageId(Player.UP_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX), (oldY - 1));
						Log.d(CoolGame.TAG, "Going up");
						
					}
				}
			}
	
			// rechts naar onder!
			else {
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
					
						}
							else {
								((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
								this.moveObject(getPlayer(), (oldX), (oldY + 1));
								Log.d(CoolGame.TAG, "Going down");

							

						}
					} else {
						((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX + 1), oldY);
						Log.d(CoolGame.TAG, "Going right");
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
						
						}
							else {
								((Player) getPlayer()).setImageId(Player.RIGHT_PLAYER_IMAGE);
								this.moveObject(getPlayer(), (oldX + 1), (oldY));
								Log.d(CoolGame.TAG, "Going right");

							

						}
					} else {
						((Player) getPlayer()).setImageId(Player.DOWN_PLAYER_IMAGE);
						this.moveObject(getPlayer(), (oldX), oldY + 1);
						Log.d(CoolGame.TAG, "Going down");
					}
				}

				else {
					return;
				}
			}
			updateView();
		}
	//}

	@Override
	public String getBackgroundImg(int mx, int my) {
		return null;
	}

	public int haalMinWeg(int getal) {
		return getal * -1;
	}

}
