package com.halong.associationapp.tab2;


import com.halong.associationapp.R;
import com.halong.associationapp.util.DragImageView;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.Window;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.graphics.Rect;

import android.view.ViewTreeObserver;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;


public class ShowPictureActivity extends Activity {
	private DragImageView imageView;
	private int window_width, window_height;// 控件宽度
	
	private int state_height;// 状态栏的高度

	private ViewTreeObserver viewTreeObserver;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_submit_showpicture);
		imageView=(DragImageView)findViewById(R.id.imageView1);
		Intent intent=getIntent();
		Bundle bundle=intent.getExtras();
		byte[] buffer=(byte[]) bundle.get("bitmap");
		//InputStream inputStream=new ByteArrayInputStream(buffer);
		Bitmap bmp =BitmapFactory.decodeByteArray(buffer, 0, buffer.length);
		imageView.setImageBitmap(bmp);
		imageView.setmActivity(this);//注入Activity.
		/** 测量状态栏高度 **/
		viewTreeObserver = imageView.getViewTreeObserver();
		viewTreeObserver
				.addOnGlobalLayoutListener(new OnGlobalLayoutListener() {

					@Override
					public void onGlobalLayout() {
						if (state_height == 0) {
							// 获取状况栏高度
							Rect frame = new Rect();
							getWindow().getDecorView()
									.getWindowVisibleDisplayFrame(frame);
							state_height = frame.top;
							imageView.setScreen_H(window_height-state_height);
							imageView.setScreen_W(window_width);
						}

					}
				});

	}
	

}
