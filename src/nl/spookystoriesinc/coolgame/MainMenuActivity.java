package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.spookystories.R;
import nl.spookystoriesinc.view.VolumeMenu;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainMenuActivity extends Activity {
	
	private Button settings, startGame;
	private Context context;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		
		onClickMainMenu menuClicks = new onClickMainMenu();
		startGame = (Button) findViewById(R.id.button21);
		startGame.setOnClickListener(menuClicks);
		settings = (Button) findViewById(R.id.button22);
		settings.setOnClickListener(menuClicks);
		context = getApplicationContext();
		
	}
	
	public class onClickMainMenu implements OnClickListener{

		@Override
		public void onClick(View v) {
			if(v == settings){
				VolumeMenu volumeMenu= new VolumeMenu(MainMenuActivity.this, context);
				volumeMenu.setTitle("Volume Control");
				volumeMenu.show();
			}else{
				finish();	
			}
			
			
			
		}
	
		
	}
	


}
