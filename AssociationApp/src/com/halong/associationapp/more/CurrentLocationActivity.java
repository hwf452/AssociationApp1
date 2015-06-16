package com.halong.associationapp.more;

import net.tsz.afinal.annotation.view.ViewInject;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;






import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.LocationData;
import com.baidu.mapapi.map.MKEvent;
import com.baidu.mapapi.map.MKMapViewListener;
import com.baidu.mapapi.map.MapController;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationOverlay;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;



/**
 * 演示MapView的基本用法
 */
public class CurrentLocationActivity extends BackActivity {
	@ViewInject(id=R.id.requestLocationBtn) Button requestLocationBtn;
	@ViewInject(id=R.id.switch_mapStyle) Button requestLocButton;
	@ViewInject(id=R.id.textView2) TextView tv2;
	@ViewInject(id=R.id.textView3) TextView tv3;
	private enum E_BUTTON_TYPE {
		LOC,
		COMPASS
		
	}
	
	private E_BUTTON_TYPE mCurBtnType;
	
	LocationClient mLocClient;
	LocationData locData = null;
	MyLocationOverlay myLocationOverlay;


	final static String TAG = "MainActivity";
	 public boolean m_bKeyRight = true;
	  BMapManager mBMapManager = null;

	    public static final String strKey = "NSr9Owg1Z66kSWM0MF3HwtOj";
	/**
	 *  MapView 是地图主控件
	 */
	private MapView mMapView = null;
	boolean isRequest = false;//是否手动触发请求定位
	boolean isFirstLoc = true;//是否首次定位
	
	/**
	 *  用MapController完成地图控制 
	 */
	private MapController mMapController = null;
	/**
	 *  MKMapViewListener 用于处理地图事件回调
	 */
	MKMapViewListener mMapListener = null;
	
	
	

	public MyLocationListenner myListener = new MyLocationListenner();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         * 使用地图sdk前需先初始化BMapManager.
         * BMapManager是全局的，可为多个MapView共用，它需要地图模块创建前创建，
         * 并在地图地图模块销毁后销毁，只要还有地图模块在使用，BMapManager就不应该销毁
         */
        
        initEngineManager(this);
        
        
        
        if (mBMapManager == null) {
            mBMapManager = new BMapManager(this);
            /**
             * 如果BMapManager没有初始化则初始化BMapManager
             */
           mBMapManager.init(strKey,new MyGeneralListener());
        }
        /**
          * 由于MapView在setContentView()中初始化,所以它需要在BMapManager初始化之后
          */
        setContentView(R.layout.activity_locationoverlay);
        requestLocButton = (Button)findViewById(R.id.switch_mapStyle);
        requestLocationBtn=(Button)findViewById(R.id.requestLocationBtn);
        mMapView = (MapView)findViewById(R.id.bmapView);
        
