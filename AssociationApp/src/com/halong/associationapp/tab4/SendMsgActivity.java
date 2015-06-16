package com.halong.associationapp.tab4;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.Toast;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.tab1.PullToRefreshView;
import com.halong.associationapp.tab1.PullToRefreshView.OnFooterRefreshListener;
import com.halong.associationapp.tab1.PullToRefreshView.OnHeaderRefreshListener;


public class SendMsgActivity extends BackActivity implements OnHeaderRefreshListener, OnFooterRefreshListener {
	private PullToRefreshView mPullToRefreshView;
	private ListView mListView;
	private SendMsgListAdapter mPullListAdapter;
	private List<SendMessageModel> mList = new ArrayList<SendMessageModel>();
	

	private static final int REFRESH_DONE = 001;
	private static final int REFRESH_ON = 002;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_msg);
		mPullToRefreshView = (PullToRefreshView) findViewById(R.id.PullToRefreshView);
		mListView = (ListView)findViewById(R.id.pull_listview);
		initData();
		
		mPullListAdapter = new SendMsgListAdapter(this, mList);
		
		mListView.setAdapter(mPullListAdapter);
		

		mPullToRefreshView.setOnHeaderRefreshListener(this);
		mPullToRefreshView.setOnFooterRefreshListener(this);

	}
	private void initData() {

		SendMessageModel a1 = new SendMessageModel();
		a1.setTime("2014-1-14 19:22");
		a1.setContent("日前，国家发展和改革委员会、工业和信息化部、财政部、商务部、国家税务总局等五部委联合下发《关于印发2013-2014年度国家规划布局内重点软件企业和集成电路设计企业名单的通知》。我市东信和平科技股份有限公司、珠海世纪鼎利通信科技股份有限公司、远光软件股份有限公司、珠海金山办公软件有限公司被认定为“2013-2014年度国家规划布局内重点软件企业”，炬力集成电路设计有限公司、珠海全志科技股份有限公司被认定为“2013-2014年度国家规划布局内重点集成电路设计企业”，通过企业比往年增加2家。");
		a1.setHeadPicId(R.drawable.head2);
		
		
		
		mList.add(a1);
		SendMessageModel a2 = new SendMessageModel();
		a1.setTime("2014-1-15 13:22");
		a1.setContent("国家税务总局等五部委联合下发《关于印发2013-2014年度国家规划布局内重点软件企业和集成电路设计企业名单的通知》。我市东信和平科技股份有限公司、珠海世纪鼎利通信科技股份有限公司、远光软件股份有限公司、珠海金山办公软件有限公司被认定为“2013-2014年度国家规划布局内重点软件企业”，炬力集成电路设计有限公司、珠海全志科技股份有限公司被认定为“2013-2014年度国家规划布局内重点集成电路设计企业”，通过企业比往年增加2家。");
		a1.setHeadPicId(R.drawable.head);
		mList.add(a2);
		
	}
	@Override
	public void onFooterRefresh(PullToRefreshView view) {
		mHandler.sendEmptyMessage(REFRESH_DONE);
		
	}
	@Override
	public void onHeaderRefresh(PullToRefreshView view) {
		mHandler.sendEmptyMessage(REFRESH_ON);
		
	}
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case REFRESH_DONE:
				mPullToRefreshView.postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						mPullToRefreshView.onHeaderRefreshComplete();
					}
				}, 1000);
				break;
			case REFRESH_ON:
				mPullToRefreshView.postDelayed(new Runnable() {

					@Override
					public void run() {
						Toast.makeText(SendMsgActivity.this, "没有更多数据",
								Toast.LENGTH_SHORT).show();
						mPullToRefreshView.onFooterRefreshComplete();
					}
				}, 1000);
				break;

			default:
				break;
			}
		}

	};


}
