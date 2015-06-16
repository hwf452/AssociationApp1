package com.halong.associationapp.tab4;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.halong.associationapp.BackActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.tab1.AssociationData;

public class MyActiveActivity extends BackActivity {
	private ListView mPull_listview;
	private List<AssociationData> mList = new ArrayList<AssociationData>();
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_active);
		mPull_listview=(ListView)findViewById(R.id.pull_listview);
		initData();
		init();
		
	}

	private void init() {
		mPull_listview.setAdapter(new BaseAdapter() {
			
			@Override
			public View getView(int position, View view, ViewGroup arg2) {
				
				view = getLayoutInflater().inflate(R.layout.pulllist_item_news, null);
				ImageView list_item_head_image=(ImageView) view.findViewById(R.id.list_item_head_image);
				TextView textView1 =(TextView)view.findViewById(R.id.recommend_list_item_title_textview);
		       
		        TextView textView2 = (TextView)view.findViewById(R.id.recommend_list_item_desc_textview);
				list_item_head_image.setImageDrawable(getResources().getDrawable(mList.get(position).getDrawableId()));
		        textView1.setText(mList.get(position).getmTitle());
		        textView2.setText(mList.get(position).getmContent());
		        
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
				return mList.size();
			}
		});
		
	}
	private void initData() {

		AssociationData a1 = new AssociationData();
		a1.setmTitle("我市6家企业荣获2013-2014年度国家规划布局内重点软件企业、集成电路设计企业认定");
		a1.setmContent("日前，国家发展和改革委员会、工业和信息化部、财政部、商务部、国家税务总局等五部委联合下发《关于印发2013-2014年度国家规划布局内重点软件企业和集成电路设计企业名单的通知》。我市东信和平科技股份有限公司、珠海世纪鼎利通信科技股份有限公司、远光软件股份有限公司、珠海金山办公软件有限公司被认定为“2013-2014年度国家规划布局内重点软件企业”，炬力集成电路设计有限公司、珠海全志科技股份有限公司被认定为“2013-2014年度国家规划布局内重点集成电路设计企业”，通过企业比往年增加2家。");
		a1.setDrawableId(R.drawable.main2);
		
		
		a1.setTime("2014-01-22");
		a1.setSource("珠海软件协会");
		mList.add(a1);
		AssociationData a2 = new AssociationData();
		a2.setmTitle("协会出台《珠海市信息技术公共服务平台 责任制管理办法》");
		a2.setmContent("为落实市科技工贸和信息化局对我市信息技术公共服务平台优化服务内容，促进业务发展的总体要求，加强和规范协会对珠海南方软件网络评测中心、珠海南方集成电路设计服务中心、珠海南方数字娱乐公共服务中心三个公共技术服务平台的运营管理，经过多方讨论并征求意见，协会制定并出台了《珠海市信息技术公共服务平台责任制管理办法》（以下简称“《办法》”）。《办法》将于2014年1月1日起执行。");
		a2.setDrawableId(R.drawable.main3);
		a1.setTime("2014-01-16");
		a1.setSource("珠海软件协会");
		mList.add(a2);
		AssociationData a3 = new AssociationData();
		a3.setmTitle("协会顺利通过ISO9000质量管理体系认证");
		a3.setmContent("为进一步规范和提高协会业务工作服务质量，2013年协会引入ISO9001-2008国际质量管理认证体系，以“搭建平台、服务产业”为协会质量方针，将协会认证服务、会员服务、行政业务纳入质量控制目标，并按体系要求，完成协会《质量手册》及相关的体系文件。经过相关部门半年来的认真准备，目前协会已通过内部培训、规范制定、内审、外审工作等认证环节，并于12月29日顺利通过全部质量体系审核。");
		a3.setDrawableId(R.drawable.main4);
		a3.setTime("2014-01-14");
		a3.setSource("珠海软件协会");
		mList.add(a3);
		AssociationData a4 = new AssociationData();
		a4.setmTitle("协会联合举办珠海市软件企业知识产权保护与维权培训会");
		a4.setmContent("为提高软件行业知识产权保护与维权意识，增强企业自主创新能力，12月25日，由珠海市软件行业协会、珠海市服务外包行业协会、广东秉德律师事务所联合主办的“软件企业知识产权保护与维权”培训会在望海楼酒店顺利召开。本次培训特别邀请到广东秉德律师事务所律师、资深专利代理人杨焕军与会员企业分享了有关软件企业知识产权保护与维权方面的业务知识。培训会由协会副秘书长张玉霞主持。金山、炬力、世纪鼎利、全志等50余家企业负责人、技术研发人员参加了培训。");
		a4.setDrawableId(R.drawable.main5);
		a4.setTime("2014-01-12");
		a4.setSource("珠海软件协会");
		mList.add(a4);
		AssociationData a5 = new AssociationData();
		a5.setmTitle("协会联合平安银行举办融资产品推介会");
		a5.setmContent("针对一些会员单位反映的资金短缺周转困难以及融资成本加大、信贷手续繁杂等问题，11月6日下午，协会牵手平安银行，在平安银行会议室举办信贷融资产品“贷贷平安商务卡”推介会，珠海爱浦京软件技术有限公司、珠海联迪软件系统有限公司、广东兆邦智能科技有限公司、珠海众能科技发展有限公司、珠海宏利来电子工程有限公司、珠海协成科技有限公司、珠海沃姆电子有限公司等7家企业代表参加了会议。");
		a5.setDrawableId(R.drawable.main6);
		a5.setTime("2014-01-10");
		a5.setSource("珠海软件协会");
		mList.add(a5);
		AssociationData a6 = new AssociationData();
		a6.setmTitle("协会组织企业参加珠海市服务外包政策宣讲培训会");
		a6.setmContent("为促进我市服务外包行业的发展，使广大企业了解国家和省市的服务外包政策，11月28日，协会组织企业参加在南方软件园举行的全市服务外包政策宣讲培训会。会议由市科工贸信局经济技术合作科王伟科长主持，广东省外经贸厅服务贸易处钟进才处长、曾增科长，市科工贸信局经济技术合作科、市各功能区业务主管部门有关人员，全市70多家服务外包企业参加了会议。");
		a6.setDrawableId(R.drawable.main7);
		a6.setTime("2014-01-8");
		a6.setSource("珠海软件协会");
		mList.add(a6);

	}

}
