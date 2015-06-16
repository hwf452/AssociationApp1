package com.halong.associationapp.tab3;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;


import android.net.http.SslError;
import android.webkit.SslErrorHandler;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.KeyEvent;

import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class CompanyWebToDetaelActivity extends BackActivity {
	private WebView mWebView;
	private String url;
	private ProgressDialog mProgressDialog;

	@Override
	@SuppressLint("SetJavaScriptEnabled")
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_company_web_to_detail);
		final Activity activity=this;
		mWebView=(WebView)findViewById(R.id.webView1);
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
		mWebView.setHorizontalScrollBarEnabled(false);
		mWebView.getSettings().setSupportZoom(true);
		mWebView.getSettings().setBuiltInZoomControls(true);
		mWebView.setInitialScale(70);
		mWebView.getSettings().setAllowFileAccess(true);
		mWebView.setHorizontalScrollbarOverlay(true);
		Intent intent=getIntent();
		 url=intent.getStringExtra("SourceUrl");
		 mProgressDialog=new ProgressDialog(this);
			mProgressDialog.setProgress(ProgressDialog.STYLE_SPINNER);
			mProgressDialog.show();
		 new MyAsyncTask(this,url).execute();
		 mWebView.setWebViewClient(new WebViewClient(){

			@Override
			public void onReceivedError(WebView view, int errorCode,
					String description, String failingUrl) {
				
			}
			@Override
			public void onReceivedSslError(WebView view,
					SslErrorHandler handler, SslError error) {
				handler.proceed();  
			}
			

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				
				Intent intent=new Intent(CompanyWebToDetaelActivity.this, CompanyWebToDetaelActivity.class);
				 intent.putExtra("SourceUrl", url);
				 startActivityForResult(intent, 0);
				
				
				return true;
			}
		
		});
		
		 mWebView.setWebChromeClient(new WebChromeClient(){

			@Override
			public void onProgressChanged(WebView view, int newProgress) {
				activity.setTitle("Loading...");
				activity.setProgress(newProgress*100);
				if(newProgress==100){
					
					activity.setTitle("Loading OK!");
				}
			}
			
			
			
		});
		
	}
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {  
		mWebView.goBack();  
		return true;  
		}else{
		        finish();

		}
		return super.onKeyDown(keyCode, event);  
		}

	
	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == this.getResources().getConfiguration().ORIENTATION_PORTRAIT) {

		}

		// 切换为横屏

		else if (newConfig.orientation == this.getResources()
				.getConfiguration().ORIENTATION_LANDSCAPE) {

		}

	}
	
	class MyAsyncTask extends AsyncTask<String, Void, Void> {
		private Context context;
		private String url;
		
		public MyAsyncTask(Context context,String url) {
			this.url=url;
			this.context = context;
		}
		

		@Override
		protected Void doInBackground(String... params) {
			try {
				mWebView.loadUrl(url);
			} catch (Exception e) {
				// TODO: handle exception
			}

			return null;

		}

		@Override
		protected void onPostExecute(Void result) {
			if(mProgressDialog!=null){
				mProgressDialog.cancel();
			}

		}

	}
	

}	