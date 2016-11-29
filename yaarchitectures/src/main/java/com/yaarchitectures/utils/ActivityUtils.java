package com.yaarchitectures.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Mesrop Davoyan on 5/26/14.
 */
public class ActivityUtils {


    public static ProgressDialog showProgressDialog(Context context,String message){

        ProgressDialog progressDialog=new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        return progressDialog;
    }
    public static void dismissProgressDialog(ProgressDialog progressDialog) {
        try {
            if(progressDialog != null) {
                progressDialog.dismiss();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showAlert(Context context, String message) {
        if(message == null){
            return;
        }
        try {
            AlertDialog.Builder alertBuilder  = new AlertDialog.Builder(context);
            alertBuilder.setMessage(message);
            alertBuilder.setPositiveButton("OK", null);
            alertBuilder.setCancelable(true);
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertDialog.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showAlert(Context context, String message, String title) {
        try {
            AlertDialog.Builder alertBuilder  = new AlertDialog.Builder(context);
            alertBuilder.setMessage(message);
            alertBuilder.setTitle(title);
            alertBuilder.setPositiveButton("OK", null);
            alertBuilder.setCancelable(true);
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertDialog.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showAlert(Context context, String message, DialogInterface.OnClickListener onClickListener) {
        try {
            AlertDialog.Builder alertBuilder  = new AlertDialog.Builder(context);
            alertBuilder.setMessage(message);
            alertBuilder.setPositiveButton("OK", onClickListener);
            alertBuilder.setCancelable(true);
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertDialog.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showYesNoDialog(Context context, String message, String[] buttonText, DialogInterface.OnClickListener onYesClickListener,
                                       DialogInterface.OnClickListener onNoClickListener){
        try {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setMessage(message);
            alertBuilder.setPositiveButton(buttonText[0], onYesClickListener);
            alertBuilder.setNegativeButton(buttonText[1], onNoClickListener);
            alertBuilder.setCancelable(true);
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertDialog.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void showDeleteDialog(Context context, String message, DialogInterface.OnClickListener deleteListener) {
        try {
            AlertDialog.Builder alertBuilder  = new AlertDialog.Builder(context);
            alertBuilder.setMessage(message);
            alertBuilder.setPositiveButton("Delete", deleteListener);
            alertBuilder.setNegativeButton("Cancel", null);
            alertBuilder.setCancelable(true);
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertDialog.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showYesNoDialog(Context context, String message,
                                       DialogInterface.OnClickListener onYesListener) {
        showYesNoDialog(context, message, onYesListener, null);
    }

    public static void showYesNoDialog(Context context, String message,
                                       DialogInterface.OnClickListener onYesListener,
                                       DialogInterface.OnClickListener onNoListener) {
        try {
            AlertDialog.Builder alertBuilder  = new AlertDialog.Builder(context);
            alertBuilder.setMessage(message);
            alertBuilder.setPositiveButton("Yes", onYesListener);
            alertBuilder.setNegativeButton("No", onNoListener);
            alertBuilder.setCancelable(true);
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertDialog.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }




    public static void showLeaveCancelDialog(Context context, String title, String message,
                                             DialogInterface.OnClickListener onCancelListener,
                                             DialogInterface.OnClickListener onLeaveListener) {
        try {
            AlertDialog.Builder alertBuilder  = new AlertDialog.Builder(context);
            alertBuilder.setTitle(title);
            alertBuilder.setMessage(message);
            alertBuilder.setPositiveButton("Cancel", onCancelListener);
            alertBuilder.setNegativeButton("Leave", onLeaveListener);
            alertBuilder.setCancelable(true);
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertDialog.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showPermissionsDialog(Context context, String message,
                                             DialogInterface.OnClickListener onYesListener,
                                             DialogInterface.OnClickListener onNoListener) {
        try {
            AlertDialog.Builder alertBuilder  = new AlertDialog.Builder(context);
            alertBuilder.setMessage(message);
            alertBuilder.setPositiveButton("SETTINGS", onYesListener);
            alertBuilder.setNegativeButton("NOT NOW", onNoListener);
            alertBuilder.setCancelable(true);
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            alertDialog.show();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void hideSoftInput(Context context) {
        try {
            if(context instanceof Activity) {
                Activity activity = (Activity) context;
                InputMethodManager inputMethodManager = (InputMethodManager)  activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
                View currentView = activity.getCurrentFocus();
                if(currentView != null) {
                    inputMethodManager.hideSoftInputFromWindow(currentView.getWindowToken(), 0);
                    currentView.clearFocus();
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showSoftInput(Context context, EditText editText) {
        try {
            InputMethodManager imm = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
            editText.requestFocus();
            imm.showSoftInput(editText, 0);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean sendSms(Context context, String address, String body) {
        Uri uri = Uri.parse("sms:" + address);
        Intent intent = new Intent();
        intent.setData(uri);
        intent.putExtra(Intent.EXTRA_TEXT, body);
        intent.putExtra("sms_body", body);
        intent.putExtra("address", address);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            intent.setAction(Intent.ACTION_SENDTO);
            String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(context);
            if(defaultSmsPackageName != null) {
                intent.setPackage(defaultSmsPackageName);
            }
        } else {
            intent.setAction(Intent.ACTION_VIEW);
            intent.setType("vnd.android-dir/mms-sms");
        }

        try {
            context.startActivity(intent);
        } catch (Exception e) {

            return false;
        }

        return true;
    }

    public static void sendEmail(Context context, String address, String subject, String body) {
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setType("message/rfc822");
        i.setData(Uri.parse("mailto:")); // only email apps should handle this
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{address});
        i.putExtra(Intent.EXTRA_SUBJECT, subject);
        i.putExtra(Intent.EXTRA_TEXT, body);
        try {
            context.startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (Exception e) {

            Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public static void startInstalledAppDetailsActivity(final Activity context) {
        if (context == null) {
            return;
        }
        final Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setData(Uri.parse("package:" + context.getPackageName()));
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(intent);
    }

    public static void openLocationSettingsPage(final Activity context){
        if (context == null) {
            return;
        }
        final Intent intent = new Intent();
        intent.setAction(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        intent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(intent);
    }

    public static boolean softInputOpen(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE);

        if (imm.isAcceptingText()) {
           return true;
        }
        return false;
    }
    public static boolean isAppOnForeground(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null) {
            return false;
        }
        final String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND && appProcess.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if device location is enabled or disabled
     * @param mContext
     * @return true if enabled, false if disabled
     */
    public static boolean checkLocationEnabled(final Activity mContext){

        if(mContext == null)
            return false;
        int locationMode = 0;
        String locationProviders;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            try {
                locationMode = Settings.Secure.getInt(mContext.getContentResolver(), Settings.Secure.LOCATION_MODE);
            } catch (Settings.SettingNotFoundException e) {
                e.printStackTrace();
            }
            return locationMode != Settings.Secure.LOCATION_MODE_OFF;
        }else{
            locationProviders = Settings.Secure.getString(mContext.getContentResolver(), Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
            return !TextUtils.isEmpty(locationProviders);
        }
    }

}