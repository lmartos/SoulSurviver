package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.spookystories.R;
import nl.spookystoriesinc.view.InventoryView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The main activity.
 * 
 * @author Paul de Groot
 * @author Jan Stroet
 */
public class MainActivity extends Activity {
	private CoolGame game = null;
	private CoolGameBoardView gameView;
	private TextView scoreLabel;	
	private int init = 0;
	private Intent mainMenu;
	private MediaPlayer mediaPlayer;
	public static final int START_GAME = 1;
	private InventoryView inventory;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Load main.xml
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Find some of the user interface elements
		gameView = (CoolGameBoardView) findViewById(R.id.game);
		scoreLabel = (TextView) findViewById(R.id.scoreTextView);
		inventory = (InventoryView) findViewById(R.id.inventoryView1);
		
		// Create the game object. This contains all data and functionality
		// belonging to the game
		game = new CoolGame(this);
		// Do something when user clicks new game
		registerNewGameButton();
		mainMenu = new Intent(MainActivity.this, MainMenuActivity.class);
		startActivityForResult(mainMenu, START_GAME);
		}
	
	private void playBackgroundMusic() {
		mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.nightmare_on_elm_st);
		mediaPlayer.start();
	}


	protected void onActivityResult(int requestCode, int resultCode, Intent data){
			if(resultCode == RESULT_OK){
				inventory.clear();
				game.initNewGame();
				playBackgroundMusic();
		}
	}
	
	public void initGameOverState(){
		mediaPlayer.stop();
		Intent initGameOver = new Intent(this, MainMenuActivity.class);
		initGameOver.putExtra("Game is over", true);
		startActivityForResult(initGameOver, START_GAME);
		
		
	}
	
	

	/**
	 * Set a new score on the score label
	 * 
	 * @param newScore
	 *            The new score.
	 */
	public void updateScoreLabel(int newScore) {
		scoreLabel.setText("Score: " + newScore);
	}

	/**
	 * Returns the view on the game board.
	 */
	public CoolGameBoardView getGameBoardView() {
		return gameView;
	}

	/**
	 * 
	 * @return returns the application context of the main activity
	 */



	/**
	 * Install a listener to the 'New game'-button so that it starts a new game
	 * when clicked.
	 */
	private void registerNewGameButton() {
		// Find the 'New Game'-button in the activity
		final Button button1 = (Button) findViewById(R.id.newGameButton);

		// Add a click listener to the button that calls initNewGame()
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				game.initNewGame();
			}
		});
	}

	/**
	 * 
	 * clears the static inventory elements after closing the game
	 * 
	 */

	public void onDestroy() {
		inventory.clear();
		super.onDestroy();
	}
}
