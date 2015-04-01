package nl.spookystoriesinc.coolgame.objects;

import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
	
	public class DiningTable extends GameObject {
		public static final String DININGTABLE_LEFT_IMAGE = "Dining Table Left";
		public static final String DININGTABLE_MIDDLE_IMAGE = "Dining Table Middle";
		public static final String DININGTABLE_RIGHT_IMAGE = "Dining Table Right";
		
		private String state;
		
		
		public DiningTable(String state) {
			super();
			this.state = state;
		}

		/** Returns the ImageId of the image to show. */
		@Override
		public String getImageId() {
			return state;
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


