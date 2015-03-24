package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.spookystories.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainMenuActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		
		Button startGame = (Button) findViewById(R.id.button21);
		startGame.setOnClickListener(new onClickMainMenu());
	}
	
	public class onClickMainMenu implements OnClickListener{

		@Override
		public void onClick(View v) {
			
			finish();
			
			
		}
		
	}

}
