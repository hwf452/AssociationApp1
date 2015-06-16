package com.halong.associationapp.tab4;

import java.util.List;

import com.halong.associationapp.R;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessagePullListAdapter extends BaseAdapter {
	Context context;
	LayoutInflater inflater;
	private List<MessageModel> mList;
	int last_item;

	public MessagePullListAdapter(Context context,List<MessageModel> provinceList){
	this.context = context;
	mList = provinceList;
	inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); 

    }
	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@SuppressLint("NewApi")
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
	   
	    convertView = inflater.inflate(R.layout.item_tab4_message, null);
	    
        
	    
	    return convertView;
	}
	

}
