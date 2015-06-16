package com.halong.associationapp;

import com.halong.associationapp.tab4.LoginActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

public class StartActivity extends Activity {
	private long m_dwSplashTime = 3000;
	private boolean m_bPaused = false;
	private boolean m_bSplashActive = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		Thread splashTimer = new Thread() {
			public void run() {
				try {
					long ms = 0;
					while (m_bSplashActive && ms < m_dwSplashTime) {
						sleep(100);
						if (!m_bPaused) {
							ms += 100;
						}
					}
					Intent intent=new Intent(StartActivity.this,LoginActivity.class);
					startActivity(intent);
					overridePendingTransition(R.anim.push_right_in,
							R.anim.push_left_out);

				} catch (Exception e) {
					Log.e("splash", e.getMessage());
				} finally {
					finish();
				}

			}

		};
		splashTimer.start();
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		super.onKeyDown(keyCode, event);
		switch (keyCode) {
		case KeyEvent.KEYCODE_MENU:
			m_bSplashActive = false;

			break;
		case KeyEvent.KEYCODE_BACK:
			android.os.Process.killProcess(android.os.Process.myPid());

			break;
		default:
			break;
		}

		return true;
	}

	@Override
	protected void onPause() {
		super.onPause();
		m_bPaused = true;

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		m_bPaused = false;
	}


}
