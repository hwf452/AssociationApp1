package com.halong.associationapp.tab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class PrivateImformationActivity extends BackActivity implements OnClickListener {
	private Button mModify;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_private_information);
		mModify=(Button)findViewById(R.id.modify);
		mModify.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()){
		
		case R.id.modify:
			Intent intent=new Intent(this,PrivateInfomationModifyActivity.class);
			startActivity(intent);
			
			break;

		default:
			break;
		}
		
	}

}
