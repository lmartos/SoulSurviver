package nl.spookystoriesinc.coolgame.objects;

import nl.spookystoriesinc.spookystories.R;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
import nl.spookystoriesinc.coolgame.TekstOverlayActivity;
import nl.spookystoriesinc.model.GameBoard;
import nl.spookystoriesinc.model.GameObject;

public class Note extends GameObject{
	
	public static final String NOTE_IMAGE = "Note";
	public static final String NOTE_NIGHTSTAND_IMAGE = "Nightstand note";
	public static final String NOTE_TABLE_IMAGE = "Table note";
	public static final String NOTE_BOOKCASE_LEFT_IMAGE = "Bookshelf left note";
	public static final String NOTE_BOOKCASE_RIGHT_IMAGE = "Bookshelf right note";
	public static final String NOTE_BOOKCASE_LEFT_CORNER_DOWN_NOTE_IMAGE = "Bookshelf left corner down note";
	
	private String state;
	private int pageNum;
	private Context context;
	private int noteX;
	private int noteY;
	
	
	public Note(String state, int pageDrawable, Context context){
		super();
		this.state= state;
		this.context = context;
		this.pageNum = pageDrawable;
		
		
	}

	/** Returns the ImageId of the image to show. */
	@Override
	public String getImageId() {
		return state;
	}
	
	@Override
	public void onTouched(GameBoard gameBoard) {
		this.noteX = this.getPositionX();
		this.noteY = this.getPositionY();
		if (noteX == (gameBoard.getPlayer().getPositionX() + 1)
				&& noteY == gameBoard.getPlayer().getPositionY()) {
			startOverlay();
		} else if (noteX == (gameBoard.getPlayer().getPositionX() - 1)
				&& noteY == gameBoard.getPlayer().getPositionY()) {
			startOverlay();
		} else if (noteY == (gameBoard.getPlayer().getPositionY() + 1)
				&& noteX == gameBoard.getPlayer().getPositionX()) {
			startOverlay();
		} else if (noteY == (gameBoard.getPlayer().getPositionY() - 1)
				&& noteX == gameBoard.getPlayer().getPositionX()) {
			startOverlay();
		} else {
			Toast.makeText(context, "Out of range!",Toast.LENGTH_SHORT).show();
		}
	}
	
	public void startOverlay(){
		Log.d("startOverlay", "starting new activity");
		Intent intent = new Intent(context, TekstOverlayActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("page", pageNum);
		context.startActivity(intent);
	}

	/** Returns the R.drawable generated unique code for the image
	 * or 0 when not needed*/
	@Override
	public int getImageIdInt() {
		return 0;
	}

}
