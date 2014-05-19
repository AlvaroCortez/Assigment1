package com.assigment1.splashscreen;

import java.util.Date;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;

public class SplashScreenActivity extends ActionBarActivity {
	private static Date dateSinceStartSeconds = new Date();
	private static long delayMilliseconds;
	private static long timeSinceLaunchMilliseconds;
	private static final long globalTimeMilliseconds = dateSinceStartSeconds.getSeconds()*1000;
	private static final int startDelayMilliseconds = 2000;
	private static final String TIIME = "myTime";

	private Runnable start;
	private Handler handler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		start = new Runnable() {

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
			timeSinceLaunchMilliseconds = savedInstanceState.getLong(TIIME);// total time and then
																			// calculate delay
			delayMilliseconds = startDelayMilliseconds - (timeSinceLaunchMilliseconds - globalTimeMilliseconds);
			
			if (delayMilliseconds < 0) {
				delayMilliseconds = 0;  
			}
		} else {
			delayMilliseconds = startDelayMilliseconds;
			timeSinceLaunchMilliseconds = dateSinceStartSeconds.getSeconds()*1000;
		}
	}

	protected void onStart() {
		super.onStart();
		handler.postDelayed(start, delayMilliseconds);
	}

	public void onSaveInstanceState(Bundle saveInstanceState) {
		timeSinceLaunchMilliseconds += dateSinceStartSeconds.getSeconds()*1000;
		saveInstanceState.putLong(TIIME, timeSinceLaunchMilliseconds);
		super.onSaveInstanceState(saveInstanceState);
	}

	protected void onStop() {
		super.onStop();
		handler.removeCallbacks(start);
	}
}
