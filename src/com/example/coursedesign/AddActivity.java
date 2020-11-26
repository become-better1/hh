package com.example.coursedesign;

import android.app.Activity;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends Activity {

	Button button;
	EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add);
		button=(Button) findViewById(R.id.add_button);
		editText=(EditText) findViewById(R.id.add_text);
		 button.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	               String s=editText.getText().toString();
	               DBOpenHelper dbHelper = new DBOpenHelper(getApplicationContext(), DBOpenHelper.name, null, 1);
	               if(s!=null){
	            	   if(dbHelper.addMyCollection(s)){
	            		   Toast.makeText(getApplicationContext(), "添加成功", Toast.LENGTH_SHORT).show();
	            		   SharedPreferences sharedP=getSharedPreferences("SaveTable",MODE_PRIVATE);
	            		   SharedPreferences.Editor editor=sharedP.edit();
	            		   int num=sharedP.getInt("number", 0);
	            		   num++;
	            		   editor.putInt("number", num);
	            		   editor.commit();
	            		   finish();
	            	   }
	            	   else{
	            		   Toast.makeText(getApplicationContext(), "添加失败", Toast.LENGTH_SHORT).show();
	            	   }
	               }
	            }
	        });
	}


}
