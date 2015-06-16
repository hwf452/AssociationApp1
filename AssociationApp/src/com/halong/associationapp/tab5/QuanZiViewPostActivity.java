/**
 * 
 */
package com.halong.associationapp.tab5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

/**
 * @author 杨锘 创建时间：2014年3月13日 下午6:59:08
 * 
 */
public class QuanZiViewPostActivity extends BackActivity {
	private ListView mListView;
	private QuanZiViewPostAdpter mAdpter;
	private TextView titleTextView;
	private TextView postCommentTextView;
	private ImageView headImageView;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quanzi_view_post);
		Intent intent=getIntent();
		String value =intent.getStringExtra("which");
		mListView = (ListView) findViewById(R.id.listView);
		mAdpter = new QuanZiViewPostAdpter(this);
		View view=getLayoutInflater().inflate(
				R.layout.itmes_quanzi_view_post_head, null);
		mListView.addHeaderView(view);
		titleTextView=(TextView)view.findViewById(R.id.title);
		postCommentTextView=(TextView)view.findViewById(R.id.postComment);
		headImageView=(ImageView)view.findViewById(R.id.head);
		if (value.equals("live")) {
		
			titleTextView.setText(R.string.dolive_site_name);
			postCommentTextView.setText(R.string.dolive_site_content);
			headImageView.setImageDrawable(getResources().getDrawable(R.drawable.picture0003));
			
		}
		mListView.setAdapter(mAdpter);
		mListView.setDivider(getResources().getDrawable(R.drawable.line001));
	}

}
