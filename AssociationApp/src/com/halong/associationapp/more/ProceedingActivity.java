package com.halong.associationapp.more;

import java.util.ArrayList;
import java.util.List;




import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.tab3.ViewPageAdapterTab3;
import com.halong.associationapp.tab3.ViewPageAdapterTab3.OnViewPagerClick1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v4.view.ViewPager;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;


public class ProceedingActivity extends BackActivity implements
		OnViewPagerClick1 {
	private ViewPager viewPager;
	private List<View> views = new ArrayList<View>();
	private View view;
	
	
	private int[] images = { R.layout.viewpage_proceeding1,
			R.layout.viewpage_proceeding2, R.layout.viewpage_proceeding3,R.layout.viewpage_proceeding4 };

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		View view1 = getLayoutInflater().inflate(R.layout.activity_proceeding, null);
		setContentView(view1);
		viewPager = (ViewPager)findViewById(R.id.viewPager);
		
		initView();
	}
	

	private void initView() {
		
		
		for (int i = 0; i < images.length; i++) {
			view = getLayoutInflater().inflate(images[i], null);
			views.add(view);

		}

		ViewPageAdapterTab3 adapter = new ViewPageAdapterTab3(this,
				views);
		adapter.SetOnViewPagerClick(this);
		viewPager.setAdapter(adapter);
		

	}

	@Override
	public void OnItemClick(View v) {
		switch (Integer.valueOf(v.getTag().toString())) {
		case 0:
			Intent intent = new Intent(this, ProceedingDetailActivity.class);
			startActivity(intent);
			break;

		case 1:
			Intent intent1 = new Intent(this, ProceedingDetailActivity.class);
			startActivity(intent1);
			break;

		case 2:
			Intent intent2 = new Intent(this,ProceedingDetailActivity.class);
			startActivity(intent2);
			break;

		case 3:
			Intent intent3 = new Intent(this, ProceedingDetailActivity.class);
			startActivity(intent3);
			break;
		}

	}
	@Override
	public void toOtherActivity(Class<?> activity) {
		Intent intent=new Intent(this,activity);
		startActivity(intent);
	}
	
}
