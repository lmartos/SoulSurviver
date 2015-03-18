package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;

public class Key extends GameObject{

	private final int id;
	
	public Key(int id){
		this.id = id;
	}
	
	@Override
	public String getImageId() {
		return null;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getImageIdInt() {
		if(this.id == 1){
			return R.drawable.sleutelgrijs;
		}
		else if(this.id == 2){
			return R.drawable.sleutelgoud;
		}
		else if(this.id == 3){
			return R.drawable.sleutelblauw;
		}
		return R.drawable.sleutelgrijs;
	}
	
	public int getKeyId(){
		return this.id;
	}

}
