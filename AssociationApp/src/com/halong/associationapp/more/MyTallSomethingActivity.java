package com.halong.associationapp.more;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;

public class MyTallSomethingActivity extends BackActivity {
	private ListView mListView;
	private Button mMore,mSend;
	private PopupWindow popWindow;
	private View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		view = getLayoutInflater().inflate(R.layout.activity_my_tallsomething,
				null);
		setContentView(view);
		mListView = (ListView) view.findViewById(R.id.listView1);
		mMore = (Button) view.findViewById(R.id.more);
		initView();
	}

	private void initView() {
		mMore.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				showPopupWindow();

			}
		});
		mListView.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				View view = null;
				if (convertView == null) {
					view = getLayoutInflater().inflate(
							R.layout.item_more_write_something, null);
				} else {
					view = convertView;
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
				return 12;
			}
		});

	}

	private void showPopupWindow() {
		DisplayMetrics dm = getResources().getDisplayMetrics();
		int displayWidth = dm.widthPixels;

		View view1 = getLayoutInflater().inflate(
				R.layout.popupwindow_send_tallabout_active, null);
		mSend=(Button)view1.findViewById(R.id.send);
		mSend.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				Intent intent=new Intent(MyTallSomethingActivity.this,SendPostActivity.class);
				startActivity(intent);
				
			}
		});

		// 初始化弹出菜单
		popWindow = new PopupWindow(view1,
				WindowManager.LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.WRAP_CONTENT, true);

		// 设置可以获取焦点，否则弹出菜单中的EditText是无法获取输入的
		popWindow.setFocusable(true);
		//popWindow.setAnimationStyle(R.style.popwin_anim_style_menu);
		// 这句是为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
		popWindow.setBackgroundDrawable(new BitmapDrawable());
		// 防止虚拟软键盘被弹出菜单遮住
		popWindow
				.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		// 在底部显示
		// popWindow.showAtLocation(view1,Gravity.CENTER_HORIZONTAL, 30, 30);
		// popWindow.showAsDropDown(mActive);
		// 计算x轴方向的偏移量，使得PopupWindow在Title的正下方显示，此处的单位是pixels

		// int xoffInPixels =
		// getActivity().getWindow().getWindowManager().getDefaultDisplay().getWidth()
		// / 2 -33;
		// 将pixels转为dip
		// int xoffInDip = Px2Dp(getActivity(), xoffInPixels);
		// int offY=Dp2Px(getActivity(),(float) 10.5);
		popWindow.showAsDropDown(mMore);
		// popWindow.showAtLocation(view1,Gravity.LEFT,
		// 0,getActivity().getWindow().getWindowManager().getDefaultDisplay().getHeight()
		// -66);
		popWindow.update();

	}

	public int Px2Dp(Context context, float px) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (px / scale + 0.5f);
	}

	public int Dp2Px(Context context, float dp) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}

}
