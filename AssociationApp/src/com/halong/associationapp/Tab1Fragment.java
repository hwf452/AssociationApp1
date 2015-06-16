package com.halong.associationapp;
/**
 * 活动页页tab1
 * 
 */



import com.halong.associationapp.more.MoreActivity;
import com.halong.associationapp.more.MyFavoritesActivity;
import com.halong.associationapp.more.MyLiveSiteShowActivity;
import com.halong.associationapp.more.MyReviewActivity;
import com.halong.associationapp.more.MyTallSomethingActivity;
import com.halong.associationapp.tab1.ActiveInfoActivity;
import com.halong.associationapp.tab2.MyEnterActive;
import com.halong.associationapp.tab4.LoginActivity;
import com.halong.associationapp.tab4.PrivateImformationActivity;
import com.halong.associationapp.util.ScreenUtil;



import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import android.widget.ImageView;
import android.widget.ListView;

import android.widget.AdapterView.OnItemClickListener;

public class Tab1Fragment extends FragmentToOtherActivity{
	/**
	 * 声明控件
	 */
	private Button mLoginButton,mButton13,mButton12,mButton14,mButton10;
	private PopupWindow popWindow;
	private Context mContext;
	private View popWindowHidden;
	private ListView mListView;
	private LinearLayout mLinear22;
	private Button mMenuButton,mButton9,mButton11,mButtonMedia;
	private View view;

	private int[] imageIds={R.drawable.head155,R.drawable.head154,R.drawable.head153,R.drawable.head155};
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		view=inflater.inflate(R.layout.fragment_tab1, null);
		mContext=getActivity();
		
		mListView=(ListView)view.findViewById(R.id.listView1);
				
		mMenuButton=(Button)view.findViewById(R.id.MenuButton);
		initView();
		return view;
	}
	/**
	 * 初始化控件及绑定相关点击事件
	 */
	private void initView() {
		mMenuButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				showPopupWindow();
				//drawerGarment.openDrawer();
				
			}
		});
		
		
		mListView.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View view, ViewGroup parent) {
				view =getActivity().getLayoutInflater().inflate(R.layout.item_list_tab3_active, null);
				ImageView imageView1=(ImageView) view.findViewById(R.id.imageView1);
				imageView1.setImageResource(imageIds[position]);
				switch (position) {
				case 0:
					((ImageView)view.findViewById(R.id.typeImg)).setImageResource(R.drawable.icon_bq_jj2);
					break;
				case 2:
					((ImageView)view.findViewById(R.id.typeImg)).setImageResource(R.drawable.icon_bq_ad2);
					view.findViewById(R.id.joinBtn).setVisibility(View.INVISIBLE);
					view.findViewById(R.id.comeBtn).setVisibility(View.INVISIBLE);
					break;
				default:
					break;
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
				return imageIds.length;
			}
		});
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				
					Intent intent = new Intent(getActivity(), ActiveInfoActivity.class);
					intent.putExtra("proceedingPic",imageIds[position] );
					
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
			
			}
		});
		
	}
	
	/**
	 * 左侧栏菜单调用的方法
	 */
	
	private void showPopupWindow() {
		DisplayMetrics dm = getResources().getDisplayMetrics();
		int displayWidth = dm.widthPixels;
		
		 View view1 = getActivity().getLayoutInflater().inflate(R.layout.popupwindow_tab1_menu, null);
		 
		    //初始化弹出菜单
		    popWindow = new PopupWindow(view1,WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT,true);
		  
	       
		    //设置可以获取焦点，否则弹出菜单中的EditText是无法获取输入的
		    popWindow.setFocusable(true);
		    popWindow.setAnimationStyle(R.style.popwin_anim_style_menu);
		    //这句是为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
		    popWindow.setBackgroundDrawable(new BitmapDrawable()); 
		    //防止虚拟软键盘被弹出菜单遮住
		    popWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		    //在底部显示
		    //popWindow.showAtLocation(view1,Gravity.CENTER_HORIZONTAL, 30, 30);
		    //popWindow.showAsDropDown(mActive);
		    // 计算x轴方向的偏移量，使得PopupWindow在Title的正下方显示，此处的单位是pixels  
		    
		    //int xoffInPixels = getActivity().getWindow().getWindowManager().getDefaultDisplay().getWidth() / 2 -33;  
		        // 将pixels转为dip  
		     //   int xoffInDip =  Px2Dp(getActivity(), xoffInPixels); 
		    	int offY=ScreenUtil.Dp2Px(mContext,(float) 10.5);
		       popWindow.showAsDropDown(mMenuButton);  
		       // popWindow.showAtLocation(view1,Gravity.LEFT, 0,getActivity().getWindow().getWindowManager().getDefaultDisplay().getHeight() -66);
		       popWindow.update();
		       	                      
		       mLoginButton=(Button) view1.findViewById(R.id.button8);
		       
		       mLinear22=(LinearLayout)view1.findViewById(R.id.linear22);
		       mButton9=(Button)view1.findViewById(R.id.button9);
		       mButton11=(Button)view1.findViewById(R.id.button11);
		       mButton13=(Button)view1.findViewById(R.id.button13);
		       mButton12=(Button)view1.findViewById(R.id.button12);
		       mButton14=(Button)view1.findViewById(R.id.button14);
		       mButton10=(Button)view1.findViewById(R.id.button10);
		       mButtonMedia=(Button)view1.findViewById(R.id.buttonMedia);
		       mButton10.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(mContext,MyTallSomethingActivity.class);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
					
				}
			});
		       mButton14.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(mContext,PrivateImformationActivity.class);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
					
					
				}
			});
		       mButton12.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(mContext,MyReviewActivity.class);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
					
				}
			});
		       mButton13.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(mContext,MyFavoritesActivity.class);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
					
				}
			});
		       mLinear22.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(mContext,MoreActivity.class);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
					
				}
			});
		       mButton11.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(mContext,MyEnterActive.class);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
					
				}
			});
		       mButton9.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					popWindow.dismiss();
					
				}
			});
		       mLoginButton.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(mContext,LoginActivity.class);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
					
				}
			});
		       
		       mButtonMedia.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent intent=new Intent(mContext,MyLiveSiteShowActivity.class);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);
					
				}
			});
		     
		popWindowHidden=(View)view1.findViewById(R.id.popWindowHidden);
		

		
		
		popWindowHidden.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				popWindow.dismiss();
				
			}
		});
	}
	
	
	

}
