package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.spookystories.R;

import nl.spookystoriesinc.view.VolumeMenu;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends Activity {
	
	private Button settings, startGame, credits;
	private Context context;
	private MediaPlayer mediaPlayer;
	private Intent testGameOver;
	private Intent resultIntent;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		testGameOver = getIntent();
		onClickMainMenu menuClicks = new onClickMainMenu();
		startGame = (Button) findViewById(R.id.button21);
		startGame.setOnClickListener(menuClicks);
		settings = (Button) findViewById(R.id.button22);
		settings.setOnClickListener(menuClicks);
		context = getApplicationContext();
		credits = (Button) findViewById(R.id.button23);
		credits.setOnClickListener(menuClicks);
		
		if(testGameOver.getBooleanExtra("Game is over", false)){
			Intent startGameOver = new Intent(this, GameOverScreenActivity.class);
			startActivity(startGameOver);
			
		}
		playMusic();
		}
		private void playMusic() {
			
			Log.d("MainActivity", "starting music!");
			mediaPlayer = MediaPlayer.create(context, R.raw.hughes_hall_sleep_now);
			mediaPlayer.start();
			mediaPlayer.setLooping(true);
		}
		
		public void onDestroy(){
			mediaPlayer.stop();
			super.onDestroy();
		}
	
	public class onClickMainMenu implements OnClickListener{

		@Override
		public void onClick(View v) {
			if(v == settings){
				VolumeMenu volumeMenu= new VolumeMenu(MainMenuActivity.this, context);
				volumeMenu.setTitle("Volume Control");
				volumeMenu.show();
			}else if (v == startGame){
				resultIntent = new Intent();
				setResult(Activity.RESULT_OK, resultIntent);
				mediaPlayer.stop();
				finish();
			}else{
				Intent creditsIntent = new Intent(MainMenuActivity.this, CreditsActivity.class);
				startActivity(creditsIntent);
			}
			
		}
		
	}

}
