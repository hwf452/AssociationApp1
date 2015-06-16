package com.halong.associationapp.tab4;

import java.util.List;

import com.baidu.a.a.c.c;
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

public class SendMsgListAdapter extends BaseAdapter {
	Context context;
	LayoutInflater inflater;
	private List<SendMessageModel> mList;
	int last_item;

	public SendMsgListAdapter(Context context,List<SendMessageModel> provinceList){
	this.context = context;
	mList = provinceList;
	inflater = LayoutInflater.from(context);

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
		if(position==0){
			convertView=inflater.inflate(R.layout.item_send_msg_tab4, null);
		}else{
			convertView=inflater.inflate(R.layout.item_send_msg1_tab4, null);
		}
		TextView timeShow=(TextView) convertView.findViewById(R.id.timeShow);
		TextView msg=(TextView)convertView.findViewById(R.id.msg);
		ImageView imageView=(ImageView)convertView.findViewById(R.id.image1);
//		timeShow.setText(mList.get(position).getTime());
//		msg.setText(mList.get(position).getContent());
//		Drawable drawable=context.getResources().getDrawable(mList.get(position).getHeadPicId());
//		imageView.setImageDrawable(drawable);
		
	    return convertView;
	}
	

}
