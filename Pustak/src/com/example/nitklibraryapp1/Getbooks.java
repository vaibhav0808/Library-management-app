package com.example.nitklibraryapp1;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Getbooks extends ActionBarActivity {
	 
	 String data = "";
	 EditText etbook_name;
	 EditText etauthor;
	 
	 Button bsearch;
	 Button asearch;
	 
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_getbooks);
		
		etbook_name= (EditText) findViewById(R.id.tbookname);
		etauthor= (EditText) findViewById(R.id.tauthor);
		etbook_name.setTextColor(Color.parseColor("#FFFFFF"));
		etauthor.setTextColor(Color.parseColor("#FFFFFF"));
		
		
		//final GetDataFromDB getdb = new GetDataFromDB();
		  System.out.println(data);
			Button asearch=(Button) findViewById(R.id.basearch);
			Button bsearch=(Button) findViewById(R.id.bbsearch);
            
	            
            bsearch.setOnClickListener(new OnClickListener() {
            		
            	
					public void onClick(View arg0) {
	                    				
						Intent i = new Intent(Getbooks.this,ShowBook.class);
						 String book_name =etbook_name.getText().toString();  
		             		
						 i.putExtra("book_name",book_name);
	                     
	        //             Toast.makeText(getApplicationContext(), "pqr"+book_name, 4000).show();
	             		
	                     startActivity(i);
					}
				});  
            
            asearch.setOnClickListener(new OnClickListener() {
            	
				public void onClick(View arg0) {
					 Intent i = new Intent(Getbooks.this,ShowBook1.class);
					 String author =etauthor.getText().toString();  
	             		
					 i.putExtra("author",author);
                     
              //      Toast.makeText(getApplicationContext(), "pqr"+author, 4000).show();
             		
                     startActivity(i);
				}
			})  ;
    
           }  

     
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.getbooks, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/*public void sendMessageToShowBook(View view) 
    {
        Intent intent = new Intent(Getbooks.this, ShowBook.class);
        startActivity(intent);
    }*/
}
