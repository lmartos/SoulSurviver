package nl.spookystoriesinc.view;

import nl.spookystoriesinc.coolgame.*;

import nl.spookystoriesinc.spookystories.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class VolumeMenu extends Dialog {

	private Activity c;
	private SeekBar volume;
	private CheckBox mute;
	private Context context;
	private AudioManager am;
	
	public VolumeMenu(Activity a, Context context) {
	    super(a);
	    this.context = context;
	    am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	    this.c = a;
	  }
	public void onCreate(Bundle savedInstaceState){
		 super.onCreate(savedInstaceState);
		    requestWindowFeature(Window.FEATURE_NO_TITLE);
		    setContentView(R.layout.settingsmenu);
		    volume = (SeekBar) findViewById(R.id.volumeSeekBar1);
		    volume.setOnSeekBarChangeListener(new seekBarListener());
		    mute = (CheckBox) findViewById(R.id.muteCheckBox1);
		    android.widget.CompoundButton.OnCheckedChangeListener clicker = new Clicker();
		    volume.setMax(am.getStreamMaxVolume(am.STREAM_MUSIC));
		    volume.setProgress(am.getStreamVolume(am.STREAM_MUSIC));
		    mute.setOnCheckedChangeListener(clicker);
		    if(am.getStreamVolume(am.STREAM_MUSIC) == 0){
		    	mute.setChecked(true);
		    }else{
		    	mute.setChecked(false);
		    }
		    
		 
	}
	
	public class seekBarListener implements OnSeekBarChangeListener{

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			if(fromUser){
				am.setStreamVolume(am.STREAM_MUSIC, volume.getProgress(), am.FLAG_VIBRATE);
				Log.d("wut", "msg");
					
			}
			
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			am.setStreamVolume(am.STREAM_MUSIC, volume.getProgress(), am.FLAG_VIBRATE);
			
		}
		
	}
	
	public class Clicker implements android.widget.CompoundButton.OnCheckedChangeListener{	

		

		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			Log.d("tag", "click");
			if(isChecked){
				am.setStreamMute(am.STREAM_MUSIC, true);
				volume.setProgress(am.getStreamVolume(am.STREAM_MUSIC));
			}else{
				am.setStreamMute(am.STREAM_MUSIC, false);
				//am.setStreamVolume(am.STREAM_MUSIC, (int) (0.2 * (am.getStreamMaxVolume(am.STREAM_MUSIC))), am.FLAG_VIBRATE);
				volume.setProgress(am.getStreamVolume(am.STREAM_MUSIC));
			}
			
			
		}
		
		
		
	}

	
	
	}
	
	
	

	
	
	


