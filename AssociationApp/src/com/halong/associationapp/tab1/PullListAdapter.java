package com.halong.associationapp.tab1;

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

public class PullListAdapter extends BaseAdapter {
	Context context;
	LayoutInflater inflater;
	private List<AssociationData> mList;
	int last_item;

	public PullListAdapter(Context context,List<AssociationData> provinceList){
	this.context = context;
	mList = provinceList;
	
	inflater=LayoutInflater.from(context);
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
		ViewHolder  holder = null;
	    if(convertView==null){
	    convertView = inflater.inflate(R.layout.pulllist_item_news, null);
	    holder = new ViewHolder();
        holder.textView =(TextView)convertView.findViewById(R.id.recommend_list_item_title_textview);
        holder.imageview = (ImageView)convertView.findViewById(R.id.list_item_head_image);
        holder.content = (TextView)convertView.findViewById(R.id.recommend_list_item_desc_textview);
        convertView.setTag(holder);
	    }
	    else{
	    holder=(ViewHolder)convertView.getTag();
	    }
	    holder.textView .getPaint().setFakeBoldText(true);
	    holder.imageview.setImageDrawable(context.getResources().getDrawable(mList.get(position).getDrawableId()));
	    holder.textView.setText(mList.get(position).getmTitle());
	    
	    if(mList.get(position).getmContent().length()>21){
	    	String string=mList.get(position).getmContent();
	    	String string2=string.substring(0, 21);
	    	holder.content.setText(string2+"...");
	    }else{
	    	holder.content.setText(mList.get(position).getmContent());
	    }
	    
	    
	    holder.textView.setTextColor(Color.BLACK);
	    return convertView;
	}
	
	public static class ViewHolder{
		public TextView textView;
		public ImageView imageview;
		public TextView content;
	}

}
