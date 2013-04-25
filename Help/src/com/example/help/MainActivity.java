package com.example.help;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.example.help.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import android.widget.ImageButton;



public class MainActivity extends Activity
{
	
	//SharedPreferences preferences;
	 
   public void onCreate(Bundle icicle)
   {
      super.onCreate(icicle);
      setContentView(R.layout.mainpage);
      
      //preferences = getSharedPreferences("myspace1", 0);
      
      //Contacts Button
      ImageButton contact = (ImageButton) findViewById(R.id.imageButton1);
	  contact.setOnClickListener(new View.OnClickListener() {
         public void onClick(View arg0) {
         Intent i = new Intent(MainActivity.this, contacts.class);
         startActivity(i);
         } 
      });
      
      //Personal Information Button
      ImageButton personal = (ImageButton) findViewById(R.id.imageButton2);
      personal.setOnClickListener(new View.OnClickListener() {
         public void onClick(View arg0) {
         Intent i = new Intent(MainActivity.this, personal_info.class);
         startActivity(i);
         } 
      });
      
      //Settings Button
      ImageButton service = (ImageButton) findViewById(R.id.imageButton4);
      service.setOnClickListener(new View.OnClickListener() {
          public void onClick(View arg0) {
          Intent k = new Intent(MainActivity.this, services.class);
          startActivity(k);
          } 
       });
      
      //Help Button
      ImageButton help = (ImageButton) findViewById(R.id.imageButton5);
      final Context context = this;
      help.setOnClickListener(new View.OnClickListener() {
          public void onClick(View arg0) {
        	  AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
      				context);
       
      			// set title
      			alertDialogBuilder.setTitle("Help");
      			
      			// set dialog message
      			alertDialogBuilder
      				.setMessage("Contacts: Choose the contacts that will recieve alert message in case of Emergency\n\n" + 
      							"My Data: Save Your Identity Data\n\n" + 
      							"First Aid PDF: Quick Guide for First Aid\n\n" + 
      							"Settings: Set all parameters of the application\n\n" +
      							"Emergency Contacts: Add Emergency Numbers " +
      							"and click on the button to call the particular emergency service\n\n" + 
      							"Add a widget to your Homescreen\n\n" + 
      							"On the Homescreen press\n" + 
      							"Menu->Add->Widgets->Emergency"
      						/* + "Name:" + preferences.getString("name", "0")*/)
      				.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
      					public void onClick(DialogInterface dialog,int id) {
      						// if this button is clicked, close
      						// current activity
      						dialog.cancel();
      					}
      				  });
      				
       
      				// create alert dialog
      				AlertDialog alertDialog = alertDialogBuilder.create();
       
      				// show it
      				alertDialog.show();
      			}
      		});
       
      ImageButton emergency = (ImageButton) findViewById(R.id.imageButton6);
      emergency.setOnClickListener(new View.OnClickListener() {
          public void onClick(View arg0) {
          Intent k = new Intent(MainActivity.this, emergencycontacts.class);
          startActivity(k);
          } 
       });
      
      // PDF Button
      ImageButton btnOpen=(ImageButton)findViewById(R.id.imageButton3);
      btnOpen.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              
        	  AssetManager assetManager = getAssets();

              InputStream in = null;
              OutputStream out = null;
              File file = new File(getFilesDir(), "firstaid1.pdf");
              try
              {
                  in = assetManager.open("firstaid1.pdf");
                  out = openFileOutput(file.getName(), Context.MODE_WORLD_READABLE);

                  copyFile(in, out);
                  in.close();
                  in = null;
                  out.flush();
                  out.close();
                  out = null;
              } catch (Exception e)
              {
                  Log.e("tag", e.getMessage());
              }

              Intent intent = new Intent(Intent.ACTION_VIEW);
              intent.setDataAndType(
                      Uri.parse("file://" + getFilesDir() + "/firstaid1.pdf"),
                      "application/pdf");

              startActivity(intent);
          }

          private void copyFile(InputStream in, OutputStream out) throws IOException
          {
              byte[] buffer = new byte[1024];
              int read;
              while ((read = in.read(buffer)) != -1)
              {
                  out.write(buffer, 0, read);
              }
          }

          
      });
   }
   
   	
   	
   
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}