package com.halong.associationapp.tab4;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class ImformationFavoritesActivity extends BackActivity {
	private ListView mPull_listview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_imformation_favorites);
		mPull_listview=(ListView)findViewById(R.id.pull_listview);
		init();
	}
	private void init() {
		mPull_listview.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View view, ViewGroup arg2) {
				view=getLayoutInflater().inflate(R.layout.item_tab4_imformation_favorites, null);
				
				
				return view;
			}
			
			@Override
			public long getItemId(int position) {
				// TODO Auto-generated method stub
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return 13;
			}
		});
		
	}

}
