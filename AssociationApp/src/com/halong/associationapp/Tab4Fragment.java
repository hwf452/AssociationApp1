package com.halong.associationapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import com.halong.associationapp.tab3.CompanyModel;
import com.halong.associationapp.tab3.CompanyTab3Activity;
import com.halong.associationapp.tab3.TabViewPagerAdapter;
import com.halong.associationapp.tab3.TabViewPagerAdapter.OnViewPagerClick;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;

import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Tab4Fragment extends FragmentToOtherActivity implements
		OnClickListener,  OnViewPagerClick {
	
	
	private TabViewPagerAdapter mAdapter;
	
	private Button mLeftButton, mRightButton;
	private ListView mListView;
	
	List<HashMap<String, Object>> orderList;
	List<HashMap<String, Object>> orderList1;
	List<HashMap<String, Object>> orderList2;
	List<HashMap<String, Object>> orderList3;
	List<HashMap<String, Object>> orderList4;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_tab4, null);
		mListView = (ListView) view.findViewById(R.id.listView1);
		
		
		addData();
		addData1();
		addDate2();
		addDate3();
		addData4();
		initView(view);
		
		return view;
	}

	private void addData() {
		orderList = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("name", "阿里巴巴网络有限公司");
		hashMap.put("phone", "400-800-1688 ");
		hashMap.put("addr", "杭州市滨江区网商路699号");
		hashMap.put("url", "http://www.alibaba.com");
		CompanyModel companyModel=new CompanyModel();
		companyModel.setDrawableId(R.drawable.portrait7_4);
		hashMap.put("imageview",companyModel);

		orderList.add(hashMap);

		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		hashMap1.put("name", "支付宝网络技术有限公司");
		hashMap1.put("phone", "0105-623-2917 ");
		hashMap1.put("addr", "杭州市文三路478号华星时代广场22楼");
		hashMap1.put("url", "https://www.alipay.com/");
		CompanyModel companyModel1=new CompanyModel();
		companyModel1.setDrawableId(R.drawable.portrait7_6);
		hashMap1.put("imageview",companyModel1);
		
		orderList.add(hashMap1);

		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
		hashMap2.put("name", "北京京东叁佰陆拾度电子商务有限公司");
		hashMap2.put("phone", "021-50936927");
		hashMap2.put("addr", "北京市徐汇区华山路2018号汇银广场");
		hashMap2.put("url", "http://bjjingdong.diyi.tv/");
		CompanyModel companyModel2=new CompanyModel();
		companyModel2.setDrawableId(R.drawable.portrait7_7);
		hashMap2.put("imageview",companyModel2);
		
		orderList.add(hashMap2);

		HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
		hashMap3.put("name", "北京当当网信息技术有限公司");
		hashMap3.put("phone", "400-106-6666");
		hashMap3.put("addr", "北京市安定门三利大厦");
		
		hashMap3.put("url", "http://book.dangdang.com");
		CompanyModel companyModel3=new CompanyModel();
		companyModel3.setDrawableId(R.drawable.portrait7_8);
		hashMap3.put("imageview",companyModel3);
		
		orderList.add(hashMap3);

		HashMap<String, Object> hashMap4 = new HashMap<String, Object>();
		hashMap4.put("name", "易迅电子商务发展有限公司");
		hashMap4.put("phone", "021-61831100");
		hashMap4.put("addr", "上海市宝山区纪蕰路588号");
		hashMap4.put("url", "http://www.yixun.com/");
		CompanyModel companyModel4=new CompanyModel();
		companyModel4.setDrawableId(R.drawable.portrait7_9);
		hashMap4.put("imageview",companyModel4);
		
		orderList.add(hashMap4);

		HashMap<String, Object> hashMap5 = new HashMap<String, Object>();
		hashMap5.put("name", "中山大学珠海校区");
		hashMap5.put("phone", "0756-3583833");
		hashMap5.put("addr", "珠海市香洲区唐家湾镇");
		hashMap5.put("url", "http://zhongda.gd-jiaoyu.com");
		CompanyModel companyModel5=new CompanyModel();
		companyModel5.setDrawableId(R.drawable.portrait7_8);
		hashMap5.put("imageview",companyModel5);
		
		orderList.add(hashMap5);

		HashMap<String, Object> hashMap6 = new HashMap<String, Object>();
		hashMap6.put("name", "北京师范大学珠海校区");
		hashMap6.put("phone", "0756-338386");
		hashMap6.put("addr", "珠海市香洲区唐家湾镇金凤路");
		hashMap6.put("url", "http://www.bnuz.edu.cn");
		CompanyModel companyModel6=new CompanyModel();
		companyModel6.setDrawableId(R.drawable.portrait9);
		hashMap6.put("imageview",companyModel6);
		
		orderList.add(hashMap6);
		HashMap<String, Object> hashMap7 = new HashMap<String, Object>();
		hashMap7.put("name", "吉林大学珠海校区");
		hashMap7.put("phone", "0756-35837322");
		hashMap7.put("addr", "珠海市金湾区草唐湾");
		hashMap7.put("url", "http://www.jluzh.com/");
		CompanyModel companyModel7=new CompanyModel();
		companyModel7.setDrawableId(R.drawable.portrait10);
		hashMap7.put("imageview",companyModel7);
		
		orderList.add(hashMap7);
		HashMap<String, Object> hashMap8 = new HashMap<String, Object>();
		hashMap8.put("name", "暨南大学珠海校区");
		hashMap8.put("phone", "0756-3589823");
		hashMap8.put("addr", "珠海市香洲区前山路206号");
		hashMap8.put("url", "http://zh.jnu.edu.cn/");
		CompanyModel companyModel8=new CompanyModel();
		companyModel8.setDrawableId(R.drawable.portrait11);
		hashMap8.put("imageview",companyModel8);
		
		orderList.add(hashMap8);

		HashMap<String, Object> hashMap9 = new HashMap<String, Object>();
		hashMap9.put("name", "深圳市万朝科技有限公司");
		hashMap9.put("phone", "0755-25361216");
		hashMap9.put("addr", "深圳市盐田区国际创意港6栋5B");
		hashMap9.put("url", "http://www.dyninfo.com.cn/");
		CompanyModel companyModel9=new CompanyModel();
		companyModel9.setDrawableId(R.drawable.portrait51);
		hashMap9.put("imageview",companyModel9);
		

		orderList.add(hashMap9);

		HashMap<String, Object> hashMap10 = new HashMap<String, Object>();
		hashMap10.put("name", "深圳市朗华在线技术有限公司");
		hashMap10.put("phone", "0755-82789555");
		hashMap10.put("addr", "深圳市福田区深南大道6021号");
		hashMap10.put("url", "http://leoszscm.cn.china.cn/");
		CompanyModel companyModel10=new CompanyModel();
		companyModel10.setDrawableId(R.drawable.portrait52);
		hashMap10.put("imageview",companyModel10);
		
		orderList.add(hashMap10);
		HashMap<String, Object> hashMap11 = new HashMap<String, Object>();
		hashMap11.put("name", "深圳市邮政局");
		hashMap11.put("phone", "400-8895580");
		hashMap11.put("addr", "广东省深圳市福田区滨河路9013号");
		hashMap11.put("url", "http://www.shenzhenpost.com.cn/");
		CompanyModel companyModel11=new CompanyModel();
		companyModel11.setDrawableId(R.drawable.portrait53);
		hashMap11.put("imageview",companyModel11);
		
		orderList.add(hashMap11);
		HashMap<String, Object> hashMap12 = new HashMap<String, Object>();
		hashMap12.put("name", "深圳市百乐礼品有限公司");
		hashMap12.put("phone", "0755-26893372");
		hashMap12.put("addr", "深圳市宝安区西乡街道榕树路64号");
		hashMap12.put("url", "http://polerchina.1688.com/");
		CompanyModel companyModel12=new CompanyModel();
		companyModel12.setDrawableId(R.drawable.portrait36);
		hashMap12.put("imageview",companyModel12);
		
		orderList.add(hashMap12);
		HashMap<String, Object> hashMap13 = new HashMap<String, Object>();
		hashMap13.put("name", "深圳市新悦伊点商贸有限公司");
		hashMap13.put("phone", "0755-28373440");
		hashMap13.put("addr", "深圳市龙岗区南湾街道南岭村");
		hashMap13.put("url", "http://pgtozhslsarik.shengyidi.com/");
		CompanyModel companyModel13=new CompanyModel();
		companyModel13.setDrawableId(R.drawable.portrait54);
		hashMap13.put("imageview",companyModel13);
		

		orderList.add(hashMap13);

		HashMap<String, Object> hashMap14 = new HashMap<String, Object>();
		hashMap14.put("name", "中山大学珠海校区");
		hashMap14.put("phone", "0756-3583833");
		hashMap14.put("addr", "珠海市香洲区唐家湾镇");
		hashMap14.put("url", "http://zhuhai.sysu.edu.cn/");
		CompanyModel companyModel14=new CompanyModel();
		companyModel14.setDrawableId(R.drawable.portrait8);
		hashMap14.put("imageview",companyModel14);
		
		orderList.add(hashMap14);
		
		HashMap<String, Object> hashMap15 = new HashMap<String, Object>();
		hashMap15.put("name", "珠海用友软件有限公司");
		hashMap15.put("phone", "0756-2312008 ");
		hashMap15.put("addr", "海滨南路47号光大国际贸易中心1008");
		hashMap15.put("url", "http://atj_59105.atobo.com.cn/");
		CompanyModel companyModel15=new CompanyModel();
		companyModel15.setDrawableId(R.drawable.portrait7_2);
		hashMap15.put("imageview",companyModel15);
		

		orderList.add(hashMap15);

		HashMap<String, Object> hashMap16 = new HashMap<String, Object>();
		hashMap16.put("name", "珠海南方软件园发展有限公司");
		hashMap16.put("phone", "0756-519085");
		hashMap16.put("addr", "珠海唐家南方软件园");
		hashMap16.put("url", "http://www.china-ssp.com/");
		CompanyModel companyModel16=new CompanyModel();
		companyModel16.setDrawableId(R.drawable.portrait7_5);
		hashMap16.put("imageview",companyModel16);
		
		orderList.add(hashMap16);

		HashMap<String, Object> hashMap17 = new HashMap<String, Object>();
		hashMap17.put("name", "珠海夏浪信息科技有限公司");
		hashMap17.put("phone", "0756-6218155");
		hashMap17.put("addr", "珠海市香洲区人民东路珠信大夏512");
		hashMap17.put("url", "http://www.halong-tech.com/");
		CompanyModel companyModel17=new CompanyModel();
		companyModel17.setDrawableId(R.drawable.portrait7_10);
		hashMap17.put("imageview",companyModel17);
		
		orderList.add(hashMap17);

		HashMap<String, Object> hashMap18 = new HashMap<String, Object>();
		hashMap18.put("name", "珠海金山软件股份有限公司");
		hashMap18.put("phone", "0756-0756-3335268");
		hashMap18.put("addr", "珠海市吉大石花西路62号");
		hashMap18.put("url", "http://www.kingsoft.com/");
		CompanyModel companyModel18=new CompanyModel();
		companyModel18.setDrawableId(R.drawable.portrait29);
		hashMap18.put("imageview",companyModel18);
		
		orderList.add(hashMap18);

		HashMap<String, Object> hashMap19 = new HashMap<String, Object>();
		hashMap19.put("name", "珠海市金邦达保密卡有限公司");
		hashMap19.put("phone", "0756-8660888");
		hashMap19.put("addr", "珠海市前山福溪金邦达工业园");
		hashMap19.put("url", "http://11610676.czvv.com/");
		CompanyModel companyModel19=new CompanyModel();
		companyModel19.setDrawableId(R.drawable.portrait34);
		hashMap19.put("imageview",companyModel19);
		

		orderList.add(hashMap4);

		HashMap<String, Object> hashMap20 = new HashMap<String, Object>();
		hashMap20.put("name", "珠海泰坦软件系统有限公司");
		hashMap20.put("phone", "0756-519015");
		hashMap20.put("addr", "珠海市吉大石花西路泰坦科技园");
		hashMap20.put("url", "http://zhttrjxt.cn.china.cn/");
		CompanyModel companyModel20=new CompanyModel();
		companyModel20.setDrawableId(R.drawable.portrait7_5);
		hashMap20.put("imageview",companyModel20);
		
		orderList.add(hashMap20);
		
		HashMap<String, Object> hashMap21 = new HashMap<String, Object>();
		hashMap21.put("name", "安利(中国)日用品有限公司");
		hashMap21.put("phone", "020-851981981");
		hashMap21.put("addr", "中国广东省广州市天河北路233号中信广场41楼");
		hashMap21.put("url", "http://www.amway.com.cn");
		CompanyModel companyModel21=new CompanyModel();
		companyModel21.setDrawableId(R.drawable.portrait7_12);
		hashMap21.put("imageview",companyModel21);
		

		orderList.add(hashMap21);
		HashMap<String, Object> hashMap22 = new HashMap<String, Object>();
		hashMap22.put("name", "完美(中国)有限公司");
		hashMap22.put("phone", "076088701828");
		hashMap22.put("addr", "广东省中山市石岐区东明北路（民营科技园）");
		hashMap22.put("url", "http://www.perfect99.com");
		CompanyModel companyModel22=new CompanyModel();
		companyModel22.setDrawableId(R.drawable.portrait7_15);
		hashMap22.put("imageview",companyModel22);
		

		orderList.add(hashMap22);
		HashMap<String, Object> hashMap23 = new HashMap<String, Object>();
		hashMap23.put("name", "广东汤臣倍健生物科技股份有限公司");
		hashMap23.put("phone", "020-28956666 ");
		hashMap23.put("addr", "珠海市金湾区三灶科技工业园星汉路19号");
		hashMap23.put("url", "http://www.by-health.com.cn/");
		CompanyModel companyModel23=new CompanyModel();
		companyModel23.setDrawableId(R.drawable.portrait7_11);
		hashMap23.put("imageview",companyModel23);
		

		orderList.add(hashMap23);
		
		
		HashMap<String, Object> hashMap24 = new HashMap<String, Object>();
		hashMap24.put("name", "香港康富来集团有限公司");
		hashMap24.put("phone", "400 888 0682  ");
		hashMap24.put("addr", "佛山市顺德区天富来国际工业城");
		hashMap24.put("url", "http://www.hongfuloi.com.cn/");
		CompanyModel companyModel24=new CompanyModel();
		companyModel24.setDrawableId(R.drawable.portrait7_12);
		hashMap24.put("imageview",companyModel24);
		

		orderList.add(hashMap24);
		
		
		HashMap<String, Object> hashMap25 = new HashMap<String, Object>();
		hashMap25.put("name", "哈药集团有限公司");
		hashMap25.put("phone", "0755-86683422 ");
		hashMap25.put("addr", "哈尔滨市道里区哈药路509号");
		CompanyModel companyModel25=new CompanyModel();
		hashMap25.put("url", "http://www.hayao.com/");
		companyModel25.setDrawableId(R.drawable.portrait7_13);
		hashMap25.put("imageview",companyModel25);
		

		orderList.add(hashMap25);

		
		

	}

	private void addData1() {
		orderList1 = new ArrayList<HashMap<String, Object>>();

		
		
		HashMap<String, Object> hashMap5 = new HashMap<String, Object>();
		hashMap5.put("name", "安利(中国)日用品有限公司");
		hashMap5.put("phone", "020-851981981");
		hashMap5.put("addr", "中国广东省广州市天河北路233号中信广场41楼");
		hashMap5.put("url", "http://www.amway.com.cn");
		CompanyModel companyModel5=new CompanyModel();
		companyModel5.setDrawableId(R.drawable.portrait7_12);
		hashMap5.put("imageview",companyModel5);
		
		orderList1.add(hashMap5);
		HashMap<String, Object> hashMap6 = new HashMap<String, Object>();
		hashMap6.put("name", "完美(中国)有限公司");
		hashMap6.put("phone", "076088701828");
		hashMap6.put("addr", "广东省中山市石岐区东明北路（民营科技园）");
		hashMap6.put("url", "http://www.perfect99.com");
		CompanyModel companyModel6=new CompanyModel();
		companyModel6.setDrawableId(R.drawable.portrait7_15);
		hashMap6.put("imageview",companyModel6);
		

		orderList1.add(hashMap6);
		HashMap<String, Object> hashMap7 = new HashMap<String, Object>();
		hashMap7.put("name", "广东汤臣倍健生物科技股份有限公司");
		hashMap7.put("phone", "020-28956666 ");
		hashMap7.put("addr", "珠海市金湾区三灶科技工业园星汉路19号");
		hashMap7.put("url", "http://www.by-health.com.cn/");
		CompanyModel companyModel7=new CompanyModel();
		companyModel7.setDrawableId(R.drawable.portrait7_11);
		hashMap7.put("imageview",companyModel7);
		

		orderList1.add(hashMap7);
		
		
		HashMap<String, Object> hashMap8 = new HashMap<String, Object>();
		hashMap8.put("name", "香港康富来集团有限公司");
		hashMap8.put("phone", "400 888 0682  ");
		hashMap8.put("addr", "佛山市顺德区天富来国际工业城");
		hashMap8.put("url", "http://www.hongfuloi.com.cn/");
		CompanyModel companyModel8=new CompanyModel();
		companyModel8.setDrawableId(R.drawable.portrait7_12);
		hashMap8.put("imageview",companyModel8);
		

		orderList1.add(hashMap8);
		
		
		HashMap<String, Object> hashMap9 = new HashMap<String, Object>();
		hashMap9.put("name", "哈药集团有限公司");
		hashMap9.put("phone", "0755-86683422 ");
		hashMap9.put("addr", "哈尔滨市道里区哈药路509号");
		hashMap9.put("url", "http://www.hayao.com/");
		CompanyModel companyModel9=new CompanyModel();
		companyModel9.setDrawableId(R.drawable.portrait7_13);
		hashMap9.put("imageview",companyModel9);
		
		orderList1.add(hashMap9);
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("name", "深圳市万朝科技有限公司");
		hashMap.put("phone", "0755-25361216");
		hashMap.put("addr", "深圳市盐田区国际创意港6栋5B");
		hashMap.put("url", "http://www.dyninfo.com.cn/");
		CompanyModel companyMode=new CompanyModel();
		companyMode.setDrawableId(R.drawable.portrait51);
		hashMap.put("imageview",companyMode);
		

		orderList1.add(hashMap);

		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		hashMap1.put("name", "深圳市朗华在线技术有限公司");
		hashMap1.put("phone", "0755-82789555");
		hashMap1.put("addr", "深圳市福田区深南大道6021号");
		hashMap1.put("url", "http://leoszscm.cn.china.cn/");
		CompanyModel companyMode1=new CompanyModel();
		companyMode1.setDrawableId(R.drawable.portrait52);
		hashMap1.put("imageview",companyMode1);
		
		orderList1.add(hashMap1);

		

		HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
		hashMap3.put("name", "深圳市百乐礼品有限公司");
		hashMap3.put("phone", "0755-26893372");
		hashMap3.put("addr", "深圳市宝安区西乡街道榕树路64号");
		hashMap3.put("url", "http://polerchina.1688.com/");
		CompanyModel companyMode3=new CompanyModel();
		companyMode3.setDrawableId(R.drawable.portrait51);
		
		hashMap3.put("imageview",companyMode3);
		orderList1.add(hashMap3);

		HashMap<String, Object> hashMap4 = new HashMap<String, Object>();
		hashMap4.put("name", "深圳市新悦伊点商贸有限公司");
		hashMap4.put("phone", "0755-28373440");
		hashMap4.put("addr", "深圳市龙岗区南湾街道南岭村");
		hashMap4.put("url", "http://pgtozhslsarik.shengyidi.com/");
		CompanyModel companyMode4=new CompanyModel();
		companyMode4.setDrawableId(R.drawable.portrait54);
		
		hashMap4.put("imageview",companyMode4);
		
		orderList1.add(hashMap4);

		
	}

	private void addDate2() {
		orderList2 = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("name", "中山大学珠海校区");
		hashMap.put("phone", "0756-3583833");
		hashMap.put("addr", "珠海市香洲区唐家湾镇");
		
		hashMap.put("url", "http://zhongda.gd-jiaoyu.com");
		CompanyModel companyModel=new CompanyModel();
		companyModel.setDrawableId(R.drawable.portrait8);
		hashMap.put("imageview",companyModel);
		
		orderList2.add(hashMap);

		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		hashMap1.put("name", "北京师范大学珠海校区");
		hashMap1.put("phone", "0756-338386");
		hashMap1.put("addr", "珠海市香洲区唐家湾镇金凤路");
		hashMap1.put("url", "http://www.bnuz.edu.cn");
		CompanyModel companyModel1=new CompanyModel();
		companyModel1.setDrawableId(R.drawable.portrait9);
		hashMap1.put("imageview",companyModel1);
		
		orderList2.add(hashMap1);
		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
		hashMap2.put("name", "吉林大学珠海校区");
		hashMap2.put("phone", "0756-35837322");
		hashMap2.put("addr", "珠海市金湾区草唐湾");
		hashMap2.put("url", "http://www.jluzh.com/");
		CompanyModel companyModel2=new CompanyModel();
		companyModel2.setDrawableId(R.drawable.portrait10);
		hashMap2.put("imageview",companyModel2);
		
		orderList2.add(hashMap2);
		HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
		hashMap3.put("name", "暨南大学珠海校区");
		hashMap3.put("phone", "0756-3589823");
		hashMap3.put("addr", "珠海市香洲区前山路206号");
		hashMap3.put("url", "http://zh.jnu.edu.cn/");
		CompanyModel companyModel3=new CompanyModel();
		companyModel3.setDrawableId(R.drawable.portrait11);
		hashMap3.put("imageview",companyModel3);
		
		orderList2.add(hashMap3);
		HashMap<String, Object> hashMap4 = new HashMap<String, Object>();
		hashMap4.put("name", "北京大学");
		hashMap4.put("phone", "010-62752114");
		hashMap4.put("addr", "北京市海淀区颐和园路5号");
		hashMap4.put("url", "http://www.pku.edu.cn/");
		CompanyModel companyModel4=new CompanyModel();
		companyModel4.setDrawableId(R.drawable.portrait7_19);
		hashMap4.put("imageview",companyModel4);
		
		orderList2.add(hashMap4);
		HashMap<String, Object> hashMap5 = new HashMap<String, Object>();
		hashMap5.put("name", "清华大学");
		hashMap5.put("phone", "010-62793001");
		hashMap5.put("addr", "北京市海淀区清华大学");
		hashMap5.put("url", "http://www.tsinghua.edu.cn");
		CompanyModel companyModel5=new CompanyModel();
		companyModel5.setDrawableId(R.drawable.portrait7_17);
		hashMap5.put("imageview",companyModel5);
		
		orderList2.add(hashMap5);
		HashMap<String, Object> hashMap6 = new HashMap<String, Object>();
		hashMap6.put("name", "深圳大学");
		hashMap6.put("phone", "0755-26536114");
		hashMap6.put("addr", "广东省深圳市南山区南海大道3688号");
		hashMap6.put("url", "http://www.szu.edu.cn");
		CompanyModel companyModel6=new CompanyModel();
		companyModel6.setDrawableId(R.drawable.portrait7_18);
		hashMap6.put("imageview",companyModel6);
		
		orderList2.add(hashMap6);
		HashMap<String, Object> hashMap7 = new HashMap<String, Object>();
		hashMap7.put("name", "广州大学");
		hashMap7.put("phone", "020-39366972");
		hashMap7.put("addr", "广州市番禺区大学城外环西路23");
		hashMap7.put("url", "http://www.gzhu.edu.cn/");
		CompanyModel companyModel7=new CompanyModel();
		companyModel7.setDrawableId(R.drawable.portrait7_16);
		hashMap7.put("imageview",companyModel7);
		
		orderList2.add(hashMap7);

	}

	private void addDate3() {
		orderList3 = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("name", "阿里巴巴网络有限公司");
		hashMap.put("phone", "400-800-1688 ");
		hashMap.put("addr", "杭州市滨江区网商路699号");
		
		hashMap.put("url", "http://www.alibaba.com");
		CompanyModel companyModel=new CompanyModel();
		companyModel.setDrawableId(R.drawable.portrait7_4);
		hashMap.put("imageview",companyModel);
		

		orderList3.add(hashMap);

		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		hashMap1.put("name", "支付宝网络技术有限公司");
		hashMap1.put("phone", "0105-623-2917 ");
		hashMap1.put("addr", "杭州市文三路478号华星时代广场22楼");
		hashMap1.put("url", "https://www.alipay.com/");
		CompanyModel companyModel1=new CompanyModel();
		companyModel1.setDrawableId(R.drawable.portrait7_6);
		hashMap1.put("imageview",companyModel1);
		
		orderList3.add(hashMap1);

		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
		hashMap2.put("name", "北京京东叁佰陆拾度电子商务有限公司");
		hashMap2.put("phone", "021-50936927");
		hashMap2.put("addr", "北京市徐汇区华山路2018号汇银广场");
		hashMap2.put("url", "http://bjjingdong.diyi.tv/");
		CompanyModel companyModel2=new CompanyModel();
		companyModel2.setDrawableId(R.drawable.portrait7_7);
		hashMap2.put("imageview",companyModel2);
		
		orderList3.add(hashMap2);

		HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
		hashMap3.put("name", "北京当当网信息技术有限公司");
		hashMap3.put("phone", "400-106-6666");
		hashMap3.put("addr", "北京市安定门三利大厦");
		hashMap3.put("url", "http://book.dangdang.com");
		CompanyModel companyModel3=new CompanyModel();
		companyModel3.setDrawableId(R.drawable.portrait7_8);
		hashMap3.put("imageview",companyModel3);
		
		orderList3.add(hashMap3);

		HashMap<String, Object> hashMap4 = new HashMap<String, Object>();
		hashMap4.put("name", "易迅电子商务发展有限公司");
		hashMap4.put("phone", "021-61831100");
		hashMap4.put("addr", "上海市宝山区纪蕰路588号");
		hashMap4.put("url", "http://www.yixun.com/");
		CompanyModel companyModel4=new CompanyModel();
		companyModel4.setDrawableId(R.drawable.portrait7_9);
		hashMap4.put("imageview",companyModel4);
		

		orderList3.add(hashMap4);

	}

	private void addData4() {
		orderList4 = new ArrayList<HashMap<String, Object>>();

		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("name", "珠海用友软件有限公司");
		hashMap.put("phone", "0756-2312008 ");
		hashMap.put("addr", "海滨南路47号光大国际贸易中心1008");
		
		hashMap.put("url", "http://atj_59105.atobo.com.cn/");
		CompanyModel companyModel=new CompanyModel();
		companyModel.setDrawableId(R.drawable.portrait7_2);
		hashMap.put("imageview",companyModel);
		

		orderList4.add(hashMap);

		HashMap<String, Object> hashMap1 = new HashMap<String, Object>();
		hashMap1.put("name", "珠海南方软件园发展有限公司");
		hashMap1.put("phone", "0756-519085");
		hashMap1.put("addr", "珠海唐家南方软件园");
		hashMap1.put("url", "http://www.china-ssp.com/");
		CompanyModel companyModel1=new CompanyModel();
		companyModel1.setDrawableId(R.drawable.portrait7_5);
		hashMap1.put("imageview",companyModel1);
		
		orderList4.add(hashMap1);

		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
		hashMap2.put("name", "珠海夏浪信息科技有限公司");
		hashMap2.put("phone", "0756-6218155");
		hashMap2.put("addr", "珠海市香洲区人民东路珠信大夏512");
		hashMap2.put("url", "http://www.halong-tech.com/");
		CompanyModel companyModel2=new CompanyModel();
		companyModel2.setDrawableId(R.drawable.portrait7_10);
		hashMap2.put("imageview",companyModel2);
		
		orderList4.add(hashMap2);

		HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
		hashMap3.put("name", "珠海金山软件股份有限公司");
		hashMap3.put("phone", "0756-0756-3335268");
		hashMap3.put("addr", "珠海市吉大石花西路62号");
		hashMap3.put("url", "http://www.kingsoft.com/");
		CompanyModel companyModel3=new CompanyModel();
		companyModel3.setDrawableId(R.drawable.portrait29);
		hashMap3.put("imageview",companyModel3);
		
		orderList4.add(hashMap3);

		HashMap<String, Object> hashMap4 = new HashMap<String, Object>();
		hashMap4.put("name", "珠海市金邦达保密卡有限公司");
		hashMap4.put("phone", "0756-8660888");
		hashMap4.put("addr", "珠海市前山福溪金邦达工业园");
		hashMap4.put("url", "http://11610676.czvv.com/");
		CompanyModel companyModel4=new CompanyModel();
		companyModel4.setDrawableId(R.drawable.portrait34);
		hashMap4.put("imageview",companyModel4);
		

		orderList4.add(hashMap4);

		HashMap<String, Object> hashMap5 = new HashMap<String, Object>();
		hashMap5.put("name", "珠海泰坦软件系统有限公司");
		hashMap5.put("phone", "0756-519015");
		hashMap5.put("addr", "珠海市吉大石花西路泰坦科技园");
		hashMap5.put("url", "http://zhttrjxt.cn.china.cn/");
		CompanyModel companyModel5=new CompanyModel();
		companyModel5.setDrawableId(R.drawable.portrait7_5);
		hashMap5.put("imageview",companyModel5);
		
		orderList4.add(hashMap5);

	}

	/**
	 * 滑动标签方法
	 */
	private void initView(View view) {
		
		mContext = getActivity().getApplicationContext();
		String[] tabStrings = getResources().getStringArray(R.array.tab3_array);
		
		mAdapter=flingTab(view, tabStrings);
		mAdapter.SetOnViewPagerClick(this);
		

		mLeftButton = (Button) view.findViewById(R.id.leftButton);
		mRightButton = (Button) view.findViewById(R.id.rightButton);
		mLeftButton.setOnClickListener(this);
		mRightButton.setOnClickListener(this);
		
		mListView.setAdapter(new BaseAdapter() {

			@Override
			public View getView(int position, View view, ViewGroup arg2) {
				ViewHolder viewHolder;
				if (view == null) {

					view = getActivity().getLayoutInflater().inflate(
							R.layout.item_list_tab3_main, null);
					viewHolder = new ViewHolder();
					viewHolder.name = (TextView) view
							.findViewById(R.id.user_name);
					viewHolder.phone = (TextView) view
							.findViewById(R.id.user_company);
					viewHolder.addr = (TextView) view
							.findViewById(R.id.textView1);
					viewHolder.imageview = (ImageView) view
							.findViewById(R.id.list_item_head_image);
					view.setTag(viewHolder);
				} else {
					viewHolder = (ViewHolder) view.getTag();
				}
				Log.i("orderlist", orderList.toString());
				viewHolder.name.setText(orderList.get(position).get("name")
						.toString());
				viewHolder.phone.setText(orderList.get(position).get("phone")
						.toString());
				viewHolder.addr.setText(orderList.get(position).get("addr")
						.toString());
				CompanyModel companyModel=(CompanyModel) orderList.get(position).get("imageview");
				viewHolder.imageview.setImageResource(companyModel.getDrawableId());

				return view;
			}

			@Override
			public long getItemId(int arg0) {
				// TODO Auto-generated method stub
				return arg0;
			}

			@Override
			public Object getItem(int arg0) {
				
				return null;
			}

			@Override
			public int getCount() {
				// TODO Auto-generated method stub
				return orderList.size();

			}

			class ViewHolder {
				TextView name;
				TextView phone;
				TextView addr;
				ImageView imageview;

			}
		});
		
		

		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {

				Intent intent = new Intent(getActivity(), CompanyTab3Activity.class);
				intent.putExtra("name",orderList.get(position).get("name").toString());
				intent.putExtra("phone",orderList.get(position).get("phone").toString());
				intent.putExtra("addr",orderList.get(position).get("addr").toString());
				intent.putExtra("url",orderList.get(position).get("url").toString());
				CompanyModel companyModel=(CompanyModel) orderList.get(position).get("imageview");
				
				intent.putExtra("imageview", companyModel);
				
				startActivity(intent);
				getActivity().overridePendingTransition(R.anim.push_right_in,
						R.anim.push_left_out);

			}
		});
		mPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				
				if (mPager.getCurrentItem() == 0) {
					mLeftButton.setVisibility(View.INVISIBLE);
				} else {
					mLeftButton.setVisibility(View.VISIBLE);
				}
				if (mPager.getCurrentItem() == (mPager.getChildCount() - 1)) {
					mRightButton.setVisibility(View.INVISIBLE);
				} else {
					mRightButton.setVisibility(View.VISIBLE);
				}

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.view.View.OnClickListener#onClick(android.view.View)
	 * 滑动标签左右指示按钮点击事件
	 */
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.leftButton:
			mPager.setCurrentItem(mPager.getCurrentItem() - 1);
			break;
		case R.id.rightButton:
			mPager.setCurrentItem(mPager.getCurrentItem() + 1);
			break;
		default:
			break;
		}
	}

	

	@Override
	public void OnItemClick(View v) {

		if (Integer.valueOf(v.getTag().toString()) == 0) {
			mListView.setAdapter(new BaseAdapter() {

				@Override
				public View getView(int position, View view, ViewGroup arg2) {
					ViewHolder viewHolder;
					if (view == null) {

						view = getActivity().getLayoutInflater().inflate(
								R.layout.item_list_tab3_main, null);
						viewHolder = new ViewHolder();
						viewHolder.name = (TextView) view
								.findViewById(R.id.user_name);
						viewHolder.phone = (TextView) view
								.findViewById(R.id.user_company);
						viewHolder.addr = (TextView) view
								.findViewById(R.id.textView1);
						viewHolder.imageview = (ImageView) view
								.findViewById(R.id.list_item_head_image);
						view.setTag(viewHolder);
					} else {
						viewHolder = (ViewHolder) view.getTag();
					}
					
					viewHolder.name.setText(orderList.get(position).get("name")
							.toString());
					viewHolder.phone.setText(orderList.get(position)
							.get("phone").toString());
					viewHolder.addr.setText(orderList.get(position).get("addr")
							.toString());

					CompanyModel companyModel=(CompanyModel) orderList.get(position).get("imageview");
					viewHolder.imageview.setImageResource(companyModel.getDrawableId());
					return view;
				}

				@Override
				public long getItemId(int arg0) {
					// TODO Auto-generated method stub
					return arg0;
				}

				@Override
				public Object getItem(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return orderList.size();

				}

				class ViewHolder {
					TextView name;
					TextView phone;
					TextView addr;
					ImageView imageview;

				}
			});
			
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {

					Intent intent = new Intent(getActivity(), CompanyTab3Activity.class);
					intent.putExtra("name",orderList.get(position).get("name").toString());
					intent.putExtra("phone",orderList.get(position).get("phone").toString());
					intent.putExtra("addr",orderList.get(position).get("addr").toString());
					intent.putExtra("url",orderList.get(position).get("url").toString());
					CompanyModel companyModel=(CompanyModel) orderList.get(position).get("imageview");
					
					intent.putExtra("imageview", companyModel);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);

				}
			});

		} else if (Integer.valueOf(v.getTag().toString()) == 1) {
			mListView.setAdapter(new BaseAdapter() {

				@Override
				public View getView(int position, View view, ViewGroup arg2) {
					ViewHolder viewHolder;
					if (view == null) {

						view = getActivity().getLayoutInflater().inflate(
								R.layout.item_list_tab3_main, null);
						viewHolder = new ViewHolder();
						viewHolder.name = (TextView) view
								.findViewById(R.id.user_name);
						viewHolder.phone = (TextView) view
								.findViewById(R.id.user_company);
						viewHolder.addr = (TextView) view
								.findViewById(R.id.textView1);
						viewHolder.imageview = (ImageView) view
								.findViewById(R.id.list_item_head_image);
						view.setTag(viewHolder);
					} else {
						viewHolder = (ViewHolder) view.getTag();
					}
					
					viewHolder.name.setText(orderList1.get(position)
							.get("name").toString());
					viewHolder.phone.setText(orderList1.get(position)
							.get("phone").toString());
					viewHolder.addr.setText(orderList1.get(position)
							.get("addr").toString());

					CompanyModel companyModel=(CompanyModel) orderList1.get(position).get("imageview");
					viewHolder.imageview.setImageResource(companyModel.getDrawableId());

					return view;
				}

				@Override
				public long getItemId(int arg0) {
					// TODO Auto-generated method stub
					return arg0;
				}

				@Override
				public Object getItem(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return orderList1.size();

				}

				class ViewHolder {
					TextView name;
					TextView phone;
					TextView addr;
					ImageView imageview;

				}
			});
			
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {

					Intent intent = new Intent(getActivity(), CompanyTab3Activity.class);
					intent.putExtra("name",orderList1.get(position).get("name").toString());
					intent.putExtra("phone",orderList1.get(position).get("phone").toString());
					intent.putExtra("addr",orderList1.get(position).get("addr").toString());
					intent.putExtra("url",orderList1.get(position).get("url").toString());
					CompanyModel companyModel=(CompanyModel) orderList1.get(position).get("imageview");
					
					intent.putExtra("imageview", companyModel);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);

				}
			});

		} else if (Integer.valueOf(v.getTag().toString()) == 2) {
			mListView.setAdapter(new BaseAdapter() {

				@Override
				public View getView(int position, View view, ViewGroup arg2) {
					ViewHolder viewHolder;
					if (view == null) {

						view = getActivity().getLayoutInflater().inflate(
								R.layout.item_list_tab3_main, null);
						viewHolder = new ViewHolder();
						viewHolder.name = (TextView) view
								.findViewById(R.id.user_name);
						viewHolder.phone = (TextView) view
								.findViewById(R.id.user_company);
						viewHolder.addr = (TextView) view
								.findViewById(R.id.textView1);
						viewHolder.imageview = (ImageView) view
								.findViewById(R.id.list_item_head_image);
						view.setTag(viewHolder);
					} else {
						viewHolder = (ViewHolder) view.getTag();
					}
					
					viewHolder.name.setText(orderList2.get(position).get("name")
							.toString());
					viewHolder.phone.setText(orderList2.get(position)
							.get("phone").toString());
					viewHolder.addr.setText(orderList2.get(position).get("addr")
							.toString());

					CompanyModel companyModel=(CompanyModel) orderList2.get(position).get("imageview");
					viewHolder.imageview.setImageResource(companyModel.getDrawableId());

					return view;
				}

				@Override
				public long getItemId(int arg0) {
					// TODO Auto-generated method stub
					return arg0;
				}

				@Override
				public Object getItem(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return orderList2.size();

				}

				class ViewHolder {
					TextView name;
					TextView phone;
					TextView addr;
					ImageView imageview;

				}
			});
			
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {

					Intent intent = new Intent(getActivity(), CompanyTab3Activity.class);
					intent.putExtra("name",orderList2.get(position).get("name").toString());
					intent.putExtra("phone",orderList2.get(position).get("phone").toString());
					intent.putExtra("addr",orderList2.get(position).get("addr").toString());
					intent.putExtra("url",orderList2.get(position).get("url").toString());
					CompanyModel companyModel=(CompanyModel) orderList2.get(position).get("imageview");
					
					intent.putExtra("imageview", companyModel);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);

				}
			});

		} else if (Integer.valueOf(v.getTag().toString()) == 3) {
			mListView.setAdapter(new BaseAdapter() {

				@Override
				public View getView(int position, View view, ViewGroup arg2) {
					ViewHolder viewHolder;
					if (view == null) {

						view = getActivity().getLayoutInflater().inflate(
								R.layout.item_list_tab3_main, null);
						viewHolder = new ViewHolder();
						viewHolder.name = (TextView) view
								.findViewById(R.id.user_name);
						viewHolder.phone = (TextView) view
								.findViewById(R.id.user_company);
						viewHolder.addr = (TextView) view
								.findViewById(R.id.textView1);
						viewHolder.imageview = (ImageView) view
								.findViewById(R.id.list_item_head_image);
						view.setTag(viewHolder);
					} else {
						viewHolder = (ViewHolder) view.getTag();
					}
					
					viewHolder.name.setText(orderList3.get(position)
							.get("name").toString());
					viewHolder.phone.setText(orderList3.get(position)
							.get("phone").toString());
					viewHolder.addr.setText(orderList3.get(position)
							.get("addr").toString());

					CompanyModel companyModel=(CompanyModel) orderList3.get(position).get("imageview");
					viewHolder.imageview.setImageResource(companyModel.getDrawableId());

					return view;
				}

				@Override
				public long getItemId(int arg0) {
					// TODO Auto-generated method stub
					return arg0;
				}

				@Override
				public Object getItem(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return orderList3.size();

				}

				class ViewHolder {
					TextView name;
					TextView phone;
					TextView addr;
					ImageView imageview;

				}
			});
			
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {

					Intent intent = new Intent(getActivity(), CompanyTab3Activity.class);
					intent.putExtra("name",orderList3.get(position).get("name").toString());
					intent.putExtra("phone",orderList3.get(position).get("phone").toString());
					intent.putExtra("addr",orderList3.get(position).get("addr").toString());
					intent.putExtra("url",orderList3.get(position).get("url").toString());
					CompanyModel companyModel=(CompanyModel) orderList3.get(position).get("imageview");
					
					intent.putExtra("imageview", companyModel);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);

				}
			});

		} else if (Integer.valueOf(v.getTag().toString()) == 4) {
			mListView.setAdapter(new BaseAdapter() {

				@Override
				public View getView(int position, View view, ViewGroup arg2) {
					ViewHolder viewHolder;
					if (view == null) {

						view = getActivity().getLayoutInflater().inflate(
								R.layout.item_list_tab3_main, null);
						viewHolder = new ViewHolder();
						viewHolder.name = (TextView) view
								.findViewById(R.id.user_name);
						viewHolder.phone = (TextView) view
								.findViewById(R.id.user_company);
						viewHolder.addr = (TextView) view
								.findViewById(R.id.textView1);
						viewHolder.imageview = (ImageView) view
								.findViewById(R.id.list_item_head_image);
						view.setTag(viewHolder);
					} else {
						viewHolder = (ViewHolder) view.getTag();
					}
					
					viewHolder.name.setText(orderList4.get(position)
							.get("name").toString());
					viewHolder.phone.setText(orderList4.get(position)
							.get("phone").toString());
					viewHolder.addr.setText(orderList4.get(position)
							.get("addr").toString());

					CompanyModel companyModel=(CompanyModel) orderList4.get(position).get("imageview");
					viewHolder.imageview.setImageResource(companyModel.getDrawableId());
					return view;
				}

				@Override
				public long getItemId(int arg0) {
					// TODO Auto-generated method stub
					return arg0;
				}

				@Override
				public Object getItem(int arg0) {
					// TODO Auto-generated method stub
					return null;
				}

				@Override
				public int getCount() {
					// TODO Auto-generated method stub
					return orderList4.size();

				}

				class ViewHolder {
					TextView name;
					TextView phone;
					TextView addr;
					ImageView imageview;

				}
			});
			
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> parent, View view, int position,
						long id) {

					Intent intent = new Intent(getActivity(), CompanyTab3Activity.class);
					intent.putExtra("name",orderList4.get(position).get("name").toString());
					intent.putExtra("phone",orderList4.get(position).get("phone").toString());
					intent.putExtra("addr",orderList4.get(position).get("addr").toString());
					intent.putExtra("url",orderList4.get(position).get("url").toString());
					CompanyModel companyModel=(CompanyModel) orderList4.get(position).get("imageview");
					
					intent.putExtra("imageview", companyModel);
					startActivity(intent);
					getActivity().overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);

				}
			});

		}

	}
	
	
	

}
