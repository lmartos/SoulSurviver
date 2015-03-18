package nl.spookystoriesinc.coolgame.objects;

import java.util.ArrayList;




import android.content.Context;
import android.content.Intent;
import nl.spookystoriesinc.coolgame.*;
import nl.spookystoriesinc.model.*;
import nl.spookystoriesinc.view.*;

public class Book extends GameObject{

	public static final String BOOK_IMAGE = "Book";
	private ArrayList<Integer> pages = new ArrayList<Integer>();
	private int bookX, bookY;
	
	public Book(int page){
		super();
		this.pages.add(page);
	}
	
	public void addPage(int page){
		this.pages.add(page);
	}

	@Override
	public String getImageId() {
		return BOOK_IMAGE;
	}
	
	

	@Override
	public void onTouched(GameBoard gameBoard) {
		this.bookX = this.getPositionX();
		this.bookY = this.getPositionY();
		if(bookX == (gameBoard.getPlayer().getPositionX() + 1) && bookY == gameBoard.getPlayer().getPositionY()){
		Intent intent = new Intent(MainActivity.getContext(), TekstOverlayActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putIntegerArrayListExtra("pages", pages);
		Context context = MainActivity.getContext();
		context.startActivity(intent);
		}else if(bookX == (gameBoard.getPlayer().getPositionX() - 1) && bookY == gameBoard.getPlayer().getPositionY()){
			Intent intent = new Intent(MainActivity.getContext(), TekstOverlayActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.putIntegerArrayListExtra("pages", pages);
			Context context = MainActivity.getContext();
			context.startActivity(intent);
		}else if(bookY == (gameBoard.getPlayer().getPositionY() + 1) && bookX == gameBoard.getPlayer().getPositionX()){
			Intent intent = new Intent(MainActivity.getContext(), TekstOverlayActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.putIntegerArrayListExtra("pages", pages);
			Context context = MainActivity.getContext();
			context.startActivity(intent);
		}else if(bookY == (gameBoard.getPlayer().getPositionY() - 1) && bookX == gameBoard.getPlayer().getPositionX()){
			Intent intent = new Intent(MainActivity.getContext(), TekstOverlayActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			intent.putIntegerArrayListExtra("pages", pages);
			Context context = MainActivity.getContext();
			context.startActivity(intent);
		}
		
		
	}

	@Override
	public int getImageIdInt() {
		return 0;
	}
}
