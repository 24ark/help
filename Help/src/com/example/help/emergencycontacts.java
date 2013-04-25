package com.example.help;

import com.example.help.R;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class emergencycontacts extends Activity {

	public static EditText policeNumber;
	public static EditText medicalNumber;
	public static EditText fireNumber;
	public static EditText childlineNumber;
	public static EditText bloodbankNumber;
	public static EditText womenNumber;
	public static EditText animalNumber;
	public static EditText accidentNumber;
	public static Button police;
	public static Button fire;
	public static Button medical;
	public static Button childline;
	public static Button bloodbank;
	public static Button women;
	public static Button animal;
	public static Button accident;
	
	
	
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	
	    setContentView(R.layout.emergency);
	    
	    accidentNumber = (EditText) findViewById(R.id.accidentNumber);
	    animalNumber = (EditText) findViewById(R.id.animalNumber);
	    bloodbankNumber = (EditText) findViewById(R.id.bloodbankNumber);
	    childlineNumber = (EditText) findViewById(R.id.childlineNumber);
	    fireNumber = (EditText) findViewById(R.id.fireNumber);
	    policeNumber = (EditText) findViewById(R.id.policeNumber);
	    medicalNumber = (EditText) findViewById(R.id.medicalNumber);
	    womenNumber = (EditText) findViewById(R.id.womenNumber);
	    police = (Button) findViewById(R.id.policeButton);
	    medical = (Button) findViewById(R.id.medicalButton);
	    fire = (Button) findViewById(R.id.fireButton);
	    accident = (Button) findViewById(R.id.accidentButton);
	    animal = (Button) findViewById(R.id.animalButton);
	    women = (Button) findViewById(R.id.womenButton);
	    childline = (Button) findViewById(R.id.childlineButton);
	    bloodbank = (Button) findViewById(R.id.bloodbankButton);
	    
	    
	    SharedPreferences settings5 = getSharedPreferences("myspace5", 0);
	    //String a = settings5.getString("police", "");
	    policeNumber.setText(settings5.getString("police", "100"));
	    medicalNumber.setText(settings5.getString("medical", "101"));
	    bloodbankNumber.setText(settings5.getString("bloodbank", "1910"));
	    fireNumber.setText(settings5.getString("fire", "102"));
	    childlineNumber.setText(settings5.getString("childline", "1098"));
	    womenNumber.setText(settings5.getString("women", "181"));
	    animalNumber.setText(settings5.getString("animal", ""));
	    accidentNumber.setText(settings5.getString("accident", "1099"));
	    
	 
	    police.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View arg0) {
	        	 String emergencyno1 = policeNumber.getText().toString();	        	 
	    	     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
	    	     Integer.getInteger(emergencyno1);
	    	     if(emergencyno1.length() == 0 )
	        	 {
	        		 Toast.makeText(getApplicationContext(),"Enter number first", Toast.LENGTH_SHORT).show();
	        	 }
	        	 else
	        	 {
	    	     phoneCallIntent.setData(Uri.parse("tel:" + emergencyno1));
	    	     startActivity(phoneCallIntent);
	    	     System.exit(0);
	        	 }
	         }});
	    
	    
	      medical.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View arg0) {
	        	 String emergencyno2 = medicalNumber.getText().toString();
	    	     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
	    	     Integer.getInteger(emergencyno2);
	    	     if(emergencyno2.length() == 0 )
	        	 {
	        		 Toast.makeText(getApplicationContext(),"Enter number first", Toast.LENGTH_SHORT).show();
	        	 }
	        	 else
	        	 {
	        		 phoneCallIntent.setData(Uri.parse("tel:" + emergencyno2));
	        		 startActivity(phoneCallIntent);
	        		 System.exit(0);
	        	 }
	         }});
	    
	    
	    fire.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View arg0) {
	        	 String emergencyno3 = fireNumber.getText().toString();
	    	     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
	    	     Integer.getInteger(emergencyno3);
	    	     if(emergencyno3.length() == 0 )
	        	 {
	        		 Toast.makeText(getApplicationContext(),"Enter number first", Toast.LENGTH_SHORT).show();
	        	 }
	        	 else
	        	 {
	        		 phoneCallIntent.setData(Uri.parse("tel:" + emergencyno3));
	        		 startActivity(phoneCallIntent);
	    	     	 System.exit(0);
	        	 }
	         }});
	    
	    
	    
	    accident.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View arg0) {
	        	 String emergencyno4 = accidentNumber.getText().toString();
	    	     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
	    	     Integer.getInteger(emergencyno4);
	    	     if(emergencyno4.length() == 0 )
	        	 {
	        		 Toast.makeText(getApplicationContext(),"Enter number first", Toast.LENGTH_SHORT).show();
	        	 }
	        	 else
	        	 {
	        		 phoneCallIntent.setData(Uri.parse("tel:" + emergencyno4));
	        		 startActivity(phoneCallIntent);
	        		 System.exit(0);
	        	 }
	         }});
	    
	    
	    
	    animal.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View arg0) {
	        	 String emergencyno5 = animalNumber.getText().toString();
	    	     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
	    	     Integer.getInteger(emergencyno5);
	    	     if(emergencyno5.length() == 0 )
	        	 {
	        		 Toast.makeText(getApplicationContext(),"Enter number first", Toast.LENGTH_SHORT).show();
	        	 }
	        	 else
	        	 {
	        		 phoneCallIntent.setData(Uri.parse("tel:" + emergencyno5));
	        		 startActivity(phoneCallIntent);
	        		 System.exit(0);
	        	 }
	         }});
	    
	    
	    women.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View arg0) {
	        	 String emergencyno6 = womenNumber.getText().toString();
	    	     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
	    	     Integer.getInteger(emergencyno6);
	    	     if(emergencyno6.length() == 0 )
	        	 {
	        		 Toast.makeText(getApplicationContext(),"Enter number first", Toast.LENGTH_SHORT).show();
	        	 }
	        	 else
	        	 {
	        		 phoneCallIntent.setData(Uri.parse("tel:" + emergencyno6));
	        		 startActivity(phoneCallIntent);
	        		 System.exit(0);
	        	 }
	         }});
	    
	    
	    childline.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View arg0) {
	        	 String emergencyno7 = childlineNumber.getText().toString();
	    	     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
	    	     Integer.getInteger(emergencyno7);
	    	     if(emergencyno7.length() == 0 )
	        	 {
	        		 Toast.makeText(getApplicationContext(),"Enter number first", Toast.LENGTH_SHORT).show();
	        	 }
	        	 else
	        	 {
	        		 phoneCallIntent.setData(Uri.parse("tel:" + emergencyno7));
	        		 startActivity(phoneCallIntent);
	        		 System.exit(0);
	        	 }
	         }});
	    
	    
	    bloodbank.setOnClickListener(new View.OnClickListener() {
	         public void onClick(View arg0) {
	        	 String emergencyno8 = bloodbankNumber.getText().toString();
	    	     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
	    	     Integer.getInteger(emergencyno8);
	    	     if(emergencyno8.length() == 0 )
	        	 {
	        		 Toast.makeText(getApplicationContext(),"Enter number first", Toast.LENGTH_SHORT).show();
	        	 }
	        	 else
	        	 {
	        		 phoneCallIntent.setData(Uri.parse("tel:" + emergencyno8));
	        		 startActivity(phoneCallIntent);
	    	     	 System.exit(0);
	        	 }
	         }});
	    
	    
	}
	
	public void onBackPressed() {
    	super.onBackPressed();
    	SharedPreferences settings5 = getSharedPreferences("myspace5", 0);
    	SharedPreferences.Editor editor5 = settings5.edit();
    	editor5.putString("police", policeNumber.getText().toString());
    	editor5.putString("medical", medicalNumber.getText().toString());
    	editor5.putString("bloodbank", bloodbankNumber.getText().toString());
    	editor5.putString("fire", fireNumber.getText().toString());
    	editor5.putString("childline", childlineNumber.getText().toString());
    	editor5.putString("women", womenNumber.getText().toString());
    	editor5.putString("animal", animalNumber.getText().toString());
    	editor5.putString("accident", accidentNumber.getText().toString());
    	editor5.commit();
 
	}
	}
