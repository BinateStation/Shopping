package rkr.binatestation.shopping.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Environment;
import android.support.v7.app.AlertDialog;

import java.io.File;

/**
 * Created by RKR on 27-01-2016.
 * GeneralUtil.
 */
public class GeneralUtil {

    /**
     * static variable for saving images in external storage directory.
     */

    private static final String captureImagePath = Environment.getExternalStorageDirectory().toString() +
            File.separator + "PicLo" + File.separator + "Images" + File.separator;

    /**
     * Method to check Weather a valid Email ID
     */

    public static boolean isValidEmail(CharSequence target) {
        return target != null && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    /**
     * static method used to get the External Storage path which ensures whether it exits or not
     */

    public static String getCaptureImagePath() {
        File file = new File(captureImagePath);
        if (file.exists()) {
            return captureImagePath;
        } else {
            if (file.mkdirs()) {
                return captureImagePath;
            } else {
                return Environment.getExternalStorageDirectory().toString() + File.separator;
            }
        }
    }


    public static void showAlert(Context context, String title, String message) {
        try {
            new AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    })
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showAlert(Context context, String title, String message, DialogInterface.OnClickListener onClickListener) {
        try {
            new AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .setPositiveButton(android.R.string.ok, onClickListener)
                    .show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
