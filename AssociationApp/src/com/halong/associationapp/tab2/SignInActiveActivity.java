package com.halong.associationapp.tab2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class SignInActiveActivity extends BackActivity {
	private Button mButton3;
	private TextView mResultText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signin);
		mButton3=(Button)findViewById(R.id.button3);
		mResultText=(TextView)findViewById(R.id.resultText);
		Intent intent=getIntent();
		String result=intent.getStringExtra("twoWeiCode");
		mResultText.setText(result);
		mButton3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(SignInActiveActivity.this,SignInFailActivity.class);
				startActivity(intent);
				
			}
		});
		
	}

}
