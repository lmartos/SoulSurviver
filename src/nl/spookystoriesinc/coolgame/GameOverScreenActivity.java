package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.spookystories.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class GameOverScreenActivity extends Activity {
	private Button mainMenuButton;
	private Intent mainMenu;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gameoverscreen);
		mainMenu = new Intent(GameOverScreenActivity.this, MainMenuActivity.class);
		onClickMainMenu menuClicks = new onClickMainMenu();
		mainMenuButton = (Button) findViewById(R.id.mainMenuButton);
		mainMenuButton.setOnClickListener(menuClicks);
		RelativeLayout background = (RelativeLayout) findViewById(R.id.RelativeLayout1);
		Intent intent = getIntent();
		
		boolean isVictory = intent.getBooleanExtra("Victory", false);
		
		if(isVictory){
			background.setBackgroundResource(R.drawable.awesome_boekenkast);
		}else{
			background.setBackgroundResource(R.drawable.game_over_screen);
		}
		
	}

	public class onClickMainMenu implements OnClickListener{

		@Override
		public void onClick(View arg0) {
			finish();
		}

	}
	

}
