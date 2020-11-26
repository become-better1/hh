package com.example.coursedesign;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
   ImageButton buttonRefresh;
   ImageButton  buttonAdd;
   ImageButton buttonHome;
   ImageButton buttonPerson;
   DBOpenHelper dbHelper;
   List<String> listString=new ArrayList<String>();
   ListView listview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		dbHelper = new  DBOpenHelper(getApplicationContext(),DBOpenHelper.name , null, 1);
		buttonRefresh=(ImageButton) findViewById(R.id.refresh);//刷新
		listview=(ListView) findViewById( R.id.main_list);
		 buttonRefresh.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                listString = dbHelper.readAllCommodities();
	                ArrayAdapter<String> adapter=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,listString);
	                listview.setAdapter(adapter);
	            }
	        });
		 listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {///List
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                String s = (String) listview.getAdapter().getItem(position);
	                Bundle bundle1 = new Bundle();
	                bundle1.putInt("position",position);
	                bundle1.putString("title",s);
	                Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
	                intent.putExtras(bundle1);
	                startActivity(intent);
	            }
	        });
		 buttonAdd=(ImageButton) findViewById(R.id.ib_add_product);//Add
		 buttonAdd.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	  Intent intent = new Intent(MainActivity.this, AddActivity.class);
	                  startActivity(intent);
	            }
	        });
		 buttonHome=(ImageButton) findViewById(R.id.ib_home_page);//home
		  buttonHome.setOnClickListener(new View.OnClickListener() {
		            @Override
		            public void onClick(View v) {
		            	 Toast.makeText(getApplicationContext(), "已在主页", Toast.LENGTH_SHORT).show();
		            }
		        });
		  buttonPerson=(ImageButton) findViewById(R.id.ib_personal_center);///person
		  buttonPerson.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	            	 Intent intent = new Intent(MainActivity.this, PersonActivity.class);
	                  startActivity(intent);
	            	 Toast.makeText(getApplicationContext(), "进入个人中心", Toast.LENGTH_SHORT).show();
	            }
	        });
		 
	}

	
}
