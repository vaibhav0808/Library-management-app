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

@TargetApi(Build.VERSION_CODES.GINGERBREAD) @SuppressLint("NewApi") public class ASinup extends ActionBarActivity {
	EditText etaname,etausername,etapassworda,etapassword;
	//private ProgressBar spinner;
	Button basinup;
    
	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	    StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	
		setContentView(R.layout.activity_asinup);
		
		etaname=(EditText) findViewById(R.id.taname);
		etausername=(EditText) findViewById(R.id.tausername);
		etapassword=(EditText)findViewById(R.id.tapassword);
		etapassworda=(EditText)findViewById(R.id.tapassworda);
	
		etaname.setTextColor(Color.parseColor("#FFFFFF"));
		etausername.setTextColor(Color.parseColor("#FFFFFF"));
		etapassword.setTextColor(Color.parseColor("#FFFFFF"));
		etapassworda.setTextColor(Color.parseColor("#FFFFFF"));
		basinup=(Button) findViewById(R.id.baregister);
	    basinup.setOnClickListener(new OnClickListener() {
			
			InputStream is=null;
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			//	spinner.setVisibility(View.VISIBLE);	
				String name=etaname.getText().toString();
				String username=etausername.getText().toString();
				String password=etapassword.getText().toString();
				String passworda=etapassworda.getText().toString();
				
				    List<NameValuePair> namevaluepairs=new ArrayList<NameValuePair>(1);
					namevaluepairs.add(new BasicNameValuePair("name",name));		

					namevaluepairs.add(new BasicNameValuePair("username",username));
					namevaluepairs.add(new BasicNameValuePair("password",password));
				    namevaluepairs.add(new BasicNameValuePair("passworda",passworda));
				    

    		if(password.equals(passworda))
    		{	
				  try
				  {
					  HttpClient httpClient=new DefaultHttpClient();
					  HttpPost httPost=new HttpPost("http://vaibhav0808.comli.com/check1.php");
					  httPost.setEntity(new UrlEncodedFormEntity(namevaluepairs));
					  HttpResponse httpResponse=httpClient.execute(httPost);
					  HttpEntity httpEntity=httpResponse.getEntity();
					  is=httpEntity.getContent();
					 
					   ResponseHandler<String> responseHandler = new BasicResponseHandler();
			            final String response = httpClient.execute(httPost, responseHandler);
			           
			            
			            String[] result =response.split(" ",2);
			            String first = result[0];
			            //Toast.makeText(getApplicationContext(), Toast.LENGTH_SHORT).show(); 
			            if(first.equals("yes"))
			            {    
			            	  HttpClient httpClient1=new DefaultHttpClient();
							  HttpPost httPost1=new HttpPost("http://vaibhav0808.comli.com/adminSave.php");
							  httPost1.setEntity(new UrlEncodedFormEntity(namevaluepairs));
							  HttpResponse httpResponse1=httpClient1.execute(httPost1);
							  HttpEntity httpEntity1=httpResponse1.getEntity();
							  is=httpEntity1.getContent();
							  Intent it = new Intent(ASinup.this,ALogin.class);
							   startActivity(it);
			              
			            }else{
			            	Intent it = new Intent(ASinup.this,ASinup.class);
							startActivity(it);
			            	Toast.makeText(getApplicationContext(),"Username already exists", Toast.LENGTH_SHORT).show();                
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
					  String msg="Data Entered successfully";
					  Toast.makeText(getApplicationContext(), msg, 4000).show();
				//	  spinner.setVisibility(View.GONE);				 
				  }
			  }
    		  else{
    			  Toast.makeText(getApplicationContext(), "Paasword didnot match", 4000).show();	  
    		  }
			}
		});

	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.asinup, menu);
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
