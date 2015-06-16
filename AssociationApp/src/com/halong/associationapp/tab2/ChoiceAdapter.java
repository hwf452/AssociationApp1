package com.halong.associationapp.tab2;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.halong.associationapp.R;

public class ChoiceAdapter extends BaseAdapter {
	private List<Map<String, Object>> mList;
	private Context mContext;

	public ChoiceAdapter(Context context, List<Map<String, Object>> list) {
		this.mContext = context;
		this.mList = list;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return mList.size();
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
		
		View view=null;
		if(convertView==null){
			view=LayoutInflater.from(mContext).inflate(R.layout.item_list_tab2_livesite_choice, null);
		}else{
			view=convertView;
		}
		TextView textView1 = (TextView) view.findViewById(R.id.textView1);
		TextView textView2 = (TextView) view.findViewById(R.id.textView2);
		ImageView imageView1 = (ImageView) view
				.findViewById(R.id.imageView1);
		TextView textView4 = (TextView) view.findViewById(R.id.textView3);

		textView1.setText(mList.get(position).get("textView1").toString());
		textView2.setText(mList.get(position).get("textView2").toString());
		imageView1.setBackgroundResource((Integer)mList.get(position)
				.get("imageView1"));
		textView4.setText(mList.get(position).get("textView3").toString());
		
		
		
		return view;
	}

	
}