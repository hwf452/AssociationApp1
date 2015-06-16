package com.halong.associationapp.tab3;


import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.SslErrorHandler;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;


public class ToWeiboActivity extends BackActivity {
	private WebView mWebView;
	private ProgressBar mPd;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_to_weibo);
		mWebView = (WebView) findViewById(R.id.webView1);
		mPd=(ProgressBar) findViewById(R.id.progressBar1);
		init();
	}

	private void init() {
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		mWebView.setHorizontalScrollBarEnabled(false);
		mWebView.getSettings().setSupportZoom(true);
		mWebView.getSettings().setBuiltInZoomControls(true);
		mWebView.getSettings().setAllowFileAccess(true);

		mWebView.setInitialScale(70);
		mWebView.setHorizontalScrollbarOverlay(true);
		mWebView.setWebViewClient(new WebViewClient() {

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {

			}

			public void onReceivedSslError(WebView view,
					SslErrorHandler handler, android.net.http.SslError error) {
				// 重写此方法可以让webview处理https请求
				handler.proceed();
			}

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				// Intent intent=new Intent(ToWeiboActivity.this,
				// CompanyWebToDetaelActivity.class);
				// intent.putExtra("SourceUrl", url);
				// startActivityForResult(intent, 0);
				view.loadUrl(url);
				return true;
			}

		});
		Intent intent = getIntent();
		String url = intent.getStringExtra("webAddr");
		mWebView.loadUrl(url);
		mWebView.setWebChromeClient(new WebChromeClient(){

			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				mPd.setVisibility(View.VISIBLE);
				if(newProgress==100){
					if(mPd!=null){
						mPd.setVisibility(View.GONE);
					}
					
				}
			
				
			}
			
		});

	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
			mWebView.goBack();
			return true;
		} else {
			finish();

		}
		return super.onKeyDown(keyCode, event);
	}
	

}
