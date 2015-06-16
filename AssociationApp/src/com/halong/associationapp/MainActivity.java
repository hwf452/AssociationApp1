package com.halong.associationapp;

import java.lang.reflect.Field;

import com.halong.associationapp.util.UpdateManager;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

public class MainActivity extends FragmentActivity implements
		OnCheckedChangeListener,
		android.widget.CompoundButton.OnCheckedChangeListener {
	public TabHost tabHost;
	public static MainActivity mainActivity;
	public RadioButton rb1, rb2, rb4, rb5;
	public Button mMoreBtn;

	public RadioGroup radioGroup;

	public MainActivity() {
		super();
		mainActivity = this;
	}

	public static MainActivity getInstance() {
		return mainActivity;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		mMoreBtn = (Button) findViewById(R.id.More);

		initTabView();

	}

	private void initTabView() {

		radioGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		tabHost = (TabHost) findViewById(android.R.id.tabhost);
		rb1 = (RadioButton) findViewById(R.id.radio0);
		rb2 = (RadioButton) findViewById(R.id.radio1);

		rb4 = (RadioButton) findViewById(R.id.radio3);
		rb5 = (RadioButton) findViewById(R.id.radio4);
		rb1.setOnCheckedChangeListener(this);
		rb2.setOnCheckedChangeListener(this);

		rb4.setOnCheckedChangeListener(this);
		rb5.setOnCheckedChangeListener(this);
		mMoreBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MainActivity.this,
						MoreActivity.class);
				startActivity(intent);
				 overridePendingTransition(R.anim.more_in_anim,
				 R.anim.more_out_anim);
			}
		});

		tabHost.setup();
		tabHost.addTab(tabHost
				.newTabSpec(getResources().getString(R.string.tab1))
				.setContent(R.id.fragment1)
				.setIndicator(getResources().getString(R.string.tab1)));
		tabHost.addTab(tabHost
				.newTabSpec(getResources().getString(R.string.tab2))
				.setContent(R.id.fragment2)
				.setIndicator(getResources().getString(R.string.tab2)));

		tabHost.addTab(tabHost
				.newTabSpec(getResources().getString(R.string.tab4))
				.setContent(R.id.fragment4)
				.setIndicator(getResources().getString(R.string.tab4)));
		tabHost.addTab(tabHost
				.newTabSpec(getResources().getString(R.string.tab5))
				.setContent(R.id.fragment5)
				.setIndicator(getResources().getString(R.string.tab5)));
		tabHost.setCurrentTab(0);
		radioGroup.setOnCheckedChangeListener(this);

	}

	@Override
	public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
		switch (checkedId) {
		case R.id.radio0:
			tabHost.setCurrentTab(0);

			break;
		case R.id.radio1:
			tabHost.setCurrentTab(1);

			break;

		case R.id.radio3:
			tabHost.setCurrentTab(2);
			break;
		case R.id.radio4:
			tabHost.setCurrentTab(3);
			break;
		}

	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.radio0:
			tabHost.setCurrentTab(0);

			break;
		case R.id.radio1:
			tabHost.setCurrentTab(1);

			break;

		case R.id.radio3:
			tabHost.setCurrentTab(2);

			break;
		case R.id.radio4:
			tabHost.setCurrentTab(3);

			break;

		default:
			break;
		}

	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		switch (keyCode) {

		case KeyEvent.KEYCODE_BACK:

			new AlertDialog.Builder(this)
					.setTitle("提醒")
					.setMessage("您确定要退出社云通?")
					.setPositiveButton("确定",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {

									finish();

								}
							})
					.setNegativeButton("取消",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {

								}
							}).show();

			break;

		}
		return true;

	}

	public static int getStatusBarHeight(Context context) {
		Class<?> c = null;
		Object obj = null;
		Field field = null;
		int x = 0, statusBarHeight = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			statusBarHeight = context.getResources().getDimensionPixelSize(x);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		return statusBarHeight;
	}

}
