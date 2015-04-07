package nl.spookystoriesinc.coolgame.objects;

import android.content.Context;
import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;

	public class Sofa extends GameObject{
		public static final String SOFA_TOP_IMAGE = "Sofa op";
		public static final String SOFA_MIDDLE_IMAGE = "Sofa middle";
		public static final String SOFA_DOWN_IMAGE = "Sofa down";
		
	
		private String state;
	
	
	
		public Sofa(String state) {
			super();
			this.state = state;
			
		}

		/** Returns the ImageId of the image to show. */
		public String getImageId() {
			return state;
		}

		public void onTouched(GameBoard gameBoard) {
	
					
		}

		/** Returns the R.drawable generated unique code for the image
		 * or 0 when not needed*/
		public int getImageIdInt() {
			return 0;
		}

}