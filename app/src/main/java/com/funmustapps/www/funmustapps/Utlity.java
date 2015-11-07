package com.funmustapps.www.funmustapps;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by AppsGeniiPc on 10/26/2015.
 */
public class Utlity {
    public static ProgressDialog showProgressDialog(Context context, String title) {
        ProgressDialog barProgressDialog = new ProgressDialog(context);
        barProgressDialog.setTitle(title);
        barProgressDialog.setMessage("Please Wait...");
        barProgressDialog.show();
        return barProgressDialog;
    }

    public static void showDialougeYesnNo(Context context, String title, String msg, String yesText, String noText, DialogInterface.OnClickListener yes, DialogInterface.OnClickListener no) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(yesText, yes)
                .setNegativeButton(noText, no);

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();


    }

    public static void showDialougeYes(Context context, String title, String msg, String yesText, DialogInterface.OnClickListener yes) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                context);
        // set title
        alertDialogBuilder.setTitle(title);

        // set dialog message
        alertDialogBuilder
                .setMessage(msg)
                .setCancelable(false)
                .setPositiveButton(yesText, yes);

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();


    }

    public static void saveUserInSharedPrefrence(Activity activity, Object object) {
        //Creating a shared preference
        SharedPreferences mPrefs = activity.getPreferences(Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefsEditor = mPrefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(object);
        prefsEditor.putString("temp_user", json);
        prefsEditor.commit();
    }

    public static Object getUserInSharedPrefrence(Activity activity, Object object) {
        //Creating a shared preference
        SharedPreferences mPrefs = activity.getPreferences(Activity.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = mPrefs.getString("temp_user", "");
        // if(json.isEmpty())
        Object obj = gson.fromJson(json, Object.class);
        return obj;
    }
}
