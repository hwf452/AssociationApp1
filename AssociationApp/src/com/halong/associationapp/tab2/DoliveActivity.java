package com.halong.associationapp.tab2;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ImageView;
import android.widget.Toast;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.util.FileUtils;

public class DoliveActivity extends BackActivity implements OnClickListener {

	private Button mDoliveButton;
	private EditText mContentEditText;
	private ImageView mImageButton1, mImageButton2, mImageButton3,mImageButton4;
	private AlertDialog.Builder mDialog;
	private String ImageName;
	private Integer mWidth;
	private Integer mHeight;
	
	private String url = "http://192.168.32.250:8080/web18_uploadpic/updoadPic?name=hwf452";
	private Uri imageUri;// to store the big bitmap

	private static final int TAKE_BIG_PICTURE1 = 1;
	private static final int TAKE_BIG_PICTURE2 = 2;
	private static final int TAKE_BIG_PICTURE3 = 3;
	private static final int TAKE_BIG_PICTURE4 = 4;
	private static final int CROP_BIG_PICTURE1 = 5;
	private static final int CROP_BIG_PICTURE2 = 6;
	private static final int CROP_BIG_PICTURE3 = 7;
	private static final int CROP_BIG_PICTURE4 = 8;
	private static final int CHOOSE_BIG_PICTURE1 = 9;
	private static final int CHOOSE_BIG_PICTURE2 = 10;
	private static final int CHOOSE_BIG_PICTURE3 = 11;
	private static final int CHOOSE_BIG_PICTURE4 = 12;
	private Context mContext;
	private byte[] mBitmap11  = null;
	private byte[] mBitmap22 = null;
	private byte[] mBitmap33 = null;
	private byte[] mBitmap44 = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab2_dolive);
		mContext = this;
		// 初始化控件
		initView();
		mWidth = getWindowManager().getDefaultDisplay().getWidth();
		mHeight = getWindowManager().getDefaultDisplay().getHeight();
		
		
		
		imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "/temp.jpg"));
		

	}

	private void initView() {
		// TODO Auto-generated method stub
		mDoliveButton = (Button) findViewById(R.id.doliveButton);
		mContentEditText = (EditText) findViewById(R.id.doLiveContentEditText);
		mImageButton1 = (ImageView) findViewById(R.id.doLiveImageButton1);
		mImageButton2 = (ImageView) findViewById(R.id.doLiveImageButton2);
		mImageButton3 = (ImageView) findViewById(R.id.doLiveImageButton3);
		mImageButton4=(ImageView)findViewById(R.id.doLiveImageButton4);
		mDoliveButton.setOnClickListener(this);
		mImageButton1.setOnClickListener(this);
		mImageButton2.setOnClickListener(this);
		mImageButton3.setOnClickListener(this);
		mImageButton4.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.doliveButton:

			break;
		case R.id.doLiveImageButton1:

			if (mBitmap11 != null) {

				Intent intent = new Intent(this, ShowPictureActivity.class);
				intent.putExtra("bitmap", mBitmap11);
				
				startActivity(intent);

			} else {
				mDialog = new AlertDialog.Builder(this);
				mDialog.setTitle("上传像片");
				mDialog.setMessage("请选择上传方式");
				mDialog.setPositiveButton("拍照",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								if (imageUri != null) {
									Intent intent = new Intent(
											MediaStore.ACTION_IMAGE_CAPTURE);
									intent.putExtra(MediaStore.EXTRA_OUTPUT,
											imageUri);
									startActivityForResult(intent,
											TAKE_BIG_PICTURE1);
								}

							}
						});
				mDialog.setNegativeButton("从像册选择",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Intent intent = new Intent(
										Intent.ACTION_GET_CONTENT, null);
								intent.setType("image/*");
								intent.putExtra("crop", "true");
								intent.putExtra("aspectX", mWidth);
								intent.putExtra("aspectY",mHeight);
								intent.putExtra("outputX", mWidth);
								intent.putExtra("outputY", mHeight);
								intent.putExtra("scale", true);
								intent.putExtra("return-data", false);
								intent.putExtra(MediaStore.EXTRA_OUTPUT,
										imageUri);
								intent.putExtra("outputFormat",
										Bitmap.CompressFormat.JPEG.toString());
								intent.putExtra("noFaceDetection", false); // no
																			// face
																			// detection
								startActivityForResult(intent,
										CHOOSE_BIG_PICTURE1);

							}
						});
				mDialog.show();
			}

			break;
		case R.id.doLiveImageButton2:

			if (mBitmap22 != null) {

				Intent intent = new Intent(this, ShowPictureActivity.class);
				intent.putExtra("bitmap", mBitmap22);
				startActivity(intent);

			} else {
				mDialog = new AlertDialog.Builder(this);
				mDialog.setTitle("上传像片");
				mDialog.setMessage("请选择上传方式");
				mDialog.setPositiveButton("拍照",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								if (imageUri != null) {
									Intent intent = new Intent(
											MediaStore.ACTION_IMAGE_CAPTURE);
									intent.putExtra(MediaStore.EXTRA_OUTPUT,
											imageUri);
									startActivityForResult(intent,
											TAKE_BIG_PICTURE2);
								}

							}
						});
				mDialog.setNegativeButton("从像册选择",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Intent intent = new Intent(
										Intent.ACTION_GET_CONTENT, null);
								intent.setType("image/*");
								intent.putExtra("crop", "true");
								intent.putExtra("aspectX", mWidth);
								intent.putExtra("aspectY", mHeight);
								intent.putExtra("outputX", mWidth);
								intent.putExtra("outputY", mHeight);
								intent.putExtra("scale", true);
								intent.putExtra("return-data", false);
								intent.putExtra(MediaStore.EXTRA_OUTPUT,
										imageUri);
								intent.putExtra("outputFormat",
										Bitmap.CompressFormat.JPEG.toString());
								intent.putExtra("noFaceDetection", false); // no
																			// face
																			// detection
								startActivityForResult(intent,
										CHOOSE_BIG_PICTURE2);

							}
						});
				mDialog.show();
			}

			break;
		case R.id.doLiveImageButton3:

			if (mBitmap33 != null) {

				Intent intent = new Intent(this, ShowPictureActivity.class);
				intent.putExtra("bitmap", mBitmap33);
				startActivity(intent);

			} else {
				mDialog = new AlertDialog.Builder(this);
				mDialog.setTitle("上传像片");
				mDialog.setMessage("请选择上传方式");
				mDialog.setPositiveButton("拍照",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								if (imageUri != null) {
									Intent intent = new Intent(
											MediaStore.ACTION_IMAGE_CAPTURE);
									intent.putExtra(MediaStore.EXTRA_OUTPUT,
											imageUri);
									startActivityForResult(intent,
											TAKE_BIG_PICTURE3);
								}

							}
						});
				mDialog.setNegativeButton("从像册选择",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Intent intent = new Intent(
										Intent.ACTION_GET_CONTENT, null);
								intent.setType("image/*");
								intent.putExtra("crop", "true");
								intent.putExtra("aspectX", mWidth);
								intent.putExtra("aspectY", mHeight);
								intent.putExtra("outputX", mWidth);
								intent.putExtra("outputY", mHeight);
								intent.putExtra("scale", true);
								intent.putExtra("return-data", false);
								intent.putExtra(MediaStore.EXTRA_OUTPUT,
										imageUri);
								intent.putExtra("outputFormat",
										Bitmap.CompressFormat.JPEG.toString());
								intent.putExtra("noFaceDetection", false); // no
																			// face
																			// detection
								startActivityForResult(intent,
										CHOOSE_BIG_PICTURE3);

							}
						});
				mDialog.show();
			}

			break;
		case R.id.doLiveImageButton4:

			if (mBitmap44 != null) {

				Intent intent = new Intent(this, ShowPictureActivity.class);
				intent.putExtra("bitmap", mBitmap44);
				startActivity(intent);

			} else {
				mDialog = new AlertDialog.Builder(this);
				mDialog.setTitle("上传像片");
				mDialog.setMessage("请选择上传方式");
				mDialog.setPositiveButton("拍照",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								if (imageUri != null) {
									Intent intent = new Intent(
											MediaStore.ACTION_IMAGE_CAPTURE);
									intent.putExtra(MediaStore.EXTRA_OUTPUT,
											imageUri);
									startActivityForResult(intent,
											TAKE_BIG_PICTURE4);
								}

							}
						});
				mDialog.setNegativeButton("从像册选择",
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								Intent intent = new Intent(
										Intent.ACTION_GET_CONTENT, null);
								intent.setType("image/*");
								intent.putExtra("crop", "true");
								intent.putExtra("aspectX", mWidth);
								intent.putExtra("aspectY", mHeight);
								intent.putExtra("outputX", mWidth);
								intent.putExtra("outputY", mHeight);
								intent.putExtra("scale", true);
								intent.putExtra("return-data", false);
								intent.putExtra(MediaStore.EXTRA_OUTPUT,
										imageUri);
								intent.putExtra("outputFormat",
										Bitmap.CompressFormat.JPEG.toString());
								intent.putExtra("noFaceDetection", false); // no
																			// face
																			// detection
								startActivityForResult(intent,
										CHOOSE_BIG_PICTURE4);

							}
						});
				mDialog.show();
			}

			break;

		default:
			break;
		}
	}

	

	private void cropImageUri(Uri uri, int outputX, int outputY, int requestCode) {
		Intent intent = new Intent("com.android.camera.action.CROP");
		intent.setDataAndType(uri, "image/*");
		intent.putExtra("crop", "true");

		intent.putExtra("aspectX", mWidth);
		intent.putExtra("aspectY", mHeight);

		intent.putExtra("outputX", mWidth);
		intent.putExtra("outputY", mHeight);
		intent.putExtra("scale", true);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
		intent.putExtra("return-data", false);
		intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
		intent.putExtra("noFaceDetection", true); // no face detection
		startActivityForResult(intent, requestCode);
	}

	private Drawable decodeUriAsBitmap(Uri uri) {
		Drawable drawable = null;
		try {
			
			 drawable=Drawable.createFromStream(getContentResolver()
					.openInputStream(uri), null);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		return drawable;
	}
	private InputStream getInputStream(Uri imageUri){
		try {
			InputStream inputStream = getContentResolver()
					.openInputStream(imageUri);
			return inputStream;
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode != Activity.RESULT_OK) {

			return;
		} else {

			switch (requestCode) {
			case TAKE_BIG_PICTURE1:

				cropImageUri(imageUri, mWidth, mHeight, CROP_BIG_PICTURE1);

				break;
			case CROP_BIG_PICTURE1:// from crop_big_picture

				if (imageUri != null) {
					final Drawable bitmap = decodeUriAsBitmap(imageUri);
					
					mImageButton1.setImageDrawable(bitmap);
					
					InputStream inputStream = getInputStream(imageUri);
					try {
						mBitmap11=FileUtils.toByteArray(inputStream);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					FinalHttp finalHttp = new FinalHttp();

					AjaxParams params = new AjaxParams();

					params.put("profile_picture2", inputStream); // 上传数据流

					finalHttp.post(url, params, new AjaxCallBack<Object>() {
						@Override
						public void onSuccess(Object t) {
							Toast.makeText(mContext, "success", 3).show();

							
						}

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Toast.makeText(mContext, "fial", 3).show();
						}

					});
				}
				break;
			case CHOOSE_BIG_PICTURE1:

				if (imageUri != null) {
					final Drawable bitmap = decodeUriAsBitmap(imageUri);
					
					InputStream inputStream = getInputStream(imageUri);
					mImageButton1.setImageDrawable(bitmap);
					try {
						mBitmap11=FileUtils.toByteArray(inputStream);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					FinalHttp finalHttp = new FinalHttp();

					AjaxParams params = new AjaxParams();

					params.put("profile_picture2", inputStream); // 上传数据流

					finalHttp.post(url, params, new AjaxCallBack<Object>() {
						@Override
						public void onSuccess(Object t) {
							Toast.makeText(mContext, "success", 3).show();
							
						}

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Toast.makeText(mContext, "fial", 3).show();
						}

					});

				}
				break;
			case TAKE_BIG_PICTURE2:

				cropImageUri(imageUri, mWidth, mHeight, CROP_BIG_PICTURE2);

				break;
			case CROP_BIG_PICTURE2:// from crop_big_picture

				if (imageUri != null) {
					final Drawable bitmap = decodeUriAsBitmap(imageUri);
					InputStream inputStream=getInputStream(imageUri);;
					try {
						mBitmap22=FileUtils.toByteArray(inputStream);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mImageButton2.setImageDrawable(bitmap);
					
					

					FinalHttp finalHttp = new FinalHttp();

					AjaxParams params = new AjaxParams();

					params.put("profile_picture2", inputStream); // 上传数据流

					finalHttp.post(url, params, new AjaxCallBack<Object>() {
						@Override
						public void onSuccess(Object t) {
							Toast.makeText(mContext, "success", 3).show();

						}

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Toast.makeText(mContext, "fial", 3).show();
						}

					});
				}
				break;
			case CHOOSE_BIG_PICTURE2:

				if (imageUri != null) {
					final Drawable bitmap = decodeUriAsBitmap(imageUri);
					InputStream inputStream=getInputStream(imageUri);;
					try {
						mBitmap22=FileUtils.toByteArray(inputStream);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mImageButton2.setImageDrawable(bitmap);
					FinalHttp finalHttp = new FinalHttp();

					AjaxParams params = new AjaxParams();

					params.put("profile_picture2", inputStream); // 上传数据流

					finalHttp.post(url, params, new AjaxCallBack<Object>() {
						@Override
						public void onSuccess(Object t) {
							Toast.makeText(mContext, "success", 3).show();
							
						}

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Toast.makeText(mContext, "fial", 3).show();
						}

					});

				}
				break;
			case TAKE_BIG_PICTURE3:

				cropImageUri(imageUri, mWidth, mHeight, CROP_BIG_PICTURE3);

				break;
			case CROP_BIG_PICTURE3:// from crop_big_picture

				if (imageUri != null) {
					final Drawable bitmap = decodeUriAsBitmap(imageUri);
					InputStream inputStream=getInputStream(imageUri);;
					try {
						mBitmap33=FileUtils.toByteArray(inputStream);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mImageButton3.setImageDrawable(bitmap);

					FinalHttp finalHttp = new FinalHttp();

					AjaxParams params = new AjaxParams();

					params.put("profile_picture2", inputStream); // 上传数据流

					finalHttp.post(url, params, new AjaxCallBack<Object>() {
						@Override
						public void onSuccess(Object t) {
							Toast.makeText(mContext, "success", 3).show();

							
						}

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Toast.makeText(mContext, "fial", 3).show();
						}

					});
				}
				break;
			case CHOOSE_BIG_PICTURE3:

				if (imageUri != null) {
					final Drawable bitmap = decodeUriAsBitmap(imageUri);
					InputStream inputStream=getInputStream(imageUri);;
					try {
						mBitmap33=FileUtils.toByteArray(inputStream);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mImageButton3.setImageDrawable(bitmap);
					FinalHttp finalHttp = new FinalHttp();

					AjaxParams params = new AjaxParams();

					params.put("profile_picture2", inputStream); // 上传数据流

					finalHttp.post(url, params, new AjaxCallBack<Object>() {
						@Override
						public void onSuccess(Object t) {
							Toast.makeText(mContext, "success", 3).show();
							
						}

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Toast.makeText(mContext, "fial", 3).show();
						}

					});

				}
				break;
			case TAKE_BIG_PICTURE4:

				cropImageUri(imageUri, mWidth, mHeight, CROP_BIG_PICTURE3);

				break;
			case CROP_BIG_PICTURE4:// from crop_big_picture

				if (imageUri != null) {
					final Drawable bitmap = decodeUriAsBitmap(imageUri);
					InputStream inputStream=getInputStream(imageUri);;
					try {
						mBitmap44=FileUtils.toByteArray(inputStream);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mImageButton4.setImageDrawable(bitmap);

					FinalHttp finalHttp = new FinalHttp();

					AjaxParams params = new AjaxParams();

					params.put("profile_picture2", inputStream); // 上传数据流

					finalHttp.post(url, params, new AjaxCallBack<Object>() {
						@Override
						public void onSuccess(Object t) {
							Toast.makeText(mContext, "success", 3).show();

							
						}

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Toast.makeText(mContext, "fial", 3).show();
						}

					});
				}
				break;
			case CHOOSE_BIG_PICTURE4:

				if (imageUri != null) {
					final Drawable bitmap = decodeUriAsBitmap(imageUri);
					InputStream inputStream=getInputStream(imageUri);;
					try {
						mBitmap44=FileUtils.toByteArray(inputStream);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					mImageButton4.setImageDrawable(bitmap);
					FinalHttp finalHttp = new FinalHttp();

					AjaxParams params = new AjaxParams();

					params.put("profile_picture2", inputStream); // 上传数据流

					finalHttp.post(url, params, new AjaxCallBack<Object>() {
						@Override
						public void onSuccess(Object t) {
							Toast.makeText(mContext, "success", 3).show();
							
						}

						@Override
						public void onFailure(Throwable t, int errorNo,
								String strMsg) {
							Toast.makeText(mContext, "fial", 3).show();
						}

					});

				}
				break;
			}

		}
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {

		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == this.getResources().getConfiguration().ORIENTATION_PORTRAIT) {

		}

		// 切换为横屏

		else if (newConfig.orientation == this.getResources()
				.getConfiguration().ORIENTATION_LANDSCAPE) {

		}

	}


}
