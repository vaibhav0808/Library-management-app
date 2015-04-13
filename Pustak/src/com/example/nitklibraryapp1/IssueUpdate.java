package com.example.nitklibraryapp1;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class IssueUpdate extends ActionBarActivity {
 	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_issue_update);
		
		Button bissue=(Button) findViewById(R.id.bissue);
		Button bupdate=(Button) findViewById(R.id.bupdate);
		Button blogout=(Button) findViewById(R.id.blogout);
		
		
		  bissue.setOnClickListener(new OnClickListener(){
      		
				public void onClick(View arg0) {
                  				
					Intent i = new Intent(IssueUpdate.this,IssueBook.class);
					// String book_name =etbook_name.getText().toString();  
	             		
				//	 i.putExtra("book_name",book_name);
                   
      //             Toast.makeText(getApplicationContext(), "pqr"+book_name, 4000).show();
           		
                   startActivity(i);
				}
			});  

		  bupdate.setOnClickListener(new OnClickListener() {
      		
          	
				public void onClick(View arg0) {
                  				
					Intent i = new Intent(IssueUpdate.this,UpdateBook.class);
					// String book_name =etbook_name.getText().toString();  
	             		
				//	 i.putExtra("book_name",book_name);
                   
      //             Toast.makeText(getApplicationContext(), "pqr"+book_name, 4000).show();
           		
                   startActivity(i);
				}
			});  

		  blogout.setOnClickListener(new OnClickListener() {
      		
          	
				public void onClick(View arg0) {
                  				
					Intent i = new Intent(IssueUpdate.this,MainActivity.class);
					// String book_name =etbook_name.getText().toString();  
		             Toast.makeText(getApplicationContext(), "logged out succesfully", 4000).show();
		             	
				//	 i.putExtra("book_name",book_name);
                   
                   startActivity(i);
				}
			});  
		
		
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.issue_update, menu);
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
}
