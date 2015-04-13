package com.example.nitklibraryapp1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi") public class UpdateBook extends ActionBarActivity {
	
	EditText etbook_name,etauthor,etavailability;
	Button update;
	

	@SuppressLint("NewApi") @TargetApi(Build.VERSION_CODES.GINGERBREAD) @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
		 StrictMode.setThreadPolicy(policy);
		
		
		setContentView(R.layout.activity_update_book);
		
		etbook_name=(EditText) findViewById(R.id.tbookname);
		etauthor=(EditText) findViewById(R.id.tauthor);
		etavailability=(EditText)findViewById(R.id.tavailability);
		
		etbook_name.setTextColor(Color.parseColor("#FFFFFF"));
		etauthor.setTextColor(Color.parseColor("#FFFFFF"));
		etavailability.setTextColor(Color.parseColor("#FFFFFF"));
		update = (Button) findViewById(R.id.bupdate);
		
		 update.setOnClickListener(new OnClickListener() {
				
				InputStream is=null;
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
				//	spinner.setVisibility(View.VISIBLE);	
					String book_name=etbook_name.getText().toString();
					String author=etauthor.getText().toString();
					String availability=etavailability.getText().toString();
				
				
					    List<NameValuePair> namevaluepairs=new ArrayList<NameValuePair>(1);
						namevaluepairs.add(new BasicNameValuePair("book_name",book_name));		
				
						namevaluepairs.add(new BasicNameValuePair("author",author));
						namevaluepairs.add(new BasicNameValuePair("availability",availability));  
	
					  try
					  {  
                               	  HttpClient httpClient1=new DefaultHttpClient();
								  HttpPost httPost1=new HttpPost("http://vaibhav0808.comli.com/updateBook.php");
								  httPost1.setEntity(new UrlEncodedFormEntity(namevaluepairs));
								  HttpResponse httpResponse1=httpClient1.execute(httPost1);
								  HttpEntity httpEntity1=httpResponse1.getEntity();
								  is=httpEntity1.getContent();				 
								  Toast.makeText(getApplicationContext(), "helo", 4000).show();
								  Intent it = new Intent(UpdateBook.this,UpdateBook.class);
										startActivity(it);            
						  }
					  catch(ClientProtocolException e){
						  Log.e("ClientProtocol","Log_tag");
					      e.printStackTrace();
					  }
					  catch(IOException e){
						   Log.e("ClientProtocol","Log_tag");
						   e.printStackTrace();
					  }
					  finally{
						  String msg="Data Entered successfully";
						  Toast.makeText(getApplicationContext(), msg, 4000).show();
						  
						  
					//	  spinner.setVisibility(View.GONE);				 
					  }
	  
				}
			});			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.update_book, menu);
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
