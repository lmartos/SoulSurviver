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
