package com.rajacasestudy.com;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class MainActivity extends Activity implements OnItemClickListener{

	ListView listView;
	ArrayList<String> list; 
	ArrayAdapter<String> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list = new ArrayList<String>();
		list.add("Frech Fries");
		list.add("Coke");
		list.add("Idly");
		list.add("Dosai");
		
		listView = (ListView)findViewById(R.id.items_listView);
		
		adapter =new ArrayAdapter<String>(this,
		        android.R.layout.simple_list_item_1, list);
		
		listView.setAdapter(adapter);
		listView.setOnItemClickListener(this);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
		// TODO Auto-generated method stub
		String text;
		text = list.get(position);
		//Toast.makeText(getApplicationContext(), text, 2).show();
		Intent intent = new Intent(this, SecondActivity.class);
		Bundle bundle=new Bundle();
		bundle.putString("foodItem", text);
		intent.putExtras(bundle);
		startActivity(intent);
		
	}

}

