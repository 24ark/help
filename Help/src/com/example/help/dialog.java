package com.example.help;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.gsm.SmsManager;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class dialog extends Activity{
	
	 int gps_enabled = 0;
	 SharedPreferences sp;
	 SharedPreferences preferences;
	 static String loc,lat,lon;
	 String phoneNo1;
	 String phoneNo2;
	 String phoneNo3;
	 public static ToggleButton sendmessage;
	 public static ToggleButton sendgps;
	 
	 
	
     public void onCreate(Bundle savedInstanceState) {
		 
			super.onCreate(savedInstanceState);
			setContentView(R.layout.widget1);
			
			sp = getSharedPreferences("myspace1", 0);
			preferences = getSharedPreferences("my_space1", 0);
			
		    
			
			
			final Context context = this;
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

			// set title
			alertDialogBuilder.setTitle("Confirmation:");

			// set dialog message
			alertDialogBuilder
			.setMessage("Click yes to continue!")
			
			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
			
			public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, close
					// current activity
					dialog.this.gpslocation();
					
					
				}
			  })
			.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					// if this button is clicked, just close
					// the dialog box and do nothing
					dialog.this.finish();
				}
			});

			// create alert dialog
			AlertDialog alertDialog = alertDialogBuilder.create();

			// show it
			alertDialog.show();
			
		}
     
     
	 
	 
	 public void gpslocation()
		{
		 	
		 	
		 	//if(gpspref==true){
			LocationManager locationManager=(LocationManager) getSystemService(Context.LOCATION_SERVICE);
	        LocationListener listener=new LocationListener() {

	            @Override
	            public void onStatusChanged(String arg0, int arg1, Bundle arg2) {

	            }

	            @Override
	            public void onProviderEnabled(String arg0) {


	            }
	            @Override
	            public void onProviderDisabled(String arg0) {
	            }

	            @Override
	            public void onLocationChanged(Location location) {
	                dialog.loc = String.valueOf(location.getLatitude())+","+String.valueOf(location.getLongitude());
	                dialog.lat = String.valueOf(location.getLatitude());
	                dialog.lon = String.valueOf(location.getLongitude());
	                Handler handler = new Handler(); 
	                handler.postDelayed(new Runnable() { 
	                     public void run() { 
	                    	 message();  
	                     } 
	                }, 1000);
	                
	               
	            }
	            };
		 	
	        
	        boolean isEnabled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
	        if(isEnabled)
	        {
	        	//gps_enabled=1;
	            Toast.makeText(getApplicationContext(),"Network Provider is Enabled", Toast.LENGTH_SHORT).show();
	            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
	            
	            
	        }
	        else
	        {
	            Toast.makeText(getApplicationContext(),"Network Provider is disabled!", Toast.LENGTH_LONG).show();
	        }
	        
		 	
		 	//else{
		 		
		 	
		 	
		 	
		 	
	        
	        
	    }
	 	
	 
	 	public String GetAddress(String lat, String lon)
		{
			Geocoder geocoder = new Geocoder(this, Locale.ENGLISH);
			String ret = "";
			try {
				List<Address> addresses = geocoder.getFromLocation(Double.parseDouble(lat), Double.parseDouble(lon), 1);
				if(addresses != null) {
					Address returnedAddress = addresses.get(0);
					StringBuilder strReturnedAddress = new StringBuilder("My Current Address is:\n");
					for(int i=0; i<returnedAddress.getMaxAddressLineIndex(); i++) {
						strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
					}
					ret = strReturnedAddress.toString();
				}
				else{
					ret = "No Address returned!";
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				ret = "Can't get Address because of poor internet connection!";
			}
			return ret;
		}
		
		public void phoneCall()
	    {
		 String emergencyno = sp.getString("emergency", "0");
	     Intent phoneCallIntent = new Intent(Intent.ACTION_CALL);
	     Integer.getInteger(emergencyno);
	     phoneCallIntent.setData(Uri.parse("tel:" + emergencyno));
	     startActivity(phoneCallIntent);
         System.exit(1);
	    }
		
		public void message()
		{	
			boolean messagepref = preferences.getBoolean("messagepref", true);
			//boolean gpspref = preferences.getBoolean("gpspref", true);
			boolean callpref = preferences.getBoolean("callpref", true);
			phoneNo1 = sp.getString("number1", "0");
			phoneNo2 = sp.getString("number2", "0");
			phoneNo3 = sp.getString("number3", "0");
	        final String message;
	        
	        
	        if(messagepref==true){
	        //if(gpspref==true){
	        String a = GetAddress(lat, lon);
	        String b = sp.getString("msg","");
	        message =  b + "\n" + "My Current Location (within 100m) according to the Network Provider is  " + loc + "\n" + a;
	        
                 
                	 
            
	        
	        
	        /*}
	        else{
	        message = sp.getString("msg","");
	        }*/
	        
	        
	        
	        if (phoneNo1.length()>0 && message.length()>0)     
	            sendSMS(phoneNo1, message);       
	        else
	            Toast.makeText(getBaseContext(), 
	                "Please enter both phone number and message.", 
	                Toast.LENGTH_LONG).show();
	                
	        
	        
	        if (phoneNo2.length()>0 && message.length()>0)                
	            sendSMS(phoneNo2, message);       
	        else
	            Toast.makeText(getBaseContext(), 
	                "Please enter both phone number and message for second field.", 
	                Toast.LENGTH_LONG).show();
	        
	        if (phoneNo3.length()>0 && message.length()>0)                
	            sendSMS(phoneNo3, message);       
	        else
	            Toast.makeText(getBaseContext(), 
	                "Please enter both phone number and message for third field.", 
	                Toast.LENGTH_LONG).show();
	        
	        if(callpref==true){
	        	phoneCall();
	        }
	        else{
	        	System.exit(0);
	        }
	        }
	        else{
	        	if(callpref==true){
		        	phoneCall();
		        }
	        	else{
	        		System.exit(0);
	        	}
	        
		        
	        }
		}
	        
		
		
		
		public void sendSMS(String phoneNumber, String message)
	    {        
			
			String SENT = "SMS_SENT";
	        String DELIVERED = "SMS_DELIVERED";
	 
	        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0,
	            new Intent(SENT), 0);
	 
	        PendingIntent deliveredPI = PendingIntent.getBroadcast(this, 0,
	            new Intent(DELIVERED), 0);
	 
	        //---when the SMS has been sent---
	        registerReceiver(new BroadcastReceiver(){
	            public void onReceive(Context arg0, Intent arg1) {
	                switch (getResultCode())
	                {
	                    case Activity.RESULT_OK:
	                        Toast.makeText(getBaseContext(), "SMS sent", 
	                                Toast.LENGTH_SHORT).show();
	                        break;
	                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
	                        Toast.makeText(getBaseContext(), "Generic failure", 
	                                Toast.LENGTH_SHORT).show();
	                        break;
	                    case SmsManager.RESULT_ERROR_NO_SERVICE:
	                        Toast.makeText(getBaseContext(), "No service", 
	                                Toast.LENGTH_SHORT).show();
	                        break;
	                    case SmsManager.RESULT_ERROR_NULL_PDU:
	                        Toast.makeText(getBaseContext(), "Null PDU", 
	                                Toast.LENGTH_SHORT).show();
	                        break;
	                    case SmsManager.RESULT_ERROR_RADIO_OFF:
	                        Toast.makeText(getBaseContext(), "Radio off", 
	                                Toast.LENGTH_SHORT).show();
	                        break;
	                }
	            }
	        }, new IntentFilter(SENT));
	 
	        //---when the SMS has been delivered---
	        registerReceiver(new BroadcastReceiver(){

	            public void onReceive(Context arg0, Intent arg1) {
	                switch (getResultCode())
	                {
	                    case Activity.RESULT_OK:
	                        Toast.makeText(getBaseContext(), "SMS delivered", 
	                                Toast.LENGTH_SHORT).show();
	                        break;
	                    case Activity.RESULT_CANCELED:
	                        Toast.makeText(getBaseContext(), "SMS not delivered", 
	                                Toast.LENGTH_SHORT).show();
	                        break;                        
	                }
	            }
	        }, new IntentFilter(DELIVERED));        
	 
	        PendingIntent pi = PendingIntent.getActivity(this, 0,
	            new Intent(this, MainActivity.class), 0);                
	        SmsManager sms = SmsManager.getDefault();
	        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);        
	    }    
	 
	
	 
}

