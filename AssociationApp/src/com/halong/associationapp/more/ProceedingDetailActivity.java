package com.halong.associationapp.more;

import android.os.Bundle;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.tab3.ViewPageAdapterProceedingTab3;

import java.util.ArrayList;
import java.util.List;

import android.support.v4.view.ViewPager;

import android.view.View;


public class ProceedingDetailActivity extends BackActivity {
	private ViewPager viewPager;
	private List<View> views = new ArrayList<View>();
	private View view;

	private int[] images = { R.layout.activity_one_tab3,
			R.layout.activity_two_tab3, R.layout.activity_three_tab3,R.layout.activity_four_tab3 };

	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_proceeding_tab3);
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		initView();
	}




	private void initView() {
		for (int i = 0; i < images.length; i++) {
			view = getLayoutInflater().inflate(images[i], null);
			views.add(view);

		}

		ViewPageAdapterProceedingTab3 adapter = new ViewPageAdapterProceedingTab3(this,
				views);
		
		viewPager.setAdapter(adapter);
		
	}

}
