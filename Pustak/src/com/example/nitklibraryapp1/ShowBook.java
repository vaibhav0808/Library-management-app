package com.example.nitklibraryapp1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ShowBook extends ActionBarActivity {

	 String data = "";
	 EditText etbook_name;
	 TextView resultView ; 
	 Button bsearch;
	 
	 @SuppressLint("NewApi") @Override
	 protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_book);
		StrictMode.enableDefaults();
		
		resultView = (TextView) findViewById(R.id.tsbook_name);
		
		Bundle extras = getIntent().getExtras();
	     
		if (extras == null) {
	           return;
	       }
	          final String book_name = extras.getString("book_name");
	          
	         try{
	                getData(book_name);
	         }
	         catch(IOException e){
				  Log.e("log.tag","error1"+e.toString());
				}
       }
	 
	 public void getData(String book_name) throws IOException {
		
		 InputStream is = null ;
		 
		 String result="";
		 
		 List<NameValuePair> namevaluepairs=new ArrayList<NameValuePair>(1);
		 namevaluepairs.add(new BasicNameValuePair("book_name",book_name));
	//	 Toast.makeText(getApplicationContext(), "xyz"+book_name, 4000).show();
				
		 
		 try{
			 HttpClient httpClient=new DefaultHttpClient();
			 
			  HttpPost httPost=new HttpPost("http://vaibhav0808.comli.com/getdata.php");
			  
			  httPost.setEntity(new UrlEncodedFormEntity(namevaluepairs));
			  //httPost.setEntity(new UrlEncodedFormEntity(namevaluepairs));
			  HttpResponse httpResponse=httpClient.execute(httPost);
			  HttpEntity httpEntity=httpResponse.getEntity();
			  is = httpEntity.getContent();
			  
			  // httpResponse=httpClient.execute(httPost);
		 } catch(ClientProtocolException e){
			 Log.e("ClientProtocol","Log_tag");
		     e.printStackTrace();
		  }
		 
		 try{
			 BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
			 StringBuilder sb = new StringBuilder();
				
			 String line = null ;
			 
			 while((line = reader.readLine())!=null){
			     sb.append(line + "\n");
			}
			is.close();

			result=sb.toString();
			 
		 }
		 catch (Exception e){
			  Toast.makeText(getApplicationContext(), ""+result, 4000).show();
				
		 }
		 
		 try{
			    String s= "\n\n";
			  JSONArray jArray = new JSONArray(result);

			    for(int i = 0; i < jArray.length(); i++){

			            JSONObject json = jArray.getJSONObject(i);
			            s = s + "Book   : "+json.getString("book_name")+
			                  "\nAuthor : "+json.getString("author")+
			                  "\nAvailability : "+json.getString("availability")+"\n\n\n";           
			          
			        }
		
			        //putting it in next activity
			         resultView.setText(s);
			         
			   } 
			catch(Exception e){
			  Log.e("log.tag","error"+e.toString());
			}
	 }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_book, menu);
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