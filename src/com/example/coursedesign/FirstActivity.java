package com.example.coursedesign;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FirstActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first);
		Button button=(Button) findViewById(R.id.Loading);
		 button.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	  Intent intent = new Intent(FirstActivity.this, MainActivity.class);
	                  startActivity(intent);
	            }
	        });
	}

	
}
