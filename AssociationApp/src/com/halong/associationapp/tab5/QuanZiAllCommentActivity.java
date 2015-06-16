/**
 * 
 */
package com.halong.associationapp.tab5;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

/**
 * @author 杨锘 创建时间：2014年3月12日 下午5:11:37
 * 
 */
public class QuanZiAllCommentActivity extends BackActivity {
	private ListView mListView;
	private QuanZiAllCommentAdpter mAdpter;
	private Button moreButton;
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quanzi_all_comment);
		mListView=(ListView)findViewById(R.id.listView);
		mAdpter=new QuanZiAllCommentAdpter(this);
		mListView.setAdapter(mAdpter);
		mListView.setSelector(android.R.color.transparent);
		moreButton=(Button)findViewById(R.id.more);
		moreButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				toOtherActivity(QuanZiNewsActivity.class);
				overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			}
		});
	}
}
