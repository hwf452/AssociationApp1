package com.halong.associationapp.tab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.MainActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.util.UpdateManager;

public class LoginActivity extends BackActivity implements OnClickListener {
	private Button mLoginBtn, mShow, mAbout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		// 传入包名和是否显示对话框更新
		UpdateManager manager = new UpdateManager(this,"com.halong.associationapp", false);
		manager.checkUpdate();
		setContentView(R.layout.activity_login);
		mLoginBtn = (Button) findViewById(R.id.loginBtn);
		mShow = (Button) findViewById(R.id.show);
		mAbout = (Button) findViewById(R.id.aboutButton);
		initView();
	}

	private void initView() {
		mLoginBtn.setOnClickListener(this);
		mShow.setOnClickListener(this);
		mAbout.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.loginBtn:
			Intent intent = new Intent(this, MainActivity.class);
			startActivity(intent);
			finish();
			overridePendingTransition(R.anim.push_right_in,
					R.anim.push_left_out);

			break;
		case R.id.show:
			Intent intent1 = new Intent(this, MainActivity.class);
			startActivity(intent1);
			finish();
			overridePendingTransition(R.anim.push_right_in,
					R.anim.push_left_out);
			break;
		case R.id.aboutButton:
			Intent intent2 = new Intent(this, LoginAboutActivity.class);
			startActivity(intent2);
			overridePendingTransition(R.anim.push_right_in,
					R.anim.push_left_out);
			break;

		default:
			break;
		}

	}
	public void toRegist(View view){
		Intent intent=new Intent(this,RegistActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.push_right_in,
				R.anim.push_left_out);
	}

}
