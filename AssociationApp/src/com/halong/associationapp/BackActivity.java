
package com.halong.associationapp;



import android.view.View;

public class BackActivity extends ToOtherActivity {
	
	public void backButton(View view) {
		// TODO Auto-generated method stub
		finish();
		overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
	}

}
