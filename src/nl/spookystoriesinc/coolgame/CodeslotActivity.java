package nl.spookystoriesinc.coolgame;

import nl.spookystoriesinc.coolgame.objects.CodelockDoor;
import nl.spookystoriesinc.coolgame.objects.Door;
import nl.spookystoriesinc.spookystories.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CodeslotActivity extends Activity {
	
	private Intent intent;
	private CodelockDoor door;
	private int codeInt = 666;
	private EditText code;
	private Button confirm;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.codeslot);
		
		intent = getIntent();
		door = (CodelockDoor) intent.getSerializableExtra("Door");
		
		code = (EditText) findViewById(R.id.codeLock);
		confirm = (Button) findViewById(R.id.confirmButton2);
		
	}
	
	public class onClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			int enteredCode = Integer.parseInt("" + code.getText());
			if(codeInt == enteredCode){
				door.setOpened(true);
				finish();
			}else{
				Toast.makeText(CodeslotActivity.this, "The code you entered was wrong", Toast.LENGTH_SHORT).show();
				finish();
			}
			
		}
		
	}

}
