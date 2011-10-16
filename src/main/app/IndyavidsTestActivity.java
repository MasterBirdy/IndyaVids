package main.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;


public class IndyavidsTestActivity extends Activity {
    /** Called when the activity is first created. */
    
    private WebView webContent;
    private ImageView homeButton; 
    private ImageView videoButton;
    private ImageView uploadButton;
    

    
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        
        // create web view and set its settings
        webContent = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webContent.getSettings();
        webSettings.setSupportZoom(false);
        webSettings.setJavaScriptEnabled(true);
       webContent.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webContent.setWebViewClient(new CustomWebViewClient());
        
        webContent.loadUrl("http://indyavids.com/addons/m/");
        
		
        homeButton = (ImageView) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
        		
        		webContent.loadUrl("http://indyavids.com/addons/m/");
        		
        	}
        	
        });
        
        videoButton = (ImageView) findViewById(R.id.videoButton);
        videoButton.setOnClickListener( new View.OnClickListener() {
        	public void onClick( View v ) {
        		webContent.loadUrl("http://indyavids.com/addons/m/videos.php");
        		
        		
        	}
        });
        
        uploadButton = (ImageView) findViewById(R.id.uploadButton);
        uploadButton.setOnClickListener( new View.OnClickListener() {
        	public void onClick( View v ) {
        		webContent.loadUrl("http://indyavids.com/mobile_login.php");
        		
        	}
        });
             
    }
    
    // handles functionality for device hardware buttons
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
        	webContent.goBack();
            return false; // this avoids passing to super
        }
        else if(keyCode == KeyEvent.KEYCODE_SEARCH) {
        	webContent.loadUrl("http://indyavids.com/addons/m/");
        	return false;
        }

        return super.onKeyDown(keyCode, event);
    }
    
}
   


