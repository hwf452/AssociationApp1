package com.halong.associationapp.tab2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class CatContratActivity extends BackActivity{
	private ListView listView_catContrat;
	private List<String> mCatContrat=new ArrayList<String>();;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab2_catmain);
		listView_catContrat=(ListView)findViewById(R.id.listView_catContrat);
		initView();
	}

	private void initView() {
		String[] str=getResources().getStringArray(R.array.tab2_catContract);
		for(int i=0;i<str.length;i++){
			mCatContrat.add(str[i]);
		}
		
		
		
		listView_catContrat.setAdapter(new BaseAdapter() {
			
			
			@Override
			public View getView(int position, View view, ViewGroup arg2) {
				TextView catTextView;
				if(view==null){
					view=getLayoutInflater().inflate(R.layout.item_list_tab2_catcontrat, null);
					catTextView=(TextView) view.findViewById(R.id.textView1);
					TextPaint tp = catTextView.getPaint(); 
					tp.setFakeBoldText(true); 
					catTextView.setText(mCatContrat.get(position));
					
				}
				
				
				
				
				return view;
			}
			
			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}
			
			@Override
			public Object getItem(int arg0) {
				// TODO Auto-generated method stub
				return mCatContrat.get(arg0);
			}
			
			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return mCatContrat.size();
			}
		});
		
		listView_catContrat.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent=new Intent(CatContratActivity.this,ContratDetailActivity.class);
				intent.putExtra("contratCat", listView_catContrat.getItemAtPosition(position).toString());
				startActivity(intent);
				
				overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
				
			}
		});
		
	}

	

}
