package nl.spookystoriesinc.view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import nl.spookystoriesinc.coolgame.MainActivity;
import nl.spookystoriesinc.coolgame.objects.Key;
import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class InventoryView extends LinearLayout implements Observer {

	private static ArrayList<GameObject> items = new ArrayList<GameObject>();

	private static InventoryViewTile tile1;
	private static InventoryViewTile tile2;
	private static InventoryViewTile tile3;
	private static InventoryViewTile tile4;
	private static InventoryViewTile tile5;
	private static InventoryViewTile tile6;
	private static InventoryViewTile tile7;
	private static InventoryViewTile tile8;
	private static InventoryViewTile tile9;
	private static InventoryViewTile tile10;
	private static InventoryViewTile tile11;
	private static InventoryViewTile tile12;

	public InventoryView(Context context) {
		super(context);
		init(context);
	}

	public InventoryView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public InventoryView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);

	}

	/**
	 * 
	 * checks whether an object can be opened with current inventory
	 * 
	 * @param doorId
	 *            the id of a locked object
	 * @return boolean returns a boolean value true when a key with the same
	 *         doorId, as the provided doorId is found returns false otherwise.
	 */
	public static boolean checkForKey(int doorId) {
		for (GameObject g : items) {
			if (g instanceof Key) {
				if (((Key) g).getKeyId() == doorId) {
					return true;

				}
			}
		}
		return false;
	}

	/**
	 * adds items to the existing inventory and updates current inventoryview
	 * accordingly
	 * 
	 * @param item
	 *            : the item you wish to add to the inventory
	 */
	public static void addItemToInventory(GameObject item) {
		items.add(item);
		switch (items.lastIndexOf(item)) {
		case 0:
			tile1.setImageResource(item.getImageIdInt());
			break;
		case 1:
			tile2.setImageResource(item.getImageIdInt());
			break;
		case 2:
			tile3.setImageResource(item.getImageIdInt());
			break;
		case 3:
			tile4.setImageResource(item.getImageIdInt());
			break;
		case 4:
			tile5.setImageResource(item.getImageIdInt());
			break;
		case 5:
			tile6.setImageResource(item.getImageIdInt());
			break;
		case 6:
			tile7.setImageResource(item.getImageIdInt());
			break;
		case 7:
			tile8.setImageResource(item.getImageIdInt());
			break;
		case 8:
			tile9.setImageResource(item.getImageIdInt());
			break;
		case 9:
			tile10.setImageResource(item.getImageIdInt());
			break;
		case 10:
			tile11.setImageResource(item.getImageIdInt());
			break;
		case 11:
			tile12.setImageResource(item.getImageIdInt());
			break;
		}

	}

	/**
	 * instances the inventoryview
	 * 
	 * @param context
	 *            : the current application context
	 */
	public void init(Context context) {
		if (!isInEditMode()) {

			// inflation of the inventory xml
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			inflater.inflate(R.layout.inventory, this);

			// coupling of xml to java variables
			tile1 = (InventoryViewTile) findViewById(R.id.inventoryViewTile1);
			tile2 = (InventoryViewTile) findViewById(R.id.inventoryViewTile2);
			tile3 = (InventoryViewTile) findViewById(R.id.inventoryViewTile3);
			tile4 = (InventoryViewTile) findViewById(R.id.inventoryViewTile4);
			tile5 = (InventoryViewTile) findViewById(R.id.inventoryViewTile5);
			tile6 = (InventoryViewTile) findViewById(R.id.inventoryViewTile6);
			tile7 = (InventoryViewTile) findViewById(R.id.inventoryViewTile7);
			tile8 = (InventoryViewTile) findViewById(R.id.inventoryViewTile8);
			tile9 = (InventoryViewTile) findViewById(R.id.inventoryViewTile9);
			tile10 = (InventoryViewTile) findViewById(R.id.inventoryViewTile10);
			tile11 = (InventoryViewTile) findViewById(R.id.inventoryViewTile11);
			tile12 = (InventoryViewTile) findViewById(R.id.inventoryViewTile12);

			// instancing onclicklistener
			OnClickListener onclickListener = new ClickListener();

			// adding onclicklisteners to inventory tiles
			tile1.setOnClickListener(onclickListener);
			tile2.setOnClickListener(onclickListener);
			tile3.setOnClickListener(onclickListener);
			tile4.setOnClickListener(onclickListener);
			tile5.setOnClickListener(onclickListener);
			tile6.setOnClickListener(onclickListener);
			tile7.setOnClickListener(onclickListener);
			tile8.setOnClickListener(onclickListener);
			tile9.setOnClickListener(onclickListener);
			tile10.setOnClickListener(onclickListener);
			tile11.setOnClickListener(onclickListener);
			tile12.setOnClickListener(onclickListener);

			// setting the default images for the inventory tiles
			tile1.setBackgroundResource(R.drawable.inventoryslot);
			tile2.setBackgroundResource(R.drawable.inventoryslot);
			tile3.setBackgroundResource(R.drawable.inventoryslot);
			tile4.setBackgroundResource(R.drawable.inventoryslot);
			tile5.setBackgroundResource(R.drawable.inventoryslot);
			tile6.setBackgroundResource(R.drawable.inventoryslot);
			tile7.setBackgroundResource(R.drawable.inventoryslot);
			tile8.setBackgroundResource(R.drawable.inventoryslot);
			tile9.setBackgroundResource(R.drawable.inventoryslot);
			tile10.setBackgroundResource(R.drawable.inventoryslot);
			tile11.setBackgroundResource(R.drawable.inventoryslot);
			tile12.setBackgroundResource(R.drawable.inventoryslot);

		}

	}

	public class ClickListener implements OnClickListener {

		public void onClick(View v) {
			Toast.makeText(MainActivity.getContext(),
					"This is a key you've picked up!", Toast.LENGTH_SHORT)
					.show();
		}

	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub

	}

	/**
	 * clears the current static inventory
	 */
	public static void clear() {
		items.removeAll(items);
	}

}
