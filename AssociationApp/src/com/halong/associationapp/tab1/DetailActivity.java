package com.halong.associationapp.tab1;

import java.io.Serializable;





import android.annotation.SuppressLint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;


import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.framework.Platform.ShareParams;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.onekeyshare.ShareContentCustomizeCallback;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;



@SuppressWarnings("serial")
public class DetailActivity extends BackActivity implements OnClickListener, ShareContentCustomizeCallback, Serializable{
	private PopupWindow popWindow;
	private View view;
	private Button mMore;

	

	private TextView mInfo_detail_title,mInfo_detail_comefrom,mInfo_detail_content;
	private RelativeLayout mInfo_detail_imageview;
	private Button mButton18;
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ShareSDK.stopSDK(this);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		ShareSDK.initSDK(this);
		view=getLayoutInflater().inflate(R.layout.activity_detail_pulllist, null);
		setContentView(view);
		mInfo_detail_comefrom=(TextView)view.findViewById(R.id.info_detail_comefrom);
		mInfo_detail_title=(TextView)view.findViewById(R.id.info_detail_title);
		mInfo_detail_content=(TextView)view.findViewById(R.id.info_detail_content);
		mInfo_detail_imageview=(RelativeLayout)view.findViewById(R.id.info_detail_imageview);
		
		mMore=(Button)view.findViewById(R.id.more);
		
		mMore.setOnClickListener(this);
		initView();
		
	}
	
	private void share(){
		OnekeyShare oks = new OnekeyShare();

		// 分享时Notification的图标和文字
		oks.setNotification(R.drawable.ic_launcher,
		this.getString(R.string.app_name));
		// address是接收人地址，仅在信息和邮件使用
		oks.setAddress("");
		// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
		oks.setTitle(this.getString(R.string.share));
		// titleUrl是标题的网络链接，仅在人人网和QQ空间使用
		oks.setTitleUrl("http://sharesdk.cn");
		// text是分享文本，所有平台都需要这个字段
		oks.setText("fenxiangneirong");
		// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//		oks.setImagePath(this.TEST_IMAGE);
		// imageUrl是图片的网络路径，新浪微博、人人网、QQ空间、
		// 微信的两个平台、Linked-In支持此字段
		oks.setImageUrl("http://img.appgo.cn/imgs/sharesdk/content/2013/07/25/1374723172663.jpg");
		// url仅在微信（包括好友和朋友圈）中使用
		oks.setUrl("http://sharesdk.cn");
		// appPath是待分享应用程序的本地路劲，仅在微信中使用
//		oks.setAppPath(MainActivity.TEST_IMAGE);
		// comment是我对这条分享的评论，仅在人人网和QQ空间使用
//		oks.setComment(getContext().getString(R.string.share));
		// site是分享此内容的网站名称，仅在QQ空间使用
		oks.setSite("11111");
		// siteUrl是分享此内容的网站地址，仅在QQ空间使用
		oks.setSiteUrl("http://sharesdk.cn");
		// venueName是分享社区名称，仅在Foursquare使用
		oks.setVenueName("Southeast in China");
		// venueDescription是分享社区描述，仅在Foursquare使用
		oks.setVenueDescription("This is a beautiful place!");
		// latitude是维度数据，仅在新浪微博、腾讯微博和Foursquare使用
		oks.setLatitude(23.122619f);
		// longitude是经度数据，仅在新浪微博、腾讯微博和Foursquare使用
		oks.setLongitude(113.372338f);
		// 是否直接分享（true则直接分享）
		oks.setSilent(true);
		// 指定分享平台，和slient一起使用可以直接分享到指定的平台
//		if (platform != null) {
//		        oks.setPlatform(platform);
//		}
		// 去除注释可通过OneKeyShareCallback来捕获快捷分享的处理结果
		// oks.setCallback(new OneKeyShareCallback());
		//通过OneKeyShareCallback来修改不同平台分享的内容
		oks.setShareContentCustomizeCallback(this);

		oks.show(this);
	}

	@SuppressWarnings("deprecation")
	private void initView() {
		
		AssociationData associationData=(AssociationData)getIntent().getSerializableExtra("mainDetail");
		
		mInfo_detail_title.setText(associationData.getmTitle());
		String string=associationData.getTime()+" 来源 : "+associationData.getSource();
		mInfo_detail_comefrom.setText(string);
		mInfo_detail_content.setText(associationData.getmContent());
		
		
		Drawable drawable=getResources().getDrawable(associationData.getDrawableId());
		
		mInfo_detail_imageview.setBackgroundDrawable(drawable);
		}

	@Override
	public void onShare(Platform platform, ShareParams paramsToShare) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button18:
			share();
			popWindow.dismiss();
			break;
		case R.id.more:
			showPopupWindow();
			break;
		
		default:
			break;
		}
	}
	
	private void showPopupWindow() {
		 View view1 = getLayoutInflater().inflate(R.layout.popupwindow_tab2_more1, null);
		 mButton18=(Button) view1.findViewById(R.id.button18);
		 Button button14=(Button)view1.findViewById(R.id.button14);
		 button14.setVisibility(View.GONE);
		 mButton18.setOnClickListener(this);
		    //初始化弹出菜单
		    popWindow = new PopupWindow(view1, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT,false);
		    //设置可以获取焦点，否则弹出菜单中的EditText是无法获取输入的
		    popWindow.setFocusable(true);
		   // popWindow.setAnimationStyle(R.style.popwin_anim_style);
		    //这句是为了防止弹出菜单获取焦点之后，点击activity的其他组件没有响应
		    popWindow.setBackgroundDrawable(new BitmapDrawable()); 
		    //防止虚拟软键盘被弹出菜单遮住
		    popWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
		    //在底部显示
		    //popWindow.showAtLocation(view1,Gravity.BOTTOM, 0, 40);
		    popWindow.showAsDropDown(mMore);
		    
		
	}

	
}
