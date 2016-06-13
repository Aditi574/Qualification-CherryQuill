package com.example.cherryquill1;

import java.io.FileInputStream;
import java.util.Locale;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import android.widget.TextView;
import android.widget.Toast;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;

public class ViewActivity extends Activity {
	Button b1,b2;
	   TextView tv;
	   TextToSpeech t1;
	   public String file = "mydata";
	   

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view);
		// Show the Up button in the action bar.
		
		Intent intent = getIntent();
		   String title = intent.getStringExtra("title");
		   TextView textView = new TextView(this);
		   textView.setTextSize(20);
		   textView.setTypeface(null,Typeface.BOLD);
		   textView.setText(title);
		   
		   String genre = intent.getStringExtra("genre");
		   TextView textView33 = new TextView(this);
		   textView33.setTextSize(20);
		   textView33.setText(genre);
		   textView33.setTypeface(null,Typeface.BOLD_ITALIC);
		   
		   LinearLayout layout = (LinearLayout) findViewById(R.id.content1);
		   layout.addView(textView);
		   layout.addView(textView33);
		tv=(TextView)findViewById(R.id.textView1);
		b1=(Button)findViewById(R.id.button1);
	      b2=(Button)findViewById(R.id.button2);
	      
	      b2.setOnClickListener(new View.OnClickListener() {
	          @Override
	          public void onClick(View v) {
	             try{
	                FileInputStream fin = openFileInput(file);
	                int c;
	                String temp="";
	                
	                while( (c = fin.read()) != -1){
	                   temp = temp + Character.toString((char)c);
	                }
	                tv.setText(temp);
	                Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_SHORT).show();
	             }
	             catch(Exception e){
	             }
	          }
	       });
	      t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
	          @Override
	          public void onInit(int status) {
	             if(status != TextToSpeech.ERROR) {
	                t1.setLanguage(Locale.UK);
	             }
	          }
	       });
	       
	       b1.setOnClickListener(new View.OnClickListener() {
	          @Override
	          public void onClick(View v) {
	             String toSpeak = tv.getText().toString();
	             Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
	             t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
	          }
	       });
	
	}
	
	public void onPause(){
	      if(t1 !=null){
	         t1.stop();
	         t1.shutdown();
	      }
	      super.onPause();
	   }
	   

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.view, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
