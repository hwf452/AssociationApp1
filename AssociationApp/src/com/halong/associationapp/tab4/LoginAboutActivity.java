package com.halong.associationapp.tab4;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class LoginAboutActivity extends BackActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_login_about_info);
	}
	
}
