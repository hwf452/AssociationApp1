package com.halong.associationapp.more;

import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class MyFavoritesActivity extends BackActivity {
	private ListView mListView1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myfavorites_activity);
		mListView1=(ListView) findViewById(R.id.listView1);
		initView();
	}
	private void initView() {
		mListView1.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {

				View view=null;
				if (convertView==null) {
					view=getLayoutInflater().inflate(R.layout.item_tab4_imformation_favorites, null);
					
				}else{
					view=convertView;
				}
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
				return 23;
			}
		});
		
	}

}
