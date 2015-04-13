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

@TargetApi(Build.VERSION_CODES.GINGERBREAD) public class ALogin extends ActionBarActivity {
	EditText etal,etal1;

	@TargetApi(Build.VERSION_CODES.GINGERBREAD) @SuppressLint("NewApi") @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_alogin);
		
		StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	
		
		etal = (EditText) findViewById(R.id.tausername1);
		etal.setTextColor(Color.parseColor("#FFFFFF"));
		
        etal1 = (EditText) findViewById(R.id.apassword1);
		etal1.setTextColor(Color.parseColor("#FFFFFF"));
		
        Button submit1=(Button) findViewById(R.id.balogin);
		
        submit1.setOnClickListener(new OnClickListener() {
			InputStream is=null;
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String username=etal.getText().toString();
				
				String password=etal1.getText().toString();
				
				
					Toast.makeText(getBaseContext(), "enterd", 4000).show();
					List<NameValuePair> namevaluepairs=new ArrayList<NameValuePair>(1);
					namevaluepairs.add(new BasicNameValuePair("username",username));
					namevaluepairs.add(new BasicNameValuePair("password",password));
					
					//namevaluepairs.add(new BasicNameValuePair("confirm_password",confirm_password));					
					  try
					  {
						  HttpClient httpClient=new DefaultHttpClient();
						  HttpPost httPost=new HttpPost("http://vaibhav0808.comli.com/adminLogin.php");
						  httPost.setEntity(new UrlEncodedFormEntity(namevaluepairs));
						  HttpResponse httpResponse=httpClient.execute(httPost);
						  HttpEntity httpEntity=httpResponse.getEntity();
						  is=httpEntity.getContent();
						  httpResponse=httpClient.execute(httPost);
				            // edited by James from coderzheaven.. from here....
				            ResponseHandler<String> responseHandler = new BasicResponseHandler();
				            final String response = httpClient.execute(httPost, responseHandler);
				            System.out.println("Response : " + response); 
				            //runOnUiThread(new Runnable() {
				               // public void run() {
				                   /* tv.setText("Response from PHP : " + response);
				                    dialog.dismiss();
				                	String msg="Login successfull";
									  Toast.makeText(getApplicationContext(), msg, 4000).show();*/
				                //}
				           // });
				           // String demo = "hello hi";
				            String[] result =response.split(" ",2);
				            String first = result[0];
				            Toast.makeText(getApplicationContext(),first, Toast.LENGTH_SHORT).show(); 
				            if(first.equals("yes")){
				               // runOnUiThread(new Runnable() {
				                   // public void run() {
				            	
				                       Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_SHORT).show();
				                      // String ge=textView.getText().toString();

				                     //Create the bundle
				                     Bundle bundle = new Bundle();

				                     //Add your data to bundle
				                     //bundle.putString(“username”,"password", username,password);
				                     Intent i = new Intent(ALogin.this,IssueUpdate.class);
				                     //Add the bundle to the intent
				                     i.putExtra("username",username);
				                     i.putExtra("password",password);

				                     //Fire that second activity
				                     startActivity(i);
				                    //}
				                //});
				                 
				               // startActivity(new Intent(AndroidPHPConnectionDemo.this, UserPage.class));
				            }else{
				            	Toast.makeText(getApplicationContext(),"Login Failed1", Toast.LENGTH_SHORT).show();                
				            }
				             
				        }
			         catch(ClientProtocolException e){Log.e("ClientProtocol","Log_tag");
					  e.printStackTrace();}
					  catch(IOException e){Toast.makeText(getApplicationContext(), "Login failed", 4000).show();
						  Log.e("ClientProtocol","Log_tag");e.printStackTrace();}
					  catch(Exception e){
						  Toast.makeText(getApplicationContext(), "Login failed2", 4000).show();
					  }
			}
		});
 
	}
	  public void sendMessageToASinup(View view) 
	    {
	        Intent intent = new Intent(ALogin.this, ASinup.class);
	        startActivity(intent);
	    }  
	  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.alogin, menu);
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
