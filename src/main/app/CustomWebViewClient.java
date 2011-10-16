package main.app;

import android.content.Intent;
import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class CustomWebViewClient extends WebViewClient {
	
	 
	@Override
	public boolean shouldOverrideUrlLoading(WebView view, String url) {
		if (url.endsWith(".mp4")) {
			Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(url));
			view.getContext().startActivity(intent);
			return true;
		} else {
			return super.shouldOverrideUrlLoading(view, url);
		}
	}
	
	
}
