package com.example.help;

import java.util.Arrays;

import com.example.help.R;

import android.app.AlertDialog;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class WidgetProvider extends AppWidgetProvider{
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
	    final int N = appWidgetIds.length;
	    Log.i("ExampleWidget",  "Updating widgets " + Arrays.asList(appWidgetIds));
	    // Perform this loop procedure for each App Widget that belongs to this
	    // provider
	    for (int i = 0; i < N; i++) {
	      int appWidgetId = appWidgetIds[i];
	      // Create an Intent to launch ExampleActivity
	      Intent intent = new Intent(context, dialog.class);
	      PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
	      // Get the layout for the App Widget and attach an on-click listener
	      // to the button
	      RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget);
	      views.setOnClickPendingIntent(R.id.widget, pendingIntent);
	      // To update a label
	      
	      // Tell the AppWidgetManager to perform an update on the current app
	      // widget
	      appWidgetManager.updateAppWidget(appWidgetId, views);
	    }
	  }
}
