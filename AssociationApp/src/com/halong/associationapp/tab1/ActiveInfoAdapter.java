package com.halong.associationapp.tab1;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.halong.associationapp.R;
import com.halong.associationapp.tab2.DoliveActivity;

public class ActiveInfoAdapter extends BaseAdapter implements OnClickListener{

	private Context mContext;
	private List<String> mList;

	public ActiveInfoAdapter(Context context, List<String> list) {
		this.mContext = context;
		this.mList = list;
	}

	/**
	 * 前面有3个item不在数据内
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size()+3;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (position == 0) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_list_active_info_1, null);
		} else if (position == 1) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_list_active_info_2, null);
		} else if (position == 2) {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_list_active_info_3, null);
			TextView talkClickTextView=(TextView) convertView.findViewById(R.id.talkClickTextView);
			talkClickTextView.setOnClickListener(this);
			
		} else {
			convertView = LayoutInflater.from(mContext).inflate(
					R.layout.item_list_active_info_4, null);
		}

		return convertView;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.talkClickTextView:
			Intent intent = new Intent(mContext,DoliveActivity.class);
			//不加Flags会报错
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			v.getContext().startActivity(intent);
			break;

		default:
			break;
		}
	}

	
}
