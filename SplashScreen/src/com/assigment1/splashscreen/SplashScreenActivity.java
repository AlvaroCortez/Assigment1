package com.assigment1.splashscreen;

import java.util.Date;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;

public class SplashScreenActivity extends ActionBarActivity {
	private static final Date dateSinceStartSeconds = new Date(); 
	private Date currentDateTime = new Date();
	private long delayMilliseconds;
	private long timeSinceLaunchMilliseconds;
	private long startTimeMilliseconds;
	private static final int startDelayMilliseconds = 2000;
	private static final String TIIME = "myTime";

	private Runnable startNewActivity;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		startNewActivity = new Runnable() {

			// Using handler with postDelayed called runnable run method

			@Override
			public void run() {
				Intent i = new Intent(getBaseContext(), HomeActivity.class);
				startActivity(i);
				// close this activity
				finish();
			}
		};
		if (savedInstanceState != null) {
			startTimeMilliseconds = savedInstanceState.getLong(TIIME);// 
		} else {
			 startTimeMilliseconds= dateSinceStartSeconds.getTime();
		}
	}

	protected void onStart() {
		super.onStart();
		timeSinceLaunchMilliseconds = currentDateTime.getTime() - startTimeMilliseconds;
		if (timeSinceLaunchMilliseconds<startDelayMilliseconds){
			delayMilliseconds = startDelayMilliseconds-timeSinceLaunchMilliseconds;
			handler.postDelayed(startNewActivity, delayMilliseconds);
		} else{
			handler.post(startNewActivity);
		}
	}

	public void onSaveInstanceState(Bundle saveInstanceState) {
		saveInstanceState.putLong(TIIME, startTimeMilliseconds);
		super.onSaveInstanceState(saveInstanceState);
	}

	protected void onStop() {
		super.onStop();
		handler.removeCallbacks(startNewActivity);
	}
}
