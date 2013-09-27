package com.rajacasestudy.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class SecondActivity extends Activity implements OnClickListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	String text;
	Button cancel, order;
	EditText small, medium, large;
	TextView description;

	String description1="my desc 1";
	String description2="my desc 2";
	String description3="my desc 3";
	String description4="my desc 4";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondpage);

		cancel = (Button)findViewById(R.id.cancel);
		order =  (Button)findViewById(R.id.order);
		small =(EditText) findViewById(R.id.small_textbox);
		medium =(EditText) findViewById(R.id.medium_textbox);
		large =(EditText) findViewById(R.id.large_textbox);
		description = (TextView) findViewById(R.id.description);

		cancel.setOnClickListener(this);
		order.setOnClickListener(this);

		Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
		text = bundle.getString("foodItem");


		if(text.equals("Frech Fries")){
			description.setText(description1);
		}else if(text.equals("Coke")){
			description.setText(description2);
		}else if(text.equals("Idly")){
			description.setText(description3);
		}else if(text.equals("Dosai")){
			description.setText(description4);
		}


	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.order:
			String smallQuantity;
			String mediumQuantity;
			String largeQuantity;
			int quaSmall;
			int quaMedium;
			int quaLarge;
			
			smallQuantity = small.getText().toString();
			mediumQuantity = medium.getText().toString();
			largeQuantity = large.getText().toString();
			Log.i("small", smallQuantity+"");
			try{
					quaSmall = Integer.parseInt(smallQuantity);
			}catch(Exception e){
				quaSmall=0;
			}
			try{
				quaMedium = Integer.parseInt(mediumQuantity);
			}catch(Exception e){
				quaMedium=0;
			}
			try{
				quaLarge = Integer.parseInt(largeQuantity);
			}catch(Exception e){
				quaLarge=0;
			}
			int total = (quaSmall*1)+(quaMedium *2)+(quaLarge*3);
			Log.i("total", total+"");
			Intent intent = new Intent(this, ThirdActivity.class);
			Bundle bundle=new Bundle();
			bundle.putInt("quantity", total);
			intent.putExtras(bundle);
			startActivity(intent);

			break;
		case R.id.cancel:
			Intent main = new Intent(this, MainActivity.class);
			startActivity(main);
			break;
		}

	}



}
