package nl.spookystoriesinc.coolgame.objects;

import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
	
	public class DiningTableRight extends GameObject {
		public static final String DININGTABLERIGHT_IMAGE = "Dining Table Right";

		public DiningTableRight() {
			super();
		}

		/** Returns the ImageId of the image to show. */
		@Override
		public String getImageId() {
			return DININGTABLERIGHT_IMAGE;
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
