package com.halong.associationapp.more;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.tab5.QuanZiViewPostActivity;

public class MyLiveSiteShowActivity extends BackActivity {
	private ListView mListView;
	private List<Map<String, Object>> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab2_livesite_list);

		list = new ArrayList<Map<String, Object>>();
		mListView = (ListView) findViewById(R.id.liveSiteListView);
		initData();
		
		initListiew();
	}

	private void initListiew() {
		// TODO Auto-generated method stub
		ChoiceAdapter1 adapter = new ChoiceAdapter1(this, list);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				toOtherActivity(QuanZiViewPostActivity.class, "live");
				
			}
		});
	}
	private void initData() {
		// TODO Auto-generated method stub
		Map<String, Object> map;
		for (int i = 0; i < 8; i++) {
			map = new HashMap<String, Object>();
			map.put("textView1", getString(R.string.dolive_site_name));
			map.put("textView2", getString(R.string.dolive_date));
			map.put("imageView1", R.drawable.button016 + "");
			map.put("textView3", getString(R.string.dolive_site_name));
			list.add(map);
		}
	}

	
	 
}
