package main.app;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.VideoView;

public class OverlayVideoScreen extends Activity{
	
	private VideoView videoView1;
	private ScrollView scrollView1;
	private ImageView weirdThing2;
	private ImageView overlayButton2;
	private MediaController ctlr;
	private boolean isOverlayOn = false; 

	   @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.videooverlay);
	        videoView1 = (VideoView) findViewById(R.id.videoView1);
	        scrollView1 = (ScrollView) findViewById(R.id.scrollView1);
	        overlayButton2 = (ImageView) findViewById(R.id.overlayButton2);
	        weirdThing2 = (ImageView) findViewById(R.id.weirdThing2);
	        Uri uri=Uri.parse("http://indyavids.com/uploads/jbv0M4JL1LZvlz5VVDkD.mp4");
	        ctlr=new MediaController(this);
	        ctlr.setMediaPlayer(videoView1);
	        videoView1.setMediaController(ctlr);
	        videoView1.setVideoURI(uri);
	        videoView1.start();
	        weirdThing2.setOnClickListener(new View.OnClickListener() {
	        	public void onClick(View v) {
	        		if (!isOverlayOn) {
	       		      scrollView1.setVisibility(View.VISIBLE);
	        		  overlayButton2.setVisibility(View.VISIBLE);
	        		  isOverlayOn = true;
	        		  }
	        			
	        	}
	     
	        	 });
	   }
	   
	   public boolean onKeyDown(int keyCode, KeyEvent event) {

	        if (keyCode == KeyEvent.KEYCODE_BACK) {
	        	if (isOverlayOn) {
	        		scrollView1.setVisibility(View.GONE);
	        		overlayButton2.setVisibility(View.GONE);
	        		isOverlayOn = false;
	        		return false; // this avoids passing to super
	        	}
	       	
	        }
			return super.onKeyDown(keyCode, event);
	
}
}