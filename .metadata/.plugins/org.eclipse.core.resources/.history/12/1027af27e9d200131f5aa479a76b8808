package com.example.splashscreen;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class DemoActivity extends ListActivity {
	final String[] catnames = new String[] { "Ёлемент1", "Ёлемент2",
			"Ёлемент3", "Ёлемент4", "Ёлемент5", "Ёлемент6", "Ёлемент7",
			"Ёлемент8", "Ёлемент9", "Ёлемент10", "Ёлемент11", "Ёлемент12",
			"Ёлемент13", "Ёлемент14", "Ёлемент15", "Ёлемент16", "Ёлемент17",
			"Ёлемент18", "Ёлемент19", "Ёлемент20", "" };
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
