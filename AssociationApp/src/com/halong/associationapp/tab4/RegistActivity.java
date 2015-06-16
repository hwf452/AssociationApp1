package com.halong.associationapp.tab4;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class RegistActivity extends BackActivity implements OnClickListener {
	private TextView apply_by_phone,find_pwd_by_phone;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View view=getLayoutInflater().inflate(R.layout.activity_register_guide, null);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(view);
		apply_by_phone=(TextView)findViewById(R.id.apply_by_phone);
		find_pwd_by_phone=(TextView)findViewById(R.id.find_pwd_by_phone);
		
		init();
		
		//setContentView(R.layout.activity_tab4_regist);
	}
	private void init() {
		apply_by_phone.setOnClickListener(this);
		find_pwd_by_phone.setOnClickListener(this);
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		switch (keyCode) {
		case KeyEvent.KEYCODE_BACK:
			
			finish();
			overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
			break;

		
		}
		return true;
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.apply_by_phone:
			Intent dialIntent = new 
			 Intent(Intent.ACTION_DIAL,Uri.parse("tel:07566218155")); 
			 
			
			 startActivity(dialIntent); 
			overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			break;
		case R.id.find_pwd_by_phone:
			Intent dialIntent1 = new 
			 Intent(Intent.ACTION_DIAL,Uri.parse("tel:07566218155")); 
			 
			
			 startActivity(dialIntent1); 
			overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			
			break;

		default:
			break;
		}
		
	}

}
