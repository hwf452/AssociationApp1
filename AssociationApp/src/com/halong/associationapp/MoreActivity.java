package com.halong.associationapp;

/**
 * wenfei  create
 * 主页更多功能更面
 */



import net.tsz.afinal.annotation.view.ViewInject;

import com.halong.associationapp.more.ContractActivity;
import com.halong.associationapp.more.CurrentLocationActivity;
import com.halong.associationapp.more.ProceedingActivity;
import com.halong.associationapp.tab3.ToWeiboActivity;
import com.halong.associationapp.tab5.AboutMeActivity;
import com.halong.associationapp.util.ScreenUtil;
import com.halong.associationapp.util.UpdateManager;
import com.mining.app.zxing.BarCodeTestActivity;



import android.content.Intent;
import android.os.Bundle;

import android.view.Display;
import android.view.KeyEvent;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;


import android.widget.RelativeLayout.LayoutParams;

public class MoreActivity extends BackActivity {
	/**
	 * 
	 * 查找Button控件id=
	 * 对应点击方法click=
	 * 按钮名称Button mBtnContrat
	 */
	private View view;
	@ViewInject(id=R.id.button1,click="mBtnContrat")Button mBtnContrat;
	@ViewInject(id=R.id.button2,click="mBtnUpdate")Button mBtnUpdate;
	@ViewInject(id=R.id.button3,click="mBtnTwocode")Button mBtnTwocode;
	@ViewInject(id=R.id.button4,click="mBtnWeibo")Button mBtnWeibo;
	@ViewInject(id=R.id.button5,click="mBtnWeixin")Button mBtnWeixin;
	@ViewInject(id=R.id.button6,click="mBtnHueikan")Button mBtnHueikan;
	@ViewInject(id=R.id.button7,click="mBtnAboutMe")Button mBtnAboutMe;
	@ViewInject(id=R.id.button8,click="mBtnWaitAddButton")Button mBtnWaitAddButton;
	@ViewInject(id=R.id.button9,click="mBtnExit")Button mBtnExit;
	/**
	 * 按钮属性
	 */

