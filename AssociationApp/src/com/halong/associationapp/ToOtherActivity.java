package com.halong.associationapp;



import net.tsz.afinal.FinalActivity;
import android.content.Intent;

public class ToOtherActivity extends FinalActivity {
	
	public void toOtherActivity(Class<?> activity) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, activity);
		startActivity(intent);
	}
	
	public void toOtherActivity(Class<?> activity,String value) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, activity);
		intent.putExtra("which", value);
		startActivity(intent);
	}
}
