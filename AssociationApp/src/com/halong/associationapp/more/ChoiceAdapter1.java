package com.halong.associationapp.more;

import java.util.List;
import java.util.Map;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.halong.associationapp.R;

public class ChoiceAdapter1 extends BaseAdapter {
	private List<Map<String, Object>> mList;
	private Context mContext;

	public ChoiceAdapter1(Context context, List<Map<String, Object>> list) {
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
		
		View view=null;
		if(convertView==null){
			view=LayoutInflater.from(mContext).inflate(R.layout.item_list_tab2_livesite, null);
			
		}else{
			view=convertView;
		}
		
		
		return view;
	}


}