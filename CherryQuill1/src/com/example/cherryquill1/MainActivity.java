package com.example.cherryquill1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }

 public void SendMessage(View view)
 {
	 Intent intent= new Intent(MainActivity.this,WriteActivity.class);
	 EditText e1=(EditText)findViewById(R.id.e1);
	 String message= e1.getText().toString();
	 intent.putExtra("message", message);
	 startActivity(intent);
 }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
