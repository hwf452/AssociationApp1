/**
 * 
 */
package com.halong.associationapp.tab3;

import java.util.ArrayList;
import java.util.List;

import com.halong.associationapp.R;





import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * @author 锘 创建时间：2014年1月13日 上午11:37:30
 * 
 */
public class TabViewPagerAdapter extends PagerAdapter implements
		OnClickListener {
	private String[] mString;// 滑动标签名
	private List<View> views;// 滑动标签所在的布局集合
	private Context mContext;
	private int count;// 滑动标签的页数
	private int[] mTabButtonIds;// 滑动标签的ID
	private Button mTabButton;// 滑动标签
	private List<Button> mCreatTabButtons;// 滑动标签集合
	private OnViewPagerClick mOnViewPagerClick;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.view.PagerAdapter#getCount()
	 */

	/**
	 * 调用该适配器时初始化mString，views，count，mTabButtonIds
	 */
	public TabViewPagerAdapter(Context context, String[] strings) {
		// TODO Auto-generated constructor stub
		mContext = context;
		mString = strings;
		// 根据mString.length来判断count
		if (strings.length % 3 == 0) {
			count = strings.length / 3;
		} else {
			count = strings.length / 3 + 1;
		}
		
		// 滑动标签的布局个数为count，布局为R.layout.tab_button_layout
		views = new ArrayList<View>();
		for (int i = 0; i < count; i++) {
			views.add(LayoutInflater.from(mContext).inflate(
					R.layout.tab_button_layout, null));
		}

		mTabButtonIds = new int[] { R.id.tab1Button, R.id.tab2Button,
				R.id.tab3Button };
		mCreatTabButtons = new ArrayList<Button>();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.view.PagerAdapter#isViewFromObject(android.view.View,
	 * java.lang.Object)
	 */
	@Override
	public boolean isViewFromObject(View arg0, Object arg1) {
		// TODO Auto-generated method stub
		return arg0 == arg1;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.view.PagerAdapter#instantiateItem(android.view.ViewGroup
	 * , int)
	 */
	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		// TODO Auto-generated method stub
		container.addView(views.get(position));
		// 加载滑动标签名、选中状态
		if (mString.length % 3 == 0) {
			for (int i = 0; i < mTabButtonIds.length; i++) {
				mTabButton = (Button) views.get(position).findViewById(
						mTabButtonIds[i]);
				mTabButton.setText(mString[position * 3 + i]);
				
					mTabButton.setTag(position * 3 + i);
				
				
				mCreatTabButtons.add(mTabButton);
			}
		} else {
			if (position != count - 1) {
				for (int i = 0; i < mTabButtonIds.length; i++) {
					mTabButton = (Button) views.get(position).findViewById(
							mTabButtonIds[i]);
					mTabButton.setText(mString[position * 3 + i]);
					mTabButton.setTag(position * 3 + i);
					mCreatTabButtons.add(mTabButton);
				}
			} else {
				for (int i = 0; i < mString.length % 3; i++) {
					mTabButton = (Button) views.get(position).findViewById(
							mTabButtonIds[i]);
					mTabButton.setText(mString[position * 3 + i]);
					mTabButton.setTag(position * 3 + i);
					mCreatTabButtons.add(mTabButton);
				}
				for (int i = 0; i < mTabButtonIds.length - mString.length % 3; i++) {
					mTabButton = (Button) views.get(position).findViewById(mTabButtonIds[mString.length % 3 + i]);
					mTabButton.setTag(position * 3 + i);
					mTabButton.setVisibility(View.INVISIBLE);
				}
			}
		}
		for (int i = 0; i < mCreatTabButtons.size(); i++) {
			mCreatTabButtons.get(i).setOnClickListener(this);
		}
		mCreatTabButtons.get(0).setSelected(true);;
		return views.get(position);
	}

	/*
	 * (non-Javadoc) 点击选中效果
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mCreatTabButtons.size(); i++) {
			mCreatTabButtons.get(i).setSelected(false);
		}

		v.setSelected(true);
		

		
		if(mOnViewPagerClick != null){
			mOnViewPagerClick.OnItemClick(v);
		}
	}
	


	/**
	 * 第几个tab被选中，供其他页面做判断
	 */
	public int whichTabSelected() {
		// TODO Auto-generated method stub

		int whichTabSelected = 0;
		for (int i = 0; i < mCreatTabButtons.size(); i++) {
			if (mCreatTabButtons.get(i).isSelected()) {
				whichTabSelected = i;
			};
			
		}
		return whichTabSelected;
	}
	
	public void SetOnViewPagerClick(OnViewPagerClick on){
		mOnViewPagerClick = on;
	}
	
	public interface OnViewPagerClick{
		void OnItemClick(View v);
	}
}
