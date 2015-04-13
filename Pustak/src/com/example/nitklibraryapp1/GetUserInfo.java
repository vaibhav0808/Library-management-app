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

public class GetUserInfo extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_get_user_info);
		
		Button bgetinfo=(Button) findViewById(R.id.bgetinfo);
		Button blogout=(Button) findViewById(R.id.blogout);
		

		final Bundle extras = getIntent().getExtras();
		
		if (extras == null) {
	           return;
	       }
        bgetinfo.setOnClickListener(new OnClickListener() {
        		
				public void onClick(View arg0) {
                    				
					Intent i = new Intent(GetUserInfo.this,UserInfo.class);
					 final String username = extras.getString("username");
					 i.putExtra("username",username);
                     
        //             Toast.makeText(getApplicationContext(), "pqr"+book_name, 4000).show();
             		
                     startActivity(i);
				}
			});  
  	  blogout.setOnClickListener(new OnClickListener() {
    		
 	
			public void onClick(View arg0) {
            				
				Intent i = new Intent(GetUserInfo.this,MainActivity.class);
				// String book_name =etbook_name.getText().toString();  
	             Toast.makeText(getApplicationContext(), "logged out succesfully", 4000).show();
	             	
			//	 i.putExtra("book_name",book_name);
	           

             startActivity(i);
             finish();
			}
		});         
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.get_user_info, menu);
		return true;
	}
	 
    @Override
 	protected void onStop() {
 		// TODO Auto-generated method stub
 		super.onPause();
 		finish();
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
