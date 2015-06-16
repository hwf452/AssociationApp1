package com.halong.associationapp.tab3;

import java.util.List;


import android.content.Context;


import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;


public class ViewPageAdapterProceedingTab3 extends PagerAdapter implements OnClickListener{
	List<View> views;
	Context context;
	private OnViewPagerClick1 mOnViewPagerClick;
	
	public ViewPageAdapterProceedingTab3(Context context,List<View> views){
		this.views=views;
		this.context=context;
		
	}

	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return views.size();
	}

	@Override
	public void destroyItem(ViewGroup container, int position,
			Object object) {
		container.removeView(views.get(position));
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		container.addView(views.get(position), 0);
		for (int i = 0; i < views.size(); i++) {
			views.get(i).setOnClickListener(this);
			views.get(i).setTag(i);
		}
		return views.get(position);
	}

	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return super.getItemPosition(object);
	}
	public void SetOnViewPagerClick(OnViewPagerClick1 on){
		mOnViewPagerClick = on;
	}
	
	public interface OnViewPagerClick1{
		void OnItemClick(View v);
	}

	

	@Override
	public void onClick(View v) {
		if(mOnViewPagerClick != null){
			mOnViewPagerClick.OnItemClick(v);
		}

		
		
	}
	

}
