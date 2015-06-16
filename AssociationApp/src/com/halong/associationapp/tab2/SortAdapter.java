package com.halong.associationapp.tab2;

import java.util.List;

import com.halong.associationapp.R;

import android.R.integer;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.Toast;

public class SortAdapter extends BaseAdapter implements SectionIndexer {
	public List<SortModel> list = null;

	public static SortAdapter sortAdapter;

	private Context mContext;
	private String[] letterStringsString = { "a", "b", "c", "d", "e", "f", "g",
			"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z", };

	public SortAdapter(Context mContext, List<SortModel> list) {
		this.mContext = mContext;
		this.list = list;
		sortAdapter = this;

	}

	public static SortAdapter getInstance() {
		return sortAdapter;
	}

	public void updateListView(List<SortModel> list) {

		if (list.size() == 0) {
			Toast.makeText(mContext, "此类用户不存在", Toast.LENGTH_SHORT).show();
		} else {
			this.list = list;
			notifyDataSetChanged();
		}

	}

	public int getCount() {
		if (list.size() == 0) {
			return 1;
		}
		return this.list.size();
	}

	public Object getItem(int position) {
		return list.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View view, ViewGroup arg2) {

		view = LayoutInflater.from(mContext).inflate(
				R.layout.item_list_home2_main, null);
		TextView tv_listtitle = (TextView) view.findViewById(R.id.tv_listtitle);
		TextView name = (TextView) view.findViewById(R.id.user_name);
		RelativeLayout relate11=(RelativeLayout)view.findViewById(R.id.relate11);
		TextView user_post = (TextView) view.findViewById(R.id.user_post);
		TextView user_company = (TextView) view.findViewById(R.id.user_company);
		TextView user_city = (TextView) view.findViewById(R.id.user_city);
		name.setText(list.get(position).getName().toString());
		user_post.setText(list.get(position).getUser_post().toString());
		user_company.setText(list.get(position).getUser_company().toString());
		user_city.setText(list.get(position).getUser_city().toString());

		int section = getSectionForPosition(position);

//		if (position == getPositionForSection(section)) {
//			
//			relate11.setVisibility(View.VISIBLE);
//			tv_listtitle.setText(list.get(position).getSortLetters());
//
//		} else {
//			relate11.setVisibility(View.GONE);
//		}
		if(position==0){
			relate11.setVisibility(View.VISIBLE);
			tv_listtitle.setText("常务会长");
		}
		if(position==2){
			relate11.setVisibility(View.VISIBLE);
			tv_listtitle.setText("荣誉会长");
		}
		if(position==4){
			relate11.setVisibility(View.VISIBLE);
			tv_listtitle.setText("理事长");
		}

		return view;

	}

	public int getSectionForPosition(int position) {
		return list.get(position).getSortLetters().charAt(0);
	}

	public int getPositionForSection(int section) {
		for (int i = 0; i < getCount(); i++) {
			String sortStr = list.get(i).getSortLetters();
			char firstChar = sortStr.toUpperCase().charAt(0);
			if (firstChar == section) {
				return i;
			}
		}

		return -1;
	}

	private String getAlpha(String str) {
		String sortStr = str.trim().substring(0, 1).toUpperCase();

		if (sortStr.matches("[A-Z]")) {
			return sortStr;
		} else {
			return "#";
		}
	}

	@Override
	public Object[] getSections() {
		return null;
	}
}