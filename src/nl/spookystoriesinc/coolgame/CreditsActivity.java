package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.spookystories.R;
import android.app.Activity;
import android.os.Bundle;

public class CreditsActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.credits);
		
		
	}
	
	public void onBackPressed(){
		finish();
	}

}
