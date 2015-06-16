package com.halong.associationapp;

import java.io.Serializable;

import com.halong.associationapp.tab1.PullToRefreshView.OnFooterRefreshListener;
import com.halong.associationapp.tab1.PullToRefreshView.OnHeaderRefreshListener;
import com.halong.associationapp.tab3.TabViewPagerAdapter.OnViewPagerClick;

import android.os.Bundle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.halong.associationapp.tab1.AssociationData;
import com.halong.associationapp.tab1.DetailActivity;
import com.halong.associationapp.tab1.PullListAdapter;
import com.halong.associationapp.tab1.PullToRefreshView;
import com.halong.associationapp.tab1.PullToRefreshView.OnFooterRefreshListener;
import com.halong.associationapp.tab1.PullToRefreshView.OnHeaderRefreshListener;
import com.halong.associationapp.tab1.ViewPagerAdapter;
import com.halong.associationapp.tab3.TabViewPagerAdapter;
import com.halong.associationapp.tab3.TabViewPagerAdapter.OnViewPagerClick;





import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;


import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

@SuppressWarnings("serial")
public class ImfoActivity extends BackActivity implements
OnHeaderRefreshListener, OnFooterRefreshListener,
OnViewPagerClick,Serializable, OnClickListener {
	private TabViewPagerAdapter mTabViewPagerAdapter;
	private PullToRefreshView mPullToRefreshView;
	private ListView mListView;
	private PullListAdapter mPullListAdapter, mPullListAdapter1,
			mPullListAdapter2;
	private List<AssociationData> mList = new ArrayList<AssociationData>();
	private List<AssociationData> mList1 = new ArrayList<AssociationData>();
	private List<AssociationData> mList2 = new ArrayList<AssociationData>();

	private static final int REFRESH_DONE = 001;
	private static final int REFRESH_ON = 002;
	protected Button mLeftButton, mRightButton;
	private static String[] mTitleString;
	private ViewPager mViewPager,mViewPager2;
	private Context mMainActivity;
	private LinearLayout mLinearLayout;

	private ArrayList<View> arrayList;
	private int image_id[] = { R.drawable.a, R.drawable.b, R.drawable.c,
			R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g };

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_more_contrat);
		mMainActivity=this;
		mPullToRefreshView = (PullToRefreshView)findViewById(R.id.PullToRefreshView);
		mListView = (ListView)findViewById(R.id.pull_listview);
		mViewPager2=(ViewPager) findViewById(R.id.viewpager);
		mLeftButton = (Button) findViewById(R.id.leftButton);
		mRightButton = (Button)findViewById(R.id.rightButton);
		initData();
		initData1();
		initData2();
		mPullListAdapter = new PullListAdapter(mMainActivity, mList);
		initViewpager();
		mListView.setAdapter(mPullListAdapter);
		

		mPullToRefreshView.setOnHeaderRefreshListener(this);
		mPullToRefreshView.setOnFooterRefreshListener(this);
		mLeftButton.setOnClickListener(this);
		mRightButton.setOnClickListener(this);

		mTitleString = getResources().getStringArray(R.array.tab1_array);
		mTabViewPagerAdapter = new TabViewPagerAdapter(this, mTitleString);
		mViewPager2.setAdapter(mTabViewPagerAdapter);
		mTabViewPagerAdapter.SetOnViewPagerClick(this);
		mListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1,
					int position, long id) {
				if(position==0){
					
				}else{
					Intent intent = new Intent(mMainActivity, DetailActivity.class);
					intent.putExtra("mainDetail",mList.get(position-1));
					
					startActivity(intent);
				}
				
			}
		});
		
		mViewPager2.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				// TODO Auto-generated method stub
				if (mViewPager2.getCurrentItem() == 0) {
					mLeftButton.setVisibility(View.INVISIBLE);
				} else {
					mLeftButton.setVisibility(View.VISIBLE);
				}
				if (mViewPager2.getCurrentItem() == (mViewPager2.getChildCount() - 1)) {
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

	private void initData1() {

		AssociationData a1 = new AssociationData();
		a1.setmContent("三天半完成85%以上青苗补偿、三个多月建成横琴金融产业服务基地11栋花园式办公楼、一年半实现约10公里市政道路通车、三年多基本建成十字门会展商务组团……自2010年6月28日珠海十字门中央商务区正式破土动工以来，十字门建设者们发扬敢拼敢闯、奋发有为、只争朝夕的“华发精神”，“五+二、白+黑”地加班加点，以快速高效、大气磅礴的神奇进度推进着十字门中央商务区的建设，在创造出一个又一个“十字门奇迹”的同时，一次又一次地刷新着珠海特区建筑史的纪录。");
		a1.setmTitle("“两基地一平台”格局成型 十字门用速度镌刻特区历史 ");
		a1.setDrawableId(R.drawable.main8);
		a1.setTime("2014-01-22 ");
		a1.setSource("珠海新闻网");
		mList1.add(a1);
		AssociationData a2 = new AssociationData();
		a2.setmContent("蓝天白云，堪称能罐装出口的空气，曾经是珠海的骄傲。但是近年来，雾霾天气开始侵扰珠海人的生活，河流遭污染的消息也反复出现。今晚18时30分至20时，晚报“代表委员热线”2639375话题是：珠海的环境保护。我们将邀请市政协委员侯伟芳通过热线电话，以及晚报官方微博，与您就此话题展开交流。");
		a2.setmTitle("咱曾经能“罐装出口的空气”去哪了？");
		a2.setDrawableId(R.drawable.main9);
		a1.setTime("2014-01-21");
		a1.setSource("珠江晚报");
		mList1.add(a2);
		AssociationData a3 = new AssociationData();
		a3.setmTitle("一小时内免费换乘可能吗？技术不难 需要财政支持");
		a3.setmContent("南都讯 一小时内免费换乘、最后两站乘车免费、刷卡打折再优惠点……昨天，市人大代表万晓丽就改进公交服务提交建议。市公交巴士公司回应：免费换乘是珠海公交的发展方向，未来还会推行公交巴士、有轨电车等多种公交出行方式的免费换乘，不过今年暂无推行计划。");
		a3.setDrawableId(R.drawable.main10);
		a3.setTime("2014-01-20 ");
		a3.setSource("珠海新闻网");
		mList1.add(a3);
		AssociationData a4 = new AssociationData();
		a4.setmTitle("委员愿自掏500万建渔女天桥 自己构思+设计师落实");
		a4.setmContent("天桥话题持续发酵。昨天，政协委员杨华瑞带着自己的“渔女区域天桥设计图”到现场，并表示自己愿掏500万建这个天桥，引来热烈掌声。委员们呼吁珠海开建天桥刻不容缓，不能再陷入“天桥和地道之争”，并由此热议市内交通种种“怪现状”。");
		a4.setDrawableId(R.drawable.main11);
		a4.setTime("2014-01-19");
		a4.setSource("珠海新闻网");
		mList1.add(a4);
		AssociationData a5 = new AssociationData();
		a5.setmTitle("去年6大医院发生66涉医安全事件 盼严厉打击职业医闹 ");
		a5.setmContent("南都讯 昨日，珠海政协表彰了40件优秀提案，仅有1件提案涉及到卫生方面。提案工作的报告中涉及的7个方面内容中也没有1个方面提及卫生健康。据卫生部门粗略统计，2013年全市6家大医院共发生涉医安全事件66起，涉及人数达24人。面对这种情况，在科教文卫组的分组讨论中，珠海市政协委员，市卫生局副局长糜庆有话说：现在珠海不管是创文还是幸福村居建设等都与健康卫生息息相关，大家要关注医生的职业环境、医闹问题等，希望大家能理解医护人员。");
		a5.setDrawableId(R.drawable.main12);
		a5.setTime("2014-01-18");
		a5.setSource("珠海新闻网");
		mList1.add(a5);

	}

	private void initData2() {
		AssociationData a1 = new AssociationData();
		a1.setmContent("12月9日上午，作为珠海优秀企业代表，珠海飞企软件有限公司接受了珠海电视台《点评晚十点》栏目记者的采访，共同探讨了以产教融合为出发点的企业人才培养机制，就专业性人才的用工问题提出了有效建议。记者首先参观了新近落成的飞企展厅和办公区域。飞企展厅是飞企软件企业文化展示的一个窗口，有效的企业人才培训机制，同时离不开企业自身健全、深入的企业文化建设，这也是公司为员工的培养与成长做出的努力。随后记者就与院校之间建立合理的人才培养机制与研发部门负责人与主管进行采访。采访中提到产教融合必须是一个长久的动作，除了在校期间接受的培训之外，更重要的是进入企业之后的不断提升。在正式进入公司后，会针对不同职能及专业技术，不断会有相应的培训及分阶段的考核，逐渐提升员工的学习意识和竞争意识，实现自我突破，一方面促使员工的专业技能大大提升，在另一方面，也为企业带来长久的人才效益，保证企业的创造力。南方学院作为公司长久以来的合作院校，为公司输送了大量的人才，通过产教融合的实施，会发现南方学院的毕业生在实操经验上更具优势，基本经过企业短期的技术培训就能很快适应企业的岗位需求。");
		a1.setmTitle("珠海电视台《点评晚十点》采访飞企软件 ");
		a1.setDrawableId(R.drawable.main13);
		a1.setTime("2014-01-16 ");
		a1.setSource("珠海软件协会 ");
		mList2.add(a1);
		AssociationData a2 = new AssociationData();
		a2.setmContent("2013年由住房和城乡建设部主办的“华夏建设科学技术奖”评审工作已经结束。该奖作为建设行业唯一的部级科技进步奖．也是我国建筑行业最高科技奖项，该奖项设立的目的是加快建设科技创新，提升我国建设行业的综合技术水平。每年的获奖项目都代表了目前建设行业最先进的科技水平。");
		a2.setmTitle("华夏建设科学技术奖派诺科技榜上有名");
		a2.setDrawableId(R.drawable.main14);
		a1.setTime("2014-01-15");
		a1.setSource("珠海软件协会");
		mList2.add(a2);
		AssociationData a3 = new AssociationData();
		a3.setmTitle("派诺科技喜获“中国产学研合作创新示范企业”称号");
		a3.setmContent("12月15日，由中国产学研合作促进会与重庆市政府共同主办的第七届“中国产学研合作创新大会”在重庆举行，出席此次会议的有：全国人大常委会原副委员长、中国产学研合作促进会会长路甬祥，中国工程院原副院长、中国工程科技发展战略研究院常务副院长、工信部通信科技委主任、重庆邮电大学名誉校长、第一届董事会主席邬贺铨院士等。");
		a3.setDrawableId(R.drawable.main15);
		a3.setTime("2014-01-14 ");
		a3.setSource("珠海软件协会");
		mList2.add(a3);
		AssociationData a4 = new AssociationData();
		a4.setmTitle("同望科技中标港珠澳大桥主体工程综合管理信息系统项目");
		a4.setmContent("12月26日，由广州建设工程交易中心发布通知（广州建交（公）中字【2013】第【7229】号），经评标委员会推荐，广东同望科技股份有限公司（以下简称“同望科技”）凭借丰富的交通信息化开发实施经验和专业的服务水平，从众多竞争者中脱颖而出，中标港珠澳大桥主体工程综合管理信息系统第一阶段系统维护与第二阶段系统开发项目。港珠澳大桥全长约50km，主体工程“海中桥隧”长35.578km，包括“一隧、两岛、三桥”，总投资729.4亿元。大桥东连香港，西接珠海、澳门，是我国继三峡工程、青藏铁路、南水北调、西气东输之后又一重大基础设施项目，是一国两制条件下，粤港澳首次合作建设的特大型交通基础设施，具有里程碑式的重要意义和深远的社会影响，大桥的建设对于促进香港、澳门和珠江三角洲西岸地区经济发展也具有重要战略意义，港珠澳大桥的建设是国家级重大工程项目。");
		a4.setDrawableId(R.drawable.main16);
		a4.setTime("2014-01-13");
		a4.setSource("珠海软件协会");
		mList2.add(a4);
		AssociationData a5 = new AssociationData();
		a5.setmTitle("围着居民转的智慧城市“政民通”启动华发试点 ");
		a5.setmContent("12月14日，珠海市首创移动互联网应用政务信息及应用平台——“政民通”正式进驻华发社区启动试点。远光软件负责人表示，“政民通”继在珠海市春晖社区取得成功以来，在进入华发社区试点时，更加着重考虑了华发社区本身的社区分布和居民情况。“政民通”的智慧在于能否回应居民对生活的期待，任何需求是否围绕着居民在转。因此，“政民通”将帮助华发社区构建社区居民、物业公司、周边公共服务机构及居委会“三位一体”的互动模式，实现共同参与社区管理、共建智慧城市，共创城市治理新篇章。据介绍，“政民通”明年将在全市范围进行推广据悉，“政民通”是珠海市创新社会管理、创建智慧城市的独创项目，以智能手机等移动终端为载体，整合各类服务资源，集政务服务、公共服务、征集民意于一体。该项目由珠海市科工贸和信息化局承建、远光软件负责“政民通”手机软件开发与技术支持。2013年11月14日，“政民通”率先在春晖社区成功应用，帮助社区与民众实现良性的互联、互通、互动，构建了上下贯通、方便快捷的社会治理服务体系，实现为民服务的全方位、全覆盖、零距离。");
		a5.setDrawableId(R.drawable.main18);
		a5.setTime("2014-01-12");
		a5.setSource("珠海软件协会");
		mList2.add(a5);


	}

	private void initViewpager() {
		LayoutInflater layoutInflater = (LayoutInflater) mMainActivity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View headView = layoutInflater.inflate(R.layout.viewpage_h, null);
		mLinearLayout = (LinearLayout) headView.findViewById(R.id.linear_main);
		mViewPager = (ViewPager) headView.findViewById(R.id.Ad_pager);
		initPagerChild();
		mViewPager.setAdapter(new ViewPagerAdapter(arrayList));

		mListView.addHeaderView(headView);
	}

	private void initPagerChild() {
		arrayList = new ArrayList<View>();
		for (int i = 0; i < image_id.length; i++) {
			ImageView imageView = new ImageView(mMainActivity);
			imageView.setScaleType(ScaleType.FIT_XY);
			Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
					image_id[i]);
			int width = ((Activity) mMainActivity).getWindowManager().getDefaultDisplay()
					.getWidth();
			Bitmap bitmap2 = getBitmap(bitmap, width);
			imageView.setImageBitmap(bitmap2);
			arrayList.add(imageView);
		}
		// initPoint();

	}

	Bitmap getBitmap(Bitmap bitmap, int width) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		System.out.println("w--->" + w + " h--->" + h);
		Matrix matrix = new Matrix();
		float scale = (float) width / w;
		// 保证图片不变形.
		matrix.postScale(scale, scale);
		// w,h是原图的属性.
		return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
	}

	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case REFRESH_DONE:
				mPullToRefreshView.postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						mPullToRefreshView.onHeaderRefreshComplete();
					}
				}, 1000);
				break;
			case REFRESH_ON:
				mPullToRefreshView.postDelayed(new Runnable() {

					@Override
					public void run() {
						Toast.makeText(mMainActivity, "没有更多数据",
								Toast.LENGTH_SHORT).show();
						mPullToRefreshView.onFooterRefreshComplete();
					}
				}, 1000);
				break;

			default:
				break;
			}
		}

	};

	@Override
	public void OnItemClick(View v) {

		switch (Integer.valueOf(v.getTag().toString())) {
		case 0:
			mLinearLayout.setVisibility(View.VISIBLE);

			mListView.setAdapter(mPullListAdapter);
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long id) {
					if(position==0){
						
					}else{
						Intent intent = new Intent(mMainActivity, DetailActivity.class);
						intent.putExtra("mainDetail",mList.get(position-1));
						
						startActivity(intent);
					}
					
					
				}
			});

			break;
		case 1:
			mLinearLayout.setVisibility(View.GONE);
			mPullListAdapter1 = new PullListAdapter(mMainActivity, mList1);

			mListView.setAdapter(mPullListAdapter1);
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long id) {
					Intent intent = new Intent(mMainActivity, DetailActivity.class);
					intent.putExtra("mainDetail",mList1.get(position-1));
					
					startActivity(intent);
					
				}
			});

			break;
		case 2:
			mLinearLayout.setVisibility(View.GONE);
			mPullListAdapter2 = new PullListAdapter(mMainActivity, mList2);

			mListView.setAdapter(mPullListAdapter2);
			mListView.setOnItemClickListener(new OnItemClickListener() {

				@Override
				public void onItemClick(AdapterView<?> arg0, View arg1,
						int position, long id) {
					Intent intent = new Intent(mMainActivity, DetailActivity.class);
					intent.putExtra("mainDetail",mList2.get(position-1));
					
					startActivity(intent);
					
				}
			});

			break;
		default:
			break;
		}
	}

	@Override
	public void onHeaderRefresh(PullToRefreshView view) {
		// TODO Auto-generated method stub
		mHandler.sendEmptyMessage(REFRESH_DONE);
	}

	@Override
	public void onFooterRefresh(PullToRefreshView view) {
		// TODO Auto-generated method stub
		mHandler.sendEmptyMessage(REFRESH_ON);
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.leftButton:
			mViewPager2.setCurrentItem(mViewPager2.getCurrentItem() - 1);
			break;
		case R.id.rightButton:
			mViewPager2.setCurrentItem(mViewPager2.getCurrentItem() + 1);
			break;
		default:
			break;
		}
		
	}


}
