package com.example.cherryquill1;

import java.io.FileOutputStream;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class WriteActivity extends Activity {
	Button b1,b2;
	EditText ed1;
	String data;
	   public String file = "mydata";
	;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_write);
		// Show the Up button in the action bar.
		
		Intent intent = getIntent();
		   String message = intent.getStringExtra("message");
		   TextView textView = new TextView(this);
		   textView.setTextSize(20);
		   textView.setText("welcome"+message+",");

		   RelativeLayout layout = (RelativeLayout) findViewById(R.id.content);
		   layout.addView(textView);
		
		   b1=(Button)findViewById(R.id.button1);
		      
		      
		      ed1=(EditText)findViewById(R.id.e13);
		      
		      b1.setOnClickListener(new View.OnClickListener() {
		         @Override
		         public void onClick(View v) {
		            data=ed1.getText().toString();
		            
		            try {
		               FileOutputStream fOut = openFileOutput(file,MODE_WORLD_READABLE);
		               fOut.write(data.getBytes());
		               fOut.close();
		               Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_SHORT).show();
		            }
		            
		            catch (Exception e) {
		               // TODO Auto-generated catch block
		               e.printStackTrace();
		            }
		         }
		      });
		    
		      b2 = (Button)findViewById(R.id.button2);
	            b2.setOnClickListener(new View.OnClickListener() {
	                @Override
	                public void onClick(View v) {
	                    Intent myIntent=new Intent(WriteActivity.this,ViewActivity.class);
	                    EditText edit1=(EditText)findViewById(R.id.e1);
	                    EditText edit2=(EditText)findViewById(R.id.e12);
	                    String title=edit1.getText().toString();
	                    String genre=edit2.getText().toString();
	                    myIntent.putExtra("title", title);
	                    myIntent.putExtra("genre", genre);
	                    startActivity(myIntent);
	                }
	            });
	            
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.write, menu);
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
