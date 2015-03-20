package nl.spookystoriesinc.coolgame.objects;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import nl.spookystoriesinc.coolgame.*;
import nl.spookystoriesinc.model.*;
import nl.spookystoriesinc.spookystories.R;
import nl.spookystoriesinc.view.*;

public class Book extends GameObject {

	public static final String BOOK_IMAGE = "Book";
	private ArrayList<Integer> pages = new ArrayList<Integer>();
	private int bookX, bookY;

	public Book(int page) {
		super();
		this.pages.add(page);
	}

	/**
	 * @param page
	 *            adds a drawable int to this object
	 */
	public void addPage(int page) {
		this.pages.add(page);
	}

	@Override
	/**
	 * returns the String drawable of this object
	 */
	public String getImageId() {
		return BOOK_IMAGE;
	}

	@Override
	/**
	 * checks whether the player is standing near the object if true opens the TekstOverlayActivity
	 * if false throws a toast message.
	 */
	public void onTouched(GameBoard gameBoard) {
		this.bookX = this.getPositionX();
		this.bookY = this.getPositionY();
		if (bookX == (gameBoard.getPlayer().getPositionX() + 1)
				&& bookY == gameBoard.getPlayer().getPositionY()) {
			startOverlay();
		} else if (bookX == (gameBoard.getPlayer().getPositionX() - 1)
				&& bookY == gameBoard.getPlayer().getPositionY()) {
			startOverlay();
		} else if (bookY == (gameBoard.getPlayer().getPositionY() + 1)
				&& bookX == gameBoard.getPlayer().getPositionX()) {
			startOverlay();
		} else if (bookY == (gameBoard.getPlayer().getPositionY() - 1)
				&& bookX == gameBoard.getPlayer().getPositionX()) {
			startOverlay();
		} else {
			Toast.makeText(MainActivity.getContext(), "Out of range!",
					Toast.LENGTH_SHORT).show();
		}

	}

	/**
	 * starts the tekstoverlay activity with an intent containing the objects
	 * images
	 */
	private void startOverlay() {
		Log.d("startOverlay", "starting new activity");
		Intent intent = new Intent(MainActivity.getContext(),
				TekstOverlayActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putIntegerArrayListExtra("pages", pages);
		Context context = MainActivity.getContext();
		context.startActivity(intent);
	}

	@Override
	/**
	 * @return returns the integer of the drawable for this object
	 */
	public int getImageIdInt() {
		return R.drawable.book;
	}
}
