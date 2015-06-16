package com.halong.associationapp;

import com.halong.associationapp.more.SendPostActivity;
import com.halong.associationapp.tab5.QuanziCommentFragment;
import com.halong.associationapp.tab5.QuanziPostFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;

public class Tab5Fragment extends FragmentToOtherActivity {
	private ViewPager mViewPager;
	private FragmentPagerAdapter mAdapter;
	private RadioButton commentButton, postCommentButton;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_tab5, null);
		pagerView(view);

		clickEvent(view);
		return view;

	}

	private void pagerView(View view) {
		mViewPager = (ViewPager) view.findViewById(R.id.viewPager);
		mAdapter = new FragmentPagerAdapter(getFragmentManager()) {

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 2;
			}

			@Override
			public Fragment getItem(int arg0) {
				// TODO Auto-generated method stub
				Fragment fragment = null;
				switch (arg0) {
				case 0:
					fragment = new QuanziCommentFragment();
					break;
				case 1:
					fragment = new QuanziPostFragment();
					
					break;
				default:
					break;
				}
				return fragment;
			}
		};

		mViewPager.setAdapter(mAdapter);
		mViewPager
				.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

					@Override
					public void onPageSelected(int arg0) {
						// TODO Auto-generated method stub
						switch (arg0) {
						case 0:
							commentButton.setChecked(true);
							break;
						case 1:
							postCommentButton.setChecked(true);
							break;
						default:
							break;
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
	}

	private void clickEvent(View view) {
		OnClickListener onClickListener = new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				switch (v.getId()) {
				case R.id.postComment:
					mViewPager.setCurrentItem(1);
					break;
				case R.id.comment:
					mViewPager.setCurrentItem(0);
					break;
				case R.id.rightButton:
					toOtherActivity(SendPostActivity.class);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
					break;
				default:
					break;
				}
			}
		};
		commentButton = (RadioButton) view.findViewById(R.id.comment);
		commentButton.setOnClickListener(onClickListener);
		commentButton.setChecked(true);
		postCommentButton = (RadioButton) view.findViewById(R.id.postComment);
		postCommentButton.setOnClickListener(onClickListener);
		view.findViewById(R.id.rightButton).setOnClickListener(onClickListener);
	}
}
