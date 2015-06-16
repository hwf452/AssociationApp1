package com.halong.associationapp.tab2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.more.ChoiceAdapter1;
import com.halong.associationapp.tab5.QuanZiViewPostActivity;

public class LiveSiteShowActivity extends BackActivity {
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
				toOtherActivity(QuanZiViewPostActivity.class, "live");

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
			map.put("imageView1", R.drawable.button016 + "");
			map.put("textView3", getString(R.string.dolive_site_name));
			list.add(map);
		}
	}

	 
}
