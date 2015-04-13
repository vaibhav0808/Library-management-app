package com.example.nitklibraryapp1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.R.string;

public class GetDataFromDB {

     public String GetDataFromDB(String book_name) {
         
         InputStream is=null;
         List<NameValuePair> namevaluepairs=new ArrayList<NameValuePair>(1);
            namevaluepairs.add(new BasicNameValuePair("book_name",book_name));
            try {
     
                HttpPost httppost;
                HttpClient httpclient;
                httpclient = new DefaultHttpClient();
                httppost = new HttpPost("http://http://vaibhav0808.comli.com/getdata.php"); // <span id="IL_AD8" class="IL_AD">change</span> this to your URL.....
                httppost.setEntity(new UrlEncodedFormEntity(namevaluepairs));
                  HttpResponse httpResponse=httpclient.execute(httppost);
                  HttpEntity httpEntity=httpResponse.getEntity();
                  is=httpEntity.getContent();
                  //httpResponse=httpclient.execute(httppost);
                ResponseHandler<String> responseHandler = new BasicResponseHandler();
                final String response = httpclient.execute(httppost,responseHandler);
                 
                return response.trim();
     
            } catch (Exception e) {
                System.out.println("ERROR : " + e.getMessage());
                return "error";
            }
        }
}