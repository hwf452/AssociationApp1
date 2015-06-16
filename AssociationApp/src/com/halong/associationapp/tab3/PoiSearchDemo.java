package com.halong.associationapp.tab3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;








import com.baidu.mapapi.BMapManager;
import com.baidu.mapapi.MKGeneralListener;
import com.baidu.mapapi.map.MKEvent;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.search.MKAddrInfo;
import com.baidu.mapapi.search.MKBusLineResult;
import com.baidu.mapapi.search.MKDrivingRouteResult;
import com.baidu.mapapi.search.MKPoiInfo;
import com.baidu.mapapi.search.MKPoiResult;
import com.baidu.mapapi.search.MKSearch;
import com.baidu.mapapi.search.MKSearchListener;
import com.baidu.mapapi.search.MKShareUrlResult;
import com.baidu.mapapi.search.MKSuggestionInfo;
import com.baidu.mapapi.search.MKSuggestionResult;
import com.baidu.mapapi.search.MKTransitRouteResult;
import com.baidu.mapapi.search.MKWalkingRouteResult;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;




/**
 * 演示poi搜索功能 
 */
public class PoiSearchDemo extends BackActivity {
	
	private MapView mMapView = null;
	private MKSearch mSearch = null;   // 搜索模块，也可去掉地图模块独立使用
	private Button switch_mapStyle;
	public boolean m_bKeyRight = true;
    BMapManager mBMapManager = null;

    public static final String strKey = "NSr9Owg1Z66kSWM0MF3HwtOj";
    
	/**
	 * 搜索关键字输入窗口
	 */
    
	private AutoCompleteTextView keyWorldsView = null;
	private ArrayAdapter<String> sugAdapter = null;
    private int load_Index;
    private String city,address;
    private enum E_BUTTON_TYPE {
		LOC,
		COMPASS
		
	}
    private E_BUTTON_TYPE mCurBtnType;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	 super.onCreate(savedInstanceState);
    	 initEngineManager(this);
    	 
         
         if (mBMapManager == null) {
             mBMapManager = new BMapManager(this);
             mBMapManager.init(strKey,new MyGeneralListener());
         }
         setContentView(R.layout.activity_poisearch);
         switch_mapStyle=(Button)findViewById(R.id.switch_mapStyle);
         mCurBtnType = E_BUTTON_TYPE.LOC;
         OnClickListener btnClickListener = new OnClickListener() {
         	public void onClick(View v) {
 				switch (mCurBtnType) {
 				case LOC:
 					mMapView.setSatellite(false);
 					mCurBtnType=E_BUTTON_TYPE.COMPASS;
 					switch_mapStyle.setText("卫星地图");
 					switch_mapStyle.setBackgroundResource(R.drawable.button_map_switch);
 					mMapView.refresh();
 					
 					break;
 				case COMPASS:
 					mMapView.setSatellite(true);
 					mCurBtnType=E_BUTTON_TYPE.LOC;
 					switch_mapStyle.setText("普通地图");
 					switch_mapStyle.setBackgroundResource(R.drawable.btn102);
 					switch_mapStyle.setTextColor(Color.WHITE);
 					mMapView.refresh();
 					
 					break;
 				
 				}
 			}
 		};
 		switch_mapStyle.setOnClickListener(btnClickListener);
         
        mMapView = (MapView)findViewById(R.id.bmapView);
		mMapView.getController().enableClick(true);
        mMapView.getController().setZoom(16);
        mMapView.setBuiltInZoomControls(true);
        
        GeoPoint p ;
        double cLat = 22.195274 ;
        double cLon = 113.551960;
       
        
        	 p = new GeoPoint((int)(cLat * 1E6), (int)(cLon * 1E6));
       
        
        mMapView.getController().setCenter(p);
        mMapView.refresh();
        Intent intent=getIntent();
         city=intent.getExtras().getString("city");
         address=intent.getExtras().getString("address");
		
