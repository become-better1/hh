package com.example.coursedesign;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PersonActivity extends Activity {

	TextView text;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person);
		 SharedPreferences sharedP=getSharedPreferences("SaveTable",MODE_PRIVATE);   
		   int num=sharedP.getInt("number", 0);
		   Integer num2=(Integer)num;
		   text=(TextView) findViewById(R.id.person_text);
		   text.setText(num2.toString());
		   Button button=(Button) findViewById(R.id.person_button);
		   button.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	Intent intent = new Intent(PersonActivity.this, AppActivity.class);
	                  startActivity(intent);
	            }
	        });
	}

	
}
