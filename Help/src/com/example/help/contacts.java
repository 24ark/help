package com.example.help;



import com.example.help.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class contacts extends Activity {
	
	 public static EditText txtPhoneNo1;
	 public static EditText txtPhoneNo2;
	 public static EditText txtPhoneNo3;
	 
	 EditText name1;
	 EditText name2;
	 EditText name3;
	
	
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.activity_main);
	    
	    txtPhoneNo1 = (EditText) findViewById(R.id.editText2);
	     txtPhoneNo2 = (EditText) findViewById(R.id.EditText02);
	     txtPhoneNo3 = (EditText) findViewById(R.id.EditText04);
	    
	     name1 = (EditText) findViewById(R.id.editText1);
		 name2 = (EditText) findViewById(R.id.EditText01);
		 name3 = (EditText) findViewById(R.id.EditText03);
		 
		 SharedPreferences settings1 = getSharedPreferences("myspace1", 0);
	     
	     txtPhoneNo1.setText(settings1.getString("number1", ""));
	     txtPhoneNo2.setText(settings1.getString("number2", ""));
	     txtPhoneNo3.setText(settings1.getString("number3", ""));
	     name1.setText(settings1.getString("name1", ""));
	     name2.setText(settings1.getString("name2", ""));
	     name3.setText(settings1.getString("name3", ""));


	}
	
	@Override
	public void onBackPressed() {
	    	super.onBackPressed();
	    	SharedPreferences settings1 = getSharedPreferences("myspace1", 0);
	    	SharedPreferences.Editor editor1 = settings1.edit();
	    	editor1.putString("name1", name1.getText().toString());
	    	editor1.putString("name2", name2.getText().toString());
	    	editor1.putString("name3", name3.getText().toString());
	    	editor1.putString("number1", txtPhoneNo1.getText().toString());
	    	editor1.putString("number2", txtPhoneNo2.getText().toString());
	    	editor1.putString("number3", txtPhoneNo3.getText().toString());
	    	editor1.commit();
	 }
	

}
