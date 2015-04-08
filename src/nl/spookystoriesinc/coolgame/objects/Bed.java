package nl.spookystoriesinc.coolgame.objects;

import android.content.Context;
import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;

	public class Bed extends GameObject{
		public static final String BED_REGULAR_TOP_IMAGE = "Bed regular top";
		public static final String BED_REGULAR_DOWN_IMAGE = "Bed regular down";
		public static final String BED_MASTER_RIGHT_UP_IMAGE = "Masterbed right up";
		public static final String BED_MASTER_RIGHT_DOWN_IMAGE = "Masterbed right down";
		public static final String BED_MASTER_LEFT_UP_IMAGE = "Master bed left up";
		public static final String BED_MASTER_LEFT_DOWN_IMAGE = "Master bed left down";
		
	
		private String state;
	
		public Bed(String state) {
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