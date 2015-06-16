package com.halong.associationapp.tab1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.widget.ListView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class ActiveInfoActivity extends BackActivity {
	
	private List<String> mList;
	private ListView mListView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_active_info);
		mListView = (ListView) findViewById(R.id.activeInfoListView);
		initView();
		initAndBindData();
	}

	private void initAndBindData() {
		// TODO Auto-generated method stub
		mList = new ArrayList<String>();
		mList.add("1");
		mList.add("2");
		mList.add("3");
		
		mListView.setAdapter(new ActiveInfoAdapter(getApplicationContext(), mList));
	}

	private void initView() {
		// TODO Auto-generated method stub
		
	}
}
