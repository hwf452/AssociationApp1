package com.halong.associationapp.tab3;



import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.tab2.OnItemClickShowDialogActivity;
import com.halong.associationapp.tab2.SortAdapter;

public class CompanyTab3Activity extends BackActivity implements OnClickListener {
	
	private TextView mTextView1,mTextView2,mTextView3,mTextView5,mUser_name,mUser_company;
	private RelativeLayout relate3,relate4,relate5,relate6,relate7,mWeb;
	private ImageView mList_item_head_image;
	private CompanyModel companyModel;
	String url=new String("http://www.halong-tech.com/");
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_companytab3);
		mTextView1=(TextView)findViewById(R.id.textView1);
		
		mTextView2=(TextView)findViewById(R.id.textView2);
		mTextView3=(TextView)findViewById(R.id.textView3);
		mTextView5=(TextView)findViewById(R.id.textView5);
		mList_item_head_image=(ImageView)findViewById(R.id.list_item_head_image);
		mUser_name=(TextView)findViewById(R.id.user_name);
		mUser_company=(TextView)findViewById(R.id.user_company);
		
		relate3=(RelativeLayout)findViewById(R.id.relate3);
		relate4=(RelativeLayout)findViewById(R.id.relate4);
		relate6=(RelativeLayout)findViewById(R.id.relate6);
		relate7=(RelativeLayout)findViewById(R.id.relate7);
		mWeb=(RelativeLayout)findViewById(R.id.web);
		
		init();
	}

	private void init() {
		
		Intent intent=getIntent();
		
		mUser_name.setText(intent.getExtras().getString("name"));
		mTextView2.setText(intent.getExtras().getString("phone"));
		mTextView3.setText(intent.getExtras().getString("addr"));
		url=intent.getExtras().getString("url").toString();
		Log.i("url",url);
		
		companyModel=(CompanyModel) intent.getSerializableExtra("imageview");
		
		
		mList_item_head_image.setImageResource(companyModel.getDrawableId());
		relate3.setOnClickListener(this);
		relate4.setOnClickListener(this);
		relate6.setOnClickListener(this);
		relate7.setOnClickListener(this);
		mWeb.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(CompanyTab3Activity.this,CompanyWebActivity.class);
				intent.putExtra("webAddr",url);
				startActivity(intent);
				
			}
		});
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.relate4:
			Intent intent=new Intent(this,PoiSearchDemo.class);
			String addrAndCity=mTextView3.getText().toString();
			String address=addrAndCity;
			String city=addrAndCity.substring(0, 6);
			intent.putExtra("address",address);
			intent.putExtra("city", city);
			startActivity(intent);
			overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			
			break;
		case R.id.relate3:
			Intent dialIntent = new 
			 Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+mTextView2.getText().toString())); 
			 
			
			 startActivity(dialIntent); 
			overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			
			break;
		case R.id.relate6:
			Intent intent6 = new Intent(this,ToWeiboActivity.class);
			intent6.putExtra("webAddr", "http://weibo.com/u/2313353500");
			
			 startActivity(intent6); 
			overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			
			break;
		case R.id.relate7:
			showHead();
			
			
			break;
			
			
			
			
			
		
		}
		
		
	}
	private void showHead() {
		Intent intent = new Intent(this,
				OnItemClickShowDialogActivity.class);
		
		startActivity(intent);
		overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
		
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

}
