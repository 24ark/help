package com.example.help;



import com.example.help.R;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

public class services extends Activity {
	
	 public static EditText txtMessage;
	 public static EditText emergencyno;
	 public static ToggleButton sendmessage;
	 public static ToggleButton sendgps;
	 public static ToggleButton call;
	 public static int x=1,y=1,z=1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.services);
	    
	    
	    emergencyno = (EditText) findViewById(R.id.settings_number);
	    txtMessage = (EditText) findViewById(R.id.settings_msg);
	    
	    
	    
	    final SharedPreferences preferences = getSharedPreferences("my_space1", 0);
	    sendmessage = (ToggleButton) findViewById(R.id.toggleButton1);
	   // sendgps = (ToggleButton) findViewById(R.id.toggleButton2);
	    call = (ToggleButton) findViewById(R.id.toggleButton3);
	    
	    SharedPreferences settings2 = getSharedPreferences("myspace1", 0);
	    txtMessage.setText(settings2.getString("msg", "HELP! I'm in Danger."));
	    emergencyno.setText(settings2.getString("emergency", "108"));
	    
	    
	    
	   
	    
	    /*sendgps.setOnClickListener(new View.OnClickListener()
	    {
	        @Override
	        public void onClick(View v)
	        {
	        	if((sendgps.isChecked()))
	            {
	                    SharedPreferences.Editor editor = preferences.edit();
	                    editor.putBoolean("gpspref", true); // value to store
	                    editor.commit();
	            }
	            else
	            {
	                    SharedPreferences.Editor editor = preferences.edit();
	                    editor.putBoolean("gpspref", false); // value to store
	                    editor.commit();
	            }
	        }
	    });
	    
	    
    	boolean gpspref = preferences.getBoolean("gpspref", true);  //default is true
    	sendgps.setChecked(gpspref);
    	*/
    	sendmessage.setOnClickListener(new View.OnClickListener()
	    {
	        @Override
	        public void onClick(View v)
	        {
	        	if((sendmessage.isChecked()))
	            {
	                    SharedPreferences.Editor editor = preferences.edit();
	                    editor.putBoolean("messagepref", true); // value to store
	                    editor.commit();
	                    y=1;
	            }
	            else
	            {
	                    SharedPreferences.Editor editor = preferences.edit();
	                    editor.putBoolean("messagepref", false); // value to store
	                    editor.commit();
	                    y=0;
	            }
	        }
	    });
	    
	    
    	boolean messagepref = preferences.getBoolean("messagepref", true);  //default is true
    	sendmessage.setChecked(messagepref);
    	
    	call.setOnClickListener(new View.OnClickListener()
	    {
	        @Override
	        public void onClick(View v)
	        {
	        	if((call.isChecked()))
	            {
	                    SharedPreferences.Editor editor = preferences.edit();
	                    editor.putBoolean("callpref", true); // value to store
	                    editor.commit();
	                    z=1;
	            }
	            else
	            {
	                    SharedPreferences.Editor editor = preferences.edit();
	                    editor.putBoolean("callpref", false); // value to store
	                    editor.commit();
	                    z=0;
	            }
	        }
	    });
	    
	    
    	boolean callpref = preferences.getBoolean("callpref", true);  //default is true
    	call.setChecked(callpref);
	
	    
	}
	
	 public void onBackPressed() {
	    	super.onBackPressed();
	    	SharedPreferences settings2 = getSharedPreferences("myspace1", 0);
	    	SharedPreferences.Editor editor2 = settings2.edit();
	    	editor2.putString("msg", txtMessage.getText().toString());
	    	editor2.putString("emergency", emergencyno.getText().toString());
	    	editor2.commit();
	    	
	    	
	 }

}