        /**
         * 获取地图控制器
         */
        mMapController = mMapView.getController();
        /**
         *  设置地图是否响应点击事件  .
         */
        mMapController.enableClick(true);
        /**
         * 设置地图缩放级别
         */
        mMapController.setZoom(16);
        mMapView.setBuiltInZoomControls(true);
        myLocationOverlay = new MyLocationOverlay( mMapView);
        mCurBtnType = E_BUTTON_TYPE.LOC;
        OnClickListener btnClickListener = new OnClickListener() {
        	public void onClick(View v) {
				switch (mCurBtnType) {
				case LOC:
					//手动定位请求
					requestLocClick();
					
					break;
				case COMPASS:
					mMapView.setSatellite(false);
					mCurBtnType=E_BUTTON_TYPE.LOC;
					requestLocButton.setText("卫星");
					mMapView.refresh();
					
					break;
				
				
				}
			}
		};
		 requestLocButton.setOnClickListener(btnClickListener);
		 requestLocationBtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				requestLocClick1();
				
			}
		});
       
        mLocClient = new LocationClient(this);
       
                locData = new LocationData();
       
                mLocClient.registerLocationListener(myListener);
        
                LocationClientOption option = new LocationClientOption();
        
                option.setOpenGps(true);
                option.setAddrType("all");// 打开gps
         option.setCoorType("bd09ll"); // 设置坐标类型
          option.setScanSpan(120000);
          option.disableCache(true);//禁止启用缓存定位
          option.setPoiNumber(100);    //最多返回POI个数   
          option.setPoiDistance(1000); //poi查询距离        
          option.setPoiExtraInfo(true); //是否需要POI的电话和地址等详细信息    
       
                mLocClient.setLocOption(option);
       
                mLocClient.start();
       
         
       
                // 定位图层初始化
        
             
       
                // 设置定位数据
        
                myLocationOverlay.setData(locData);
        
                // 添加定位图层
       
                mMapView.getOverlays().add(myLocationOverlay);
        
                myLocationOverlay.enableCompass();
       
                // 修改定位数据后刷新图层生效
        
                mMapView.refresh();
       
         

       



       
        /**
         * 将地图移动至指定点
         * 使用百度经纬度坐标，可以通过http://api.map.baidu.com/lbsapi/getpoint/index.html查询地理坐标
         * 如果需要在百度地图上显示使用其他坐标系统的位置，请发邮件至mapapi@baidu.com申请坐标转换接口
         */
         GeoPoint p ;
        double cLat = 22.276923 ;
        double cLon = 113.565731 ;
        Intent  intent = getIntent();
        if ( intent.hasExtra("x") && intent.hasExtra("y") ){
        	//当用intent参数时，设置中心点为指定点
        	Bundle b = intent.getExtras();
        	p = new GeoPoint(b.getInt("y"), b.getInt("x"));
        }else{
        	//设置中心点为天安门
        	 p = new GeoPoint((int)(cLat * 1E6), (int)(cLon * 1E6));
        }
        
        mMapController.setCenter(p);
        
      
        /**
    	 *  MapView的生命周期与Activity同步，当activity挂起时需调用MapView.onPause()
    	 */
        mMapListener = new MKMapViewListener() {
			@Override
			public void onMapMoveFinish() {
				/**
				 * 在此处理地图移动完成回调
				 * 缩放，平移等操作完成后，此回调被触发
				 */
			}
			
			@Override
			public void onClickMapPoi(MapPoi mapPoiInfo) {
				/**
				 * 在此处理底图poi点击事件
				 * 显示底图poi名称并移动至该点
				 * 设置过： mMapController.enableClick(true); 时，此回调才能被触发
				 * 
				 */
				String title = "";
				if (mapPoiInfo != null){
					title = mapPoiInfo.strText;
					Toast.makeText(CurrentLocationActivity.this,title,Toast.LENGTH_SHORT).show();
					mMapController.animateTo(mapPoiInfo.geoPt);
				}
			}

			@Override
			public void onGetCurrentMap(Bitmap b) {
				/**
				 *  当调用过 mMapView.getCurrentMap()后，此回调会被触发
				 *  可在此保存截图至存储设备
				 */
			}

			@Override
			public void onMapAnimationFinish() {
				/**
				 *  地图完成带动画的操作（如: animationTo()）后，此回调被触发
				 */
			}
            /**
             * 在此处理地图载完成事件 
             */
			@Override
			public void onMapLoadFinish() {
				Toast.makeText(CurrentLocationActivity.this, 
						       "地图加载完成", 
						       Toast.LENGTH_SHORT).show();
				
			}
		};
		mMapView.regMapViewListener(mBMapManager, mMapListener);
    }
    
    public void initEngineManager(Context context) {
        if (mBMapManager == null) {
            mBMapManager = new BMapManager(context);
        }

        if (!mBMapManager.init(strKey,new MyGeneralListener())) {
            Toast.makeText(CurrentLocationActivity.this, 
                    "BMapManager  初始化错误!", Toast.LENGTH_LONG).show();
        }
	}
    public void requestLocClick(){
    	mMapView.setSatellite(true);
    	mCurBtnType=E_BUTTON_TYPE.COMPASS;
    	requestLocButton.setText("普通");
        mMapView.refresh();
      
    }
    public void requestLocClick1(){
    	isRequest = true;
        mLocClient.requestLocation();
        Toast.makeText(CurrentLocationActivity.this, "正在定位……", Toast.LENGTH_SHORT).show();
    }
    public void modifyLocationOverlayIcon(Drawable marker){
    	//当传入marker为null时，使用默认图标绘制
    	myLocationOverlay.setMarker(marker);
    	//修改图层，需要刷新MapView生效
    	mMapView.refresh();
    }
    @Override
    protected void onPause() {
    	/**
    	 *  MapView的生命周期与Activity同步，当activity挂起时需调用MapView.onPause()
    	 */
        mMapView.onPause();
        super.onPause();
    }
    
    @Override
    protected void onResume() {
    	/**
    	 *  MapView的生命周期与Activity同步，当activity恢复时需调用MapView.onResume()
    	 */
        mMapView.onResume();
        super.onResume();
    }
    
    @Override
    protected void onDestroy() {
    	/**
    	 *  MapView的生命周期与Activity同步，当activity销毁时需调用MapView.destroy()
    	 */
        mMapView.destroy();
        super.onDestroy();
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	mMapView.onSaveInstanceState(outState);
    	
    }
    
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
    	super.onRestoreInstanceState(savedInstanceState);
    	mMapView.onRestoreInstanceState(savedInstanceState);
    }
  class MyGeneralListener implements MKGeneralListener {
        
        @Override
        public void onGetNetworkState(int iError) {
            if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
                Toast.makeText(CurrentLocationActivity.this, "您的网络出错啦！",
                    Toast.LENGTH_LONG).show();
            }
            else if (iError == MKEvent.ERROR_NETWORK_DATA) {
                Toast.makeText(CurrentLocationActivity.this, "输入正确的检索条件！",
                        Toast.LENGTH_LONG).show();
            }
            // ...
        }

        @Override
        public void onGetPermissionState(int iError) {
        	//非零值表示key验证未通过
            if (iError != 0) {
                //授权Key错误：
                Toast.makeText(CurrentLocationActivity.this, 
                        "请在 DemoApplication.java文件输入正确的授权Key,并检查您的网络连接是否正常！error: "+iError, Toast.LENGTH_LONG).show();
                m_bKeyRight = false;
            }
            else{
            	m_bKeyRight = true;
            	
            }
        }
    }
  class MyLocationListenner implements BDLocationListener {
  	
      @Override
      public void onReceiveLocation(BDLocation location) {
          if (location == null){
        	  return ;
          }
             
          
          locData.latitude = location.getLatitude();
          locData.longitude = location.getLongitude();
          //如果不显示定位精度圈，将accuracy赋值为0即可
          locData.accuracy = location.getRadius();
          // 此处可以设置 locData的方向信息, 如果定位 SDK 未返回方向信息，用户可以自己实现罗盘功能添加方向信息。
          locData.direction = location.getDerect();
          //更新定位数据
          myLocationOverlay.setData(locData);
          //更新图层数据执行刷新后生效
          mMapView.refresh();
          //是手动触发请求或首次定位时，移动到定位点
          
          if (isRequest || isFirstLoc){
          	//移动地图到定位点
          	Log.d("LocationOverlay", "receive location, animate to it");
              mMapController.animateTo(new GeoPoint((int)(locData.latitude* 1e6), (int)(locData.longitude *  1e6)));
              isRequest = false;
              tv3.setText(String.valueOf("纬度:"+locData.latitude));
              tv2.setText(String.valueOf("经度:"+locData.longitude));
              //myLocationOverlay.setLocationMode(LocationMode.FOLLOWING);
				
             
          }
          //首次定位完成
          isFirstLoc = false;
      }

	@Override
	public void onReceivePoi(BDLocation arg0) {
		// TODO Auto-generated method stub
		
	}

	
 
    
}
}
