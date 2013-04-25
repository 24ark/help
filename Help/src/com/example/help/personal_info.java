package com.example.help;

import com.example.help.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class personal_info extends Activity {

	
	 public EditText personal_info_name;
	 public EditText personal_info_age;
	 public EditText personal_info_address;
	 public EditText personal_info_diseases;
	 public EditText personal_info_number;
	 private SharedPreferences settings3;
	 
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.personal_info);
	    
	     personal_info_address = (EditText) findViewById(R.id.personal_info_address);
	     personal_info_name = (EditText) findViewById(R.id.personal_info_name);
	  	 personal_info_age = (EditText) findViewById(R.id.personal_info_age);
	     personal_info_diseases = (EditText) findViewById(R.id.personal_info_diseases);
	     personal_info_number = (EditText) findViewById(R.id.personal_info_number);
	     
	     settings3 = getSharedPreferences("myspace1", 0);
	     personal_info_address.setText(settings3.getString("address", ""));
	     personal_info_age.setText(settings3.getString("age", ""));
	     personal_info_diseases.setText(settings3.getString("diseases", ""));
	     personal_info_name.setText(settings3.getString("name", ""));
	     personal_info_number.setText(settings3.getString("number", ""));
	     
	}
	 @Override
	 public void onBackPressed() {
	    	super.onBackPressed();
	    	
	    	SharedPreferences.Editor editor3 = settings3.edit();
	    	editor3.putString("address", personal_info_address.getText().toString());
	    	editor3.putString("age", personal_info_age.getText().toString());
	    	editor3.putString("name", personal_info_name.getText().toString());
	    	editor3.putString("number", personal_info_number.getText().toString());
	    	editor3.putString("diseases", personal_info_diseases.getText().toString());
	    	editor3.commit();
	 }
}