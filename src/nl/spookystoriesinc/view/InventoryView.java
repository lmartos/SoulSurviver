package nl.spookystoriesinc.view;

import java.util.ArrayList;

import java.util.Observable;
import java.util.Observer;

import nl.spookystoriesinc.model.GameObject;
import nl.spookystoriesinc.spookystories.R;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class InventoryView extends LinearLayout implements Observer {
	
	
	private ArrayList<GameObject> items = new ArrayList<GameObject>();
	
	private InventoryViewTile tile1;
	private InventoryViewTile tile2;
	private InventoryViewTile tile3;
	private InventoryViewTile tile4;
	private InventoryViewTile tile5;
	private InventoryViewTile tile6;
	private InventoryViewTile tile7;
	private InventoryViewTile tile8;
	private InventoryViewTile tile9;
	private InventoryViewTile tile10;
	private InventoryViewTile tile11;
	private InventoryViewTile tile12;

	
	
	public InventoryView(Context context) {
		super(context);
		init(context);
		// TODO Auto-generated constructor stub
	}
	
	public InventoryView(Context context, AttributeSet attrs) {
		super(context, attrs);
			init(context);
			
		
		// TODO Auto-generated constructor stub
	}
	public InventoryView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		
			init(context);
			
		// TODO Auto-generated constructor stub
	}
	
	public void addItemToInventory(GameObject item){
		items.add(item);
		switch(items.lastIndexOf(item)){
		case 0: tile1.setImageResource(R.drawable.leaf);
		break;
		case 1: tile2.setImageResource(R.drawable.leaf);
		break;
		case 2: tile3.setImageResource(R.drawable.leaf);
		break;
		case 3: tile4.setImageResource(R.drawable.leaf);
		break;
		case 4: tile5.setImageResource(R.drawable.leaf);
		break;
		case 5: tile6.setImageResource(R.drawable.leaf);
		break;
		case 6: tile7.setImageResource(R.drawable.leaf);
		break;
		case 7: tile8.setImageResource(R.drawable.leaf);
		break;
		case 8: tile9.setImageResource(R.drawable.leaf);
		break;
		case 9: tile10.setImageResource(R.drawable.leaf);
		break;
		case 10: tile11.setImageResource(R.drawable.leaf);
		break;
		case 11: tile12.setImageResource(R.drawable.leaf);
		break;
		}
		
		
		
	}
	
	public void removeItemFromInventory(GameObject item){
		items.remove(item);
	}
	
	

	public void init(Context context){
		if(!isInEditMode()) {
		
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			inflater.inflate(R.layout.inventory, this);
			
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
			
			OnClickListener onclickListener = new ClickListener();
			
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

		@Override
		public void onClick(View v) {
		if(v == tile1){
			tile1.setImageResource(R.drawable.leaf);
		}else if(v == tile2){
			tile2.setBackgroundColor(Color.RED);
		}else if(v == tile3){
			tile3.setBackgroundColor(Color.RED);
		}else if(v == tile4){
			tile4.setBackgroundColor(Color.RED);
		}else if(v == tile5){
			tile5.setBackgroundColor(Color.RED);
		}else if(v == tile6){
			tile6.setBackgroundColor(Color.RED);
		}else if(v == tile7){
			tile7.setBackgroundColor(Color.RED);
		}else if(v == tile8){
			tile8.setBackgroundColor(Color.RED);
		}else if(v == tile9){
			tile9.setBackgroundColor(Color.RED);
		}else if(v == tile10){
			tile10.setBackgroundColor(Color.RED);
		}else if(v == tile11){
			tile11.setBackgroundColor(Color.RED);
		}else if(v == tile12){
			tile12.setBackgroundColor(Color.RED);
		}
			
		}
		
	}

	@Override
	public void update(Observable observable, Object data) {
		// TODO Auto-generated method stub
		
	}



}
