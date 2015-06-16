package com.halong.associationapp.more;

/*
 * 通讯录页面的
 * wenfei create
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import com.halong.associationapp.BackActivity;

import com.halong.associationapp.R;

import com.halong.associationapp.tab2.CharacterParser;
import com.halong.associationapp.tab2.ClearEditText;


import com.halong.associationapp.tab2.OnItemClickShowDialogActivity;
import com.halong.associationapp.tab2.PinyinComparator;
import com.halong.associationapp.tab2.SideBar;
import com.halong.associationapp.tab2.SortAdapter;
import com.halong.associationapp.tab2.SortModel;
import com.halong.associationapp.tab2.SideBar.OnTouchingLetterChangedListener;

import com.halong.associationapp.util.DrawerGarment;

import android.content.Intent;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import android.util.Log;


import android.view.View;

import android.widget.AdapterView;



import android.widget.ListView;


import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ContractActivity extends BackActivity {
	/**
	 * 声明控件
	 */
	private ListView mListView;
	private SideBar mSideBar;
	private TextView mDialog;
	private SortAdapter mAdapter;
	private ClearEditText mClearEditText;
	public static final int RESULT_CODE = 3;
	
	private CharacterParser mCharacterParser;
	private List<SortModel> mSourceDateList;
	private PinyinComparator mPinyinComparator;
	
	
	
	private View view;
	
	private DrawerGarment drawerGarment;

	List<HashMap<String, String>> orderList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		view = getLayoutInflater().inflate(R.layout.activity_contract, null);
		
		setContentView(view);
		
		
		
		mCharacterParser = CharacterParser.getInstance();
		
		
		mPinyinComparator = new PinyinComparator();

		mSideBar = (SideBar) view.findViewById(R.id.sidrbar);
		mDialog = (TextView) view.findViewById(R.id.dialog);
		
		mListView = (ListView) view.findViewById(R.id.listViewContract);
		mClearEditText = (ClearEditText) view.findViewById(R.id.filter_edit);
		
		
		//drawerGarment=new DrawerGarment(getActivity(),R.layout.popupwindow_tab1_menu);
		
		/**
		 * 添加数据
		 */
		addData();
		/*
		 * 绑定事件
		 */
		initViews();
		
	}

	
	private void addData() {
		orderList = new ArrayList<HashMap<String, String>>();

		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("name", "白钰");
		hashMap.put("user_post", "总经理");
		hashMap.put("user_company", "深圳市天河电子商务有限公司");
		hashMap.put("user_city", "深圳市");
		hashMap.put("user_phone", "13926985431");
		hashMap.put("user_email", "hwf433@163.com");
		hashMap.put("user_weibo", "http://weibohwf.com.cn");
		hashMap.put("user_address", "广东省深圳市宝安区沙井街道新沙路与锦程路交叉口天河联盟商务大厦");
		orderList.add(hashMap);

		HashMap<String, String> hashMap1 = new HashMap<String, String>();
		hashMap1.put("name", "白冬梅");
		hashMap1.put("user_post", "总裁");
		hashMap1.put("user_company", "深圳市昕网格开发有限公司");
		hashMap1.put("user_city", "广州市");
		hashMap1.put("user_phone", "13926984432");
		hashMap1.put("user_email", "hwf453@163.com");
		hashMap1.put("user_weibo", "http://weikgo.com.cn");
		hashMap1.put("user_address", "广东省深圳市南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap1);
		HashMap<String, String> hashMap2 = new HashMap<String, String>();
		hashMap2.put("name", "宾云水");
		hashMap2.put("user_post", "董事长");
		hashMap2.put("user_company", "深圳市里德海司科技有限公司");
		hashMap2.put("user_city", "深圳市");
		hashMap2.put("user_phone", "13926655433");
		hashMap2.put("user_email", "hwf432@163.com");
		hashMap2.put("user_weibo", "http://weryo.com.cn");
		hashMap2.put("user_address", "广东省深圳市南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap2);
		HashMap<String, String> hashMap3 = new HashMap<String, String>();
		hashMap3.put("name", "陈飞");
		hashMap3.put("user_post", "会长");
		hashMap3.put("user_company", "深圳市天河电子商务有限公司");
		hashMap3.put("user_city", "深圳市");
		hashMap3.put("user_phone", "13926125434");
		hashMap3.put("user_email", "hwf433@163.com");
		hashMap3.put("user_weibo", "http://weibo.com.cn");
		hashMap3.put("user_address", "广东省深圳市南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap3);
		HashMap<String, String> hashMap4 = new HashMap<String, String>();
		hashMap4.put("name", "曾小萍");
		hashMap4.put("user_post", "秘书长");
		hashMap4.put("user_company", "深圳市天河电子商务有限公司");
		hashMap4.put("user_city", "深圳市");
		hashMap4.put("user_phone", "13926987835");
		hashMap4.put("user_email", "hwf433@163.com");
		hashMap4.put("user_weibo", "http://weibo.com.cn");
		hashMap4.put("user_address", "广东省香蕉南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap4);
		HashMap<String, String> hashMap5 = new HashMap<String, String>();
		hashMap5.put("name", "常宾");
		hashMap5.put("user_post", "市长");
		hashMap5.put("user_company", "深圳市天河电子商务有限公司");
		hashMap5.put("user_city", "深圳市");
		hashMap5.put("user_phone", "13926989336");
		hashMap5.put("user_email", "hwf433@163.com");
		hashMap5.put("user_weibo", "http://weibo.com.cn");
		hashMap5.put("user_address", "广东省河源市南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap5);
		HashMap<String, String> hashMap6 = new HashMap<String, String>();
		hashMap6.put("name", "卢思见");
		hashMap6.put("user_post", "总经理");
		hashMap6.put("user_company", "深圳市天河电子商务有限公司");
		hashMap6.put("user_city", "深圳市");
		hashMap6.put("user_phone", "15426985437");
		hashMap6.put("user_email", "hwf433@163.com");
		hashMap6.put("user_weibo", "http://weibo.com.cn");
		hashMap6.put("user_address", "广东省朝洲南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap6);
		HashMap<String, String> hashMap7 = new HashMap<String, String>();
		hashMap7.put("name", "关振鹏");
		hashMap7.put("user_post", "副会长");
		hashMap7.put("user_company", "深圳市天河电子商务有限公司");
		hashMap7.put("user_city", "深圳市");
		hashMap7.put("user_phone", "18626985438");
		hashMap7.put("user_email", "hwf433@163.com");
		hashMap7.put("user_weibo", "http://weibo.com.cn");
		hashMap7.put("user_address", "广东省汕头南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap7);
		HashMap<String, String> hashMap8 = new HashMap<String, String>();
		hashMap8.put("name", "小妹");
		hashMap8.put("user_post", "县长");
		hashMap8.put("user_company", "深圳市天河电子商务有限公司");
		hashMap8.put("user_city", "深圳市");
		hashMap8.put("user_phone", "13686985439");
		hashMap8.put("user_email", "hwf433@163.com");
		hashMap8.put("user_weibo", "http://weibo.com.cn");
		hashMap8.put("user_address", "广东省江门南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap8);
		HashMap<String, String> hashMap9 = new HashMap<String, String>();
		hashMap9.put("name", "杨杨");
		hashMap9.put("user_post", "省长");
		hashMap9.put("user_company", "深圳市天河电子商务有限公司");
		hashMap9.put("user_city", "深圳市");
		hashMap9.put("user_phone", "13926345430");
		hashMap9.put("user_email", "hwf433@163.com");
		hashMap9.put("user_weibo", "http://weibo.com.cn");
		hashMap9.put("user_address", "广东省中山南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap9);
		HashMap<String, String> hashMap10 = new HashMap<String, String>();
		hashMap10.put("name", "赵丹");
		hashMap10.put("user_post", "设计师");
		hashMap10.put("user_company", "深圳市天河电子商务有限公司");
		hashMap10.put("user_city", "深圳市");
		hashMap10.put("user_phone", "13924585431");
		hashMap10.put("user_email", "hwf433@163.com");
		hashMap10.put("user_weibo", "http://weibo.com.cn");
		hashMap10.put("user_address", "广东省佛山市南山区科技园科兴路11号深南花园裙楼A座302号");

		orderList.add(hashMap10);
		HashMap<String, String> hashMap11 = new HashMap<String, String>();
		hashMap11.put("name", "苏朋");
		hashMap11.put("user_post", "佛山市");
		hashMap11.put("user_company", "深圳市天河电子商务有限公司");
		hashMap11.put("user_city", "深圳市");
		hashMap11.put("user_phone", "13536985432");
		hashMap11.put("user_email", "hwfjdf3@126.com");
		hashMap11.put("user_weibo", "http://weibo.com.cn");
		hashMap11.put("user_address", "广东省东莞南山区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap11);
		HashMap<String, String> hashMap12 = new HashMap<String, String>();
		hashMap12.put("name", "陈明达");
		hashMap12.put("user_post", "总经理");
		hashMap12.put("user_company", "深圳市天河电子商务有限公司");
		hashMap12.put("user_city", "深圳市");
		hashMap12.put("user_phone", "13346985433");
		hashMap12.put("user_email", "hwf4fg@163.com");
		hashMap12.put("user_weibo", "http://weibo.com.cn");
		hashMap12.put("user_address", "广东省湛江福田区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap12);
		HashMap<String, String> hashMap13 = new HashMap<String, String>();
		hashMap13.put("name", "阿杜");
		hashMap13.put("user_post", "总经理");
		hashMap13.put("user_company", "深圳市天河电子商务有限公司");
		hashMap13.put("user_city", "深圳市");
		hashMap13.put("user_phone", "13346985433");
		hashMap13.put("user_email", "hwf4fg@163.com");
		hashMap13.put("user_weibo", "http://weibo.com.cn");
		hashMap13.put("user_address", "广东省湛江福田区科技园科兴路11号深南花园裙楼A座302号");
		orderList.add(hashMap13);

		

	}

	private void initViews() {
		
		
		
		
		
		// 实例化汉字转拼音类

		// 设置右侧触摸监听
		mSideBar.setTextView(mDialog);
		mSideBar.setOnTouchingLetterChangedListener(new OnTouchingLetterChangedListener() {

			@Override
			public void onTouchingLetterChanged(String s) {
				// 该字母首次出现的位置
				int position = mAdapter.getPositionForSection(s.charAt(0));
				if (position != -1) {
					mListView.setSelection(position);
				}

			}
		});

		mSourceDateList = filledData(orderList);

		// 根据a-z进行排序源数据
		Collections.sort(mSourceDateList, mPinyinComparator);
		mAdapter = new SortAdapter(this, mSourceDateList);
		mListView.setAdapter(mAdapter);

		// 根据输入框输入值的改变来过滤搜索
		mClearEditText.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// 当输入框里面的值为空，更新为原来的列表，否则为过滤数据列表
				filterData(s.toString());
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {

				Intent intent = new Intent(ContractActivity.this,
						OnItemClickShowDialogActivity.class);
				intent.putExtra("user_phone", SortAdapter.getInstance().list
						.get(position).getUser_phone());
				intent.putExtra("user_email", SortAdapter.getInstance().list
						.get(position).getUser_email());
				intent.putExtra("user_weibo", SortAdapter.getInstance().list
						.get(position).getUser_weibo());
				intent.putExtra("user_address", SortAdapter.getInstance().list
						.get(position).getUser_address());
				intent.putExtra("name", SortAdapter.getInstance().list
						.get(position).getName());
				intent.putExtra("user_post", SortAdapter.getInstance().list
						.get(position).getUser_post());
				intent.putExtra("user_company", SortAdapter.getInstance().list
						.get(position).getUser_company());

				startActivity(intent);
				overridePendingTransition(R.anim.push_right_in,
						R.anim.push_left_out);

			}
		});
		
	}

	/**
	 * 为ListView填充数据
	 * 
	 * @param date
	 * @return
	 */
	private List<SortModel> filledData(List<HashMap<String, String>> orderList) {
		List<SortModel> mSortList = new ArrayList<SortModel>();
		Log.i("orderlist", orderList.get(0).get("user_address").toString());
		for (int i = 0; i < orderList.size(); i++) {

			SortModel sortModel = new SortModel();
			sortModel.setName(orderList.get(i).get("name").toString());
			sortModel
					.setUser_post(orderList.get(i).get("user_post").toString());
			sortModel.setUser_company(orderList.get(i).get("user_company")
					.toString());
			sortModel
					.setUser_city(orderList.get(i).get("user_city").toString());
			sortModel.setUser_phone(orderList.get(i).get("user_phone")
					.toString());
			sortModel.setUser_email(orderList.get(i).get("user_email")
					.toString());
			sortModel.setUser_weibo(orderList.get(i).get("user_weibo")
					.toString());
			sortModel.setUser_address(orderList.get(i).get("user_address")
					.toString());

			// 汉字转换成拼音
			String pinyin = mCharacterParser.getSelling(orderList.get(i)
					.get("name").toString());
			Log.i("pingyin", pinyin);
			String sortString = pinyin.substring(0, 1).toUpperCase();

			// 正则表达式，判断首字母是否是英文字母
			if (sortString.matches("[A-Z]")) {
				sortModel.setSortLetters(sortString.toUpperCase());
			} else {
				sortModel.setSortLetters("#");
			}

			mSortList.add(sortModel);
		}

		return mSortList;

	}

	/**
	 * 根据输入框中的值来过滤数据并更新ListView
	 * 
	 * @param filterStr
	 */
	private void filterData(String filterStr) {
		List<SortModel> filterDateList = new ArrayList<SortModel>();

		if (TextUtils.isEmpty(filterStr)) {
			filterDateList = mSourceDateList;
		} else {
			filterDateList.clear();
			for (SortModel sortModel : mSourceDateList) {
				String name = sortModel.getName();
				if (name.indexOf(filterStr.toString()) != -1
						|| mCharacterParser.getSelling(name).startsWith(
								filterStr.toString())) {
					filterDateList.add(sortModel);
				}
			}
		}

		// 根据a-z进行排序
		Collections.sort(filterDateList, mPinyinComparator);
		mAdapter.updateListView(filterDateList);
	}
	
	
	
	
}
