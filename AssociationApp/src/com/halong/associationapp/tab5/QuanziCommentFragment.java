/**
 * 
 */
package com.halong.associationapp.tab5;

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
@SuppressLint("NewApi")
public class QuanziCommentFragment extends Fragment {
	private ListView commentListView;

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
		commentListView = (ListView) view.findViewById(R.id.listView);
		comment();
		return view;
	}

	private void comment() {
		// TODO Auto-generated method stub

		commentListView.setAdapter(new QuanZiCommentAdpter(getActivity()
				.getApplicationContext()));

		commentListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				toOtherActivity(QuanZiAllCommentActivity.class);

			}
		});
	}

	private void toOtherActivity(Class<?> activity) {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.setClass(getActivity(), activity);
		startActivity(intent);
		getActivity().overridePendingTransition(R.anim.push_right_in,
				R.anim.push_left_out);
	}
}
