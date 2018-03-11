package valkyr.palindromeapp;


import android.app.AlertDialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;


import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;




/**
 * Created by celia on 04.12.17.
 */


/* METHOD VORLAGEN

                // 1. Instantiate an AlertDialog.Builder with its constructor
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage("Sie haben keine Telefonnummer angegeben")
                        .setTitle("Hinweis");


                // 3. Add the buttons
                builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                // 4. Create the AlertDialog
                AlertDialog dialog = builder.create();

                dialog.show();

                // 5. FOR TIMED END

                final Handler handler  = new Handler();
                    final Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            if (dialog.isShowing()) {
                                dialog.dismiss();
                            }
                        }
                    };

                    dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            handler.removeCallbacks(runnable);
                        }
                    });

                    handler.postDelayed(runnable, 3000);







 */
public class MethodPackage {


    public void saveStringToPrefs(String Key, String Value, Context context) {

        SharedPreferences settings = context.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(Key, Value);
        editor.commit();
    }


    public String getStringPrefs(String Key, Context context) {
        SharedPreferences settings = context.getSharedPreferences("settings", 0);
        String returnvalue = settings.getString(Key, "");
        return returnvalue;
    }



    public void clearAllPrefs(Context context) {
        SharedPreferences settings = context.getSharedPreferences("settings", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.clear();
        editor.commit();

    }

    public boolean isKeyPresentInPrefs(String Key, Context context) {
        SharedPreferences settings = context.getSharedPreferences("settings", 0);
        return settings.contains(Key);
    }


    public String coding(String param) {

        try {
            return URLEncoder.encode(param, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return param;

    }

    public ArrayList<String> splitIntoArrayByString(String toSplit, String splitBy) {

        ArrayList<String> returnArray = new ArrayList<String>(Arrays.asList(toSplit.split(splitBy, 0)));

        return returnArray;
    }

    public ArrayList<String> splitIntoArrayByStringRuflisten(String toSplit, String splitBy) {
        String placeHolder = toSplit;
        String toSplitNew = placeHolder.replace("[OK](OK)", "");
        toSplit = toSplitNew.replace("(OK)", "|");
        Log.d("SplitTag:", toSplit);
        ArrayList<String> returnArray = new ArrayList<String>(Arrays.asList(toSplit.split(splitBy, 0)));

        return returnArray;
    }


    public long differenceBetweenDates(Date cal1, Date cal2, String difference) {

        long millis1 = cal1.getTime();
        long millis2 = cal2.getTime();
        // Calculate difference in milliseconds
        long diff = millis2 - millis1;

        // Calculate difference in seconds
        long diffSeconds = diff / 1000;

        // Calculate difference in minutes
        long diffMinutes = diff / (60 * 1000);

        // Calculate difference in hours
        long diffHours = diff / (60 * 60 * 1000);

        // Calculate difference in days
        long diffDays = diff / (24 * 60 * 60 * 1000);


        switch (difference) {
            case "seconds":
                return diffSeconds;

            case "minutes":
                return diffMinutes;

            case "hours":
                return diffHours;

            case "days":
                return diffDays;

            default:
                return diffSeconds;

        }

    }

    // TYPE CAN BE: "noCancel", "withCancel", "timed"
    public void setAlertDialog(String type, String message, String okButton, String cancelButton, Context context){

        // INSTANTIATE HERE FIRST THEN GO INTO SWITCH
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        final AlertDialog dialog;
        switch (type){
            case "noCancel":
                // 1. Instantiate an AlertDialog.Builder with its constructor
                //AlertDialog.Builder builder = new AlertDialog.Builder(context);

                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(message)
                        .setTitle("Hinweis");


                // 3. Add the buttons
                builder.setPositiveButton(okButton, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                // 4. Create the AlertDialog
                dialog = builder.create();

                dialog.show();
                break;
            case "withCancel":
                // 1. Instantiate an AlertDialog.Builder with its constructor
                //AlertDialog.Builder builder = new AlertDialog.Builder(context);

                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(message)
                        .setTitle("Hinweis");


                // 3. Add the buttons
                builder.setPositiveButton(okButton, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                builder.setNegativeButton(cancelButton, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                // 4. Create the AlertDialog
                dialog = builder.create();

                dialog.show();
                break;

            case "timed":

                // 1. Instantiate an AlertDialog.Builder with its constructor
                //AlertDialog.Builder builder = new AlertDialog.Builder(context);

                // 2. Chain together various setter methods to set the dialog characteristics
                builder.setMessage(message)
                        .setTitle("Hinweis");


                // 4. Create the AlertDialog
                dialog = builder.create();

                dialog.show();

                // 5. FOR TIMED END

                final Handler handler  = new Handler();
                final Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }
                };

                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        handler.removeCallbacks(runnable);
                    }
                });

                handler.postDelayed(runnable, 3000);
                break;

        }


    }




    public void getContacts(Cursor cursor, int counter, Handler updateBarHandler, final ProgressDialog pDialog) {


    }
}

