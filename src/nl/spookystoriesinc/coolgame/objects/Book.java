package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Book extends GameObject{

	public static final String BOOK_IMAGE = "Book";
	
	public Book(){
		super();
	}

	@Override
	public String getImageId() {
		return BOOK_IMAGE;
	}

	@Override
	public void onTouched(GameBoard gameBoard) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getImageIdInt() {
		return 0;
	}
}
