package main.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class ShakeItUp extends Activity{
    private WebView webContent;
    
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.random);
        webContent = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = webContent.getSettings();
        webSettings.setSupportZoom(false);
        webSettings.setJavaScriptEnabled(true);
       webContent.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webContent.setWebViewClient(new CustomWebViewClient());
        webContent.loadUrl("http://indyavids.com/addons/m/mobile_randomVideo.php");
        Toast.makeText(getApplicationContext(), "Welcome! To view a random video, just shake your phone!", Toast.LENGTH_LONG).show();
	}

}
