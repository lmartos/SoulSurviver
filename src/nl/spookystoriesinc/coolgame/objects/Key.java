package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;

public class Key extends GameObject{

	private final int id;
	
	public Key(int id){
		this.id = id;
	}
	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return null;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		
	}

	/** Returns the R.drawable generated unique code for the image
	 * or 0 when not needed*/
	@Override
	public int getImageIdInt() {
		if(this.id == 1){
			return R.drawable.key_guestkey;
		}
		else if(this.id == 2){
			return R.drawable.key_studykey;
		}
		else if(this.id == 3){
			return R.drawable.key_librarykey;
		}
		else if(this.id == 4){
			return R.drawable.key_housekey;
		}
		else if(this.id == 5){
			return R.drawable.key_bedroomkey;
		}
		else if(this.id == 6){
			return R.drawable.crowbar;
		}
		else if(this.id == 7){
			return R.drawable.key_bedroomkey;
		}
		return R.drawable.key_housekey;
	}
	
	/**
	 * 			get the unique id of the key
	 * @return	returns the id
	 */
	public int getKeyId(){
		return this.id;
	}

}
