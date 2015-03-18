package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Table extends GameObject{
	public static final String TABLE_IMAGE = "Table";

	/**
	 * Constructs a rock.
	 */
	public Table() {
		super();
	}

	@Override
	public String getImageId() {
		return TABLE_IMAGE;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getImageIdInt() {
		// TODO Auto-generated method stub
		return 0;
	}

}
