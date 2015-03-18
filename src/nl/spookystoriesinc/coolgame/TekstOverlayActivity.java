package nl.spookystoriesinc.coolgame;

import java.util.ArrayList;

import nl.spookystoriesinc.spookystories.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class TekstOverlayActivity extends Activity{
	private Button returnToGame, previousPage, nextPage;
	private ImageView book;
	private ArrayList<Integer> pages;
	private int currentPage;
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tekst_overlay);
		
		Intent intent = getIntent();
		pages = intent.getIntegerArrayListExtra("pages");
		returnToGame = (Button) findViewById(R.id.button1);
		previousPage = (Button) findViewById(R.id.button2);
		nextPage = (Button) findViewById(R.id.button3);
	}
	
	public class onClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			if(v == returnToGame){
				finish();
			}else if(v == previousPage){
				if(currentPage > 0){
					currentPage--;
					book.setImageResource(pages.get(currentPage));
				}
			}else if(v == nextPage){
				if(currentPage < pages.size())
					currentPage++;
					book.setImageResource(pages.get(currentPage));
			}
			
		}
		
	}

}
