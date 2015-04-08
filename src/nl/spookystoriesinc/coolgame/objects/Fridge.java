package nl.spookystoriesinc.coolgame.objects;

import android.content.Context;
import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;


	
	public class Fridge extends GameObject{
		public static final String FRIDGE_IMAGE = "Fridge";
		
		public Fridge(){
			super();
			
			
		}

		/** Returns the ImageId of the image to show. */
		public String getImageId() {
			return FRIDGE_IMAGE;
		}

		public void onTouched(GameBoard gameBoard) {
	
					
		}

		/** Returns the R.drawable generated unique code for the image
		 * or 0 when not needed*/
		public int getImageIdInt() {
			return 0;
		}

	}
