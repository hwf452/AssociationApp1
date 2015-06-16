package com.halong.associationapp.tab4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.halong.associationapp.FragmentToOtherActivity;
import com.halong.associationapp.R;
import com.halong.associationapp.Tab5Fragment;

public class PrivateCenterFragment extends FragmentToOtherActivity implements OnClickListener {
	private RelativeLayout mRelate1,mMember_info_layout1,mRelate2,mRelate3,mRelate4,mRelate5,mRelate6,mRelate7;
	private Button mBtnLogout;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view=inflater.inflate(R.layout.activity_tab4_private_center, null);
		mRelate1=(RelativeLayout)view.findViewById(R.id.relate1);
		mRelate2=(RelativeLayout)view.findViewById(R.id.relate2);
		mRelate3=(RelativeLayout)view.findViewById(R.id.relate3);
		mRelate4=(RelativeLayout)view.findViewById(R.id.relate4);
		mRelate5=(RelativeLayout)view.findViewById(R.id.relate5);
		mRelate6=(RelativeLayout)view.findViewById(R.id.relate6);
		mRelate7=(RelativeLayout)view.findViewById(R.id.relate7);
		mBtnLogout=(Button)view.findViewById(R.id.btnLogout);
		mMember_info_layout1=(RelativeLayout)view.findViewById(R.id.member_info_layout1);
		init();
		return view;
	}

	private void init() {
		mRelate1.setOnClickListener(this);
		mRelate2.setOnClickListener(this);
		mRelate3.setOnClickListener(this);
		mRelate4.setOnClickListener(this);
		mRelate5.setOnClickListener(this);
		mRelate6.setOnClickListener(this);
		mRelate7.setOnClickListener(this);
		mBtnLogout.setOnClickListener(this);
		mMember_info_layout1.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.member_info_layout1:
			Intent intent=new Intent(getActivity(),PrivateImformationActivity.class);
			startActivity(intent);
			
			break;
		case R.id.relate1:
			Intent intent1=new Intent(getActivity(),MyActiveActivity.class);
			startActivity(intent1);
			
			break;
		case R.id.relate2:
			Intent intent2=new Intent(getActivity(),MessageCenterActivity.class);
			startActivity(intent2);
			
			break;
		case R.id.relate3:
			Intent intent3=new Intent(getActivity(),TwoDimensionalCodeActivity.class);
			startActivity(intent3);
			
			break;
		case R.id.relate4:
			Intent intent4=new Intent(getActivity(),BusinessCardHolderActivity.class);
			startActivity(intent4);
			
			break;
		case R.id.relate5:
			Intent intent5=new Intent(getActivity(),FavoritesCompanyActivity.class);
			startActivity(intent5);
			
			break;
		case R.id.relate6:
			Intent intent6=new Intent(getActivity(),ImformationFavoritesActivity.class);
			startActivity(intent6);
			
			break;
		case R.id.relate7:
			Intent intent7=new Intent(getActivity(),ProductFavoritesActivity.class);
			startActivity(intent7);
			
			break;
		case R.id.btnLogout:
			Fragment newFragment = new Tab5Fragment();
			FragmentTransaction transaction = getFragmentManager()
					.beginTransaction();
			
			transaction.replace(R.id.fragment4, newFragment);
			
			transaction.commit();
			getActivity().overridePendingTransition(R.anim.push_right_in, R.anim.push_left_out);
			
			break;
		
			

		default:
			break;
		}
		
	}

}
