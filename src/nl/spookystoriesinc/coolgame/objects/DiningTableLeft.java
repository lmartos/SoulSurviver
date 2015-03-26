package nl.spookystoriesinc.coolgame.objects;

import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
	
	public class DiningTableLeft extends GameObject {
		public static final String DININGTABLELEFT_IMAGE = "Dining Table Left";

		public DiningTableLeft() {
			super();
		}

		/** Returns the ImageId of the image to show. */
		@Override
		public String getImageId() {
			return DININGTABLELEFT_IMAGE;
		}

		@Override
		public void onTouched(GameBoard gameBoard) {
		}

		/** Returns the R.drawable generated unique code for the image
		 * or 0 when not needed*/
		@Override
		public int getImageIdInt() {
			return 0;
		}
	}


