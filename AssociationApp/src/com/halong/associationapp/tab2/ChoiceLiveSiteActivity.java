package com.halong.associationapp.tab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.os.Bundle;


import android.view.View;


import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import android.widget.ListView;


import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class ChoiceLiveSiteActivity extends BackActivity {
	private ListView mListView;
	private List<Map<String, Object>> mLlist;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab2_livesite_choice);

		mLlist = new ArrayList<Map<String, Object>>();
		mListView = (ListView) findViewById(R.id.choiceSiteListView);
		initData();
		initListiew();
	}

	private void initListiew() {
		// TODO Auto-generated method stub
		ChoiceAdapter adapter = new ChoiceAdapter(this, mLlist);
		mListView.setAdapter(adapter);
		mListView.setCacheColorHint(0);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(ChoiceLiveSiteActivity.this,DoliveActivity.class);
				startActivity(intent);
				
			}
		});
	}

	private void initData() {
		// TODO Auto-generated method stub
		Map<String, Object> map;
		for (int i = 0; i < 5; i++) {
			map = new HashMap<String, Object>();
			map.put("textView1", getString(R.string.dolive_site_name));
			map.put("textView2", getString(R.string.dolive_date));
			map.put("imageView1", R.drawable.button016);
			map.put("textView3", getString(R.string.choice));
			mLlist.add(map);
		}
	}

	 
}