		// 初始化搜索模块，注册搜索事件监听
        mSearch = new MKSearch();
        mSearch.init(mBMapManager, new MKSearchListener(){
            //在此处理详情页结果
            @Override
            public void onGetPoiDetailSearchResult(int type, int error) {
                if (error != 0) {
                    Toast.makeText(PoiSearchDemo.this, "抱歉，未找到结果", Toast.LENGTH_SHORT).show();
                    
                    
                }
                else {
                    Toast.makeText(PoiSearchDemo.this, "成功，查看详情页面", Toast.LENGTH_SHORT).show();
                }
            }
            /**
             * 在此处理poi搜索结果
             */
            public void onGetPoiResult(MKPoiResult res, int type, int error) {
                // 错误号可参考MKEvent中的定义
                if (error != 0 || res == null) {
                    Toast.makeText(PoiSearchDemo.this, "抱歉，未找到结果", Toast.LENGTH_LONG).show();
                    initMapView();
                    return;
                }
                // 将地图移动到第一个POI中心点
                if (res.getCurrentNumPois() > 0) {
                    // 将poi结果显示到地图上
                    MyPoiOverlay poiOverlay = new MyPoiOverlay(PoiSearchDemo.this, mMapView, mSearch);
                    poiOverlay.setData(res.getAllPoi());
                    Log.i("poi",res.getPoi(0).pt.toString());
                    mMapView.getOverlays().clear();
                    mMapView.getOverlays().add(poiOverlay);
                    mMapView.refresh();
                    //当ePoiType为2（公交线路）或4（地铁线路）时， poi坐标为空
                    for( MKPoiInfo info : res.getAllPoi() ){
                    	if ( info.pt != null ){
                    		mMapView.getController().animateTo(info.pt);
                    		break;
                    	}
                    }
                } else if (res.getCityListNum() > 0) {
                	//当输入关键字在本市没有找到，但在其他城市找到时，返回包含该关键字信息的城市列表
                    String strInfo = "在";
                    for (int i = 0; i < res.getCityListNum(); i++) {
                        strInfo += res.getCityListInfo(i).city;
                        strInfo += ",";
                    }
                    strInfo += "找到结果";
                    Toast.makeText(PoiSearchDemo.this, strInfo, Toast.LENGTH_LONG).show();
                }
            }
            public void onGetDrivingRouteResult(MKDrivingRouteResult res,
                    int error) {
            }
            public void onGetTransitRouteResult(MKTransitRouteResult res,
                    int error) {
            }
            public void onGetWalkingRouteResult(MKWalkingRouteResult res,
                    int error) {
            }
            public void onGetAddrResult(MKAddrInfo res, int error) {
            }
            public void onGetBusDetailResult(MKBusLineResult result, int iError) {
            }
            /**
             * 更新建议列表
             */
            @Override
            public void onGetSuggestionResult(MKSuggestionResult res, int arg1) {
            	if ( res == null || res.getAllSuggestions() == null){
            		return ;
            	}
            	sugAdapter.clear();
            	for ( MKSuggestionInfo info : res.getAllSuggestions()){
            		if ( info.key != null)
            		    sugAdapter.add(info.key);
            	}
            	sugAdapter.notifyDataSetChanged();
                
            }
			@Override
			public void onGetShareUrlResult(MKShareUrlResult result, int type,
					int error) {
				// TODO Auto-generated method stub
				
			}
        });
        
        keyWorldsView = (AutoCompleteTextView) findViewById(R.id.searchkey);
        sugAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line);
        keyWorldsView.setAdapter(sugAdapter);
        
        /**
         * 当输入关键字变化时，动态更新建议列表
         */
        keyWorldsView.addTextChangedListener(new TextWatcher(){

			@Override
			public void afterTextChanged(Editable arg0) {
				
			}

			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {
				
			}
			@Override
			public void onTextChanged(CharSequence cs, int arg1, int arg2,
					int arg3) {
				 if ( cs.length() <=0 ){
					 return ;
				 }
				 String city =  ((EditText)findViewById(R.id.city)).getText().toString();
				 /**
				  * 使用建议搜索服务获取建议列表，结果在onSuggestionResult()中更新
				  */
                 mSearch.suggestionSearch(cs.toString(), city);				
			}
        });
        
       if(address!=null){
    	   mSearch.poiSearchInCity(city,address);
       }
        	
       
        
        
    }
    public void initEngineManager(Context context) {
        if (mBMapManager == null) {
            mBMapManager = new BMapManager(context);
        }

        if (!mBMapManager.init(strKey,new MyGeneralListener())) {
            Toast.makeText(this, 
                    "BMapManager  初始化错误!", Toast.LENGTH_LONG).show();
        }
	}
    
    @Override
    protected void onPause() {
        mMapView.onPause();
        super.onPause();
    }
    
    @Override
    protected void onResume() {
        mMapView.onResume();
        super.onResume();
    }
    
    @Override
    protected void onDestroy(){
    	mMapView.destroy();
    	mSearch.destory();
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
    
    private void initMapView() {
        mMapView.setLongClickable(true);
        mMapView.getController().setZoom(16);
        mMapView.getController().enableClick(true);
        mMapView.setBuiltInZoomControls(true);
        GeoPoint p ;
        double cLat = 22.195274 ;
        double cLon = 113.551960;
       
        
        	 p = new GeoPoint((int)(cLat * 1E6), (int)(cLon * 1E6));
       
        
        mMapView.getController().setCenter(p);
        mMapView.refresh();
    }
    /**
     * 影响搜索按钮点击事件
     * @param v
     */
    public void searchButtonProcess(View v) {
          EditText editCity = (EditText)findViewById(R.id.city);
          EditText editSearchKey = (EditText)findViewById(R.id.searchkey);
          mSearch.poiSearchInCity("澳门", 
                  "澳门酒店");
    }
   public void goToNextPage(View v) {
        //搜索下一组poi
        int flag = mSearch.goToPoiPage(++load_Index);
        if (flag != 0) {
            Toast.makeText(PoiSearchDemo.this, "先搜索开始，然后再搜索下一组数据", Toast.LENGTH_SHORT).show();
        }
    }
   class MyGeneralListener implements MKGeneralListener {
       
       @Override
       public void onGetNetworkState(int iError) {
           if (iError == MKEvent.ERROR_NETWORK_CONNECT) {
           	Toast.makeText(PoiSearchDemo.this, "您的网络未联接！",
                       Toast.LENGTH_LONG).show();
           }
           else if (iError == MKEvent.ERROR_NETWORK_DATA) {
               
           }
         
       }

       @Override
       public void onGetPermissionState(int iError) {
       	
           if (iError != 0) {

                m_bKeyRight = false;
           }
           else{
           	m_bKeyRight = true;
           	
           }
       }
   }
}
