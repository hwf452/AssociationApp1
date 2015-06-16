package com.halong.associationapp.tab2;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Event;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.MainActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.tab3.CompanyModel;
import com.halong.associationapp.tab3.CompanyTab3Activity;


public class OnItemClickShowDialogActivity extends BackActivity implements OnClickListener {
	private TextView mContact_card_tel,mContact_card_email,mContact_card_web;
	private TextView mContact_card_name,mContact_card_post,mContact_card_company;
	private Button mContact_card_bottom_layout;
	private RelativeLayout mContact_card_top_layout;
	private Bundle mBundle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View view=getLayoutInflater().inflate(R.layout.activity_tab2_popupwindow, null);
//		mDialog=new AlertDialog.Builder(this).create();
//		 mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		mDialog.getWindow().setFlags(
//				WindowManager.LayoutParams.FLAG_FULLSCREEN,
//				WindowManager.LayoutParams.FLAG_FULLSCREEN);
//		
//		//view.findFocus();
//		mDialog.show();
//		mDialog.getWindow().setContentView(view);
		
		
		
		
//		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
//		InputMethodManager imm=(InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
//		imm.showSoftInput(view, 0);
//		imm.toggleSoftInput(0,InputMethodManager.HIDE_NOT_ALWAYS);
		
		
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(
				WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(view);
		mContact_card_tel=(TextView)findViewById(R.id.contact_card_tel);
		mContact_card_email=(TextView)findViewById(R.id.contact_card_email);
		mContact_card_web=(TextView)findViewById(R.id.contact_card_web);
		
		mContact_card_name=(TextView)findViewById(R.id.contact_card_name);
		mContact_card_post=(TextView)findViewById(R.id.contact_card_post);
		mContact_card_company=(TextView)findViewById(R.id.contact_card_company);
		mContact_card_bottom_layout=(Button)findViewById(R.id.contact_card_bottom_layout);
		mContact_card_top_layout=(RelativeLayout)findViewById(R.id.contact_card_top_layout);
		Intent intent=getIntent();
		mBundle=intent.getExtras();
		mContact_card_tel.setText(intent.getStringExtra("user_phone"));
		mContact_card_email.setText(intent.getStringExtra("user_phone"));
		mContact_card_web.setText(intent.getStringExtra("user_weibo"));
		
		mContact_card_name.setText(intent.getStringExtra("name"));
		mContact_card_post.setText(intent.getStringExtra("user_post"));
		mContact_card_company.setText(intent.getStringExtra("user_company"));
		mContact_card_bottom_layout.setOnClickListener(this);
		mContact_card_top_layout.setOnClickListener(this);
		
		
		
		
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
		case R.id.contact_card_bottom_layout:
			String string=mContact_card_tel.getText().toString();
			if(string!=null){
				Uri uri = Uri.parse("smsto:" + string);
			    Intent sendIntent = new Intent(Intent.ACTION_VIEW, uri);
			    
			    startActivity(sendIntent);
			}
			
			break;
		case R.id.contact_card_top_layout:
			Intent toCompanyDetail=new Intent(this,CompanyTab3Activity.class);
			toCompanyDetail.putExtra("name", mBundle.getString("user_company"));
			toCompanyDetail.putExtra("phone", mBundle.getString("user_phone"));
			toCompanyDetail.putExtra("addr", "user_address");
			toCompanyDetail.putExtra("url", "http://www.qq.com");
			CompanyModel companyModel=new CompanyModel();
			companyModel.setDrawableId(R.drawable.portrait7_4);
			
			toCompanyDetail.putExtra("imageview", companyModel);
			startActivity(toCompanyDetail);
			
			break;

		default:
			break;
		}
		
	}

}
