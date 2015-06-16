/**
 * 
 */
package com.halong.associationapp.tab5;

import com.halong.associationapp.FragmentToOtherActivity;
import com.halong.associationapp.R;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

/**
 * @author 杨 创建时间：2014年3月10日 下午2:54:51
 * 
 */
public class QuanziPostFragment extends FragmentToOtherActivity {
	private ListView postListView;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.quanzi_list, null);
		postListView = (ListView) view.findViewById(R.id.listView);
		post();
		return view;
	}

	private void post() {
		// TODO Auto-generated method stub

		postListView.setAdapter(new QuanZiPostAdpter(getActivity()
				.getApplicationContext()));

		postListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				toOtherActivity(QuanZiViewPostActivity.class,"viewPost");
			}
		});
	}

}
