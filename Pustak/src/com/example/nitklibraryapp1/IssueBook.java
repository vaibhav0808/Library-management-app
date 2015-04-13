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
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
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

@TargetApi(Build.VERSION_CODES.GINGERBREAD) @SuppressLint("NewApi") public class IssueBook extends ActionBarActivity {
	EditText etausername,etbooknumber,etbookname;
	Button bgetinfo,bissuebook,bgetbookinfo;
	InputStream is1=null;
	 InputStream is2=null;
	  InputStream is3=null;
	InputStream is4=null;
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_issue_book);
		StrictMode.enableDefaults();
		
		 StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy);
		
		etausername=(EditText) findViewById(R.id.tusername);
	    bgetinfo=(Button) findViewById(R.id.bgetinfo);
		etausername.setTextColor(Color.parseColor("#FFFFFF"));
	    bissuebook=(Button) findViewById(R.id.bissuebook);
	    etbooknumber=(EditText) findViewById(R.id.tbooknumber);
	    etbooknumber.setTextColor(Color.parseColor("#FFFFFF"));
	    etbookname=(EditText) findViewById(R.id.tbookname);
	    etbookname.setTextColor(Color.parseColor("#FFFFFF"));
	    bgetbookinfo=(Button) findViewById(R.id.bgetbookinfo);
		
		  //String msg="Data updated successfully";
			
        bgetinfo.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					
					String username=etausername.getText().toString();
					Intent i = new Intent(IssueBook.this,UserInfo.class);
					// final String username = extras.getString("username");
					 i.putExtra("username",username);
                     
        //             Toast.makeText(getApplicationContext(), "pqr"+book_name, 4000).show();
             		
                     startActivity(i);
				}
			}); 
		
        bgetbookinfo.setOnClickListener(new OnClickListener() {
				public void onClick(View arg0) {
					
					String book_name=etbookname.getText().toString();
					
					Intent i = new Intent(IssueBook.this,ShowBook.class);
					// final String username = extras.getString("username");
					 i.putExtra("book_name",book_name);
                     
        //             Toast.makeText(getApplicationContext(), "pqr"+book_name, 4000).show();
             		
                     startActivity(i);
				}
			}); 
    
        bissuebook.setOnClickListener(new OnClickListener() {		
			public void onClick(View arg0) {
				
				String booknumber=etbooknumber.getText().toString();
				String username=etausername.getText().toString();
				String bookname=etbookname.getText().toString();
				String book = "book"+booknumber;
				
				  Toast.makeText(getApplicationContext(), booknumber, 4000).show();
				  Toast.makeText(getApplicationContext(), book, 4000).show();
					
		
				Intent i = new Intent(IssueBook.this,IssueBook.class);
				// final String username = extras.getString("username");
				
			    List<NameValuePair> namevaluepairs=new ArrayList<NameValuePair>(1);
				namevaluepairs.add(new BasicNameValuePair("username",username));		
				//namevaluepairs.add(new BasicNameValuePair("book1",bookname));		
		//		namevaluepairs.add(new BasicNameValuePair("book",book));
				
				try{
					 
	            	  
	            	  if(book.equals("book1"))
	            	  {
	            		  Toast.makeText(getApplicationContext(), "in", 4000).show();
							
	 	            	 
	            	   HttpClient httpClient1=new DefaultHttpClient();
	            	   Toast.makeText(getApplicationContext(), "w", 4000).show();
						
					   HttpPost httPost1=new HttpPost("http://http://vaibhav0808.comli.com/book1.php");
					   Toast.makeText(getApplicationContext(), "x", 4000).show();
						
					   httPost1.setEntity(new UrlEncodedFormEntity(namevaluepairs));
					   Toast.makeText(getApplicationContext(), "y", 4000).show();
						
					   HttpResponse httpResponse1=httpClient1.execute(httPost1);
					   Toast.makeText(getApplicationContext(), "z", 4000).show();

					   HttpEntity httpEntity1=httpResponse1.getEntity();
						  is1=httpEntity1.getContent();
						  
						  String msg="successfully";
						  Toast.makeText(getApplicationContext(), msg, 4000).show();
											
	            	  }
	            	  else if(book.equals("book2"))
	            			  {
	            		  HttpClient httpClient1=new DefaultHttpClient();
						   HttpPost httPost1=new HttpPost("http://http://vaibhav0808.comli.com/book2.php");
						   httPost1.setEntity(new UrlEncodedFormEntity(namevaluepairs));
							  HttpResponse httpResponse1=httpClient1.execute(httPost1);
							  HttpEntity httpEntity1=httpResponse1.getEntity();
							  is2=httpEntity1.getContent();
		            	 	  }
	            	  else if(book.equals("book3"))
	            			  {
	            		  HttpClient httpClient1=new DefaultHttpClient();
						   HttpPost httPost1=new HttpPost("http://http://vaibhav0808.comli.com/book3.php");
						   httPost1.setEntity(new UrlEncodedFormEntity(namevaluepairs));
							  HttpResponse httpResponse1=httpClient1.execute(httPost1);
							  HttpEntity httpEntity1=httpResponse1.getEntity();
							  is3=httpEntity1.getContent();
		            	  }
	            	  else{
	            		  HttpClient httpClient1=new DefaultHttpClient();
						   HttpPost httPost1=new HttpPost("http://http://vaibhav0808.comli.com/book4.php");
						   httPost1.setEntity(new UrlEncodedFormEntity(namevaluepairs));
							  HttpResponse httpResponse1=httpClient1.execute(httPost1);
							  HttpEntity httpEntity1=httpResponse1.getEntity();
							  is4=httpEntity1.getContent();
		            	  	  
	            	  }
	            		  
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
					  String msg="Data updated successfully";
					  Toast.makeText(getApplicationContext(), msg, 4000).show();
				//	  spinner.setVisibility(View.GONE);				 
				  }
				
              //  Toast.makeText(getApplicationContext(), "Updated succesfully", 4000).show();
         		
                // startActivity(i);
			}
		});    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.issue_book, menu);
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
