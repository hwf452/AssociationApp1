/**
 * 
 */
package com.halong.associationapp.tab5;

import com.halong.associationapp.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author 杨锘
 * 创建时间：2014年3月13日 上午10:58:59   
 *
 */
public class QuanZiAllCommentAdpter extends BaseAdapter {
	private Context mContext;
	private TextView titleTextView;
	public	QuanZiAllCommentAdpter(Context context){
		mContext=context;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		// TODO Auto-generated method stub
		arg1=LayoutInflater.from(mContext).inflate(R.layout.items_quanzi_all_comments,null);
		if (arg0==0) {
			titleTextView=(TextView)arg1.findViewById(R.id.title);
			titleTextView.setVisibility(View.VISIBLE);
		}
		return arg1;
	}

}
