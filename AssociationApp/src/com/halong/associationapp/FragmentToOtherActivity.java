package com.halong.associationapp;

import com.halong.associationapp.tab3.TabViewPagerAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class FragmentToOtherActivity extends Fragment implements
		OnClickListener {
	protected ViewPager mPager;
	protected TabViewPagerAdapter mAdapter;
	protected Context mContext;
	
	protected Button mLeftButton, mRightButton;

	public void toOtherActivity(Class<?> activity) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(getActivity(), activity);
		startActivity(intent);
	}
	/**
	 * 
	 */
	public void toOtherActivity(Class<?> activity,String value) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(getActivity(), activity);
		intent.putExtra("which", value);
		startActivity(intent);
	}
	/**
	 * 滑动标签方法
	 */
	public TabViewPagerAdapter flingTab(View view, String[] strings) {
		// TODO Auto-generated method stub
		mPager = (ViewPager) view.findViewById(R.id.viewpager);
		mContext = getActivity().getApplicationContext();
		
		mAdapter=new TabViewPagerAdapter(getActivity(), strings);
		mPager.setAdapter(mAdapter);
		mLeftButton = (Button) view.findViewById(R.id.leftButton);
		mRightButton = (Button) view.findViewById(R.id.rightButton);
		mLeftButton.setOnClickListener(this);
		mRightButton.setOnClickListener(this);
		
		mPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if (mPager.getCurrentItem() == 0) {
					mLeftButton.setVisibility(View.INVISIBLE);
				} else {
					mLeftButton.setVisibility(View.VISIBLE);
				}
				if (mPager.getCurrentItem() == (mPager.getChildCount() - 1)) {
					mRightButton.setVisibility(View.INVISIBLE);
				} else {
					mRightButton.setVisibility(View.VISIBLE);
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});
		return mAdapter;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 * 滑动标签左右指示按钮点击事件
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.leftButton:
			mPager.setCurrentItem(mPager.getCurrentItem() - 1);
			break;
		case R.id.rightButton:
			mPager.setCurrentItem(mPager.getCurrentItem() + 1);
			break;
		default:
			break;
		}
	}

	
}
