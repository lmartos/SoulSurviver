package nl.spookystoriesinc.coolgame.objects;

import android.util.Log;
import nl.spookystoriesinc.coolgame.CoolGame;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

	public class Bookcase extends GameObject {
		public static final String BOOKCASE_DOWN_IMAGE = "Bookcase down";
		public static final String BOOKCASE_RIGHT_IMAGE = "Bookcase right";
		public static final String BOOKCASE_LEFT_IMAGE = "Bookcase left";
		public static final String BOOKCASE_UP_IMAGE = "Bookcase up";
		public static final String BOOKCASE_RIGHT_CORNER_IMAGE = "Bookcase right corner";
		public static final String BOOKCASE_RIGHT_CORNER_DOWN_IMAGE = "Bookcase right corner down";
		public static final String BOOKCASE_LEFT_CORNER_IMAGE = "Bookcase left corner";
		public static final String BOOKCASE_LEFT_CORNER_DOWN_IMAGE = "Bookcase left corner down";
	
		private String state;
	
		public Bookcase(String state) {
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

		@Override
		public int getImageIdInt() {
			return 0;
		}

	
	

}