	private LayoutParams params1 = new LayoutParams(0, 0);
	private LayoutParams params2 = new LayoutParams(0, 0);
	private LayoutParams params3 = new LayoutParams(0, 0);
	private LayoutParams params4 = new LayoutParams(0, 0);
	private LayoutParams params5 = new LayoutParams(0, 0);
	private LayoutParams params6 = new LayoutParams(0, 0);
	private LayoutParams params7 = new LayoutParams(0, 0);
	private LayoutParams params8 = new LayoutParams(0, 0);
	/**
	 * 手机屏幕宽高
	 */
	private static int width, height;
	/**
	 * 动画执行时间
	 */
	static final int anicatinoTime = 400;
	/**
	 *状态栏高度多少像素
	 */
	private Integer statusBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		view=getLayoutInflater().inflate(R.layout.activity_more, null);
		setContentView(view);
		/**
		 *初始化按钮并设置位置
		 */
		initView();
		/**
		 * 启动动画
		 */
		outAnimation();
		
		
	}

	private void initView() {

		statusBar = ScreenUtil.getStatusBarHeight(this);
		Display display = getWindowManager().getDefaultDisplay();
		height = display.getHeight();
		width = display.getWidth();
		int btn1MarginLeft = (width / 3 - 130) / 2;
		int btn2MarginLeft = width / 3 + btn1MarginLeft;
		Integer btn3MarginLeft = width / 3 * 2 + btn1MarginLeft;
		/**
		 * 设置按钮初始位置看不见
		 */

		params1 = (LayoutParams) mBtnContrat.getLayoutParams();
		params1.setMargins(btn1MarginLeft, height, 0, 0);
		mBtnContrat.setLayoutParams(params1);

		params2 = (LayoutParams) mBtnUpdate.getLayoutParams();

		params2.setMargins(btn2MarginLeft, height, 0, 0);

		mBtnUpdate.setLayoutParams(params2);
		params3 = (LayoutParams) mBtnTwocode.getLayoutParams();

		params3.setMargins(btn3MarginLeft, height, 0, 0);

		mBtnTwocode.setLayoutParams(params3);
		params4 = (LayoutParams) mBtnWeibo.getLayoutParams();
		params4.setMargins(btn1MarginLeft, height, 0, 0);
		mBtnWeibo.setLayoutParams(params4);

		params5 = (LayoutParams) mBtnWeixin.getLayoutParams();

		params5.setMargins(btn2MarginLeft, height, 0, 0);

		mBtnWeixin.setLayoutParams(params5);
		params6 = (LayoutParams) mBtnHueikan.getLayoutParams();

		params6.setMargins(btn3MarginLeft, height, 0, 0);

		mBtnHueikan.setLayoutParams(params6);

		params7 = (LayoutParams) mBtnAboutMe.getLayoutParams();
		params7.setMargins(btn1MarginLeft, height, 0, 0);
		mBtnAboutMe.setLayoutParams(params7);

		params8 = (LayoutParams) mBtnWaitAddButton.getLayoutParams();

		params8.setMargins(btn2MarginLeft, height, 0, 0);

		mBtnWaitAddButton.setLayoutParams(params8);
		/**
		 * 延迟调用动画
		 */
		getLayoutInflater().inflate(R.layout.activity_more, null).postDelayed(new Runnable() {

			@Override
			public void run() {
				outAnimation();

			}
		}, 300);

		

	}

	
	/**
	 * 执行动画的方法
	 */

	public void outAnimation() {
		final Integer btn1MarginLeft = (width/3-mBtnContrat.getWidth())/2;
		final Integer btn2MarginLeft = width / 3 + btn1MarginLeft;
		final Integer btn3MarginLeft = width / 3 * 2 + btn1MarginLeft;

		TranslateAnimation translateAnimation = new TranslateAnimation(
				0,
				0,
				0,
				-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*3 + 10));
		translateAnimation.setInterpolator(new OvershootInterpolator());
		translateAnimation.setDuration(anicatinoTime);
		translateAnimation.setFillAfter(true);
		//translateAnimation.setStartOffset(50);
		//translateAnimation.setRepeatCount(1);
		
		//translateAnimation.setRepeatMode(Animation.RESTART);
		translateAnimation.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				mBtnContrat.clearAnimation();
				
				params1 = (LayoutParams) mBtnContrat.getLayoutParams();
				params1.setMargins(btn1MarginLeft, height-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*3 + 10), 0, 0);
				mBtnContrat.setLayoutParams(params1);
				
			}
		});
		
		mBtnContrat.startAnimation(translateAnimation);



		TranslateAnimation translateAnimation1 = new TranslateAnimation(
				0,
				0,
				0,
				-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*3 + 10));
		translateAnimation1.setInterpolator(new OvershootInterpolator());
		translateAnimation1.setDuration(anicatinoTime);
		translateAnimation1.setStartOffset(50);
		translateAnimation1.setFillAfter(true);
		translateAnimation1.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				mBtnUpdate.clearAnimation();
				
				params2 = (LayoutParams) mBtnUpdate.getLayoutParams();
				params2.setMargins(btn2MarginLeft, height-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*3 + 10), 0, 0);
				mBtnUpdate.setLayoutParams(params2);
				
			}
		});
		mBtnUpdate.startAnimation(translateAnimation1);


		TranslateAnimation translateAnimation2 = new TranslateAnimation(0, 0,
				0, -(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*3
						 + 10));
		translateAnimation2.setInterpolator(new OvershootInterpolator());
		translateAnimation2.setDuration(anicatinoTime);
		translateAnimation2.setStartOffset(100);

		translateAnimation2.setFillAfter(true);
		translateAnimation2.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				mBtnTwocode.clearAnimation();
				params3 = (LayoutParams) mBtnTwocode.getLayoutParams();

				params3.setMargins(btn3MarginLeft, height-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*3
						 + 10), 0, 0);

				mBtnTwocode.setLayoutParams(params3);
				
			}
		});
		mBtnTwocode.startAnimation(translateAnimation2);
		
		
		TranslateAnimation translateAnimation3 = new TranslateAnimation(0, 0,
				0, -(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*2
						 + 10));
		translateAnimation3.setInterpolator(new OvershootInterpolator());
		translateAnimation3.setDuration(anicatinoTime);
		translateAnimation3.setStartOffset(150);
		translateAnimation3.setFillAfter(true);
		translateAnimation3.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				mBtnWeibo.clearAnimation();
				
				params4 = (LayoutParams) mBtnWeibo.getLayoutParams();
				params4.setMargins(btn1MarginLeft, height-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*2 + 10), 0, 0);
				mBtnWeibo.setLayoutParams(params4);
				
			}
		});
		mBtnWeibo.startAnimation(translateAnimation3);

		TranslateAnimation translateAnimation4 = new TranslateAnimation(0, 0,
				0, -(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*2
						 + 10));
		translateAnimation4.setInterpolator(new OvershootInterpolator());
		translateAnimation4.setDuration(anicatinoTime);
		translateAnimation4.setStartOffset(200);
		translateAnimation4.setFillAfter(true);
		translateAnimation4.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				mBtnWeixin.clearAnimation();
				
				params5 = (LayoutParams) mBtnWeixin.getLayoutParams();
				params5.setMargins(btn2MarginLeft, height-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*2 + 10), 0, 0);
				mBtnWeixin.setLayoutParams(params5);
				
			}
		});

		mBtnWeixin.startAnimation(translateAnimation4);

		TranslateAnimation translateAnimation5 = new TranslateAnimation(0, 0,
				0, -(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*2
						 + 10));
		translateAnimation5.setInterpolator(new OvershootInterpolator());
		translateAnimation5.setDuration(anicatinoTime);
		translateAnimation5.setStartOffset(250);
		translateAnimation5.setFillAfter(true);
		translateAnimation5.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				mBtnHueikan.clearAnimation();
				params6 = (LayoutParams) mBtnHueikan.getLayoutParams();

				params6.setMargins(btn3MarginLeft, height-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()*2
						 + 10), 0, 0);

				mBtnHueikan.setLayoutParams(params6);
				
			}
		});
		mBtnHueikan.startAnimation(translateAnimation5);

		TranslateAnimation translateAnimation6 = new TranslateAnimation(0, 0,
				0, -(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()
						 + 10));
		translateAnimation6.setInterpolator(new OvershootInterpolator());
		translateAnimation6.setDuration(anicatinoTime);
		translateAnimation6.setStartOffset(300);
		translateAnimation6.setFillAfter(true);
		translateAnimation6.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				mBtnAboutMe.clearAnimation();
				
				params7 = (LayoutParams) mBtnAboutMe.getLayoutParams();
				params7.setMargins(btn1MarginLeft, height-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight() + 10), 0, 0);
				mBtnAboutMe.setLayoutParams(params7);
				
			}
		});
		mBtnAboutMe.startAnimation(translateAnimation6);

		TranslateAnimation translateAnimation7 = new TranslateAnimation(0, 0,
				0, -(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight()
						 + 10));
		translateAnimation7.setInterpolator(new OvershootInterpolator());
		translateAnimation7.setDuration(anicatinoTime);
		translateAnimation7.setStartOffset(350);
		translateAnimation7.setFillAfter(true);
		translateAnimation7.setAnimationListener(new AnimationListener() {
			
			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onAnimationEnd(Animation animation) {
				mBtnWaitAddButton.clearAnimation();
				
				params8 = (LayoutParams) mBtnWaitAddButton.getLayoutParams();
				params8.setMargins(btn2MarginLeft, height-(mBtnExit.getHeight() + statusBar + mBtnContrat.getHeight() + 10), 0, 0);
				mBtnWaitAddButton.setLayoutParams(params8);
				
			}
		});
		mBtnWaitAddButton.startAnimation(translateAnimation7);
	}
	/**
	 * 通讯录按钮点击调用的方法
	 * @param view
	 */
	public void mBtnContrat(View view){
		
		Intent intent=new Intent(this,ContractActivity.class);
		
		startActivity(intent);
		overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
		
		
	}
	/**
	 * 检查更新按钮点击调用的方法
	 * @param view
	 */

	public void mBtnUpdate(View view){
		//传入包名和是否显示对话框更新
		UpdateManager manager = new UpdateManager(this,"com.halong.associationapp",true);
		
		manager.checkUpdate();
	}
	/**
	 * 二维码工具按钮点击调用的方法
	 * @param view
	 */
	public void mBtnTwocode(View view){
		Intent intent1=new Intent(this,BarCodeTestActivity.class);
		startActivity(intent1);
		overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
		
	}
	/**
	 * 关于我们按钮点击调用的方法
	 * @param view
	 */
	public void mBtnAboutMe(View view){
		Intent intent=new Intent(this,AboutMeActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
		
	}
	/**
	 * 待定添加按钮点击调用的方法
	 * @param view
	 */
	public void mBtnWaitAddButton(View view){
//		Intent intent2=new Intent(this,CurrentLocationActivity.class);
//		startActivity(intent2);
//		overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
		
		
	}
	/**
	 * 关闭按钮点击调用的方法
	 * @param view
	 */
	public void mBtnExit(View view){
		finish();
		overridePendingTransition(R.anim.more_in_anim, R.anim.more_out_anim);
	}
	/**
	 * 微博按钮点击调用的方法
	 * @param view
	 */
	
	public void mBtnWeibo(View view){
		Intent intent6 = new Intent(this, ToWeiboActivity.class);
		intent6.putExtra("webAddr", "http://weibo.com/u/2313353500");

		startActivity(intent6);
		
		overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
		
	}
	/**
	 * 会刊按钮点击调用的方法
	 * @param view
	 */
	public void mBtnHueikan(View view){
		Intent intent=new Intent(this,ProceedingActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
		
	}
	/**
	 * 公众号按钮点击调用的方法
	 * @param view
	 */
	
	public void mBtnWeixin(View view){
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		
		finish();
		overridePendingTransition(R.anim.more_in_anim, R.anim.more_out_anim);
		return true;
	}

}
