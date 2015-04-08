package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.spookystories.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ControlsActivity extends Activity {
	
	private TextView player, chest, note, enemy, door;
	private ImageView playerImage, chestImage, noteImage, enemyImage, doorImage;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.controls);
		
		player = (TextView) findViewById(R.id.textViewPlayer);
		chest = (TextView) findViewById(R.id.textViewChest);
		note = (TextView) findViewById(R.id.textViewPage);
		enemy = (TextView) findViewById(R.id.textViewEnemy);
		door = (TextView) findViewById(R.id.textViewDoor);
		
		playerImage = (ImageView) findViewById(R.id.imageViewPlayer);
		chestImage = (ImageView) findViewById(R.id.imageViewChest);
		noteImage = (ImageView) findViewById(R.id.imageViewPage);
		enemyImage = (ImageView) findViewById(R.id.imageViewEnemy);
		doorImage = (ImageView) findViewById(R.id.imageViewDoor);
	}
	
	public void onBackPressed(){
		finish();
	}

}
