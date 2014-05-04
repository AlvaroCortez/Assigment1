package com.example.splashscreen;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class DemoActivity extends ListActivity {
	final String[] catnames = new String[] { "Element1", "Element2",
			"Element3", "Element4", "Element5", "Element6", "Element7",
			"Element8", "Element9", "Element10", "Element11", "Element12",
			"Element13", "Element14", "Element15", "Element16", "Element17",
			"Element18", "Element19", "Element20", "" };
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ArrayList<String> list = new ArrayList<String>(Arrays.asList(catnames));
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, list);
		setListAdapter(adapter);
		setContentView(R.layout.activity_demo);
	}
}
