package main.app;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

public class ShakeItUp extends Activity{

	 private WebView webContent;
	 private String testTextString = "0";
	 private TextView testText;
	 private int testNumber = 0;
	  private SensorManager mSensorManager;
	  private float mAccel; // acceleration apart from gravity
	  private float mAccelCurrent; // current acceleration including gravity
	  private float mAccelLast; // last acceleration including gravity

	  private final SensorEventListener mSensorListener = new SensorEventListener() {

		    public void onSensorChanged(SensorEvent se) {
		      float x = se.values[0];
		      float y = se.values[1];
		      float z = se.values[2];
		      mAccelLast = mAccelCurrent;
		      mAccelCurrent = (float) Math.sqrt((double) (x*x + y*y + z*z));
		      float delta = mAccelCurrent - mAccelLast;
		      mAccel = mAccel * 0.9f + delta; // perform low-cut filter
		     // Toast.makeText(getApplicationContext(), mAccel + "", Toast.LENGTH_SHORT).show();
		      if (Math.abs(mAccel) > 2.1)
		    	  webContent.loadUrl("http://indyavids.com/addons/m/mobile_randomVideo.php");
		      final TextView textViewToChange = (TextView) findViewById(R.id.testText);
		      textViewToChange.setText(mAccel + "");
		    }

			 public void onAccuracyChanged(Sensor sensor, int accuracy) {
				}
		  };
		  
		  @Override
		  protected void onResume() {
		    super.onResume();
		    mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
		  }

		  @Override
		  protected void onStop() {
		    mSensorManager.unregisterListener(mSensorListener);
		    super.onStop();
		  }

	
	 @Override
	public void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
 		Toast.makeText(getApplicationContext(), "Welcome to Shake it Up! To find a random video, just shake your phone!", Toast.LENGTH_LONG).show();
		 setContentView(R.layout.random);
         testText = (TextView) findViewById(R.id.testText);
		 webContent = (WebView) findViewById(R.id.webview);
	        WebSettings webSettings = webContent.getSettings();
	        webSettings.setSupportZoom(false);
	        webSettings.setJavaScriptEnabled(true);
	       webContent.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
	        webContent.setWebViewClient(new CustomWebViewClient());
	        
	       
	        
	     // webContent.loadUrl("http://indyavids.com/addons/m/");
	        
	      webContent.loadUrl("http://indyavids.com/addons/m/mobile_randomVideo.php");
	      mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	      mSensorManager.registerListener(mSensorListener, mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);
	      mAccel = 0.00f;
	      mAccelCurrent = SensorManager.GRAVITY_EARTH;
	      mAccelLast = SensorManager.GRAVITY_EARTH;
    		//Toast.makeText(getApplicationContext(), "Welcome! To find a random video, just shake your phone!", Toast.LENGTH_LONG).show();
	}
}
