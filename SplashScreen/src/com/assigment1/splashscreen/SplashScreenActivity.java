package com.assigment1.splashscreen;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

public class SplashScreenActivity extends ActionBarActivity {
	private static final int TIME = 2000;
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
	}
	
	protected void onStart(){
		super.onStart();
		handler.postDelayed(start, TIME);
	}
	
	 protected void onStop(){
		 super.onStop();
		 handler.removeCallbacks(start);
	 }
}