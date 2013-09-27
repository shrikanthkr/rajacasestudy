package com.rajacasestudy.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends Activity implements OnClickListener{

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	TextView tv;
	Button reset,checkout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thirdpage);
		tv = (TextView)findViewById(R.id.price);
		checkout = (Button)findViewById(R.id.checkout);
		reset = (Button)findViewById(R.id.reset);
		checkout.setOnClickListener(this);
		reset.setOnClickListener(this);
		Bundle bundle = getIntent().getExtras();
		int quantity = bundle.getInt("quantity");
		tv.setText(quantity+"");
		
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent main = new Intent(this, MainActivity.class);
		switch(v.getId()){
		case R.id.checkout:
			Toast.makeText(getApplicationContext(), "Successfully Placed", Toast.LENGTH_LONG).show();
			startActivity(main);
			break;
		case R.id.reset:
			startActivity(main);
			break;
		}
	}

	
}
