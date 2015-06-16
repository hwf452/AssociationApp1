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
 * @author 杨锘 创建时间：2014年3月6日 下午4:46:31
 * 
 */
public class QuanZiPostAdpter extends BaseAdapter {
	private Context mContext;

	public QuanZiPostAdpter(Context context) {
		mContext = context;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder viewHolder;
		if (convertView == null) {

			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.items_quanzi_post, null);
			viewHolder = new ViewHolder();
//			viewHolder.title = (TextView) convertView.findViewById(R.id.title);
//			viewHolder.comment = (TextView) convertView
//					.findViewById(R.id.comment);
//			viewHolder.name = (TextView) convertView.findViewById(R.id.name);

			convertView.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

	class ViewHolder {
		TextView title;
		TextView comment;
		TextView name;

	}
}
