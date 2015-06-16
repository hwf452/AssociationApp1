package com.halong.associationapp.more;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.tab5.AboutMeActivity;
import com.halong.associationapp.util.UpdateManager;
import com.mining.app.zxing.BarCodeTestActivity;


public class MoreActivity extends BackActivity implements OnClickListener {
	private LinearLayout mPromoteOnlineUpdate,mAboutme,mTwoWeiCode,mManagerConcept,mOrgStruts;
	private LinearLayout mCurAddress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_more_old);
		mPromoteOnlineUpdate=(LinearLayout)findViewById(R.id.promote_online_update);
		mAboutme=(LinearLayout)findViewById(R.id.aboutme);
		mTwoWeiCode=(LinearLayout)findViewById(R.id.twoWeiCode);
		mCurAddress=(LinearLayout)findViewById(R.id.curAddress);
		

		init();
	}
	private void init() {
		mPromoteOnlineUpdate.setOnClickListener(this);
		mAboutme.setOnClickListener(this);
		mTwoWeiCode.setOnClickListener(this);
		mCurAddress.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.promote_online_update:
			UpdateManager manager = new UpdateManager(this,"com.halong.associationapp",true);
			
			manager.checkUpdate();
			
			break;
		case R.id.aboutme:
			Intent intent=new Intent(this,AboutMeActivity.class);
			startActivity(intent);
			overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			break;
		case R.id.twoWeiCode:
			Intent intent1=new Intent(this,BarCodeTestActivity.class);
			startActivity(intent1);
			overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			break;
		case R.id.curAddress:
			Intent intent2=new Intent(this,CurrentLocationActivity.class);
			startActivity(intent2);
			overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			break;
		

		default:
			break;
		}
		
		
	}

}
