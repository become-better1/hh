package com.example.coursedesign;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ListViewActivity extends Activity {
    EditText text;
    Button button_up;
    Button button_delete;
    int position;
    String str;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_view);
		text=(EditText) findViewById(R.id.listView_text);
		button_delete=(Button) findViewById(R.id.listView_delete);
		button_up=(Button) findViewById(R.id.listView_updata);
		Bundle b = getIntent().getExtras();
        if( b != null) {
        	str=b.getString("title");
        	//Toast.makeText(getApplicationContext(), str, Toast.LENGTH_SHORT).show();
        	  text.setText(str.toCharArray(), 0, str.length());
            position = b.getInt("position");
        }
        button_delete.setOnClickListener(new View.OnClickListener() {//delete
            @Override
            public void onClick(View v) {
               DBOpenHelper dbHelper = new DBOpenHelper(getApplicationContext(), DBOpenHelper.name, null, 1);
               dbHelper.deleteMyCollection(str);
               Toast.makeText(getApplicationContext(), "删除成功", Toast.LENGTH_SHORT).show();
               finish();
            }
        });
        button_up.setOnClickListener(new View.OnClickListener() {//delete
            @Override
            public void onClick(View v) {
            	String wordNew="";
             wordNew=text.getText().toString();
               DBOpenHelper dbHelper = new DBOpenHelper(getApplicationContext(), DBOpenHelper.name, null, 1);
               if(dbHelper.updateUser(wordNew, str)){
               Toast.makeText(getApplicationContext(), "更新成功", Toast.LENGTH_SHORT).show();
               finish();
               }
            }
        });
	}


}
