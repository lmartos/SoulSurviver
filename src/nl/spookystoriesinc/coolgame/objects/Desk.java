package nl.spookystoriesinc.coolgame.objects;

import android.content.Context;
import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;

	public class Desk extends GameObject{
		public static final String DESK_LEFT_IMAGE = "Desk Left";
		public static final String DESK_RIGHT_IMAGE = "Desk Right";
		public static final String DESK_RIGHT_IMAGE_BOOK = "Desk Right Book";
		private Book book;
	
		private String state;
	
	
	
		public Desk(String state, Context context) {
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
